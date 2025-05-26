package practica.servicio;
//para los metodos

import java.util.List;
import java.util.Optional;
import practica.modelo.Producto;

public interface ProductoServicio {

    //metodo para guardar 
    public Producto save(Producto producto);

    //obtner un producto
    public Optional<Producto> get(Integer id);

    //metodo para actualizar
    public void update(Producto producto);

    //metodo para eliminar
    public void delete(Integer id);
    
    //metodo para mostrar los productos
    public List<Producto> findAll();
}
