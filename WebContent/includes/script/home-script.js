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
	$(".btn-loadComment").click(function(e){
		e.preventDefault();
		var postId = $(this).parent().find('.postId').val();
		var postFooter = $(this).parent().find('.post-footer');
		$.ajax({
			url: "getCommentPost",
			method:"GET",
			data: {'post.postId': postId},
			success: function(data){
				postFooter.html(data);
			}
		})
	})
	$( "body" ).delegate(".comment_post", "keypress", function( event ) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			var post_comment = $(this).parents().find('.post-comment').last();
			console.log(post_comment);
			var postId = $(this).closest('.post').find('.postId').val();
			var content = $(this).val();
			var data = {'post.postId': postId, 'comment.content': content};
			return;
			$.ajax({
				url: 'createComment',
				methd: 'POST',
				data: data,
				success: function(data){
					post_comment.before(data);
					
				}
			})
		}
	});
	
	$("#submit_post").click(function(e){
		e.preventDefault();		
		var $postTitle = $("#create_post_post_title").val();
		var $postContent = $("#create_post_post_content").val();
		if($postTitle == "" || $postContent == ""){
			alert("Tiêu đề hoặc nội dung không được để trống!!");
		}else{
			var $action =$("#create_post").attr("action");
			var data = {'post.title': $postTitle, 'post.content': $postContent};
			$.ajax({
				url: $action,
				type:'POST',
				data: {'post.title': $postTitle, 'post.content': $postContent},
				success: function(data){
					clearValue();
//					console.log(data);
					$("#resultDiv").prepend( '<div class="post">'
										 	+'<div class="post-header">'
												 	+'<img src="'+data["profile"]["avatar"]+'" class="img-circle col-sm-3" alt="Avatar">'
												 	+'<div class="post-header-content col-sm-9" align="left">'
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
		}
	});

})