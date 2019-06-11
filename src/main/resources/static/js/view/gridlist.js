/* 
 * ing.jorge.eduardo.p@gmail.com
 */

var MyDateField = function (config) {
    jsGrid.Field.call(this, config);
};

MyDateField.prototype = new jsGrid.Field({

    css: "date-field", // redefine general property 'css'
    align: "center", // redefine general property 'align'

    sorter: function (date1, date2) {
        return new Date(date1) - new Date(date2);
    },
    itemTemplate: function (value) {
        return dateToString(value);
    },
    filterTemplate: function () {
        return this._insertPicker = $("<input  id ='date' autocomplete='off' onfocusout= onDatePickerClick(this.value,this)>").datepicker({defaultDate: new Date(), dateFormat: "dd/mm/yy", showButtonPanel: true, onSelect: onDatePickerClick, regional: "es"});
    }
});

function onDatePickerClick(dateText, inst) {
    console.log("dateText : " + dateText);
    console.log("inst : " + inst);
    if (inst && inst.input && inst.input[0].value === "")
    {
        dateText = "";
    }
    var filtro = $("#jsGrid").jsGrid("getFilter");
    filtro.fecha = dateText;
    $("#jsGrid").jsGrid("loadData", filtro).done(function () {
        console.log("data loaded");
    });
}

function dateToString(timestampDate) {
    var day = (new Date(timestampDate).getDate()) < 10 ? "0" + (new Date(timestampDate).getDate()) : (new Date(timestampDate).getDate())
    var month = (new Date(timestampDate).getMonth() + 1) < 10 ? "0" + (new Date(timestampDate).getMonth() + 1) : (new Date(timestampDate).getMonth() + 1)
    var fecha = day + "/" + month + "/" + new Date(timestampDate).getFullYear();
    return fecha;
}
jsGrid.fields.date = MyDateField;

$(document).ready(function () {
    $("#jsGrid").jsGrid({
        width: "100%",
        height: "400px",
        inserting: false,
        filtering: true,
        editing: false,
        sorting: true,
        paging: true,
        autoload: true,
        pageSize: 5,
        pageButtonCount: 5,
        pagerFormat: "Pag: {first} {prev} {pages} {next} {last}    {pageIndex} of {pageCount}",
        pagePrevText: "Prev",
        pageNextText: "Siguiente",
        pageFirstText: "Primero",
        pageLastText: "Último",
        pageNavigatorNextText: "...",
        pageNavigatorPrevText: "...",
        loadMessage: "Por favor espere ...",
        rowClick: function (args) {
            if (args.event.target.type === "button")
            {
                descargar(args.item);
            }

        },
        clients,
        controller: controllers,

        fields: [
            {name: "descripcion", type: "text", title: "Descripción", align: "center"},
            {name: "nombre", type: "text", title: "Nombre de Archivo", align: "center"},
            {name: "fecha", type: "date", align: "center", title: "Fecha"},
            {
                type: "control",
                modeSwitchButton: true,
                clearFilterButton: false,
                name: "descarga",
                headerTemplate: "Descarga",
                filterTemplate: "",
                width: 80,
                itemTemplate: function () {
                    return $("<button>").attr("type", "button").text("Descargar");
                }
            }
        ]
    });
});
function descargar(item) {

    console.log(item);
    var url = '/SGD/getdocumentogeneral?id=' + item.documentoId + "&pantalla=" + item.pantalla;
    console.log(url);
    getDocument(url, item.nombre);

}
var url = "/SGD/documentos?pantalla=" + pantalla;
var clients;
var dataGrid;
var controllers = {
    loadData: function (filter) {
        if (dataGrid) {
            if (filter.fecha == "") {
                filter.fecha = $("#date")[0].value;
            }
            return $.grep(dataGrid, function (client) {
                return (!filter.descripcion || client.descripcion.indexOf(filter.descripcion) > -1)
                        && (!filter.nombre || client.nombre.indexOf(filter.nombre) > -1)
                        && (!filter.fecha || dateToString(client.fecha).indexOf(filter.fecha) > -1)
            });
        }
        console.log("filter:" + filter);
        var deferred = $.Deferred();

        $.ajax({
            url: url,
            success: function (data) {
                dataGrid = data;
                deferred.resolve(data);
            }
        });

        return deferred.promise();
    }
};

