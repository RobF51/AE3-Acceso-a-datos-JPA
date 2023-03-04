package modelo.entidad;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




//Con esta anotacion podemos decirle a JPA que esta clase sera
//una tabla de base de datos, por defecto la tabla se llamar�
//como la clase. La clase debe de seguir la convenci�n JavaBean
@Entity
//Si queremos cambiar el nombre de la tabla, podemos hacerlo
//con la siguiente anotacion
@Table(name = "autores")
public class Autor {
	//la entidad debe de tener un id, en este caso sera 
	//la propiedad id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellidos;
	
	
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	
	
	@OneToMany(mappedBy="autor",cascade=CascadeType.PERSIST) 
	private List<Libro> libros;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public List<Libro> getLibros() {
		return libros;
	}



	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}



	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", libros=" + libros + "]";
	}
	
	
	
	
	
	
}
	