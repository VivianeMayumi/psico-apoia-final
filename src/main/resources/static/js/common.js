

$(document).ready(function() {

    if($('#mensagemErro') && $('#mensagemErro').val() != undefined && $('#mensagemErro').val() != "") {
        toastr.error($('#mensagemErro').val());
        $('#mensagemErro').val("");
    } else if($('#mensagemSucesso') && $('#mensagemSucesso').val() != undefined && $('#mensagemSucesso').val() != "") {
        toastr.info($('#mensagemSucesso').val());
        $('#mensagemSucesso').val("");
    }
    if(document.getElementById("botaoVoltar")) {
        document.getElementById("botaoVoltar").addEventListener("click", function() {
            document.getElementById("linkVoltar").click();
        });
    }
});