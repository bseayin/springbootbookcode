jQuery(document).ready(function($) {
    $("#header").load("/job/topul.html");

    var currentPage = 0;
    showAll();

    //查询求职者
    function showAll() {
        $.ajax({
            url: "position/showApplicant/" + currentPage + "/" + 5,
            type: "get",
            dataType: "json",
            success: function (data) {
                console.log(data)
                $("#positionTbody").empty();

                let count = 0;
                $(data.data.content).each(function (i) {
                        $("#positionTbody").append("<tr class='odd gradeX'><td>" + (i+1) + "</td><td class='center'>"
                            + this.positionName + "</td><td class='center'>"
                            + this.applicantName + "</td><td class='center'><a href='" + this.wordPath + "'><i class='fa fa fa-link'></i>&nbsp; 导出简历</a></td></tr>");
                });
                let totalPagesnumber = data.data.totalPages;

                $("#pagination1").empty();
                $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="previous1">&laquo;</a></li>');
                for (var j = 0; j < totalPagesnumber; j++) {
                    $("#pagination1").append('  <li class="page-item" id="pageLi1' + j + '"name="pageNo1"><a class="page-link" id="pageNo1' + j + '"href="#">' + (j + 1) + '</a></li>');
                }
                $("#pagination1").append('<li class="page-item"><a class="page-link" href="#" id="next1">&raquo;</a></li>');

                $("li[name='pageNo1']").removeClass("active");
                $("#pageNo1" + currentPage).parent().addClass("active");

                $("li[name='pageNo1']").click(function () {
                    var idval = this.id;
                    currentPage = Number(idval.substr(7));

                    showAll()
                })

                //下一页
                $("#next1").click(function () {
                    var curr = new Number(currentPage);
                    if (curr + 1 < totalPagesnumber) {
                        currentPage = curr + 1;
                        showAll()
                    }
                })

                //上一页
                $("#previous1").click(function () {
                    var curr = new Number(currentPage);
                    if (curr - 1 >= 0) {
                        currentPage = curr - 1;
                        showAll()
                    }
                })
            }
        })
    }
    //查询求职者end



});