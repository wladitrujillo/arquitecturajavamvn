package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;

/**
 * @author cecilio alvarez caules contacto@arquitecturajava.com
 * @version 1.0
 */
public class InsertarCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");
		String descripcion = request.getParameter("descripcion");

		Categoria categoria = new Categoria(Integer.parseInt(code), descripcion);

		categoria.insertar();

		return "MostrarLibros.do";
	}

}
