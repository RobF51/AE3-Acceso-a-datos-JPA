package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Con esta anotacion podemos decirle a JPA que esta clase sera
//una tabla de base de datos, por defecto la tabla se llamar�
//como la clase. La clase debe de seguir la convenci�n JavaBean
@Entity
//Si queremos cambiar el nombre de la tabla, podemos hacerlo
//con la siguiente anotacion
@Table(name = "librerias")
public class Libreria {
	//la entidad debe de tener un id, en este caso sera 
	//la propiedad id
	@Id
	//podemos decirle al motor de bbdd que nos autogenere 
	//el id cada vez que mandemos un objeto para persistir
	//suele ser la mejor opcion
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String nombre_dueno;
	private String direccion;
	
	
	@ManyToMany
	@JoinTable(name="Librerias-libros",
	   joinColumns= { @JoinColumn(name="fk_id_libreria", referencedColumnName="id") }, //FK que aporta Comercial
	   inverseJoinColumns= { @JoinColumn(name="fk_id_libro", referencedColumnName="id")})
	private List <Libro> libros;

	
	
	
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
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
	public String getNombre_dueno() {
		return nombre_dueno;
	}
	public void setNombre_dueno(String nombre_dueno) {
		this.nombre_dueno = nombre_dueno;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombre_dueno=" + nombre_dueno + ", direccion="
				+ direccion + "]";
	}
	
	//Libros??????????????????????????????????????????????????????????????
	
	
	 
	
}
	