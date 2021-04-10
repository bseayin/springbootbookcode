$().ready(function() {
	validateRule();

	layui.use('upload', function () {
		var upload = layui.upload;
		//执行实例
		var uploadInst = upload.render({
			elem: '#uploadBtn', //绑定元素
			url: '/common/sysFile/upload', //上传接口
			size: 1000,
			accept: 'file',
			done: function (r) {
				$("#picture").val(r.fileName);
				$("#pictureShow").empty();
				$("#pictureShow").append(`<img width="200px"  alt="image" src="${r.fileName}"></img>`);

			},
			error: function (r) {
				layer.msg(r.msg);
			}
		});
	});

	layui.use('upload', function () {
  		var upload = layui.upload;
  		//执行实例
  		var uploadInst = upload.render({
  			elem: '#iconuploadBtn', //绑定元素
  			url: '/common/sysFile/upload', //上传接口
  			size: 1000,
  			accept: 'file',
  			done: function (r) {
  				$("#icon").val(r.fileName);
  				$("#iconShow").empty();
  				$("#iconShow").append(`<img width="200px"  alt="icon" src="${r.fileName}"></img>`);

  			},
  			error: function (r) {
  				layer.msg(r.msg);
  			}
  		});
  	});

	$("#ico-btn").click(function(){
		layer.open({
			type: 2,
			title:'图标列表',
			content: '/FontIcoList.html',
			area: ['480px', '90%'],
			success: function(layero, index){
				//var body = layer.getChildFrame('.ico-list', index);
				//console.log(layero, index);
			}
		});
	});
	$("#parentSelect").click(parentSelect);
	$("#reset").click(function(){
		$("#pidName").val("根分类");
		$("#pid").val(null);
		$(".isonmainpage").show();
	});
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save(pid) {
	let postdata ={};
	postdata.pid=$("#pid").val();
	postdata.name=$("#name").val();
	postdata.icon=$("#icon").val();
	postdata.active=$("#isactive").prop("checked");
	postdata.onMainPage=$("#isonmainpage").prop("checked");
	postdata.picture=$("#picture").val();

	$.ajax({
		type : "POST",
		url : `/shop/category/save`,
		data:postdata,
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
			} else {
				parent.layer.alert(data.msg)
			}

		}
	});
}

function  parentItem(item){
	$("#pidName").val(item.name);
	$("#pid").val(item.id);
	if(item.id){
		$(".isonmainpage").hide();
	}
}
function parentSelect(){
	layer.open({
		type: 2,
		title:'选择父分类',
		content: '/shop/category/select',
		area: ['480px', '90%'],
		success: function(layero, index){
			//var body = layer.getChildFrame('.ico-list', index);
			//console.log(layero, index);
		}
	})
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}