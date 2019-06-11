$(document).ready(function () {
    var x;
    $(document).on("click", "#inmuebles, #eqcomputo, #eqtransporte, #maqyequipo, #mobiliario", function (data) {
        x = data.target.id;
        var url = '/SGD/getAAZip?x=' + x;
        var fileName = "AA" + x + ".zip";
        getDocument(url, fileName);
    });
});
