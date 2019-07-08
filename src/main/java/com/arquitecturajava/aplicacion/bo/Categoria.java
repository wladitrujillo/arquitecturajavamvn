package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 * @author      cecilio alvarez caules contacto@arquitecturajava.com
 * @version     1.0                        
 */
@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	private int id;
	private String descripcion;

	@Override
	public int hashCode() {
		return id;
		
	}
	@Override
	public boolean equals (Object o) {
		int categoriaId= ((Categoria)o).getId();
		return id==categoriaId;
		
	}
	
	@OneToMany(targetEntity = Libro.class)
	@JoinColumn(name = "categoria")
	private List<Libro> listaDeLibros;

	public List<Libro> getListaDeLibros() {
		return listaDeLibros;
	}

	public void setListaDeLibros(List<Libro> listaDeLibros) {
		this.listaDeLibros = listaDeLibros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public  static List<Categoria> buscarTodos() {

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();

		List<Categoria> listaDeCategorias = null;
		try {

			TypedQuery<Categoria> consulta = manager.createQuery(
					"Select c from Categoria c", Categoria.class);

			listaDeCategorias = consulta.getResultList();
			return listaDeCategorias;
		} finally {
			manager.close();
		}

	}

	public Categoria(int id) {
		super();
		this.id = id;
	}

	public Categoria() {
		super();
	}

	public Categoria(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public void insertar() {


		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();

		EntityTransaction tx = null;
		try {

			tx=manager.getTransaction();
			tx.begin();	
			manager.persist(this);
			tx.commit();

		} catch (PersistenceException e) {

			manager.getTransaction().rollback();
			throw e;
		} finally {

			manager.close();
		}

	}


	public static  Categoria buscarPorClave(int id) {

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();

		TypedQuery<Categoria> consulta = manager.createQuery(
				"Select c from Categoria c where c.id=?1", Categoria.class);
		
		consulta.setParameter(1, id);
		Categoria categoria=null;
		
		try {

			categoria = consulta.getSingleResult();
			
			return categoria;

		} finally {

			manager.close();
		}

	}

}
