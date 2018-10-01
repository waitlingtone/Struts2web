$("#btn_submit").click(function(e){
	e.preventDefault();
	var code = $("#frm_emailer_member_verifyCode").val();
	var email =$("#to").val();
	console.log(code);
	$.ajax({
		url: "emailer",
		data: {"member.verifyCode": code , "to" : email},
		success: function(data){
			console.log(data);
			$(".contentGrey").addClass("visited");
			$("div .modal").addClass("visited");
			$("div .modal-body").append('<form action="doCheckCode" method="POST">'
										+'<label class="labelSubmitCode">Insert your code here:</label>'
										+'<input type="text" id="inputCodeField" class="form-control" name="inputVerifyCode"></input>'
										+'</form>');
		}
	});
})
function onCloseModal(){
	$(".contentGrey").removeClass("visited");
	$("div .modal").removeClass("visited");
	$("div .modal-body").html("");
}
$("#closeX").click(function(){
	onCloseModal();
});
$(".backgroundGrey").click(function(){
	onCloseModal();
});
$("#btnCheckCodeEqual").click(function(e){
	e.preventDefault;
});
$("#btnCheckCodeEqual").click(function(){
	var code = $("#inputCodeField").val();
	var email = $("#to").val();
	var memberDataCode = $("#frm_emailer_member_verifyCode").val();
	$.ajax({
		url: "doCheckCode" , 
		data : { "codeField" : code , "member.email" : email, "member.verifyCode": memberDataCode},
		success: function(data){
			alert("Đã active email thành công!");
			window.location.href = 'http://localhost:8080/Struts2web/profile';
		}
	});
});