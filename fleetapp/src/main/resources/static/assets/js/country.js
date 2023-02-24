
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
	
	$("table #detailsButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(country, status){
			$("#idDetails").val(country.id);
			$("#descriptionDetails").val(country.description);
			$("#capitalDetails").val(country.capital);
			$("#codeDetails").val(country.code);
			$("#continentDetails").val(country.continent);
			$("#nationalityDetails").val(country.nationality);
			$("#createdByDetails").val(country.createdBy);
			$("#createdDateDetails").val(country.createdDate.substr(0,19).replace("T", " "));
			$("#lastModifiedByDetails").val(country.lastModifiedBy);
			$("#lastModifiedDateDetails").val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});
		$("#detailsModal").modal('show');
	});
});