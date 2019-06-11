$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ReglasOpEngordaR, #CurriMiemborsEngordaR, #CartasConfiEngordaR, #PlanAnualSesEngordaR, #ReportesTriEngordaR, #ConvocatoriaEngordaR, #OrdenDiaEngordaR, #PresenInforEngordaR, #MinutaEngordaR", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocomiteengordareglas?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
