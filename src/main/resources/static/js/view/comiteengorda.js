$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ReglasOpEngorda, #CurriMiemborsEngorda, #CartasConfiEngorda, #PlanAnualSesEngorda, #ReportesTriEngorda, #ConvocatoriaEngorda, #OrdenDiaEngorda, #PresenInforEngorda, #MinutaEngorda", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocomiteengorda?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
