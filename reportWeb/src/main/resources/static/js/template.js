

$(document).ready(function(){
	  // 在这里写你的代码...
    var currentpage=0;
    var url="/report/template/listAll/"+currentpage+"/3";

    getData("/report/template/listAll/",0,"/3");
    //getData方法的开始
	function getData(hosturl,curpage,param){
		  $.getJSON(hosturl+curpage+param, function(json){
			  console.log("************1****"+currentpage);
		  		var contentdata=json.data.content;
		  	  $("#databody").empty();
		       for(var i=0;i<contentdata.length;i++){
		    	   $("#databody").append(" <tr>");
						$("#databody").append(" <td>"+contentdata[i].id+"</td>");
						$("#databody").append(" <td>"+contentdata[i].name+"</td>");
						$("#databody").append(" <td>"+contentdata[i].typeMsg+"</td>");
						$("#databody").append(" <td>"+contentdata[i].createTime+"</td>");
						$("#databody").append(" <td>"+contentdata[i].statusMsg+"</td>");
						$("#databody").append(" <td><button type='button' class='btn btn-primary'>修改</button>&nbsp&nbsp&nbsp<button  type='button' name='trdelete' class='btn btn-danger' id='deletebtn"+contentdata[i].id+"'>删除</button></td>");
		    	   $("#databody").append(" </tr>");
		       }

		       //动态设置分页
			 var totalPagesnumber=json.data.totalPages;
			  $(".pagination").empty();
			  $(".pagination").append('<li class=""><a class="page-link" href="#" id="firstpage">首页</a></li>');
			  $(".pagination").append('<li class=""><a class="page-link" href="#" id="previosepage">上一页</a></li>');
		       for(var j=0;j<totalPagesnumber;j++){
		    	   $(".pagination").append(' <li class="page-item" id="pageno'+j+'"><a class="page-link" href="#">'+(j+1)+'</a></li>');
		       }
		       $(".pagination").append(' <li class=""><a class="page-link" href="#" id="nextpage">下一页</a></li>');
			//把当前页，颜色变成蓝色
				$(".page-item").removeClass("active");
				$("#pageno"+currentpage).addClass("active");

				    $(".page-item").click(function(){

					  var idval=this.id;
					  currentpage=idval.substr(6);

					  getData(hosturl,currentpage,param)
				  })


				  //下一页
			  $("#nextpage").click(function(){
				  var  curr= new Number(currentpage);
				  currentpage=curr+1;

				   getData(hosturl,currentpage,param)
			  })


			  //上一页
			   $("#previosepage").click(function(){
				   var  curr= new Number(currentpage);
				  currentpage=curr-1;

				   getData(hosturl,currentpage,param)
			  })

			   //首页
			   $("#firstpage").click(function(){
				  currentpage=0;

				  getData(hosturl,currentpage,param)
			  })

			    //删除功能
                  $("button[name='trdelete']").click( function () {
                        console.log("删除按钮被点击了");


                           var r=confirm("确认删除吗？");
                            if (r==true){

                                        let idval=$(this).attr("id");
                                        console.log(idval);
                                        console.log(idval.substr(9));


                                        $.ajax({
                                                    url : "/report/template/delete/"+idval.substr(9),
                                                    async : false,
                                                    type : "POST",
                                                    contentType : 'application/json',
                                                    dataType : 'json',

                                                    success : function(data) {
                                                        alert("删除成功");
                                                        window.location.href="/report/template.html";
                                                    }
                                                });
                            }
                            else{
                                console.log("取消了");
                            }



                  });
                   //删除功能 结束

		});

	  }
//getData方法的结束



    //搜索开始
    $("#searchbtn").click( function () {
        currentpage=0;
        url="/report/template/listBy1/"+currentpage+"/3/"+$("#byName").val()+"/"+$("#byType").val();
         getData("/report/template/listBy1/",0,"/3/"+$("#byName").val()+"/"+$("#byType").val())

    });
    //搜索结束
    //新建模板
     $("#uploadsubmitbtn").click( function () {
            $("#formId").submit();

      });
       //新建模板 结束



	})
