package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.DAOAbstractFactory;
import com.arquitecturajava.aplicacion.dao.DAOFactory;
import com.arquitecturajava.aplicacion.dao.LibroDAO;

/**
 * @author cecilio alvarez caules contacto@arquitecturajava.com
 * @version 1.0
 */
public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		DAOFactory factoria = DAOAbstractFactory.getInstance();
		LibroDAO libroDAO = factoria.getLibroDAO();

		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
		libroDAO.borrar(libro);
		return "MostrarLibros.do";
	}

}
