
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(country, status){
			$("#idEdit").val(country.id);
			$("#descriptionEdit").val(country.description);
			$("#capitalEdit").val(country.capital);
			$("#codeEdit").val(country.code);
			$("#continentEdit").val(country.continent);
			$("#nationalityEdit").val(country.nationality);
		});
		$("#editModal").modal('show');
	});
	
	$("table #deleteButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$("#confirmDeleteButton").attr('href', href);
		$("#deleteModal").modal('show');
	});
});