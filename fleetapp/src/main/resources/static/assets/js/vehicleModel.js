
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleModel, status){
			$("#idEdit").val(vehicleModel.id);
			$("#descriptionEdit").val(vehicleModel.description);
			$("#detailsEdit").val(vehicleModel.details);
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
		$.get(href, function(vehicleModel, status){
			$("#idDetails").val(vehicleModel.id);
			$("#descriptionDetails").val(vehicleModel.description);
			$("#detailsDetails").val(vehicleModel.details);
		});
		$("#detailsModal").modal('show');
	});
});