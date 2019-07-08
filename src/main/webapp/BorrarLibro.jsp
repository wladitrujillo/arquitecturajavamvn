<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.arquitecturajava.Libro"%>
<%@ page import="com.arquitecturajava.DataBaseException" %>

<% 

String isbn= request.getParameter("isbn");
	
	Libro libro= new Libro(isbn);
	libro.borrar();
	response.sendRedirect("MostrarLibros.jsp");
	

	
%>
