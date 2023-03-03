
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(role, status){
			$("#idEdit").val(role.id);
			$("#descriptionEdit").val(role.description);
			$("#detailsEdit").val(role.details);
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
		$.get(href, function(role, status){
			$("#idDetails").val(role.id);
			$("#descriptionDetails").val(role.description);
			$("#detailsDetails").val(role.details);
		});
		$("#detailsModal").modal('show');
	});
});