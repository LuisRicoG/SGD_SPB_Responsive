$(document).ready(function () {
    var Documento;
    $(document).on("click", "#RFC, #Fiel, #SelloDigital, #AvisoPrivacidad, #CumplimientoObli, #AsambleaOrdinaria, #ComprobanteDomicilio", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentolegal?documento=' + Documento;
        getDocument(url, Documento);
    });
});
