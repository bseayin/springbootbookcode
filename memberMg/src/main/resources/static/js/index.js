$(document).ready(function(){
    // 在这里写你的代码...

    var currentpage=0;
    getData();

    function getData(){
        $.getJSON("/membermg/member/showall/"+currentpage+"/10", function(json){
            console.log("************1****"+currentpage);
            var contentdata=json.content;
            $("#databody").empty();
            for(var i=0;i<contentdata.length;i++){
                $("#databody").append(" <tr>");
                $("#databody").append(" <input type='radio' name='radioselect' value='"+contentdata[i].id+"'>");
                $("#databody").append(" <td>"+contentdata[i].id+"</td>");
                $("#databody").append(" <td>"+contentdata[i].name+"</td>");
                $("#databody").append(" <td>"+contentdata[i].phone+"</td>");
                $("#databody").append(" <td>"+contentdata[i].sex+"</td>");
                $("#databody").append(" <td>"+contentdata[i].age+"</td>");
                $("#databody").append(" <td>"+contentdata[i].level+"</td>");
                $("#databody").append(" <td>"+contentdata[i].createTime+"</td>");
                $("#databody").append(" <td>"+contentdata[i].carNum+"</td>");
                $("#databody").append(" </tr>");
            }

            //动态设置分页
            var totalPagesnumber=json.totalPages;
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

                getData();
            })


            //下一页
            $("#nextpage").click(function(){
                var  curr= new Number(currentpage);
                currentpage=curr+1;
                getData();
            })


            //上一页
            $("#previosepage").click(function(){
                var  curr= new Number(currentpage);
                currentpage=curr-1;
                getData();
            })

            //首页
            $("#firstpage").click(function(){
                currentpage=0;
                getData();
            })

        });

    }

    // $.get("/membermg/member/showall/"+0+"/"+10, function(data){
    //     console.log(data)
    // });


    $("#smbbtn").click(function(){
        $("#addform").submit();

    });

    $("#updatebtn").click(function(){
        var selectedId=$("input[name='radioselect']:checked").val();
        console.log("被选中的记录--",selectedId);

        var selName=$("input[name='radioselect']:checked").next().next().text();
        var selPhone=$("input[name='radioselect']:checked").next().next().next().text();
        console.log("被选中的记录--",selName+selPhone);
        $("input[name='name']").val(selName);
        $("input[name='phone']").val(selPhone);
        $("input[name='id']").val(selectedId);
        $("#addform").attr('action',"/membermg/index/update");
        // $("#addform").action="/membermg/index/update";
        $('#myModal').modal('show')

    });


    $("#addbtn").click(function(){
        $("input[name='name']").val("");
        $("input[name='phone']").val("");
        $('#myModal').modal('show')

    });



});