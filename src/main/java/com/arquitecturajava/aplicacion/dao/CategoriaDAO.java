package com.arquitecturajava.aplicacion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.arquitecturajava.aplicacion.bo.Categoria;

public class CategoriaDAO {

	public List<Categoria> buscarTodos() {

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();

		List<Categoria> listaDeCategorias = null;
		try {

			TypedQuery<Categoria> consulta = manager.createQuery("Select c from Categoria c", Categoria.class);

			listaDeCategorias = consulta.getResultList();
			return listaDeCategorias;
		} finally {
			manager.close();
		}

	}

	public void insertar(Categoria categoria) {

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();

		EntityTransaction tx = null;
		try {

			tx = manager.getTransaction();
			tx.begin();
			manager.merge(categoria);
			tx.commit();

		} catch (PersistenceException e) {

			manager.getTransaction().rollback();
			throw e;
		} finally {

			manager.close();
		}

	}

	public Categoria buscarPorClave(int id) {

		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();

		TypedQuery<Categoria> consulta = manager.createQuery("Select c from Categoria c where c.id=?1",
				Categoria.class);

		consulta.setParameter(1, id);
		Categoria categoria = null;

		try {

			categoria = consulta.getSingleResult();

			return categoria;

		} finally {

			manager.close();
		}

	}

}
