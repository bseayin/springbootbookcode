jQuery(document).ready(function ($) {
    $("#header").load("/job/topul.html");

    var currentPage1 = 0;
    showAllPosition();
    IndustryType();

    //查询所有职位类型
    function IndustryType() {
        //请求
        $.ajax({
            url: "/job/position/showAllIndustry",
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log(data)
                $(data.data.dictValue).each(function () {
                    $("#positionType").append(" <option name='positionType' value='" + this.id + "'>" + this.label + "</option>")

                })
            }
        })
        //请求end
    }

    //职位类型查询end

    $("#query").on("click", function () {
        currentPage1 = 0;
        showByTid();
    })

    //相关职业查询
    function showByTid(){
        var type = $("option[name='positionType']:selected").val()
        //请求
        $.ajax({
            url: "position/showByTid/" + type + "/" + currentPage1 + "/" + 5,
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
                        + this.minSales + "</span>" + "~" + "<span class='count'>"
                        + this.maxSales + "</span>" + "</td><td>"
                        + this.education + "</td><td><button type='button' class='btn btn-outline-success btn-sm' name='positionDetails'"
                        + "id='" + this.address + "_" + this.detail + "_" + this.workedyears + "_" + this.skillList + "_" + this.requiredNum + "_"
                        + "'><i class='fa ti-eye'></i>&nbsp; 详情</button></td><td><button type='button' class='btn-outline-primary btn-sm' name='resumeSelectBtn' value='"
                        + this.id + "'>申请职位</button></td>"
                    )
                })

                let totalPagesnumber = data.data.totalPages;

                $("#pagination1").empty();
                $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="previous3">&laquo;</a></li>');
                for (var j = 0; j < totalPagesnumber; j++) {
                    $("#pagination1").append('  <li class="page-item" id="pageLi3' + j + '"name="pageNo3"><a class="page-link" id="pageNo3' + j + '"href="#">' + (j + 1) + '</a></li>');
                }
                $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="next3">&raquo;</a></li>');

                $("li[name='pageNo3']").removeClass("active");
                $("#pageNo3" + currentPage1).parent().addClass("active");

                $("li[name='pageNo3']").click(function () {
                    var idval = this.id;
                    currentPage1 = Number(idval.substr(7));

                    showByTid()
                })

                //下一页
                $("#next3").click(function () {
                    var curr = new Number(currentPage1);
                    if (curr + 1 < totalPagesnumber) {
                        currentPage1 = curr + 1;
                        showByTid()
                    }
                })

                //上一页
                $("#previous3").click(function () {
                    var curr = new Number(currentPage1);
                    if (curr - 1 >= 0) {
                        currentPage1 = curr - 1;
                        showByTid()
                    }
                })
            }
        })
        //请求end
    }
    //相关职业查询end


    //所有职位分页查询请求
    function showAllPosition() {
        //请求
        $.ajax({
            url: "position/showAllByPage/" + currentPage1 + "/" + 5,
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
                        + this.minSales + "</span>" + "~" + "<span class='count'>"
                        + this.maxSales + "</span>" + "</td><td>"
                        + this.education + "</td><td><button type='button' class='btn btn-outline-success btn-sm' name='positionDetails'"
                        + "id='" + this.address + "_" + this.detail + "_" + this.workedyears + "_" + this.skillList + "_" + this.requiredNum + "_"
                        + "'><i class='fa ti-eye'></i>&nbsp; 详情</button></td><td><button type='button' class='btn-outline-primary btn-sm' name='resumeSelectBtn' value='"
                        + this.id + "'>申请职位</button></td>"
                    )
                })

                let totalPagesnumber = data.data.totalPages;

                $("#pagination1").empty();
                $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="previous1">&laquo;</a></li>');
                for (var j = 0; j < totalPagesnumber; j++) {
                    $("#pagination1").append('  <li class="page-item" id="pageLi1' + j + '"name="pageNo1"><a class="page-link" id="pageNo1' + j + '"href="#">' + (j + 1) + '</a></li>');
                }
                $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="next1">&raquo;</a></li>');

                $("li[name='pageNo1']").removeClass("active");
                $("#pageNo1" + currentPage1).parent().addClass("active");

                $("li[name='pageNo1']").click(function () {
                    var idval = this.id;
                    currentPage1 = Number(idval.substr(7));

                    showAllPosition()
                })

                //下一页
                $("#next1").click(function () {
                    var curr = new Number(currentPage1);
                    if (curr + 1 < totalPagesnumber) {
                        currentPage1 = curr + 1;
                        showAllPosition()
                    }
                })

                //上一页
                $("#previous1").click(function () {
                    var curr = new Number(currentPage1);
                    if (curr - 1 >= 0) {
                        currentPage1 = curr - 1;
                        showAllPosition()
                    }
                })
            }
        })
        //请求end
    }

    //所有职位分页查询请求end



    //职位详情
    $("body").on("click", "button[name='positionDetails']", function () {
        let data = $(this).attr("id").split("_")
        let skillSet = data[3].split(",");

        $("#address").val(data[0])
        $("#detail").val(data[1])
        $("#workedyears").val(data[2])
        $("#requiredNum").val(data[4])


        $("#skillSet").empty();
        $(skillSet).each(function () {
            if( this.split("-")[1]){
                $("#skillSet").append(" <span style='display:inline-block;width:100px;font-weight:bold;'class='list-group-item'>" + this.split("-")[1] + "</span>&nbsp;&nbsp;")
            }

        })

        $("#positionDetailModal").modal("show")
        $("#positionDetailModal").removeAttr("style")


    })
    //职位详情

    var pid;
    var currentPage2 = 0;
    $("body").on("click", "button[name='resumeSelectBtn']", function () {
        pid = $(this).val();
        showAllResume();

    })
    //查询用户所有简历
    function showAllResume() {
            $("#resumeTbody").empty()
            //请求
            $.ajax({
                url: "resume/showBycreateBy/" + currentPage2 + "/" + 3,
                type: "get",
                dataType: "json",
                success: function (data) {
                    console.log(data)
                    $(data.data.content).each(function () {
                        $("#resumeTbody").append(" <tr><td>" + "<p><input class='with-gap' type='radio' name='resume' value='"
                            + this.id + "' id='" + this.id + "'><label for='" + this.id + "'>"
                            + this.resumeName + "</label></p></td>"
                            + "<td><button type='button' class='btn-outline-info btn-sm' name='resumeDetails' id='" + this.name + "_" + this.sex + "_" + this.age + "_" + this.education + "_" + this.major + "_" + this.mobile + "_" + this.assessment + "_" + this.certificate + "_" + this.workedyears + "_" + this.projectExp + "_" + this.trainExp
                            + "_" + this.id + "_" + this.image + "_" + this.wordPath + "'>详情</button></td></tr>")
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

                        showAllResume()
                    })

                    //下一页
                    $("#next2").click(function () {
                        var curr = new Number(currentPage2);
                        if (curr + 1 < totalPagesnumber) {
                            currentPage2 = curr + 1;
                            showAllResume()
                        }
                    })

                    //上一页
                    $("#previous2").click(function () {
                        var curr = new Number(currentPage2);
                        if (curr - 1 >= 0) {
                            currentPage2 = curr - 1;
                            showAllResume()
                        }
                    })
                }
                })
            //请求end
            $("#resumeSelectModal").modal("show");

        }
        //查询用户所有简历end

        //简历详情
        $("body").on("click", "button[name='resumeDetails']", function () {
            let data = $(this).attr("id").split("_")

            $("#name").val(data[0])
            let sex = data[1];
            if ("女" == sex) {
                $("#sex option:contains('女')").attr("selected", true)
            } else {
                $("#sex option:contains('男')").attr("selected", true)
            }
            $("#age").val(data[2])
            $("#education").val(data[3])
            $("#major").val(data[4])
            $("#mobile").val(data[5])
            $("#assessment").val(data[6])
            $("#certificate").val(data[7])
            $("#workedyears2").val(data[8])
            $("#projectExp").val(data[9])
            $("#trainExp").val(data[10])


            $("#resumeDetailModal").modal("show")
        })
        //简历详情

        //嵌套模态框关闭重新增加遮罩
        $("#resumeDetailModal").on("hidden.bs.modal", function () {
            $("body").addClass("modal-open");
        });
        //嵌套模态框关闭重新增加遮罩end

        // 简历投递
        $("#resumeConfirmBtn").on("click", function () {
            let rid = $("input[name='resume']:checked").val()
            let position = {"pid": pid, "rid": rid}

            //请求
            $.ajax({
                url: "user/applyJob/",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(position),
                type: "post",
                success: function (data) {
                    if ("成功" == data.msg) {
                        alert("成功")
                    } else {
                        alert("失败")
                    }
                },
                error(err) {
                    alert("已投递")
                }
            })
            //请求end
        })
        //简历投递

    }

);