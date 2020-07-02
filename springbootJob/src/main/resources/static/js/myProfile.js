jQuery(document).ready(function($) {
    $("#header").load("/job/topul.html");
    var uname;
    query();

    //个人信息查询
    function query(){
        //请求
        $.ajax({
            url : "user/info",
            type : "get",
            dataType : "json",
            success : function(data){
                let userInfo = data.data.data;
                $("#name").val(userInfo.name);
                let sex = userInfo.sex;
                if("女" == sex){
                    $("#sex option:contains('女')").attr("selected", true)
                }else{
                    $("#sex option:contains('男')").attr("selected", true)
                }
                $("#age").val(userInfo.age);
                $("#mobile").val(userInfo.mobile);
                $("#email").val(userInfo.email);
                $("#userName").text(userInfo.name);
                $("#userRole").text(userInfo.roles[0].role);
                $("#imagePath").attr('src', userInfo.imagePath);
                if(userInfo.applicationStatus == 1){
                    $("#applicationFrm").remove()
                    $("#applicationDiv").append("<div class='alert alert-info'><strong>企业申请！</strong> 正在审核中。</div>")
                }
                uname = userInfo.uname;
            }
        })
        //请求end
    }
    //个人信息查询end


    //个人信息可修改
    $("#userInfoEditBtn").on("click", function(){
        $("#userInfoFrm :input").attr("disabled", false);
        $("#userInfoEditConfirmBtn").attr("disabled", false);
    })
    //个人信息可修改end

    //个人信息修改确认
    $("#userInfoEditConfirmBtn").on("click", function(){
        var user = {"name":$("#name").val(),
                    "sex":$("#sex").val(),
                    "age":$("#age").val(),
                    "mobile":$("#mobile").val(),
                    "email":$("#email").val()}
        if(confirm("确认修改吗?")){
            //请求
            $.ajax({
                url : "user/infoEdit",
                data : JSON.stringify(user),
                type : "post",
                contentType: 'application/json;charset=utf-8',
                dataType : "json",
                success : function(data){
                    if("成功" == data.msg){
                        alert("修改成功")
                        $(location).attr("href", "myProfile.html");
                    }else{
                        alert("修改失败")
                    }
                }
            })
            //请求end
        }else{
            console.log("取消修改")
        }
    })
    //个人信息修改确认end

    //密码修改
    $("#pwdModifyBtn").on("click", function () {
        let oldPwd = $("#oldPwd").val();
        let newPwd = $("#newPwd").val();
        let newPwd2 =  $("#newPwd2").val();

        var user = {"pwd":oldPwd, "uname":uname}
        //原始密码验证请求
        $.ajax({
            url : "user/confirmOldPwd",
            data : JSON.stringify(user),
            type : "post",
            contentType: 'application/json;charset=utf-8',
            dataType : "json",
            success : function(data){

                if("成功" == data.data){

                    if(newPwd == newPwd2){
                        var user = {"pwd":newPwd, "uname":uname}

                        //密码修改请求
                        $.ajax({
                            url : "user/modifyPwd",
                            data : JSON.stringify(user),
                            type : "post",
                            contentType: 'application/json;charset=utf-8',
                            dataType : "json",
                            success : function(data){
                                alert("成功")
                                $(location).attr("href", "login.html");
                            }
                        })
                        //密码修改请求end

                    }else{
                        alert("确认密码错误")
                    }
                }else{
                    alert(data.data);
                }

            }
        })
        //原始密码验证请求end

    })
    //密码修改end

    //修改头像
    $("#imageFile").on("change", function(){
        $("#imageModifyFrm").submit();
    })
    //修改头像end

    //企业用户申请
    $("#applicationBtn").on("click", function(){
        $("#applicationFrm").submit();
    })
    //企业用户申请end

});
