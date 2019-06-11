$(document).ready(function () {
    var Documento;
    $(document).on("click", "#Consejo, #ComiteInversiones, #ComiteEngorda, #ComiteComercial ,#EnlacesCorpo", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentoreglas?documento=' + Documento;
        getDocument(url,Documento);
    });
});
