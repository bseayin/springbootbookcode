


$(document).ready(function(){


$.get("/productcore/roles/list/0/10",  function(data){
 	        console.log(data);
 //	        alert(data.msg);
 	        if(data.body){
 	        for(var i=0;i<data.body.records.length;i++){

 	            $("#rerdata").append(" <tr>  <td>"+data.body.records[i].id+"  </td>"+"  <td>"+data.body.records[i].role+"  <td>"+data.body.records[i].description+"  </td>"+"  <td>"+data.body.records[i].rid+"  </td>"+"  <td>"+data.body.records[i].available+"  </td> </tr>");

 	        }

 	        }else{
 	            alert("查询失败");
 	        }

 	        }, "json");


 $("#saverolebtn").click(function(){
 	var islocked =$("input[name='islocked']").is(':checked');
 	$.post("/productcore/roles/save", { "role": $("#rname").val(),"description": $("#rdescription").val(),"rid": $("#exampleInputrid").val(),"available": islocked },
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
  	$.post("/productcore/rolespermissions/save", { "roleId": $("#rid").val(),"permissionId": $("#pid").val() },
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