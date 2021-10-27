package co.edu.unicundi.alumnosjar.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.*;

/**
 *
 * @author acer
 */
@Entity
@Table (name = "alumno")

//Consultas JPQL (No se hace la consulta sobre la base de datos, sino en codigo java)
@NamedQueries({
    @NamedQuery(name = "Alumno.ListarTodos", query = "SELECT a FROM Alumno a")
})

public class Alumno implements Serializable {
    
    @Id //LLave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "nombre es obligatorio")
    @Size(min = 3, max = 30, message = "nombre debe estar entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    
    @NotNull(message = "apellido es obligatorio")
    @Size(min = 3, max = 30, message = "apellido debe estar entre 3 y 30 caracteres")
    @Pattern(regexp = "^[a-zA-Z_]+( [a-zA-Z_]+)*$", message = "¡Solo se admiten letras!")
    @Column(name = "apellido", nullable = false, length = 30)
    private String apellido;
    
    @NotNull(message = "edad es obligatorio")
    @Min(value = 18, message = "Debe ser mayor de edad")
    @Column(name = "edad", nullable = false)
    private Integer edad;
    
    @NotNull(message = "cedula es obligatorio")
    @Size(min = 7, max = 10, message = "cedula debe estar entre 7 y 10 caracteres")
    @Pattern(regexp = "^\\d+$", message = "¡Solo se admiten numeros!")
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;
    
    @NotNull (message = "correo es obligatorio")
    @Size(max = 50, message = "correo no debe superar los 50 caracteres")
    @Pattern (regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$", message = "¡Ingrese un formato valido!")
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    
    @NotNull (message = "fechaNacimiento es obligatorio")
    @Column(name = "fecha_nacimiento", nullable = true)
    private String fechaNacimiento;

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, Integer edad, String cedula, String correo, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
   /**
     * Metodo que envia la intancia para validar si tiene alguna violación 
     * @return 
     */
    public Set<ConstraintViolation<Alumno>> validar(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
}
