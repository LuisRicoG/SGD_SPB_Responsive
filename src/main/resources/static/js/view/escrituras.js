$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ActaConstitutiva, #Poderes", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentoescrituras?documento=' + Documento;
        getDocument(url, Documento);
    });
});
