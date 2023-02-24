
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleStatus, status){
			$("#idEdit").val(vehicleStatus.id);
			$("#descriptionEdit").val(vehicleStatus.description);
			$("#detailsEdit").val(vehicleStatus.details);
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
		$.get(href, function(vehicleStatus, status){
			$("#idDetails").val(vehicleStatus.id);
			$("#descriptionDetails").val(vehicleStatus.description);
			$("#detailsDetails").val(vehicleStatus.details);
		});
		$("#detailsModal").modal('show');
	});
});