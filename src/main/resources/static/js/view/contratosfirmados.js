$(document).ready(function () {
    var Documento;
    $(document).on("click", "#Financieros, #Provedores, #Clientes, #Personal", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocontratos?documento=' + Documento;
        getDocument(url, Documento);
    });
});
