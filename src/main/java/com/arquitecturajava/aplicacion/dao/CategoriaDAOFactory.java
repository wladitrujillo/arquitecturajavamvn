package com.arquitecturajava.aplicacion.dao;

import com.arquitecturajava.aplicacion.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.aplicacion.dao.jpa.CategoriaDAOJPAImpl;

public class CategoriaDAOFactory {
	
	public CategoriaDAO getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new CategoriaDAOHibernateImpl();
		} else {
			return new CategoriaDAOJPAImpl();
		}
	}

}
