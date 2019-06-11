$(document).ready(function () {
    var month;
    $(document).on("click", "#enero , #febrero, #marzo, #abril, #mayo, #junio, #julio, #agosto, #septiembre, #octubre, #noviembre, #diciembre", function (data) {

        month = data.target.innerText;
        var url = '/SGD/getEstado?year=' + $('#year').val()
                + '&month=' + month;
        var fileName = "EstadoFinanciero-" + month + "-" + $('#year').val() + ".pdf";
        
        getDocument(url,fileName);
    });
});
