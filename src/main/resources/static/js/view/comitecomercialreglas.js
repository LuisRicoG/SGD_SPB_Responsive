$(document).ready(function () {
    var Documento;
    $(document).on("click", "#ReglasOpComercialR, #CurriMiemborsComercialR, #CartasConfiComercialR, #PlanAnualSesComercialR, #ReportesTriComercialR, #ConvocatoriaComercialR, #OrdenDiaComercialR, #PresenInforComercialR, #MinutaComercialR", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentocomitecomercialreglas?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
