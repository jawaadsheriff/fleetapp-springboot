
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMake, status){
			$("#idEdit").val(vehicleMake.id);
			$("#descriptionEdit").val(vehicleMake.description);
			$("#detailsEdit").val(vehicleMake.details);
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
		$.get(href, function(vehicleMake, status){
			$("#idDetails").val(vehicleMake.id);
			$("#descriptionDetails").val(vehicleMake.description);
			$("#detailsDetails").val(vehicleMake.details);
		});
		$("#detailsModal").modal('show');
	});
});