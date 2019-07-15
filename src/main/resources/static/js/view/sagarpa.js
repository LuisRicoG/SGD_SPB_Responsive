$(document).ready(function () {
    var Documento;
    $(document).on("click", "#DocumentoSolicitud, #Deposito, #ComprobatePagos, #MensualesSagarpa, #EscritosEnviados, #RespuestasSagarpa", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentoSagarpa?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
