var prefix = "/schoolwall"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						singleSelect : false, // 设置为true将禁止多选
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
						queryParams : function(params) {
							return {
								// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit : params.limit,
								offset : params.offset
							};
						},
						columns : [
								{
									checkbox : true
								},
								{
									visible : true,
									title : '序号',
									width :30,
									formatter:function (value,row,index) {
										return index+1;
									}
								},
								{
									field : 'wallType',
									title : '类型',
									align : 'center',
									width :100,
									formatter : function(value, row, index) {
										if (value == '0') {
											return '<span class="label label-danger">表白</span>';
										}
										if (value == '1') {
											return '<span class="label label-primary">树洞</span>';
										}
										if (value == '2') {
											return '<span class="label label-warning">心愿</span>';
										}
										if (value == '3') {
											return '<span class="label label-success"">知乎</span>';
										}
									}
								},
								{
									field : 'wallContent',
									title : '内容',
                                    formatter:function (value,row,index) {
                                        return `<span style="word-break:break-all">${row.wallContent}</span>`;
                                    }
                                },
								{
									field : 'author',
									title : '作者',
									width :180,
									formatter:function (value,row,index) {
										return `<span>${row.username}(${row.name})</span>`;
									}
								},
								{
									field : 'wallIsanonymous',
									title : '是否匿名',
									align : 'center',
									width :80,
									formatter : function(value, row, index) {
										if (value == '0') {
											return '<span class="label label-danger">否</span>';
										} else if (value == '1') {
											return '<span class="label label-primary">是</span>';
										}
									}
								},
								{
									field : 'wallStatus',
									title : '状态',
									align : 'center',
									width :80,
									formatter : function(value, row, index) {
										if (value == '0') {
											return '<span class="label label-danger">草稿</span>';
										} else if (value == '1') {
											return '<span class="label label-primary">发布</span>';
										}else if (value == '-1') {
											return '<span class="label label-danger">无效</span>';
										}
									}
								},
								{
									field : 'wallAllowcomment',
									title : '开启评论',
									align : 'center',
									width :80,
									formatter : function(value, row, index) {
										if (value == '0') {
											return '<span class="label label-danger">否</span>';
										} else if (value == '1') {
											return '<span class="label label-primary">是</span>';
										}
									}
								},
								{
									field : 'wallCommentsnum',
									title : '评论数量',
									width :80
								},
								{
									field : 'wallLikenum',
									title : '点赞数量',
									width :80
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
									width :200,
									events:{
										"click .edit" : function (e, value, row, index) {
											edit(row.wallId);
										},
										"click .remove" : function (e, value, row, index) {
											remove(row.wallId);
										},
										"click .preview" : function (e, value, row, index) {
											preview(row.wallId);
										},
									},
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm edit '+s_edit_h+'" href="#" mce_href="#" title="编辑" ><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm remove '+s_remove_h+'" href="#" title="删除"  mce_href="#" ><i class="fa fa-remove"></i></a> ';
										// var f = '<a class="btn btn-success btn-sm preview " href="#" title="预览"  mce_href="#" ><i class="fa fa-rocket"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	var addPage = layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false,
		area : [ '100%', '100%' ],
		content : prefix + '/add',
		end: function(){
			reLoad();
		}
	});
}
function edit(id) {
	var editPage = layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false,
		area : [ '100%', '100%' ],
		content : prefix + '/edit/' + id
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}

function preview(id) {
	window.open("/blog/open/post/"+id);
	//window.location.href="/blog/open/post/"+id;
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['wallId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}