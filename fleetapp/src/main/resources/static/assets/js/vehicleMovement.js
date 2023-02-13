
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMovement, status){
			$("#idEdit").val(vehicleMovement.id);
			$("#ddlVehicleEdit").val(vehicleMovement.vehicleid);
			
			var departureDateEditStr =  vehicleMovement.departureDate.substr(0,10);
			$("#departureDateEdit").val(departureDateEditStr);
			$("#ddlDepartedFromEdit").val(vehicleMovement.departedFromId);
			
			var arrivalDateEditStr = vehicleMovement.arrivalDate.substr(0,10);
			$("#arrivalDateEdit").val(arrivalDateEditStr);
			$("#ddlArrivalAtEdit").val(vehicleMovement.arrivalAtId);
			$("#remarksEdit").val(vehicleMovement.remarks);
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
		$.get(href, function(vehicleMovement, status){
			$("#idEdit").val(vehicleMovement.id);
			$("#ddlVehicleDetails").val(vehicleMovement.vehicleid);
			
			var departureDateDetailsStr =  vehicleMovement.departureDate.substr(0,10);
			$("#departureDateDetails").val(departureDateDetailsStr);
			$("#ddlDepartedFromDetails").val(vehicleMovement.departedFromId);
			
			var arrivalDateDetailsStr = vehicleMovement.arrivalDate.substr(0,10);
			$("#arrivalDateDetails").val(arrivalDateDetailsStr);
			$("#ddlArrivalAtDetails").val(vehicleMovement.arrivalAtId);
			$("#remarksDetails").val(vehicleMovement.remarks);
		});
		$("#detailsModal").modal('show');
	});
});