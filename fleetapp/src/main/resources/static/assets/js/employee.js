$(document).ready(function() {
	$("table #editButton").click(function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(employee, status) {
			$("#idEdit").val(employee.id);
			$("#ddlTitleEdit").val(employee.title);
			$("#initialsEdit").val(employee.initials);
			$("#socialSecurityNumberEdit").val(employee.socialSecurityNumber);
			$("#firstnameEdit").val(employee.firstname);
			$("#lastnameEdit").val(employee.lastname);
			$("#othernameEdit").val(employee.othername);
			$("#ddlGenderEdit").val(employee.gender);
			$("#ddlCountryEdit").val(employee.countryid);
			$("#addressEdit").val(employee.address);

			var dobEditStr = employee.dateOfBirth.substr(0, 10);
			$("#dobEdit").val(dobEditStr);

			var hireDateEditStr = employee.hireDate.substr(0, 10);
			$("#hireDateEdit").val(hireDateEditStr);
			$("#ddlStateEdit").val(employee.stateid);
			$("#cityEdit").val(employee.city);
			$("#phoneEdit").val(employee.phone);
			$("#mobileEdit").val(employee.mobile);
			$("#ddlMaritalStatusEdit").val(employee.maritalStatus);
			$("#emailEdit").val(employee.email);
			$("#ddlJobTitleEdit").val(employee.jobtitleid);
			$("#ddlEmployeeTypeEdit").val(employee.employeetypeid);
		});
		$("#editModal").modal('show');
	});

	$("table #deleteButton").click(function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$("#confirmDeleteButton").attr('href', href);
		$("#deleteModal").modal('show');
	});

	$("table #detailsButton").click(function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function(employee, status) {
			$("#idDetails").val(employee.id);
			$("#ddlTitleDetails").val(employee.title);
			$("#initialsDetails").val(employee.initials);
			$("#socialSecurityNumberDetails").val(employee.socialSecurityNumber);
			$("#firstnameDetails").val(employee.firstname);
			$("#lastnameDetails").val(employee.lastname);
			$("#othernameDetails").val(employee.othername);
			$("#ddlGenderDetails").val(employee.gender);
			$("#ddlCountryDetails").val(employee.countryid);
			$("#addressDetails").val(employee.address);

			var dobDetailsStr = employee.dateOfBirth.substr(0, 10);
			$("#dobDetails").val(dobDetailsStr);

			var hireDateDetailsStr = employee.hireDate.substr(0, 10);
			$("#hireDateDetails").val(hireDateDetailsStr);
			$("#ddlStateDetails").val(employee.stateid);
			$("#cityDetails").val(employee.city);
			$("#phoneDetails").val(employee.phone);
			$("#mobileDetails").val(employee.mobile);
			$("#ddlMaritalStatusDetails").val(employee.maritalStatus);
			$("#emailDetails").val(employee.email);
			$("#ddlJobTitleDetails").val(employee.jobtitleid);
			$("#ddlEmployeeTypeDetails").val(employee.employeetypeid);
		});
		$("#detailsModal").modal('show');
	});

	$('.table #photoButton').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal('show');
	});
});