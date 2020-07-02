$("#subtn").click(function(){
	var rememberMe =$("input[name='rememberMe']").is(':checked');
	$.post("/usercenter/login", { "username": $("#uname").val(),"password": $("#pwd").val(),"rememberMe": rememberMe },
	        function(data){
	        console.log(data); //
	        window.location.href="index1.html";
	        }, "json");
});