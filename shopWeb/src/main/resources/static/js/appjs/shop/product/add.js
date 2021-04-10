var categorysId=[];
$().ready(function() {
	validateRule()
	$('#content_detail').summernote({
		height : '500px',
		lang : 'zh-CN',
		callbacks: {
			onImageUpload: function(files, editor, $editable) {
				console.log("onImageUpload");
				sendFile(files);
			}
		}
	});

	$("#selectCategorys").on("click",function () {
		editCatrgorys($("#id").val());
	})
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save(postFnc) {
	if(!$("#signupForm").valid()){
		return ;
	}
	let postdata={};
	postdata.titleShort=$("#titleShort").val();
	postdata.titleLong=$("#titleLong").val();
	postdata.price=$("#price").val();
	postdata.sales=$("#sales").val();
	postdata.totalStock=$("#totalStock").val();
	postdata.active=$("#isactive").prop("checked");
	postdata.service = $("#service").val();
	postdata.productDetail = $("#content_detail").summernote('code');
	postdata.categoryIds=categorysId.join(",");


	$.ajax({
		type : "POST",
		url : "/shop/product/save",
		data : postdata,// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.success) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
				var  func=eval(postFnc);
				new func(data.body);
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function getCategorys(items){
	$("#categorys").empty();
	for(let t of items){
		let tBtn=	$(`<div class="btn btn-success btn-sm " style="margin:1px" >
						${t.name} 
					</div>`);
		let delBtn=	$(`<a href="#" title="删除"  ><i class="fa fa-remove"></i></a> `)
		$("#categorys").append(tBtn.append(delBtn));

		delBtn.on("click",function(){
			tBtn.remove();
			categorysId.splice(categorysId.indexOf(t.id),1)
		})
		categorysId.push(t.id);
	}
}
function editCatrgorys(id) {
	layer.open({
		type : 2,
		title : '选择类型',
		maxmin : true,
		shadeClose : true, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/shop/productInCategory?productId=' + id, // iframe的url
		btn: ['选择', '取消'],
		yes: function(idx, oLayer) {
			if (oLayer.find('iframe').length > 0) {
				oLayer.find('iframe')[0].contentWindow.getAllSelectNodes();
			}
			return false;
		},
	});
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			price : {
				required : true
			}
		},
		messages : {
		}
	})
}