/* TABELAS */
$('#table_cliente tr').click(function() {
	$("#cliente-id").val($(this).find("td:eq(0)").text());
	$("#nome").val($(this).find("td:eq(1)").text());
	$("#sobrenome").val($(this).find("td:eq(2)").text());
	$("#cpf").val($(this).find("td:eq(4)").text()).prop('disabled', true);
	$("#rg").val($(this).find("td:eq(5)").text());
	$("#email").val($(this).find("td:eq(3)").text());
	$("#cidade").val($(this).find("td:eq(6)").text());
	$("#estado option[value="+$(this).find("td:eq(7)").text()+"]").attr('selected', 'selected');
	
});

$("#btn-limpar").click(function() {
	$("#nome").val("");
	$("#sobrenome").val("");
	$("#cpf").val("");
	$("#rg").val("");
	$("#email").val("");
	$("#cidade").val("");
	$("#estado option[value=estado").attr('selected', 'selected');
	$("#cpf").prop('disabled', false);

});