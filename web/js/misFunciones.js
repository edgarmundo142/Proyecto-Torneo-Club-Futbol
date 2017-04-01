
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

function Fecha() {
	this.dia  = "00";
	this.mes  = "00";
	this.anio = "0000";
    
	this.getDia = function() {
		return this.dia;
	}
	
	this.getMes = function() {
       return this.mes;
    }
    
    this.getAnio = function() {
       return this.anio;
    } 
    
    this.setDia = function( dia ) {
		var m = parseInt( this.getMes() );
		var diaValido = false;
		
		if( m % 2 == 1 || m == 8 || m == 10 || m == 12 ) {
			if( parseInt( dia ) > 0 && parseInt( dia ) <= 31 ) {
				this.dia = dia;
				diaValido = true;
			}
			
		} else if( m % 2 == 0 || m == 9 || m == 11 ) {
			if( m == 2 && parseInt( dia ) > 0 && parseInt( dia ) <= 29 ) {
				this.dia = dia;
				diaValido = true;
				
			} else if( parseInt( dia ) > 0 && parseInt( dia ) <= 30 ) {
			
				this.dia = dia;
				diaValido = true;
			}
		}
		
		return diaValido;
	}
    
    this.setMes = function( mes ) {
		if( parseInt( mes ) > 0 && parseInt( mes ) <= 12 ) {
			this.mes = mes;
			return true;
		} else 
			return false;
    } 
    
    this.setAnio = function( anio ) {
	    var fecha = new Date();
	    var anioActual = fecha.getFullYear();
	    
		if( parseInt( anio ) >= parseInt( anioActual ) && parseInt( anio ) <= parseInt( anioActual ) + 1 ) {
			this.anio = anio;
			
			return true;
		} 
		
		return false;
    }
    
    this.setFecha = function( fecha ) {
    	var f = fecha.split("/");
    	var fechaValida = false;
    	
    	if( f.length == 3 ) {
    		if( this.setMes( f[0] ) )
	    		if( this.setDia( f[1] ) )
					if( this.setAnio( f[2] ) )
						fechaValida = true;
    	} 
    	
    	return fechaValida;
    }
    
    this.setFechaActual = function() {
		var fecha = new Date();
		var dia, mes, anio;
	
		dia = fecha.getDate();
		mes = fecha.getMonth() + 1;
		anio = fecha.getFullYear();
	
		if( dia <= 9 ) {
			dia = "0" + dia;
		}
	
		if( mes <= 9 ) {
			mes = "0" + mes;
		}
	
		this.setDia( dia );
		this.setMes( mes );
		this.setAnio( anio );
	}
	
	this.getFecha = function() {
		return this.getMes() + "/" + this.getDia() + "/" + this.getAnio();
	}
}


function fechaTerminoTorneo() {
	var fecha = document.getElementById("iniTorneo").value;
	var fechaActual = new Fecha();
	var fecha1 = new Fecha();
	
	fechaActual.setFechaActual();
	if( !fecha1.setFecha( fecha ) ) {
		alert("FECHA NO VALIDA\n");
		return;
	}
	
	if( parseInt( fecha1.getMes() ) >= parseInt( fechaActual.getMes() ) ) {
		if( parseInt( fecha1.getMes() ) == parseInt( fechaActual.getMes() ) ) {
			if( parseInt( fecha1.getDia() ) < parseInt( fechaActual.getDia() ) ) {
				alert("No se puede iniciar un torneo con una fecha pasada\n");
				document.getElementById("iniTorneo").value = fechaActual.getFecha();
				
				return;
			}
		}
	}
	
	var x = $.datepicker.iso8601Week( new Date( fechaActual.getAnio(), fechaActual.getMes(), fechaActual.getDia() ) );
	alert( x + 4 );
}

window.addEventListener("load", botones_Ant_Sig );


$.validate( {
	form:"#siguiente",
	lang:"es",
	modules : 'file',
	onSuccess: function(){
		var lobibox = Lobibox.confirm({
			msg: "Est&aacute;s seguro que quires registrar al jugador ",
			title: "Confirmaci&oacute;n",
			buttons: {
				yes: {
					'class': 'btn btn-success',
					text: "Si",
					closeOnClick: true
				},
				cancel: {
					'class': 'btn btn-danger',
					text: 'Cancelar',
					closeOnClick: true
				}
			},
			
			callback: function(lobibox, type){
				if(type == 'yes'){
					$.ajax({
						method:"post",
						url:"ControladorRegistrarJugador",
						data:"nombre=edgar&correo=hola@hola.com&telefono=7731256415",
						success: function(resp){
							alert(resp);
						}
					});
					Lobibox.notify("success",{
						title:"Jugador actualizado",
						msg:"Se registr&oacute; al jugador correctamente",
						position:"bottom right",
						delay:4000,
						width:400,
						iconSource:"fontAwesome"
					});
				}
			},
		});
	
		return false;
	}
});





















