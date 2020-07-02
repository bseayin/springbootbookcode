jQuery(document).ready(function($) {
    $("#header").load("/job/topul.html");

    showAll();

    //查询企业申请
    function showAll(){
        //请求
        $.ajax({
            url : "user/showAllApplication",
            type : "get",
            dataType : "json",
            success : function(data){
               console.log(data);

               $(data.data).each(function(i){
                   $("#applicationTbody").append("<tr><td>"
                       + (i + 1) + "</td><td>"
                       + this.name + "</td><td><a href="
                       + this.applicationPath +"><i class='fa fa fa-link'></i>&nbsp; 导出简历</a></td><td><button type='button' class='btn-outline-primary btn-sm' name='confirmApplicationBtn' value='"
                       + this.id + "'>确认申请</button></td>")
               })
            }
        })
        //请求end
    }

    //查询企业申请end

});