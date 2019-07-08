window.onload=generarEvento;

function validacion() {
	//Revisar con el libro The Professional Javascrpipt Apress

	var isbn= document.getElementById("isbn");
	var miformulario=document.getElementById("miformulario");
	if(isbn.value==""){
		alert("datos no validos");
		return false;
	}else{
		miformulario.submit();
	}
}

