$(document).ready(function(){
	var post_title = document.getElementById("create_post_post_title");
	var post_content = document.getElementById("create_post_post_content");
	$("#create_post").click(function(){
		$("div .presentation").addClass("presentation-visited");
	});
	$(".presentation").click(function(){
		if(confirm("Bạn có muốn hủy bỏ thao tác đang thực hiện hay không?")){
			clearValue();
		}
	});
	function clearValue(){
		post_title.value="";
		post_content.value="";
		$(".presentation").removeClass("presentation-visited");
	}
	$("#submit_post").click(function(e){
		e.preventDefault();
		var $postTitle = $("#create_post_post_title").val();
		var $postContent = $("#create_post_post_content").val();
		var $action =$("#create_post").attr("action");
		var data = {'post.title': $postTitle, 'post.content': $postContent};
		$.ajax({
			url: $action,
			type:'POST',
			data: {'post.title': $postTitle, 'post.content': $postContent},
			success: function(data){
				clearValue();
				console.log(data);
				$("#resultDiv").prepend( '<div class="post">'
									 	+'<div class="post-header">'
											 	+'<img src="'+data["profile"]["avatar"]+'" class="img-circle col-sm-3" alt="Avatar">'
											 	+'<div class="post-header-content col-sm-9">'
											 		+'<label class="post-title">'+data["post"]["title"]+'</label><br>'
											 		+'<p align="left" class="post-date">'+data["post"]["postDate"]+'</p>'
											 	+'</div>'
										 	+'</div>'
										 	+'<div class="post-content">'
										 		+'<p align="left">'+data["post"]["content"]+'</p>'
										 	+'</div>'
									 +'</div>');
			}
		})
	});

})