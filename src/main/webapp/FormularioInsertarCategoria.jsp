<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<link rel="stylesheet" type="text/css" href="css/formato.css" />
<script type="text/javascript" src="js/validacion.js">
	
</script>
<title>Formulario Categoria</title>
</head>
<body>
	<form id="formularioInsercion" action="InsertarCategoria.do">
		<fieldset>
			<legend>Formulario alta Categoria</legend>
			<p>
				<label for="code">id:</label> <input type="text" id="code"
					name="code" />
			</p>
			<p>
				<label for="descripcion">Descripcion:</label> <input type="text"
					id="descripcion" name="descripcion" />
			</p>
			<p>
				<input type="submit" value="Insertar" />
			</p>
		</fieldset>
	</form>

</body>
</html>

