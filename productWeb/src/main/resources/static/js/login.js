
$(document).ready(function(){
  $("#subtn").click(function(){
  	var rememberMe =$("input[name='rememberMe']").is(':checked');
  	$.post("/usercenter/login", { "username": $("#uname").val(),"password": $("#pwd").val(),"rememberMe": rememberMe },
  	        function(data){
  	        console.log(data);
  //	        alert(data.msg);
  	        if("成功"==data.msg){
  	             window.location.href="index.html";
  	        }else{
  	            alert("登录失败");
  	        }

  	        }, "json");
  });
});