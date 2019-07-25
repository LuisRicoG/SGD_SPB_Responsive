$(document).ready(function () {
    var Documento;
    $(document).on("click", "#EstudiosEconomicos, #PrecioGanadoPie, #PrecioCarneCanal, #PrecioAlimento, #censoganadero", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentoinformacion?documento=' + Documento;
        getDocument(url, Documento);
    });
});
