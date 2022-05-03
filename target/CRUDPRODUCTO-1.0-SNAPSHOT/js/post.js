$(document).ready(function () {
    listar();
});
function listar() {
    $.get("pc", {"opc": 1}, function (data) {
   
        var x = JSON.parse(data);
        $("#tablita tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $("#tablita").append(
                    "<tr><td>" + (i + 1) + "</td><td>" + x[i].idproducto + "</td><td>" + x[i].producto + "</td><td>" + x[i].marca+ "</td><td>" + x[i].precio + "</td><td>" + x[i].stock + "</td><td><a href='#' onclick='editar(" + x[i].idproducto + ")'><i class='fa-solid fa-pen-to-square yelow'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idproducto + ")'><i class='fa-solid fa-trash-can red'></i></a></td></tr>");
        }
    });
    }
    $("#guardar").click(function () {
    var producto = $("#producto").val();
    var marca = $("#marca").val();
    var precio= $("#precio").val();
    var stock= $("#stock").val();
    $.post("pc", {"producto": producto, "marca": marca , "precio":precio , "stock":stock, "opc": 2}, function () {
        bootbox.alert({
            message: "Registro guardado correctamente...!",
            callback: function () {
                console.log('This was logged in the callback!');
            }
        });
        listar();
    });
    $("#modalGuardar").modal('hide');
});
function editar(id) {
    $.get("pc", {"idproducto": id, "opc": 4}, function (data) {
        var w = JSON.parse(data);
        $("#editar_producto").val(w.producto);
        $("#editar_marca").val(w.marca);
        $("#editar_precio").val(w.precio);
        $("#editar_stock").val(w.stock);
        $("#idproducto").val(w.idproducto);
    });
    $("#modalEditar").modal('show');
}
function eliminar(id) {
    
    bootbox.confirm({
        message: "Realmente desea Eliminar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.get("pc", {"idproducto": id, "opc": 3}, function () {                      
                    bootbox.alert({
                        message: "Registro eliminado correctamente...!",
                        callback: function () {
                            console.log('This was logged in the callback!');
                        }
                    });                    
                    listar();
                });
                
            } else {
                bootbox.alert({
                    message: "Registro no eliminado!",
                    size: 'small'
                });
            }
        }
    });
    }
$("#modificar").click(function (){
    var producto=$("#editar_producto").val();
    var marca = $("#editar_marca").val();
    var precio = $("#editar_precio").val();
    var stock = $("#editar_stock").val();
    var id = $("#idproducto").val();
    bootbox.confirm({
        message: "Realmente desea Modificar?",
        buttons: {
            confirm: {
                label: 'SI',
                className: 'btn-success'
            },
            cancel: {
                label: 'NO',
                className: 'btn-danger'
            }
        },
        callback: function (result) {
            if (result) {
                $.get("pc", {"idproducto": id, "producto": producto, "marca": marca , "precio":precio , "stock":stock,"opc": 5}, function () {
                    bootbox.alert({
                        message: "Registro Modificado correctamente...!",
                        callback: function () {
                            console.log('This was logged in the callback!');
                        }
                    });
                    listar();
                });
                $("#modalEditar").modal('hide');
            } else {
                bootbox.alert({
                    message: "Registro no Modificado!",
                    size: 'small'
                });
            }
        }
    });
});