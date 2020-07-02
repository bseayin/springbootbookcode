jQuery(document).ready(function($) {

  var currentUser;
  var isInitMenu=true;

   if(currentUser){
        init();
   }else{
      $.ajax({
            url: "/job/user/info",
            async: false,
            type: "get",
            contentType: 'application/json',
            dataType: 'json',
            success: function (data) {
                console.log(data)
                 currentUser=data.data.data;
                $("#myImage").attr("src", data.data.data.imagePath)
                 init();
            }
       });

   }

   function init(){
         let roleName=(currentUser.roles)[0].role;
         console.log(roleName);

        if("求职者"==roleName&&isInitMenu){

              $("#leftdiv").load("/job/leftmenu.html");
              isInitMenu=false

         }else if("企业"==roleName&&isInitMenu){

              $("#leftdiv").load("/job/leftmenu2.html");
               isInitMenu=false

         }else if("管理员"==roleName&&isInitMenu){

            $("#leftdiv").load("/job/leftmenu3.html");
            isInitMenu=false

        }

          console.log(currentUser.name);
         $('#loginnameb').html(currentUser.name);
   }

   //导航按钮激活end
   //  $("body").on("click", "a[name='menu']", function (){
   //      $("a[name='menu']").parent().removeClass("active")
   //
   //      $(this).parent().addClass('active');
   //  });
   //导航按钮激活end

})