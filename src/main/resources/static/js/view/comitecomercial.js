$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ReglasOpComercial, #CurriMiemborsComercial, #CartasConfiComercial, #PlanAnualSesComercial, #ReportesTriComercial, #ConvocatoriaComercial, #OrdenDiaComercial, #PresenInforComercial, #MinutaComercial", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocomitecomercial?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
