$(document).ready(function () {
    var x;
    $(document).on("click", "#inmuebles, #eqcomputo, #eqtransporte, #maqyequipo, #mobiliario", function (data) {
        x = data.target.id;
        var url = '/SGD/getFAZip?x=' + x;
        var fileName = "FA" + x + ".zip";
        getDocument(url, fileName);
    });
});
