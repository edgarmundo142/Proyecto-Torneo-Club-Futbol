$(document).ready(function(){
    
    /*Inicializar tabla de jugadores registrados por el capitan*/
    var htmlTabla = '';
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
    $(".verPlantilla").click(function(){
        equipo = $(this).attr("data-name");
        $('#modalVerP').modal({
          keyboard: true
        })
    });
    $(".registrarJugador").click(function(){
        jugador = $(this).attr("data-name");
        $('#modalRegistrar').modal({
          keyboard: true
        })
    });
    
    $(".registrarEquipo").click(function(){
        jugador = $(this).attr("data-name");
        $('#modalRegistrarEquipo').modal({
          keyboard: true
        })
    });
    
    $.validate({
		form:"#formularioActualizarJugador",
		lang:"es",
        modules : 'file',
		onSuccess: function(){
            var lobibox = Lobibox.confirm({
                msg: "Est&aacute;s seguro que desea actualizar la informaci&oacute;n",
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
                        url:"ControladorActualizarJugador",
                        data:"nombre=edgar&correo=hola@hola.com&telefono=7731256415",
                        success: function(resp){
                            alert(resp);
                        }
                    });
                    /*Lobibox.notify("success",{
                        title:"Jugador actualizado",
                        msg:"Se actualizo la informaci&oacute;n correctamente",
                        position:"bottom right",
                        delay:4000,
                        width:400,
                        iconSource:"fontAwesome"
                    });*/
                }
            },
            });
            return false;
        }
	});
    
    $.validate({
		form:"#formularioRegistrarJugador",
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
                    datos = $("#formularioRegistrarJugador").serialize();
                    $.ajax({
                        method:"post",
                        url:"ControladorRegistrarJugador",
                        data: datos,
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
                                htmlTabla += "<tr>\n<th scope='row'>1</th>\n<td>" + $("#formularioRegistrarJugador #nombre").val() + "</td>\n" +
                                "<td>" + $("#formularioRegistrarJugador #apellidoPaterno").val() + "</td>\n" +
                                "<td>" + $("#formularioRegistrarJugador #apellidoMaterno").val() + "</td>\n" +
                                "<td>" + $("#formularioRegistrarJugador #correo").val() + "</td>\n" +
                                "<td>" + "foto" + "</td>\n" +
                                "<td>\n" +
                                "<i class='fa fa-edit fa-1x editPlayer icono' aria-hidden='true' data-name='" + $("#formularioRegistrarJugador #nombre").val() + ":" + $("#formularioRegistrarJugador #apellidoPaterno").val() + ":" + $("#formularioRegistrarJugador #apellidoMaterno").val() + "'></i>\n" +
                                "<i class='fa fa-close fa-1x deletePlayer icono' aria-hidden='true' data-name='" + $("#formularioRegistrarJugador #nombre").val() + ":" + $("#formularioRegistrarJugador #apellidoPaterno").val() + ":" + $("#formularioRegistrarJugador #apellidoMaterno").val() + "'></i>\n" +
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
    
    $.validate({
		form:"#formularioRegistrarEquipo",
		lang:"es",
        modules : 'file',
		onSuccess: function(){
            jsonObj = [];
            jugadores = [];
            item = {}
            item ["equipo"] = $('#freNombreEquipo').val();
            item ["torneo"] = $('#freTorneo').val();
            item ["uniforme"] = $('#freColorUniforme').val();
            //item ["jugadores"] = [];
            var numeroJugadores = 0;
            $('#elegirJugadores').find('input[type="checkbox"]:checked').each(function () {
                numeroJugadores++;
                item2 = {}
                item2 ['nombre'] = $(this).attr('data-jugador');
                jugadores.push(item2);
            });
            if(numeroJugadores == 0){
                Lobibox.notify("error",{
                    title:"Plantilla insuficiente",
                    msg:'La plantilla no tiene el n&uacute;mero m&iacute;nimo de jugadores',
                    position:"bottom right",
                    delay:5000,
                    width:400,
                    iconSource:"fontAwesome"
                });
                return false;
            }
            item ["jugadores"] = jugadores;
            jsonObj.push(item);
            jsonString = JSON.stringify(jsonObj);
            var lobibox = Lobibox.confirm({
                msg: "Est&aacute;s seguro que quires registrar este equipo",
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
                        url:"ControladorRegistrarEquipo",
                        data:"json=" + jsonString,
                        success: function(resp){
                            alert(resp);
                            if(resp==-1){
                                Lobibox.notify("error",{
                                    title:"Equipo no registrado",
                                    msg:"No se pudo registrar al equipo, intentelo m&aacute;s tarde",
                                    position:"bottom right",
                                    delay:4000,
                                    width:400,
                                    iconSource:"fontAwesome"
                                });
                            }else{
                                Lobibox.notify("success",{
                                    title:"Equipo registrado",
                                    msg:"Se registr&oacute; al equipo correctamente",
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
