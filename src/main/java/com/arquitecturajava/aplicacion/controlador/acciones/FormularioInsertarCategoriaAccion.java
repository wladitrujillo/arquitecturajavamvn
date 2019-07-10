package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cecilio alvarez caules contacto@arquitecturajava.com
 * @version 1.0
 */
public class FormularioInsertarCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		return "FormularioInsertarCategoria.jsp";
	}

}
