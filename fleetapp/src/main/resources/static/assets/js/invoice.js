$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(invoice, status){
			$("#idEdit").val(invoice.id);
			$("#ddlClientIdEdit").val(invoice.clientid);
			
			var invoiceDateVal = invoice.invoiceDate.substr(0,10);
			$("#invoiceDateEdit").val(invoiceDateVal);
			$("#ddlInvoiceStatusIdEdit").val(invoice.invoicestatusid);
			$("#remarksEdit").val(invoice.remarks);
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
		$.get(href, function(invoice, status){
			$("#idDetails").val(invoice.id);
			$("#ddlClientIdDetails").val(invoice.clientid);
			
			var invoiceDateVal = invoice.invoiceDate.substr(0,10);
			$("#invoiceDateDetails").val(invoiceDateVal);
			$("#ddlInvoiceStatusIdDetails").val(invoice.invoicestatusid);
			$("#remarksDetails").val(invoice.remarks);
		});
		$("#detailsModal").modal('show');
	});
});