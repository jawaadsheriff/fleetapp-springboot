
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(jobTitle, status){
			$("#idEdit").val(jobTitle.id);
			$("#descriptionEdit").val(jobTitle.description);
			$("#detailsEdit").val(jobTitle.details);
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
		$.get(href, function(jobTitle, status){
			$("#idDetails").val(jobTitle.id);
			$("#descriptionDetails").val(jobTitle.description);
			$("#detailsDetails").val(jobTitle.details);
		});
		$("#detailsModal").modal('show');
	});
});