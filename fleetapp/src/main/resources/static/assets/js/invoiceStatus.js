
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(invoiceStatus, status){
			$("#idEdit").val(invoiceStatus.id);
			$("#descriptionEdit").val(invoiceStatus.description);
			$("#detailsEdit").val(invoiceStatus.details);
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
		$.get(href, function(invoiceStatus, status){
			$("#idDetails").val(invoiceStatus.id);
			$("#descriptionDetails").val(invoiceStatus.description);
			$("#detailsDetails").val(invoiceStatus.details);
		});
		$("#detailsModal").modal('show');
	});
});