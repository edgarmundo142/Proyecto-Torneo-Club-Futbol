/*Reemplazar la linea 154 .serialize por la actual FormData(). En la linea 160, en la consulta ajax se agrego processData: false*/

$(document).ready(function(){
    
    /*Inicializar tabla de jugadores registrados por el capitan*/
    var htmlTabla = '';
    var nombreestatico;
    var apellidoPaternoestatico;
    var apellidoMaternoestatico;
    $.ajax({
        method:"post",
        url:"ControladorConsultarJugadores",
        success: function(resp){
            var jugadores = $.parseJSON(resp);
            for(i = 0; i < jugadores.length; i++){
                htmlTabla += "<tr>\n<th scope='row'>1</th>\n<td>" + jugadores[i].nombre + "</td>\n" +
                            "<td>" + jugadores[i].apellidoPaterno + "</td>\n" +
                            "<td>" + jugadores[i].apellidoMaterno + "</td>\n" +
                            "<td>" + jugadores[i].correo + "</td>\n" +
                            "<td>" + jugadores[i].foto + "</td>\n" +
                            "<td>\n" +
                            "<i class='fa fa-edit fa-1x editPlayer icono' aria-hidden='true' data-name='" + jugadores[i].nombre + ":" + jugadores[i].apellidoPaterno + ":" + jugadores[i].apellidoMaterno + "'></i>\n" +
                            "<i class='fa fa-close fa-1x deletePlayer icono' aria-hidden='true' data-name='" + jugadores[i].nombre + ":" + jugadores[i].apellidoPaterno + ":" + jugadores[i].apellidoMaterno + "'></i>\n" +
                            "</td>\n</tr>";
            }
            $('#tablaDeJugadoresRegistrados').html(htmlTabla);
            $(".editPlayer").click(function(){
                jugador = $(this).attr("data-name");
                nombre = jugador.replace(/:/g,' ');
                arreglopartirnombre=jugador.split(':');
                nombreestatico=arreglopartirnombre[0];
                apellidoPaternoestatico=arreglopartirnombre[1];
                apellidoMaternoestatico=arreglopartirnombre[2];
                $('#fajNombre').val(nombre);
                $('#modalActualizar').modal({
                  keyboard: true
                })
            });

            $(".deletePlayer").click(function(){
                jugador = $(this).attr("data-name");
                nombre = jugador.replace(/:/g,' ');
                var lobibox = Lobibox.confirm({
                    msg: "Est&aacute;s seguro que quieres eliminar al jugador " + nombre,
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
                            Lobibox.notify("success",{
                                title:"Jugador eliminado",
                                msg:"Se elimino a " + nombre + ' correctamente',
                                position:"bottom right",
                                delay:5000,
                                width:400,
                                iconSource:"fontAwesome"
                            });
                        }
                    },
                });
            });
        }
    });
    
    
    $.validate({
		form:"#formularioActualizarJugador",
		lang:"es",
        modules : 'file',
		onSuccess: function(){
            var lobibox = Lobibox.confirm({
                msg: "Est&aacute;s seguro que quieres registrar al jugador ",
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
                    datos = new FormData($("#formularioActualizarJugador")[0]);
                    $.ajax({
                        method:"post",
                        url:"ControladorActualizarJugador",
                        data: datos,
                        contentType:false,
                        processData: false,
                        success: function(resp){
                            if(resp==-1){
                                Lobibox.notify("error",{
                                    title:"Jugador no registrado",
                                    msg:"No se pudo registrar al jugador, intentelo m&aacute;s tarde",
                                    position:"bottom right",
                                    delay:4000,
                                    width:400,
                                    iconSource:"fontAwesome"
                                });
                            }else{
                                htmlTabla += "<tr>\n<th scope='row'>1</th>\n<td>" + nombreestatico + "</td>\n" +
                                "<td>" + apellidoPaternoestatico + "</td>\n" +
                                "<td>" + apellidoMaternoestatico + "</td>\n" +
                                "<td>" + $("#formularioActualizarJugador #correo").val() + "</td>\n" +
                                "<td>" + $("#formularioActualizarJugador #foto").val() + "</td>\n" +
                                "<td>\n" +
                                "<i class='fa fa-edit fa-1x editPlayer icono' aria-hidden='true' data-name='" + nombreestatico + ":" + apellidoPaternoestatico + ":" + apellidoMaternoestatico + "'></i>\n" +
                                "<i class='fa fa-close fa-1x deletePlayer icono' aria-hidden='true' data-name='" + nombreestatico + ":" + apellidoPaternoestatico + ":" + apellidoMaternoestatico + "'></i>\n" +
                                "</td>\n</tr>";
                                $('#tablaDeJugadoresRegistrados').html(htmlTabla);
                                $(".editPlayer").click(function(){
                                    jugador = $(this).attr("data-name");
                                    nombre = jugador.replace(/:/g,' ');
                                    $('#fajNombre').val(nombre);
                                    $('#modalActualizar').modal({
                                      keyboard: true
                                    })
                                });

                                $(".deletePlayer").click(function(){
                                    jugador = $(this).attr("data-name");
                                    nombre = jugador.replace(/:/g,' ');
                                    var lobibox = Lobibox.confirm({
                                        msg: "Est&aacute;s seguro que quieres eliminar al jugador " + nombre,
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
                                                Lobibox.notify("success",{
                                                    title:"Jugador eliminado",
                                                    msg:"Se elimino a " + nombre + ' correctamente',
                                                    position:"bottom right",
                                                    delay:5000,
                                                    width:400,
                                                    iconSource:"fontAwesome"
                                                });
                                            }
                                        },
                                    });
                                });
                                Lobibox.notify("success",{
                                    title:"Jugador registrado",
                                    msg:"Se registr&oacute; al jugador correctamente",
                                    position:"bottom right",
                                    delay:4000,
                                    width:400,
                                    iconSource:"fontAwesome"
                                });
                            }
                        }
                    });
                }
            },
            });
            return false;
        }
	});
       
});



