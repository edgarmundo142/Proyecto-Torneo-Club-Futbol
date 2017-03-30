
function botones_Ant_Sig() {
	var ant = document.getElementById("anterior");
	var sig = document.getElementById("siguiente");
	
	ant.addEventListener("click", antPagina );
	sig.addEventListener("click", sigPagina );
}

function sigPagina() {
	var pagActiva = document.getElementById("paginas");
	var n = pagActiva.childNodes.length; // Retorna los nodos contenidos en la lista
	var page = pagActiva.childNodes; //Los espacios tambien se cuentan como nodos
	//Por eso en el for sumamos 2 en lugar de 1 para evitar los espacios
	var x, y, numPag = 0;
    
	for( var i = 1; i < n; i +=2, numPag++ ) {
		x = page[i].childNodes;  //Del elemento <li> toma los nodos 
		y = x[1].getAttribute("class"); //el nodo <a> obtenemos su clase para saber si esta activo
		
		if( y.split(" ")[1] == "active" ) {
			x[1].setAttribute("class", "nav-link");
			x = page[i+2].childNodes;
			x[1].setAttribute("class", "nav-link active");
			
			break;
		}
	}
	
	//alert( x[1].innerHTML );
}

function antPagina() {
	var pagActiva = document.getElementById("paginas");
	var n = pagActiva.childNodes.length; // Retorna los nodos contenidos en la lista
	var page = pagActiva.childNodes; //Los espacios tambien se cuentan como nodos
	//Por eso en el for sumamos 2 en lugar de 1 para evitar los espacios
	var x, y, numPag = 0;
    
	for( var i = 1; i < n; i +=2, numPag++ ) {
		x = page[i].childNodes;  //Del elemento <li> toma los nodos 
		y = x[1].getAttribute("class"); //el nodo <a> obtenemos su clase para saber si esta activo
		
		if( y.split(" ")[1] == "active" ) {
			x[1].setAttribute("class", "nav-link");
			break;
		}
	}
	
	alert( x[1].innerHTML );
	x = page[i-2].childNodes;
	x[1].setAttribute("class", "nav-link active");
}

window.addEventListener("load", botones_Ant_Sig );
