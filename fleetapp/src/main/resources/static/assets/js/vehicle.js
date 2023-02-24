
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicle, status){
			$("#idEdit").val(vehicle.id);
			$("#ddlVehicleTypeEdit").val(vehicle.vehicletypeid);
			$("#vehicleNameEdit").val(vehicle.name);
			$("#vehicleNumberEdit").val(vehicle.vehicleNumber);
			
			var registrationDateEditStr =  vehicle.registrationDate.substr(0,10);
			$("#registrationDateEdit").val(registrationDateEditStr);
			$("#descriptionEdit").val(vehicle.description);
			
			var acquisitionDateEditStr =  vehicle.acquisitionDate.substr(0,10);
			$("#acquisitionDateEdit").val(acquisitionDateEditStr);
			$("#ddlVehicleMakeEdit").val(vehicle.vehiclemakeid);
			$("#ddlVehicleModelEdit").val(vehicle.vehiclemodelid);
			$("#ddlCurrentLocationEdit").val(vehicle.locationid);
			$("#powerEdit").val(vehicle.power);
			$("#fuelCapacityEdit").val(vehicle.fuelCapacity);
			$("#netWeightEdit").val(vehicle.netWeight);
			$("#remarksEdit").val(vehicle.remarks);
			$("#ddlInchargeEdit").val(vehicle.employeeid);
			$("#ddlCurrentStatusEdit").val(vehicle.vehiclestatusid);
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
		$.get(href, function(vehicle, status){
			$("#ddlVehicleTypeDetails").val(vehicle.vehicletypeid);
			$("#vehicleNameDetails").val(vehicle.name);
			$("#vehicleNumberDetails").val(vehicle.vehicleNumber);
			
			var registrationDateDetailsStr =  vehicle.registrationDate.substr(0,10);
			$("#registrationDateDetails").val(registrationDateDetailsStr);
			$("#descriptionDetails").val(vehicle.description);
			
			var acquisitionDateDetailsStr =  vehicle.acquisitionDate.substr(0,10);
			$("#acquisitionDateDetails").val(acquisitionDateDetailsStr);
			$("#ddlVehicleMakeDetails").val(vehicle.vehiclemakeid);
			$("#ddlVehicleModelDetails").val(vehicle.vehiclemodelid);
			$("#ddlCurrentLocationDetails").val(vehicle.locationid);
			$("#powerDetails").val(vehicle.power);
			$("#fuelCapacityDetails").val(vehicle.fuelCapacity);
			$("#netWeightDetails").val(vehicle.netWeight);
			$("#remarksDetails").val(vehicle.remarks);
			$("#ddlInchargeDetails").val(vehicle.employeeid);
			$("#ddlCurrentStatusDetails").val(vehicle.vehiclestatusid);
		});
		$("#detailsModal").modal('show');
	});
});