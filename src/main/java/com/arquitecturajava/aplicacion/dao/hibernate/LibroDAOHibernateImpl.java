package com.arquitecturajava.aplicacion.dao.hibernate;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.LibroDAO;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro, String> implements LibroDAO {

	@Override
	public List<Libro> buscarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
