'use strict';

$(function() {
	$(".add-customer-validation").submit(function() {
		var form = $(this);
        if (form[0].checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.addClass('was-validated');
	});
});


function checkFormService() {
	var maDichVu = formService.maDichVu.value;
	var tenDichVu = formService.tenDichVu.value;
	var donViTinh = formService.donViTinh.value;
	var donGia = formService.donGia.value;

	if (maDichVu == '' || tenDichVu == '') {
		alert('Bạn cần nhập đầy đủ thông tin!');
		return false;
	}
	return true;
}
