$(document).ready(function () {
    var x;
    $(document).on("click", "#Iengorda, #Irastro, #Icortes, #Icorporativo, #MyEengorda, #MyErastro, #MyEcortes, #MyEcorporativo, #EdTengorda, #EdTrastro, #EdTcortes, #EdTcorporativo, #Moengorda, #Morastro, #Mocortes, #Mocorporativo, #EdCengorda, #EdCrastro, #EdCcortes, #EdCcorporativo", function (data) {
        x = data.target.id;
        var url = '/SGD/getFA?x=' + x;
        var fileName = "FA" + x + ".pdf";
        getDocument(url, fileName);
    });
});