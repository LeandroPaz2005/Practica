
package practica.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practica.modelo.Producto;
import practica.repositorio.ProductoRepositorio;

@Service
public class ProductoServicioImple implements ProductoServicio{
    
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public Producto save(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public void update(Producto producto) {
       productoRepositorio.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepositorio.deleteById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepositorio.findAll();
    }
    
}
