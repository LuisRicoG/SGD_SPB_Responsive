$(document).ready(function () {
    var Documento;
    $(document).on("click", "#tarjetaejecutiva, #proyectoespanol, #proyectoingles", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentopresentaciones?documento=' + Documento;
        getDocument(url, Documento);
    });
});
