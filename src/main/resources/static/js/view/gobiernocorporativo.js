$(document).ready(function () {
    var Documento;
    $(document).on("click", "#Consejo, #ComiteInversiones, #ComiteEngorda, #ComiteComercial, #ProtocoloAccionistas, #ReglasOperacion, #PlanTrabajoAnual, #CodigoEtica, #ComiteEngorda,#ComiteComercial ,#EnlacesCorpo, #InformeActividades, #NuestroModelo, #reglasOp", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentogobierno?documento=' + Documento;
        getDocument(url, Documento);
    });
});