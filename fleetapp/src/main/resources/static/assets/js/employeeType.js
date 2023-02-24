
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(employeeType, status){
			$("#idEdit").val(employeeType.id);
			$("#descriptionEdit").val(employeeType.description);
			$("#detailsEdit").val(employeeType.details);
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
		$.get(href, function(employeeType, status){
			$("#idDetails").val(employeeType.id);
			$("#descriptionDetails").val(employeeType.description);
			$("#detailsDetails").val(employeeType.details);
		});
		$("#detailsModal").modal('show');
	});
});