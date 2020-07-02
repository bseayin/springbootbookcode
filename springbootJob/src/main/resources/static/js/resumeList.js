jQuery(document).ready(function($) {
    $("#header").load("/job/topul.html");

    var currentPage2 = 0;
    showAll();

    //查询用户所有简历
    function showAll() {
        //请求
        $.ajax({
            url: "resume/showBycreateBy/" + currentPage2 + "/" + 3,
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log(data)
                $("#resumeTbody").empty();
                $(data.data.content).each(function (i) {
                    $("#resumeTbody").append(' <tr> <td class="serial" id="no">'
                        + (i+1) + '.</td> <td class="avatar"> <div class="round-img"> <a target=”_blank" id="imagePath" href="'
                        +this.image+'"> <img id="myImage" class="rounded-circle"src="'+this.image+'"> </a> </div> </td> <td><span class="name" id="ResumeName">'+this.resumeName+'</span></td> <td> <button type="button" class="btn btn-outline-success btn-sm" name="resumeDetails" id="'
                        +this.name + '_' + this.sex + '_' + this.age + '_' +this.education + '_' + this.major + '_' + this.resumeName + '_' + this.mobile + '_' + this.assessment + '_' + this.certificate + '_' + this.workedyears + '_' + this.projectExp + '_' + this.trainExp
                        + '_'+ this.id + '_' + this.image + '_' + this.wordPath + '"><i class="fa ti-eye"></i>&nbsp; 详情</button> </td> <td> <button type="button" class="btn btn-outline-danger btn-sm" name="resumeDelete" id="'
                        +this.id+'"><i class="fa ti-alert"></i>&nbsp; 删除</button>&nbsp;&nbsp; <a href="' + this.wordPath +'"><i class="fa fa fa-link"></i>&nbsp; 导出简历</a> </td></tr>')
                })

                let totalPagesnumber = data.data.totalPages;

                $("#pagination2").empty();
                $("#pagination2").append('<li class="page-item"><a class="page-link" href="#" id="previous2">&laquo;</a></li>');
                for (var j = 0; j < totalPagesnumber; j++) {
                    $("#pagination2").append('  <li class="page-item" id="pageLi2' + j + '"name="pageNo2"><a class="page-link" id="pageNo2' + j + '"href="#">' + (j + 1) + '</a></li>');
                }
                $("#pagination2").append('<li class="page-item"><a class="page-link" href="#" id="next2">&raquo;</a></li>');

                $("li[name='pageNo2']").removeClass("active");
                $("#pageNo2" + currentPage2).parent().addClass("active");

                $("li[name='pageNo2']").click(function () {
                    var idval = this.id;
                    currentPage2 = Number(idval.substr(7));

                    showAll()
                })

                //下一页
                $("#next2").click(function () {
                    var curr = new Number(currentPage2);
                    if (curr + 1 < totalPagesnumber) {
                        currentPage2 = curr + 1;
                        showAll()
                    }
                })

                //上一页
                $("#previous2").click(function () {
                    var curr = new Number(currentPage2);
                    if (curr - 1 >= 0) {
                        currentPage2 = curr - 1;
                        showAll()
                    }
                })
            }
        })
        //请求end
    }

    //查询用户所有简历end

    //简历详情
    $("body").on("click", "button[name='resumeDetails']", function(){
        let data = $(this).attr("id").split("_")

        $("#name2").val(data[0])
        let sex = data[1];
        if("女" == sex){
            $("#sex2 option:contains('女')").attr("selected", true)
        }else{
            $("#sex2 option:contains('男')").attr("selected", true)
        }
        $("#age2").val(data[2])
        $("#education2").val(data[3])
        $("#major2").val(data[4])
        // $("#resumeName2").val(data[5])
        $("#mobile2").val(data[6])
        $("#assessment2").val(data[7])
        $("#certificate2").val(data[8])
        $("#workedyears2").val(data[9])
        $("#projectExp2").val(data[10])
        $("#trainExp2").val(data[11])
        // $("#id2").val(data[12])
        // $("#image2").val(data[13])
        // $("#wordPath2").val(data[14])

        $("#resumeDetailModal").modal("show")
    })
    //简历详情

    //修改简历
    $("#resumeEdit").on("click", function(){
        let Data = {"id":$("#id").val(), "name":$("#name").val(), "sex":$("#sex").val(), "mobile":$("#mobile").val(),
            "education":$("#education").val(),"assessment":$("#assessment").val(),"certificate":$("#certificate").val(),
            "workedyears":$("#workedyears").val(),"projectExp":$("#projectExp").val(),"trainExp":$("#trainExp").val(),}
        //请求
        $.ajax({
            url : "resume/editResume",
            data : JSON.stringify(Data),
            type : "post",
            contentType: 'application/json;charset=utf-8',
            dataType : "json",
            success : function(data){
                if(data.data){
                    alert("成功")
                    $("#resumeDetailModal").modal("hide")
                }else{
                    alert("失败")
                }
            }
        })
        //请求end
    })
    //修改简历end

    //删除简历
    $("body").on("click", "button[name='resumeDelete']", function(){
        var $id = $(this).attr("id");

        if (confirm("确认删除吗？")){
            //请求
            $.ajax({
                url : "resume/deleteResume/" + $id,
                type : "post",
                dataType : "json",
                success : function(data){
                    showAll();
                }
            })
            //请求end
        }

    })
    //删除简历end



    //添加简历
    $("#resumeAdd").on("click", function() {
        $("#resumeAddFrm").submit();
    })



})