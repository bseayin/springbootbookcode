


$(document).ready(function(){


$.get("/productcore/user/list/0/10",  function(data){
 	        console.log(data);
 //	        alert(data.msg);
 	        if(data.body){
 	        for(var i=0;i<data.body.records.length;i++){

 	            $("#rerdata").append(" <tr>  <td>"+data.body.records[i].id+"  </td>"+"  <td>"+data.body.records[i].username+"  </td> </tr>");

 	        }

 	        }else{
 	            alert("查询失败");
 	        }

 	        }, "json");


 $("#saveuserbtn").click(function(){
 	$.post("/productcore/user/register", { "username": $("#uname").val(),"password": $("#upwd").val()},
 	//$.post("/productcore/user/save", { "role": $("#rname").val(),"description": $("#rdescription").val(),"rid": $("#exampleInputrid").val(),"available": islocked },
 	        function(data){
 	        console.log(data);
 //	        alert(data.msg);
 	        if("成功"==data.msg){
 	             window.location.href="roleList.html";
 	        }else{
 	            alert("保存失败");
 	        }

 	        }, "json");
 });


   $("#saverolepermissionbtn").click(function(){
   	$.post("/productcore/usersroles/save", { "roleId": $("#rid").val(),"permissionId": $("#pid").val() },
   	        function(data){
   	        console.log(data);
   //	        alert(data.msg);
   	        if("成功"==data.msg){
   	             window.location.href="roleList.html";
   	        }else{
   	            alert("保存失败");
   	        }

   	        }, "json");
   });



});