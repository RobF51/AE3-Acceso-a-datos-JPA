package main;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;

import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.entidad.ColeccionLibros;


public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("practicajpa");
			
		EntityManager em = null;
		
		
		
		Autor autor1 = new Autor ();
		autor1.setNombre("Paco");
		autor1.setApellidos("R.Nuno");
		//autor1.setFechaNacimiento(new Date());
		
		Autor autor2 = new Autor ();
		autor2.setNombre("Juan");
		autor2.setApellidos("C.Camino");
		//autor2.setFechaNacimiento(new Date());
		
		Autor autor3 = new Autor ();
		autor3.setNombre("Alberto");
		autor3.setApellidos("A.Tornero");
		//autor3.setFechaNacimiento(new Date());
		
		
		Editorial editorial1 = new Editorial();
		editorial1.setNombre("Planeta");
		editorial1.setDireccion("Juan Ignacio Luca de Tena, nº 17");
		
		Editorial editorial2 = new Editorial();
		editorial2.setNombre("Penguin Random");
		editorial2.setDireccion("Calle de Luchana, 23");
		
		
		Libro libro1 = new Libro();
		libro1.setTitulo("El numero 5");
		libro1.setPrecio(45);
		libro1.setEditorial(editorial1);
		libro1.setAutor(autor3);
		
		Libro libro2 = new Libro();
		libro2.setTitulo("la quinta ola");
		libro2.setPrecio(25);
		libro2.setEditorial(editorial2);
		libro2.setAutor(autor1);
		
		
		Libro libro3 = new Libro();
		libro3.setTitulo("casados");
		libro3.setPrecio(16);
		libro3.setEditorial(editorial1);
		libro3.setAutor(autor2);
		
		Libro libro4 = new Libro();
		libro4.setTitulo("cara a cara");
		libro4.setPrecio(38);
		libro4.setEditorial(editorial1);
		libro4.setAutor(autor2);
		
		Libro libro5 = new Libro();
		libro5.setTitulo("sra rushmore");
		libro5.setPrecio(5);
		libro5.setEditorial(editorial1);
		libro5.setAutor(autor2);
		
		Libro libro6 = new Libro();
		libro6.setTitulo("diccionario de la verdad");
		libro6.setPrecio(54);
		libro6.setEditorial(editorial1);
		libro6.setAutor(autor3);
		
		Libro libro7 = new Libro();
		libro7.setTitulo("sra rushmore");
		libro7.setPrecio(32);
		libro7.setEditorial(editorial1);
		libro7.setAutor(autor2);
		
		Libro libro8 = new Libro();
		libro4.setTitulo("adios");
		libro4.setPrecio(1);
		libro4.setEditorial(editorial2);
		libro4.setAutor(autor1);
		
		
		List<Libro> listalibros = new ArrayList<Libro>();
		listalibros.add(libro1);
		listalibros.add(libro2);
		listalibros.add(libro4);
		listalibros.add(libro6);
		Libreria libr1 = new Libreria();
		libr1.setLibros(listalibros);
		
		
		listalibros.clear();
		
		
		listalibros.add(libro3);
		listalibros.add(libro2);
		listalibros.add(libro4);
		listalibros.add(libro8);
		Libreria libr2 = new Libreria();
		libr1.setLibros(listalibros);
		
		
		
		
		

		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(autor1); 
		em.persist(autor2); 
		em.persist(autor3);
		em.persist(editorial1); 
		em.persist(editorial2); 
		em.persist(libro1);
		em.persist(libro2);
		em.persist(libro3);
		em.persist(libro4);
		em.persist(libro5);
		em.persist(libro6);
		em.persist(libro7);
		em.persist(libro8);
		em.persist(libr1);
		em.persist(libr2);
		
		em.getTransaction().commit(); 
		em.close();	
		
		
		
		
				
	
		//EMPEZAMOS LAS CONSULTAS
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		System.out.println("===================================");
		
		Query query = em.createQuery("SELECT lib, lib.id_editorial, id_autor FROM Libro lib");
		
		List<Libro> list = query.getResultList();
		
		listarLibros1(list);
		
		
		
		query = em.createQuery("SELECT autor, autor.id_libro  FROM Autor autor");
		
		List<Autor> list2 = query.getResultList();
		
		listarautores(list2);
		
		
		
		query = em.createQuery("SELECT libr.id_libreria, libr.id_libro  FROM Libreria libr");
		
		List<Libreria> list3 = query.getResultList();
		
		listarlibrerias(list3);
		
		
		query = em.createQuery("SELECT lib, lib.id_libreria  FROM Libros lib");
		
		List<Libro> list4 = query.getResultList();
		
		listarLibros2(list4);
		
		
		
		
		
		
		
		
		
		System.out.println("todo ok?");
		
		
		em.getTransaction().commit(); 
		
		emf.close();
		
	
	
		
		
		
	}





public static void listarLibros1(List<Libro> librosRes) {
	for(Libro l : librosRes) {
		System.out.println("Libro-> id: "+l.getId()+" titulo: " + l.getTitulo() + "; precio: " + l.getPrecio()+"editorial: "+ l.getEditorial()+ "autor: "+l.getAutor());
	}
}

public static void listarautores(List<Autor> autoresRes) {
	for(Autor a : autoresRes) {
		System.out.println("Autor-> id: "+a.getId()+" nombre: " +a.getNombre() + "; apellidos: " + a.getApellidos()+"fecha: "+ a.getFechaNacimiento()+ "libros: "+a.getLibros());
	}
}

public static void listarlibrerias(List<Libreria> libreriasRes) {
	for(Libreria lib : libreriasRes) {
		System.out.println("Libreria-> id: "+lib.getId()+" libros: " + lib.getLibros() );
	}
}


public static void listarLibros2(List<Libro> librosRes) {
	for(Libro l : librosRes) {
		System.out.println("Libro-> id: "+l.getId()+" titulo: " + l.getTitulo() + "; precio: " + l.getPrecio()+"editorial: "+ l.getEditorial()+ "autor: "+l.getAutor() + "libreria: ");
	}
}

}