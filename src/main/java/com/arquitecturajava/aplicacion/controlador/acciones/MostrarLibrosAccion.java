package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.CategoriaDAO;
import com.arquitecturajava.aplicacion.dao.CategoriaDAOFactory;
import com.arquitecturajava.aplicacion.dao.LibroDAO;
import com.arquitecturajava.aplicacion.dao.LibroDAOFactory;

/**
 * @author cecilio alvarez caules contacto@arquitecturajava.com
 * @version 1.0
 */
public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		LibroDAO libroDAO = LibroDAOFactory.getInstance();
		CategoriaDAO categoriaDAO = CategoriaDAOFactory.getInstance();
		List<Libro> listaDeLibros = libroDAO.buscarTodos();
		List<Categoria> listaDeCategorias = categoriaDAO.buscarTodos();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";

	}

}
