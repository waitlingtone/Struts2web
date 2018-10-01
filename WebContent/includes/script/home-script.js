$(document).ready(function(){
	/*
	 * Scripts for update post
	 * Scripts for delete post
	 * */
	var jPostEdit;

	$(".edit-link").click(function(e){
		e.preventDefault();
		jPostEdit = $(this).parents().eq(2);
		var	jUrl = $(this).attr("href");
		var jPost = $(this).attr("href").split("/");
//		console.log(jUrlPost[3]); //lay id post
		$.ajax({
			url: jUrl,
			method: "POST",
			data:{"post.postId" : jPost[3]},
			success: function(data){
				$("div .presentation").addClass("presentation-visited");
				$("#showPostEdit").html(data);
				$("#showPostEdit").addClass("higherIndex");
			}
		})
	});
	$("#showPostEdit").delegate(".submit_edit","click",function(e){
		e.preventDefault();
		var jTitle = $("#post_edit_post_title").val();
		var jContent = $("#post_edit_post_content").val();
		var jMemberId = $("#memberId").val();
		var jPostId = $("#postId").val();
		var jUrl = $("#post_edit").attr("action");
		console.log(jUrl);
//		var data = {"post.postId": jPostId, "post.memberId": jMemberId, 'post.title': jTitle, 'post.content': jContent};
//		console.log(data);
		$.ajax({
			url :jUrl,
			data:{"post.postId": jPostId, "post.memberId": jMemberId, 'post.title': jTitle, 'post.content': jContent},
			success: function(data){
				console.log(data);
				jPostEdit.html(data);
				clearValue();
			}
		});
	});
	
	/*
	 * Scripts for search member
	 * 
	 */
	$("#search-name").keyup(function(e){
		var jSearchName = $("#search-name").val();
		var dropdownSearch = $("#frmSearchMember").find(".dropdown-content");
		var jUrl = $("#frmSearchMember").attr('action');
		if(jSearchName != "" ){
			dropdownSearch.addClass("show");
			$.ajax({
				url: jUrl,
				method:'POST',
				data:{'name':jSearchName},
				success: function(data){
					dropdownSearch.html('');
					console.log(data);
					if(!data['list_member'] || Object.keys(data['list_member']).length){
						
						$.each(data['list_member'],function(k,v){
							dropdownSearch.append("<div class='content-name'><a href='/Struts2web/user/"+v.memberId+"/home' class='member-name' name='member.memberId'>" + v.firstname + " " + v.lastname + "</a></div>");
						})
					}
				}
			});
		} else{
			dropdownSearch.removeClass("show");
		}
	});
	$("#btn-searchMember").click(function(e){
		e.preventDefault();
	});
	$(".dropdown-content").delegate('.content-name','click',function(){
		var jMemberId = $(this).find('.member-name').attr("value");
	})
	/*
	 * Scripts for Action posts
	 * 
	 */
	$("#resultDiv").delegate(".more-action","click",function(e){
		e.preventDefault();
		var dropdown = $(this).parent().next();
		dropdown.toggleClass("show");
	});
	/*
	 * Scripts for create post
	 * 
	 * */
	var post_title = document.getElementById("create_post_post_title");
	var post_content = document.getElementById("create_post_post_content");
	
	function clearValue(){
		post_title.value="";
		post_content.value="";
		$(".presentation").removeClass("presentation-visited");
		$("#showPostEdit").removeClass("higherIndex");
		$("#showPostEdit").html("");
		$("#create_post").removeClass("higherIndex");
	}
	$("#create_post").click(function(){
		$("div .presentation").addClass("presentation-visited");
		$(this).addClass("higherIndex");
	});
	$(".presentation").click(function(){
		if(confirm("Bạn có muốn hủy bỏ thao tác đang thực hiện hay không?")){
			clearValue();
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
			});
		}
	})
	/*
	 * Scripts for comment post
	 * 
	 * */
	$("body").delegate(".btn-loadComment","click",function(e){
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
		});
	});
	
	$( ".post" ).delegate(".comment_post", "keypress", function( event ) {
		var keycode = (event.keyCode ? event.keyCode : event.which);
		if(keycode == '13'){
			var post_comment = $(this).parents().eq(1);
			console.log(post_comment);
			var postId = $(this).closest('.post').find('.postId').val();
			var content = $(this).val();
			var data = {'post.postId': postId, 'comment.content': content};
			var nullContent = $(this).val('');
			$.ajax({
				url: '/Struts2web/createComment',
				methd: 'POST',
				data: data,
				success: function(data){
					post_comment.before(data);
					nullContent;
				}
			})
		}
	});
	
})