$(function () {
        $.ajax({
                  url : "/job/user/current",
                  async : false,
                  type : "GET",
                  contentType : 'application/json',
                  dataType : 'json',
                  success : function(data) {
                        console.log(data.data.name);
                       $('#loginnameb').html(data.data.name);
                  }
        });
});
