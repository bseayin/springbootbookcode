


$(document).ready(function(){


$.get("/usercenter/permissions/list/0/10",  function(data){
 	        console.log(data);
 //	        alert(data.msg);
 	        if(data.body){
 	        for(var i=0;i<data.body.records.length;i++){

 	            $("#perdata").append(" <tr>  <td>"+data.body.records[i].id+"  </td>"+"  <td>"+data.body.records[i].permission+"  <td>"+data.body.records[i].description+"  </td>"+"  <td>"+data.body.records[i].rid+"  </td>"+"  <td>"+data.body.records[i].available+"  </td> </tr>");

 	        }

 	        }else{
 	            alert("查询失败");
 	        }

 	        }, "json");


 $("#savepermisionbtn").click(function(){
 	var islocked =$("input[name='islocked']").is(':checked');
 	$.post("/usercenter/permissions/save", { "permission": $("#pname").val(),"description": $("#pdescription").val(),"rid": $("#exampleInputrid").val(),"available": islocked },
 	        function(data){
 	        console.log(data);
 //	        alert(data.msg);
 	        if("成功"==data.msg){
 	             window.location.href="permissionmanager.html";
 	        }else{
 	            alert("保存失败");
 	        }

 	        }, "json");
 });
});