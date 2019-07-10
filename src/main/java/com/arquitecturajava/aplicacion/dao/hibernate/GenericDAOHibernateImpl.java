package com.arquitecturajava.aplicacion.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.arquitecturajava.aplicacion.dao.GenericDAO;

public class GenericDAOHibernateImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;

	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {

		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	@Override
	public T buscarPorClave(Serializable id) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		T o = (T) session.get(claseDePersistencia, id);
		session.close();
		return o;
	}

	@Override
	public List<T> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<T> listaDeLibros = session.createQuery("from" + claseDePersistencia.getSimpleName() + " o").list();
		session.close();
		return listaDeLibros;
	}

	@Override
	public void salvar(T objeto) {
		SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(objeto);
		session.getTransaction().commit();

	}

	@Override
	public void borrar(T objeto) {
		SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(objeto);
		session.getTransaction().commit();

	}

	@Override
	public void insertar(T objeto) {
		SessionFactory sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(objeto);
		session.getTransaction().commit();

	}

}
