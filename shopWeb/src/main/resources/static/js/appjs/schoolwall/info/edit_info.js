var uploadListIns;
var uploadResult=new Map();
$().ready(function() {
	// layui.use('upload', function() {
	// 	var $ = layui.jquery
	// 		, upload = layui.upload;
	// 	//多文件列表示例
	// 	var uploadFilesNum=0,uploadMaxFilesNum=3,demoListView = $('#uploadShowList');
	// 	uploadListIns = upload.render({
	// 		elem: '#uploadList'
	// 		, accept: 'images'
	// 		, multiple: false
	// 		,url:"/common/sysFile/upload"
	// 		,auto: true
	// 		, done: function (res, index, upload) {
	// 			if (res.fileName) { //上传成功
	// 				let url=res.fileName;
	// 				let id=res.fileId;
	// 				uploadResult.set(id,url);
	// 				let div=$(`<div class="file-box" style="position:relative">
	// 							<div class="file">
	// 								<span class="corner"></span>
	// 								<div class="image image_120">
	// 									<img alt="image" class="img-responsive" src="${res.fileName}">
	// 								</div>
	// 							</div></div>`);
	// 				let btn =$(`<div style="position:absolute;top:0px;z-index:9999" >
    //                                <a style="display:none" class="btn btn-danger myupload_remove" >删除</a>
    //                                 <a style="display:none" class="btn btn-success myupload_show" >预览</a>
    //                                 </div>`);
	// 				let moveBtn=$(btn).find(`.myupload_remove`)
	// 				let showBtn=$(btn).find(`.myupload_show`)
	// 				moveBtn.on("click",function(){
	// 					layer.confirm('确定要删除选中的图片？', {
	// 						btn: ['确定', '取消']
	// 					}, function () {
	// 						removeUploadFil(id);
	// 						uploadResult.delete(id);
	// 						div.remove();
	// 					})
	//
	// 				});
	// 				showBtn.on("click",function(){
	// 					let viewer = new Viewer($(`<img alt="image" class="img-responsive" src="${res.fileName}">`)[0], {
	// 						inline: false,
	// 						viewed() {
	// 							viewer.zoomTo(1);
	// 						},
	// 					});
	// 					viewer.show();
	// 				});
	// 				div.mouseenter(function() {
	// 					moveBtn.show();
	// 					showBtn.show();
	// 				});
	// 				div.mouseleave(function() {
	// 					moveBtn.hide();
	// 					showBtn.hide();
	// 				});
	// 				demoListView.append(div.prepend(btn));
	// 			}
	// 			this.error(index, upload);
	// 		}
	// 		, error: function (index, upload) {
	// 			var tr = demoListView.find('tr#upload-' + index)
	// 				, tds = tr.children();
	// 			tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
	// 			tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
	// 		}
	// 	});
	//
	//
	// })
	validateRule();
});


$.validator.setDefaults({
	submitHandler : function() {
		save(1);
	}
});
function save(status) {
	let postdata ={};
	postdata.wallStatus=status;
	postdata.wallId=$("#wallId").val();
	postdata.wallContent=$("#wallContent").val();
	postdata.wallType= $("input[name=wallType]:checked").val();
	postdata.wallAllowcomment=$("#wallAllowcomment").val() ;
	postdata.wallIsanonymous=$("#wallIsanonymous").val();
	postdata.sysFileIds=[];
	uploadResult.forEach((value,key)=>{
		postdata.sysFileIds.push({sysFileId:key,mediaUrl:value})
	})


	let url="/schoolwall/save";
	$.ajax({ url: url,
				type:"post",
				data:JSON.stringify(postdata),
				contentType:"application/json;charset=UTF-8",
				success: function(res){
					layer.msg('保存成功');
					parent.reLoad();
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
	});
}

function returnList() {
	parent.returnList();
}
function removeUploadFil(id){
	$.ajax({
		url: "/common/sysFile/remove",
		type: "post",
		data: {
			'id': id
		},
		success: function (r) {
			if (r.code == 0) {
				layer.msg(r.msg);
			} else {
				layer.msg(r.msg);
			}
		}
	});
}