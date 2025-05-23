
package practica.repositorio;
//es un DAO

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practica.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
