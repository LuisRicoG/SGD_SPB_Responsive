$(document).ready(function () {    
    $(document).on("click", "#plantrabajo", function (data) {
        fileName = data.target.id;
        var url = '/SGD/plantrabajo/descargaplan';
        getDocument(url,fileName);
    });
});
