
package practica.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practica.modelo.Producto;
import practica.servicio.ProductoServicio;

@Controller
@RequestMapping("/administrador")
public class AdminitradorControlador {
    
    @Autowired
    private ProductoServicio productoService;
    
    @GetMapping("")
    public String home(Model model){
        List<Producto> productos=productoService.findAll();
        model.addAttribute("productos", productos);
    return "administrador/home";
    }
}
