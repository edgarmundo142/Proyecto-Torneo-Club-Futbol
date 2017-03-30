$(document).ready(function(){
    
    $(".editarDatosPerfil").click(function(){
        representante = $(this).attr("data-name");
        $('#modalDatosPerfil').modal({
          keyboard: true
        })
    });
    
    $(".editarContraseñaPerfil").click(function(){
        representante = $(this).attr("data-name");
        $('#modalContraseñaPerfil').modal({
          keyboard: true
        })
    });
    
    /*$('#actualizarJugador').click(function(){
        $('#myModal').modal('hide');
        Lobibox.notify("success",{
            title:"Jugador actualizado",
            msg:"Se actualizo la informacion del jugador correctamente",
            position:"bottom right",
            delay:5000,
            width:400,
            iconSource:"fontAwesome"
        });
    });*/
    
    $.validate({
		form:"#formularioActualizarRepresentante",
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
                    alert('ok');
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
		form:"#formularioActualizarContraseña",
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
                    alert('ok');
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
    
});



