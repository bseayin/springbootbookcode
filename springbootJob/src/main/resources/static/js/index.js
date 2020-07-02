jQuery(document).ready(function($) {
    $("#header").load("/job/topul.html");

//    getUserInfo();

//    function getUserInfo() {
//        $.ajax({
//            url: "/job/user/info",
//            async: false,
//            type: "get",
//            contentType: 'application/json',
//            dataType: 'json',
//            success: function (data) {
//                /**现在只有一个role**/
//                let roleName = (data.data.data.roles)[0].role;
//
//                if("求职者" == roleName){
//                    $("#leftdiv").load("/job/leftmenu.html");
//                }else if("企业" == roleName){
//                    $("#leftdiv").load("/job/leftmenu2.html");
//                }
//
//
//
//                $("#loginName").text(data.data.data.name);
//            }
//        });
//
//    }





});
