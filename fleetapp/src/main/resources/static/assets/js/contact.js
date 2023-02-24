
$(document).ready(function(){
	$("table #editButton").click(function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(contact, status){
			$("#idEdit").val(contact.id);
			$("#firstNameEdit").val(contact.firstname);
			$("#lastNameEdit").val(contact.lastname);
			$("#phoneEdit").val(contact.phone);
			$("#emailEdit").val(contact.email);
			$("#mobileEdit").val(contact.mobile);
			$("#remarksEdit").val(contact.remarks);
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
		$.get(href, function(contact, status){
			$("#idDetails").val(contact.id);
			$("#firstNameDetails").val(contact.firstname);
			$("#lastNameDetails").val(contact.lastname);
			$("#phoneDetails").val(contact.phone);
			$("#emailDetails").val(contact.email);
			$("#mobileDetails").val(contact.mobile);
			$("#remarksDetails").val(contact.remarks);
		});
		$("#detailsModal").modal('show');
	});
});