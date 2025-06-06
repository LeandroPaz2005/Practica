package practica.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estratregi para hacer las tablas
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;

    //lista de productos
    @OneToMany(mappedBy = "usuario") //relacion de uno a muchos: un usuarios puede tener muchos productos y se mappea con usuario
    private List<Producto> productos;

    //lista de ordenens para un usuarios
    @OneToMany(mappedBy = "usuario") //relacion de uno a muchos: un usurios puede tener muchas ordenes y se mapea con usuarios
    private List<Orden> ordenes;
    
    
    public Usuarios() {
    }

    public Usuarios(Integer id, String nombre, String username, String email, String direccion, String telefono, String tipo, String password) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Usuarios" + 
                "ID:" + id + 
                "Nombre:" + nombre + 
                "Username=:" + username + 
                "Email:" + email + 
                "Direccion:" + direccion + 
                "Telefono:" + telefono + 
                "Tipo:" + tipo + 
                "Password:" + password + 
                "Productos:" + productos + 
                "Ordenes:" + ordenes;
    }
    

}
