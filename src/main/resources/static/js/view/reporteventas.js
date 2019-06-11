$(document).ready(function () {
    var month;
    $(document).on("click", "#enero , #febrero, #marzo, #abril, #mayo, #junio, #julio, #agosto, #septiembre, #octubre, #noviembre, #diciembre", function (data) {

        month = data.target.innerText;
        var url = '/SGD/getReporte?year=' + $('#year').val()
                + '&month=' + month;
        var fileName = "ReporteVentas-" + month + "-" + $('#year').val() + ".pdf";
        getDocument(url,fileName);
    });
});
