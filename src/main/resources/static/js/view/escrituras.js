$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ActaConstitutiva, #Poderes, #ActaInscrRFC, #PoderesInscrRFC, #ReformaInscrRFC", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentoescrituras?documento=' + Documento;
        getDocument(url, Documento);
    });
});
