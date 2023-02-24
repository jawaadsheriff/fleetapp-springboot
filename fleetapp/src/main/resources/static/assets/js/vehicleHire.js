
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleHire, status){
			$("#idEdit").val(vehicleHire.id);
			$("#ddlVehicleEdit").val(vehicleHire.vehicleid);
			$("#ddlClientEdit").val(vehicleHire.clientid);
			
			var dateOutEditStr =  vehicleHire.dateOut.substr(0,10);
			$("#dateOutEdit").val(dateOutEditStr);
			$("#timeOutEdit").val(vehicleHire.timeOut);
			$("#ddlDestinationEdit").val(vehicleHire.locationid);
			
			var dateInEditStr = vehicleHire.dateIn.substr(0,10);
			$("#dateInEdit").val(dateInEditStr);
			$("#timeInEdit").val(vehicleHire.timeIn);
			$("#priceEdit").val(vehicleHire.price);
			$("#remarksEdit").val(vehicleHire.remarks);
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
		$.get(href, function(vehicleHire, status){
			$("#idDetails").val(vehicleHire.id);
			$("#ddlVehicleDetails").val(vehicleHire.vehicleid);
			$("#ddlClientDetails").val(vehicleHire.clientid);
			
			var dateOutDetailsStr =  vehicleHire.dateOut.substr(0,10);
			$("#dateOutDetails").val(dateOutDetailsStr);
			$("#timeOutDetails").val(vehicleHire.timeOut);
			$("#ddlDestinationDetails").val(vehicleHire.locationid);
			
			var dateInDetailsStr = vehicleHire.dateIn.substr(0,10);
			$("#dateInDetails").val(dateInDetailsStr);
			$("#timeInDetails").val(vehicleHire.timeIn);
			$("#priceDetails").val(vehicleHire.price);
			$("#remarksDetails").val(vehicleHire.remarks);
		});
		$("#detailsModal").modal('show');
	});
});