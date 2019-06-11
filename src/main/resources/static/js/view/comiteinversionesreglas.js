$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ReglasOpInversionesR, #CurriMiemborsInversionesR, #CartasConfiInversionesR, #PlanAnualSesInversionesR, #ReportesTriInversionesR, #ConvocatoriaInversionesR, #OrdenDiaInversionesR, #PresenInforInversionesR, #MinutaInversionesR", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocomiteinversionesreglas?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
