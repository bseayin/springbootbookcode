var prefix = "/xsz/course"
$(document).ready(function () {
	load();
});
var load = function () {
	$('#exampleTable')
		.bootstrapTreeTable(
			{
				id: 'courseId',
				code: 'courseId',
				parentCode: 'parentId',
				type: "GET", // 请求数据的ajax类型
				url: prefix + '/list', // 请求数据的ajax的url
				ajaxParams: {sort:'order_num'}, // 请求数据的ajax的data属性
				expandColumn: '1',// 在哪一列上面显示展开按钮
				striped: true, // 是否各行渐变色
				bordered: true, // 是否显示边框
				expandAll: false, // 是否全部展开
				// toolbar : '#exampleToolbar',
				columns: [
					{
						title: '编号',
						field: 'courseId',
						visible: false,
						align: 'center',
						valign: 'center',
						width: '5%'
					},
					{
						title: '名称',
						valign: 'center',
						field: 'name',
						width: '20%'
					},


					{
						title: '阶段',
						field: 'type',
						align: 'center',
						valign: 'center',
						width : '10%',
						formatter: function (item, index) {
							if (item.type === 0) {
								return '<span class="label label-primary">Java入门</span>';
							}
							if (item.type === 1) {
								return '<span class="label label-success">流行框架</span>';
							}
							if (item.type === 2) {
								return '<span class="label label-warning">Java高级</span>';
							}
							if (item.type === 3) {
								return '<span class="label label-warning">Java面试</span>';
							}
						}
					},
					{
						field : 'url',
						title : '查看详情',
						valign: 'center',
						width : '20%',
						formatter:function (item,index) {
							return '<a href="#" onclick="preview(\''+ item.url+ '\')">'+item.name+'</a>';
						}
					},

					{
						title: '操作',
						field: 'id',
						align: 'center',
						valign: 'center',
						formatter: function (item, index) {
							var e = '<a class="btn btn-primary btn-sm '
								+ s_edit_h
								+ '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ item.courseId
								+ '\')"><i class="fa fa-edit"></i></a> ';
							var p = '<a class="btn btn-primary btn-sm '
								+ s_add_h
								+ '" href="#" mce_href="#" title="添加下级" onclick="add(\''
								+ item.courseId
								+ '\')"><i class="fa fa-plus"></i></a> ';
							var d = '<a class="btn btn-warning btn-sm '
								+ s_remove_h
								+ '" href="#" title="删除"  mce_href="#" onclick="remove(\''
								+ item.courseId
								+ '\')"><i class="fa fa-remove"></i></a> ';
							var f = '<a class="btn btn-success btn-sm" href="#" title="预览"  mce_href="#" onclick="preview(\''
								+ item.url
								+ '\')"><i class="fa fa-rocket"></i></a> ';
							return e + d + p+f;
						}
					}]
			});
}

function reLoad() {
	load();
}

function add(pId) {
	layer.open({
		type: 2,
		title: '增加课程',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/add/' + pId // iframe的url
	});
}

function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn: ['确定', '取消']
	}, function () {
		$.ajax({
			url: prefix + "/remove",
			type: "post",
			data: {
				'id': id
			},
			success: function (data) {
				if (data.code == 0) {
					layer.msg("删除成功");
					reLoad();
				} else {
					layer.msg(data.msg);
				}
			}
		});
	})
}

function edit(id) {
	layer.open({
		type: 2,
		title: '课程修改',
		maxmin: true,
		shadeClose: false, // 点击遮罩关闭层
		area: ['800px', '520px'],
		content: prefix + '/edit/' + id // iframe的url
	});
}

function batchRemove() {
	// var rows = $('#exampleTable').bootstrapTable('getSelections');

}

function preview(id) {
	window.open("/blog/open/post/"+id);
	//window.location.href="/blog/open/post/"+id;
}