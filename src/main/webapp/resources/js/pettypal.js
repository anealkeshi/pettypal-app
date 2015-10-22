function searchUserByEmail(event) {
	var dataToSend = $(event.target).closest('td').find('input').val();
	$.ajax({
		url : '/pettypal-app/payment/findUser?email=' + dataToSend,
		type : 'GET',
		dataType : "json", // Accepts
	}).done(function(successObject) {
		$(event.target).closest('td').next('td').text(successObject.firstName + ' ' + successObject.lastName);
		$(event.target).closest('td').find('input:hidden').val(successObject.id);
		
	}).fail(function(xhr, textStatus, errorThrown) {
		if (xhr.responseJSON.message == 'NoSuchUserException') {
			$(event.target).closest('td').next('td').text('User not found');
		}
	});
}
