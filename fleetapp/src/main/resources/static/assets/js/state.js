$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(state, status){
			$("#idEdit").val(state.id);
			$("#ddlCountryEdit").val(state.countryid);
			$("#descriptionEdit").val(state.description);
			$("#capitalEdit").val(state.capital);
			$("#codeEdit").val(state.code);
			$("#detailsEdit").val(state.details);
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
		$.get(href, function(state, status){
			$("#idDetails").val(state.id);
			$("#ddlCountryDetails").val(state.countryid);
			$("#descriptionDetails").val(state.description);
			$("#capitalDetails").val(state.capital);
			$("#codeDetails").val(state.code);
			$("#detailsDetails").val(state.details);
		});
		$("#detailsModal").modal('show');
	});
});