package practica.controlador;

import java.io.IOException;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import practica.modelo.Producto;
import practica.modelo.Usuarios;
import practica.servicio.ProductoServicio;
import practica.servicio.UploadService;

@Controller
@RequestMapping("/productos")
public class ProductoControlador {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoControlador.class);

    //declar variable para acceder a los metodos
    @Autowired
    private ProductoServicio productoServico;

    @Autowired
    private UploadService upload;

    @GetMapping("")
    public String show(Model model) { //para que nos lleve al metodo
        model.addAttribute("productos", productoServico.findAll());//se envia al producto 
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        LOGGER.info("Este el objeto producto {}", producto);
        Usuarios u = new Usuarios(1, "", "", "", "", "", "", "");
        producto.setUsuario(u);

        //logica: imagen carga por primera vez
        if (producto.getId() == null) {
            String nombreImagen = upload.saveImages(file);
            producto.setImagen(nombreImagen);
        } else {

        }

        productoServico.save(producto);
        return "redirect:/productos";
    }

    //metodo para editar o actualizar producto
    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoServico.get(id);
        producto = optionalProducto.get();

        LOGGER.info("Producto Buscando: {}", producto);
        model.addAttribute("producto", producto);

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Producto p = new Producto();
        p = productoServico.get(producto.getId()).get();

        if (file.isEmpty()) {
            producto.setImagen(p.getImagen());
        } else {//cuando se edita tambien la imagen
            if (!p.getImagen().equals("default.jpg")) {
                upload.deleteImagen(p.getImagen());
            }
            String nombreImagen = upload.saveImages(file);
            producto.setImagen(nombreImagen);
        }

        producto.setUsuario(p.getUsuario());
        productoServico.update(producto);
        return "redirect:/productos";

    }

    //metodo para eliminar
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Producto p = new Producto();
        p = productoServico.get(id).get();

        //para eliminar cuando no sea la imagen por defecto
        if (p.getImagen().equals("default.jpg")) {
            upload.deleteImagen(p.getImagen());
        }
        productoServico.delete(id);
        return "redirect:/productos";
    }

}
