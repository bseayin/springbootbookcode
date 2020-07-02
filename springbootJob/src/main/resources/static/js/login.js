$(function () {
$("#loginsubmit").click(function(){
    let postData={uname:$("#mobileinput").val(),pwd:$("#passwordinput").val()};
     $.ajax({
          url : "/job/user/login",
          async : false,
          type : "POST",
          contentType : 'application/json',
          dataType : 'json',
          data :JSON.stringify(postData),
          success : function(data) {
                console.log(data);
               if("成功"==data.msg){
                    window.location.href="/job/index.html";
               }else{
                    alert(data.msg);
               }

          }
            });



});



$("#registersubmit").click(function(){
    let p1=$("#registerpasswordinput").val();
    let p2=$("#registerpasswordinput2").val();
    if(p1!=p2){
        alert("两次密码输入不一致！请重新输入");
    }else{
        let postData={name:$("#registernameinput").val(),
                        uname:$("#registerunameinput").val(),
                        pwd:$("#registerpasswordinput").val(),
                        email:$("#registeremailinput").val(),
                        mobile:$("#registermobileinput").val(),
                        age:$("#registerageinput").val(),
                        sex:$("#registersexinput").val()
                      };
             $.ajax({
                  url : "/job/user/register",
                  async : false,
                  type : "POST",
                  contentType : 'application/json',
                  dataType : 'json',
                  data :JSON.stringify(postData),
                  success : function(data) {
                       console.log(data);
                      if("成功"==data.msg){
                            window.location.href="/job/login";
                       }else{
                            alert(data.msg);
                       }
                  }
             });
    }




});

});