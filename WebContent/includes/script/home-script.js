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
				document.getElementById("create_post_post_title").value = "";
				document.getElementById("create_post_post_content").value = "";
				$("#resultDiv").prepend(' <div class="row">'
						   +'<div class="col-sm-3">'
						     +'<div class="well">'
						      +'<p>'+data["post"]["title"]+'</p>'
						      +'<img src="bird.jpg" class="img-circle" height="55" width="55" alt="Avatar">'
						     +'</div>'
						   +'</div>'
						   +'<div class="col-sm-9">'
						     +'<div class="well">'
						     +'<p>'+data["post"]["content"]+'</p>'
						     +'</div>'
						   +'</div>'
						 +'</div>');
			}
		})
	});