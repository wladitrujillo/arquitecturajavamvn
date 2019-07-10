package com.arquitecturajava.aplicacion.dao;

import com.arquitecturajava.aplicacion.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class LibroDAOFactory {

	public static LibroDAO getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new LibroDAOHibernateImpl();
		} else {
			return new LibroDAOJPAImpl();
		}
	}

}
