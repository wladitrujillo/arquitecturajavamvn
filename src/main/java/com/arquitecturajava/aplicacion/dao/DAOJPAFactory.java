package com.arquitecturajava.aplicacion.dao;

import com.arquitecturajava.aplicacion.dao.jpa.CategoriaDAOJPAImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDAOJPAImpl;

public class DAOJPAFactory implements DAOFactory {

	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOJPAImpl();
	}

	public LibroDAO getLibroDAO() {
		return new LibroDAOJPAImpl();
	}
}
