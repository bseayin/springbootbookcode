$(document).ready(function(){
 var selectedId="";
  $.getJSON("/report/meeting/listAll", function(json){

    		  		var contentdata=json.data;
    		  	  $("#meetingdatabody").empty();
    		       for(var i=0;i<contentdata.length;i++){
    		    	   $("#meetingdatabody").append(" <tr>");
                            $("#meetingdatabody").append(" <td>"+contentdata[i].id+"</td>");
    						$("#meetingdatabody").append(" <td>"+contentdata[i].tile+"</td>");
    						$("#meetingdatabody").append(" <td>"+contentdata[i].address+"</td>");
    						$("#meetingdatabody").append(" <td>"+contentdata[i].startTime+"</td>");
    						$("#meetingdatabody").append(" <td>"+"-"+"</td>");
    						$("#meetingdatabody").append(" <td><button  type='button' name='tropentemplate' class='btn btn-primary' id='opentemplatebtn"+contentdata[i].id+"'>选择模板</button><button  type='button' name='trloadtemplate' class='btn btn-primary' id='loadtemplatebtn"+contentdata[i].id+"'>下载报告</button></td>");
    		    	   $("#meetingdatabody").append(" </tr>");
    		       }

    		         $("button[name='tropentemplate']").click( function () {
    		                     selectedId=$(this).attr("id").substr(15);

    		                    oepnTemplatepopup();

    		          })


    		           $("button[name='trloadtemplate']").click( function () {
                                 let selectedtId=$(this).attr("id").substr(15);
                              $.ajax({
                                        url : "/report/meeting/getReport/"+selectedtId,
                                        async : false,
                                        type : "GET",
                                        contentType : 'application/json',
                                        dataType : 'json',

                                        success : function(data) {
                                            alert("导出成功");

                                        }
                                    });



                      })

    	  })

    $("#addbtn").click(function(){
        var data =  {"address" :$("#addressinput").val(),"startTime" : $("#starttimeinut").val(),"tile" :$("#titleinput").val()}
        $.ajax({
            url : "/report/meeting/add",
            async : false,
            type : "POST",
            contentType : 'application/json',
            dataType : 'json',
            data :JSON.stringify(data),
            success : function(data) {
               window.location.href="/report/meeting.html";
            }
        });
    })


     $("#submittempbtn").click(function(){
        let selectedtemplateId=$("input[name='opttmpradio']:checked").val();
        console.log(selectedId);
         $.ajax({
            url : "/report/meeting/addTemplate/"+selectedId+"/"+selectedtemplateId,
            async : false,
            type : "POST",
            contentType : 'application/json',
            dataType : 'json',

            success : function(data) {
                alert("绑定成功");
                window.location.href="/report/meeting.html";
            }
        });


     })
//选择模板
function oepnTemplatepopup(){

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
                            $("#databody").append("<td><div class='radio'> <label><input type='radio' name='opttmpradio' value='"+contentdata[i].id+"'>"+contentdata[i].id+"</label></div></td>");

    						$("#databody").append(" <td>"+contentdata[i].name+"</td>");
    						$("#databody").append(" <td>"+contentdata[i].typeMsg+"</td>");
    						$("#databody").append(" <td>"+contentdata[i].createTime+"</td>");
    						$("#databody").append(" <td>"+contentdata[i].statusMsg+"</td>");
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

                    $('#templateModal').modal("show")

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
 };
 //选择模板结束
});