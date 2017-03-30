$(document).ready(function () {
   $("#btn-back").click(function () {
       window.location.href = "index.html";
   });
    $.validate({
		form:"#formulario-registro-representante",
		lang:"es",
        modules : 'file security',
		onSuccess: function(){
            datos = new FormData($("#formulario-registro-representante")[0]);
            $.ajax({
                method:"post",
                url:"ControladorRegistroRepresentante",
                data:datos,
                contentType:false,
                success: function(resp){

                }
            });
            return false;
        }
	});
});