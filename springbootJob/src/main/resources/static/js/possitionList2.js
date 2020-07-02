jQuery(document).ready(function($) {
    $("#header").load("/job/topul.html");

    var currentPage2 = 0;
    pType();
    alert(currentPage2);
    showAllPosition();

    //查询所有职位类型
    function pType(){
        //请求
        $.ajax({
            url : "position/showAllIndustry",
            type : "get",

            dataType : "json",
            success : function(data){
                 currentPage2=4;
                $(data.data.dictValue).each(function(){
                    $("#pid").append(" <option name='pid' value='"+this.id+"'>"+this.label+"</option>")
                    $("#pid2").append(" <option name='pid' value='"+this.id+"'>"+this.label+"</option>")

                })
            }
        })
        //请求end
    }
    //职位类型查询end

    var flag = true;
    $("button[name='skillAddBtn']").on("click", function () {
        if(flag){
            showAllSkill();
        }else{
            $("#skillAddModal").modal("show");
        }

    })

    // var currentPage = 0;
    // var currentPageTemp = 0;
    // var checkedSkill = new Map();

    //所有技能分页查询
    // function getAllSkill() {
    //
    //     if (!checkedSkill.get(currentPage)) {
    //         checkedSkill.set(currentPage, new Array());
    //     }
    //
    //     $("input[name='skillCheck']:checked").each(function () {
    //         let arr = checkedSkill.get(currentPageTemp);
    //         arr.push(this.value)
    //         checkedSkill.set(currentPageTemp, arr);
    //     })
    //
    //
    //     //请求
    //     $.ajax({
    //         url: "position/showSkillByLimit/" + currentPage + "/3",
    //         type: "get",
    //         dataType: "json",
    //         success: function (data) {
    //             $("#skillTbody").empty();
    //             let content = data.data.content;
    //             console.log(data.data)
    //
    //             $(content).each(function () {
    //                 $("#skillTbody").append("<tr><td style='width:20%'>" + '<input id="'+ this.id + '-' + this.label +'" name="skillCheck" type="checkbox" value="'
    //                     + this.id + '-' + this.label + '">' + "</td><td style='width:20%'>"
    //                     + this.id + "</td><td style='width:20%'>"
    //                     + this.label + "</td></tr>")
    //             })
    //
    //             currentPageTemp = currentPage;
    //
    //             let totalPagesnumber = data.data.totalPages;
    //
    //             $("#pagination1").empty();
    //             $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="previous1">&laquo;</a></li>');
    //             for (var j = 0; j < totalPagesnumber; j++) {
    //                 $("#pagination1").append('  <li class="page-item" id="pageLi1' + j + '"name="pageNo1"><a class="page-link" id="pageNo1' + j + '"href="#">' + (j + 1) + '</a></li>');
    //             }
    //             $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="next1">&raquo;</a></li>');
    //
    //             $("li[name='pageNo1']").removeClass("active");
    //             $("#pageNo1" + currentPage).parent().addClass("active");
    //
    //             $("li[name='pageNo1']").click(function () {
    //                 var idval = this.id;
    //                 currentPage = Number(idval.substr(7));
    //
    //                 getAllSkill()
    //             })
    //
    //             //下一页
    //             $("#next1").click(function () {
    //                 var curr = new Number(currentPage);
    //                 currentPage = curr + 1;
    //
    //                 getAllSkill()
    //             })
    //
    //             //上一页
    //             $("#previous1").click(function () {
    //                 var curr = new Number(currentPage);
    //                 currentPage = curr - 1;
    //
    //                 getAllSkill()
    //
    //             })
    //         }
    //     })
    //     //请求end
    //
    //
    //
    //     $("#skillAddModal").modal("show");
    //
    //     $("body").addClass("modal-open");
    //
    //     flag = false;
    // }
    //所有技能分页询end

    //所有技能查询
    function showAllSkill() {
        //请求
        $.ajax({
            url : "position/showAllSkill",
            type : "get",
            dataType : "json",
            success : function(data){
                console.log(data)
                $("#skillTbody").empty();
                $(data.data).each(function(){
                    $("#skillTbody").append("<tr><td style='width:20%'>" + '<input id="'+ this.id + '-' + this.label +'" name="skillCheck" type="checkbox" value="'
                        + this.id + '-' + this.label + '">' + "</td><td style='width:20%'>"
                        + this.id + "</td><td style='width:20%'>"
                        + this.label + "</td></tr>")
                })
            }
        })
        //请求end
        flag = false;
        $("#skillAddModal").modal("show");
    }


    //所有技能查询end


    //模态框滚动
    $("#skillModalBtn").on("click", function(){
        $("#skillAddModal").modal("hide")
        $("#positionAddModal").css({'overflow-y':'scroll'});
        $("#positionEditModal").css({'overflow-y':'scroll'});
    })
    //模态框滚动end



    //所有职位查询请求
    function showAllPosition() {
        //请求
        $.ajax({
            url: "position/showAllByCreateById/" + currentPage2 + "/" + 5,
            type: "get",
            dataType: "json",
            success: function (data) {
                $("#positionTbody").empty();
                let content = data.data.content;
                console.log(data.data)

                $(content).each(function (j) {

                    $("#positionTbody").append(" <tr><td>"
                        + (j + 1) + "</td><td>"
                        + this.name + "</td><td>"
                        + this.city + "</td><td>"
                        + "<span class='count'>"
                        +this.minSales+"</span>" + "~" + "<span class='count'>"
                        +this.maxSales+"</span>" + "</td><td>"
                        + this.education + "</td><td><button type='button' class='btn btn-outline-success btn-sm' name='positionDetails'"
                        + "id='"+this.address+"_"+this.detail+"_"+this.workedyears+"_"+this.skillList+"_"+this.requiredNum+"_"
                        +"'><i class='fa ti-eye'></i>&nbsp; 详情</button></td><td><button type='button' class='btn btn-outline-warning btn-sm' name='positionEdit' id='"
                        +this.id+"_"+this.name+"_"+this.minSales+"_"+this.maxSales+"_"+this.city+"_"+this.address+"_"+this.workedyears+"_"+this.education+"_"+this.requiredNum+"_"+this.detail
                        +"'><i class='fa fa-pencil-square-o'></i>&nbsp; 修改</button>&nbsp;&nbsp;<button type='button' class='btn btn-outline-danger btn-sm' name='positionDelete'"
                        + "id='"+ this.id +"'><i class='fa fa-warning (alias)'></i>&nbsp; 删除</button></td>"
                    )
                })

                let totalPagesnumber = data.data.totalPages;

                $("#pagination2").empty();
                $("#pagination2").append('<li class="page-item"><a class="page-link" href="#" id="previous2">&laquo;</a></li>');
                for (var j = 0; j < totalPagesnumber; j++) {
                    $("#pagination2").append('  <li class="page-item" id="pageLi2'+j+'"name="pageNo2"><a class="page-link" id="pageNo2' + j + '"href="#">' + (j + 1) + '</a></li>');
                }
                $("#pagination2").append('<li class="page-item"><a class="page-link" href="#" id="next2">&raquo;</a></li>');

                $("li[name='pageNo2']").removeClass("active");
                $("#pageNo2" + currentPage2).parent().addClass("active");

                $("li[name='pageNo2']").click(function () {
                    var idval = this.id;
                    currentPage2 = Number(idval.substr(7));

                    showAllPosition()
                })

                //下一页
                $("#next2").click(function () {
                    var curr = new Number(currentPage2);
                    if (curr + 1 < totalPagesnumber) {
                        currentPage2 = curr + 1;
                        showAllPosition()
                    }
                })

                //上一页
                $("#previous2").click(function () {
                    var curr = new Number(currentPage2);
                    if (curr - 1 >= 0) {
                        currentPage2 = curr - 1;
                        showAllPosition()
                    }
                })
            },
            error: function (err) {
                alert("失败")
            }
        })
        //请求end
    }
    //所有职位查询请求end

    //添加职位
    $("#positionAdd").on("click", function(){

        let skills = "";
        $("input[name='skillCheck']:checked").each(function(i){
            if(i == 0){
                skills += this.value;
            }else{
                skills += ","  +this.value
            }
        })

        let Data = {"name":$("#name").val(), "minSales":$("#minSales").val(), "maxSales":$("#maxSales").val(),
            "city":$("#city").val(), "address":$("#address").val(), "pid":$("#pid").val(),
            "workedyears":$("#workedyears").val(), "education":$("#education").val(),
            "requiredNum":$("#requiredNum").val(),"detail":$("#detail").val(),"skillList":skills}
        //请求
        $.ajax({
            url : "position/addPosition",
            data : JSON.stringify(Data),
            type : "post",
            contentType: 'application/json;charset=utf-8',
            dataType : "json",
            success : function(data){
                alert("成功")
                $("#positionAddModal").modal("hide")
                showAllPosition();
            }
        })
        //请求end
        flag = true;
    })
    //添加职位end

    //职位详情
    $("body").on("click", "button[name='positionDetails']", function(){
        let data = $(this).attr("id").split("_")
        let skillSet = data[3].split(",");

        $("#address2").val(data[0])
        $("#detail2").val(data[1])
        $("#workedyears2").val(data[2])
        $("#requiredNum2").val(data[4])


        $("#skillSet").empty();
        let count = 0;
        $(skillSet).each(function () {
            if( this.split("-")[1]){
                $("#skillSet").append(" <span style='display:inline-block;width:100px;font-weight:bold;'class='list-group-item'>"+this.split("-")[1]+"</span>&nbsp;&nbsp;")
            }
        })

        $("#positionDetailModal").modal("show")

    })
    //职位详情

    //修改职位模态框赋值
    $("body").on("click", "button[name='positionEdit']", function(){
        var dataArr = $(this).attr("id").split("_")
        $("#id3").val(dataArr[0])
        $("#name3").val(dataArr[1])
        $("#minSales3").val(dataArr[2])
        $("#maxSales3").val(dataArr[3])
        $("#city3").val(dataArr[4])
        $("#address3").val(dataArr[5])
        $("#workedyears3").val(dataArr[6])
        $("#education3").val(dataArr[7])
        $("#requiredNum3").val(dataArr[8])
        $("#detail3").val(dataArr[9])

        $("#positionEditModal").modal("show")
    })
    //修改职位模态框赋值end

    //修改职业
    $("#positionAdd2").on("click", function(){
        let skills = "";
        $("input[name='skillCheck']:checked").each(function(i){
            if(i == 0){
                skills += this.value;
            }else{
                skills += ","  +this.value
            }
        })

        let Data = {"id":$("#id3").val(), "name":$("#name3").val(), "minSales":$("#minSales3").val(), "maxSales":$("#maxSales3").val(),
            "city":$("#city3").val(), "address":$("#address3").val(), "pid":$("#pid2").val(),
            "workedyears":$("#workedyears3").val(), "education":$("#education3").val(),
            "requiredNum":$("#requiredNum3").val(),"detail":$("#detail3").val(), "skillList":skills}
        //请求
        $.ajax({
            url : "position/editPosition",
            data : JSON.stringify(Data),
            type : "post",
            contentType: 'application/json;charset=utf-8',
            dataType : "json",
            success : function(data){
                alert("成功")
                $("#positionEditModal").modal("hide")
                flag = true;
                showAllPosition()
            }
        })
        //请求end

    })
    //修改职业end

    //删除职位
    $("body").on("click", "button[name='positionDelete']", function(){
        var $id = $(this).attr("id");

        if (confirm("确认删除吗？")){
            //请求
            $.ajax({
                url : "position/deletePosition/" + $id,
                type : "post",
                dataType : "json",
                success : function(data){
                    showAllPosition();
                }
            })
            //请求end
        }

    })
    //删除职位end

});