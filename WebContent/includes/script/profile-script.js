function readURL(input) {

  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      $('#member_ava').attr('src', e.target.result);
    }

    reader.readAsDataURL(input.files[0]);
  }
}

$("#imageavatar_src").change(function() {
  readURL(this);
});
$("div .div-form").click(function(){
	$("div .div-form").removeClass("visited");
	$("div .modal").removeClass("visited");
	$("div .modal-body").html("");
})
$("#updatebtn").click(function(e){
	e.preventDefault();
	var id = $("#idmember").val();
	$.ajax({
		url: "updateProfile",
		data: {"member.memberId": id},
		success: function(data){
			$("div .div-form").addClass("visited");
			$("div .modal").addClass("visited");
			$("div .modal-body").html(data);
		}
	});
})

$("#closeX").click(function(){
	
	$("div .div-form").removeClass("visited");
	$("div .modal").removeClass("visited");
	$("div .modal-body").html("");
});

$("#saveChangebtn").click(function(e){
	e.preventDefault();
	var id = $("#idMember").val();
	var f_n = $("#firstname").val();
	var l_n = $("#lastname").val();
	var phone = $("#phone").val();
	var address = $("#address").val();
	var action = $("#updateProfile").attr("action");
	$.ajax({
		url: action,
		method:"GET",
		data: {'member.memberId' : id,
			'member.firstname': f_n,
			'member.lastname' : l_n,
			'member.phone'	: phone,
			'member.address' : address},
		success: function(data){
			$("div .div-form").removeClass("visited");
			$("div .modal").removeClass("visited");
			$("div .modal-body").html("");
			location.reload();

		}
	});
});
