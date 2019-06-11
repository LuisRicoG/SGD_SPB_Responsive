$(document).ready(function () {
    var Documento;
    $(document).on("click", "#Enero, #Febrero, #Marzo, #Abril, #Mayo, #Junio, #Julio, #Agosto, #Septiembre, #Octubre, #Noviembre ,#Diciembre", function (data) {
        Documento = 'InformaActividades-' + data.target.id;
        var url = '/SGD/getdocumentoInforme?year=' + $('#year').val()
                + '&documento=' + Documento;
        var fileName = Documento + "-" + $('#year').val();
        getDocument(url, fileName);
    });
});
