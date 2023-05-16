$(document).ready(function() {
    $('#name').change(
        function() {
            if($(this).val() == "0") {
                let html = '<option value="0">Primeiro escolha um Psicologo</option>';
                $('#dataHora').html(html);
            } else {
                $.getJSON("http://localhost:8080/agendas-disponiveis", {
                    idPsicologo : $(this).val(),
                    ajax : 'true'
                }, function(data) {
                    let html = '<option value="">Selecione uma data/hora</option>';
                    let len = data.length;
                    for ( let i = 0; i < len; i++) {
                        html += '<option value="' + data[i].id + '">'+ data[i].dataHora + '</option>';
                    }
                    html += '</option>';
                    $('#dataHora').html(html);
                });
            }
        }
    )
});