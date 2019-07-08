package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




@Entity
@Table(name="Libros")
public class Libro {
	
	/**
	 * @author      cecilio alvarez caules contacto@arquitecturajava.com
	 * @version     1.0                        
	 */
	@Id
	private String isbn;
	private String titulo;
	private String categoria;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}

	public Libro() {
		super();
	}

	public Libro(String isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodasLasCategorias()  {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta="select distinct libro.categoria from Libro libro";
		List<Libro> listaDeCategorias = session.createQuery(consulta).list();
		session.close();
		return listaDeCategorias;
	
	}
	

	public void insertar() {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
	
	}

	public void borrar(){

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();

	}

	public void salvar() {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	

	}

	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodos()  {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Libro> listaDeLibros = session.createQuery(" from Libro libro").list();
		session.close();
		return listaDeLibros;

	}

	public static Libro buscarPorClave(String isbn)  {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro=(Libro) session.get(Libro.class,isbn);
		session.close();
		return libro;
	}

	@SuppressWarnings("unchecked")
	public static List<Libro> buscarPorCategoria(String categoria)  {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Query consulta=session.createQuery(" from Libro libro where libro.categoria=:categoria");
		consulta.setString("categoria", categoria);
		List<Libro> listaDeLibros = consulta.list();
		session.close();
		return listaDeLibros;
	
	}

}
