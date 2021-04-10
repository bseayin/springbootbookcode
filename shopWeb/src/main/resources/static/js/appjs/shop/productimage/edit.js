$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	let postdata={};
	postdata.id=$("#id").val();
	postdata.description=$("#description").val();
	postdata.active=$("#isactive").prop("checked");
	$.ajax({
		cache : true,
		type : "POST",
		url : "/shop/productImage/update",
		data : postdata,// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 1) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
		},
		messages : {
		}
	})
}