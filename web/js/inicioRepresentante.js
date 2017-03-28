$(document).ready(function(){
    
    $(".editPlayer").click(function(){
        jugador = $(this).attr("data-name");
        $('#myModal').modal({
          keyboard: true
        })
    });
    
    $(".deletePlayer").click(function(){
        jugador = $(this).attr("data-name");
        var lobibox = Lobibox.confirm({
            msg: "Est&aacute;s seguro que quieres eliminar a " + jugador,
            title: "Confirmacion",
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
                        msg:"Se elimino a " + jugador + ' correctamente',
                        position:"bottom right",
                        delay:5000,
                        width:400,
                        iconSource:"fontAwesome"
                    });
                }
            },
        });
    });
    
    $('#actualizarJugador').click(function(){
        $('#myModal').modal('hide');
        Lobibox.notify("success",{
            title:"Jugador actualizado",
            msg:"Se actualizo la informacion del jugador correctamente",
            position:"bottom right",
            delay:5000,
            width:400,
            iconSource:"fontAwesome"
        });
    });
});

