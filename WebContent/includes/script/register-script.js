/**
 * 
 */
$(document).ready(function(){
    $("#tf_username").blur(function(){
    	var content = $("td_username").val();
       $.ajax({
    	   url: "doCheckExist",
    	   data: {"member.username" :content},
    	   success:function(data){
    		   console.log(data);
    		   
    	   }
    		   
       })
    });
});	