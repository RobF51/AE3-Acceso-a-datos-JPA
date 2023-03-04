package modelo.entidad;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Embeddable
public class ColeccionLibros {



	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private List<Libro> listalibros;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Libro> getListalibros() {
		return listalibros;
	}

	public void setListalibros(List<Libro> listalibros) {
		this.listalibros = listalibros;
	}

	@Override
	public String toString() {
		return "ColeccionLibros [id=" + id + ", listalibros=" + listalibros + "]";
	}
	
	
	
	
	
	
	
	
	

	
}
	
