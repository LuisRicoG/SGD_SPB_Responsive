$(document).ready(function () {
    var x;
    $(document).on("click", "#inmuebles, #eqcomputo, #eqtransporte, #maqyequipo, #mobiliario", function (data) {
        x = data.target.id;
        var url = '/SGD/getSZip?x=' + x;
        var fileName = "S" + x + ".zip";
        getDocument(url, fileName);
    });
});
