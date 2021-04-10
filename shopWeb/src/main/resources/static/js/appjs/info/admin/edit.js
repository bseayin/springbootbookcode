$().ready(function() {
	loadType();
	
	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                console.log("onImageUpload");
                sendFile(files);
            }
        }
    });
	
	var content = $("#content").val();

	$('#content_sn').summernote('code', content);
	$("#pictureShow").empty();
	$("#pictureShow").append(`<img width="200px"  alt="image" src="` + $("#photoUrl").val() + `"></img>`);
	validateRule();
	
	layui.use('upload', function () {
		var upload = layui.upload;
		//执行实例
		var uploadInst = upload.render({
			elem: '#test1', //绑定元素
			url: '/common/sysFile/upload', //上传接口
			size: 1000,
			accept: 'file',
			done: function (r) {
				$("#photoUrl").val(r.fileName);
				$("#pictureShow").empty();
				$("#pictureShow").append(`<img width="200px"  alt="image" src="${r.fileName}"></img>`);

			},
			error: function (r) {
				layer.msg(r.msg);
			}
		});
	});
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save(status) {
	$("#status").val(status);

	var content_sn = $("#content_sn").summernote('code');
	var categories = $("#categories_display").val();
	$("#content").val(content_sn);
	$("#categories").val(categories);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/info/admin/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				

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

function returnList() {
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}

function loadType(){
	var html = "";
	console.log('here==>');
	$.ajax({
		url : '/common/dict/list/info_type',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
			}
			$(".chosen-select").append(html);
			
			var categories = $('#categories').val();
			$('.chosen-select').val(categories);

//			$(".chosen-select").chosen({
//				maxHeight : 200
//			});
//			//点击事件
			$('.chosen-select').on('change', function(e, params) {
				console.log($(".chosen-select").val());
				$("#categories").val($('.chosen-select').val());
				console.log($("#categories").val());
			});
		}
	});
}

