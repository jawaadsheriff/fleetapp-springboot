
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(vehicleMaintenance, status){
			$("#idEdit").val(vehicleMaintenance.id);
			$("#ddlVehicleEdit").val(vehicleMaintenance.vehicleid);
			
			var startDateEditStr =  vehicleMaintenance.startDate.substr(0,10);
			$("#startDateEdit").val(startDateEditStr);
			$("#remarksEdit").val(vehicleMaintenance.remarks);
			
			var endDateEditStr = vehicleMaintenance.endDate.substr(0,10);
			$("#endDateEdit").val(endDateEditStr);
			$("#ddlSupplierEdit").val(vehicleMaintenance.supplierid);
			$("#priceEdit").val(vehicleMaintenance.price);
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
		$.get(href, function(vehicleMaintenance, status){
			$("#idDetails").val(vehicleMaintenance.id);
			$("#ddlVehicleDetails").val(vehicleMaintenance.vehicleid);
			
			var startDateDetailsStr = vehicleMaintenance.startDate.substr(0,10);
			$("#startDateDetails").val(startDateDetailsStr);
			$("#remarksDetails").val(vehicleMaintenance.remarks);
			
			var endDateDetailsStr = vehicleMaintenance.endDate.substr(0,10);
			$("#endDateDetails").val(endDateDetailsStr);
			$("#ddlSupplierDetails").val(vehicleMaintenance.supplierid);
			$("#priceDetails").val(vehicleMaintenance.price);
		});
		$("#detailsModal").modal('show');
	});
});