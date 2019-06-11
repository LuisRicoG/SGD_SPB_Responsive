$(document).ready(function () {
    var Documento;
    $(document).on("click", "#estructuraterreno, #avaluoterreno, #proyectoentregado, #programanecesidades, #programaparticularnecesidades, #justificacionproyecto, #impactosuelos, #impactoambiental, #impactovial, #energiaelectrica, #estudiohidrologico, #usodesuelo, #aguasnacionales, #planoregional, #planorural, #planotopografico, #ubicacionterreno, #planosinfraestructura ", function (data) {
        Documento = data.target.id;
        var url = '/SGD/getdocumentoejecutivo?documento=' + Documento;
        getDocument(url, Documento);
    });
});
