package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "libros")
public class Libro {
	//la entidad debe de tener un id, en este caso sera 
	//la propiedad id
	@Id
	//podemos decirle al motor de bbdd que nos autogenere 
	//el id cada vez que mandemos un objeto para persistir
	//suele ser la mejor opcion
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private double precio;


	
	@ManyToMany(mappedBy="libros",cascade=CascadeType.PERSIST) 
	private List<Libreria> librerias;
	
	
	
	@ManyToOne
	@JoinColumn(name="fk_id_autor", referencedColumnName="id")
	private Autor autor;

	
	@ManyToOne
	@JoinColumn(name="fk_id_editorial", referencedColumnName="id")
	private Editorial editorial;

	

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Libro(int id, String titulo, double precio, Editorial editorial, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
	
	}
	
	
	
	



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + "]";
	}
	
	
	
	
	
}