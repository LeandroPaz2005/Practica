
package practica.controlador;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practica.modelo.Producto;
import practica.modelo.Usuarios;
import practica.servicio.ProductoServicio;

@Controller
@RequestMapping("/productos")
public class ProductoControlador {
    
    private final Logger LOGGER=LoggerFactory.getLogger(ProductoControlador.class);
    
    //declar variable para acceder a los metodos
    @Autowired
    private ProductoServicio productoServico;
            
            
    @GetMapping("")
    public String show(Model model){ //para que nos lleve al metodo
        model.addAttribute("productos", productoServico.findAll());//se envia al producto 
    return "productos/show";
    }
    
    @GetMapping("/create")
    public String create(){
    return "productos/create";
    }
    
    @PostMapping("/save")
    public String save(Producto producto){
        LOGGER.info("Este el objeto producto {}", producto);
        Usuarios u=new Usuarios(1, "", "", "","", "", "", "");
        producto.setUsuario(u);
        productoServico.save(producto);
    return "redirect:/productos";
    }
}
