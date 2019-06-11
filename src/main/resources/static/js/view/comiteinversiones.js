$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ReglasOpInversiones, #CurriMiemborsInversiones, #CartasConfiInversiones, #PlanAnualSesInversiones, #ReportesTriInversiones, #ConvocatoriaInversiones, #OrdenDiaInversiones, #PresenInforInversiones, #MinutaInversiones", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocomiteinversiones?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
