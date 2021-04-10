var prefix = "/schoolwall/like"
$(function() {
	load();
});

function load() {
	let  id=$("#id").val();
	let  type=$("#type").val();
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + `/list/${type}/${id}`,// 服务器数据的加载地址
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
					let searchParam = {};
					searchParam.limit = params.limit;
					searchParam.offset= params.offset;
					return searchParam  ;
				},
				columns : [
					{
						visible : true,
						title : '序号',
						width :30,
						formatter:function (value,row,index) {
							return index+1;
						}
					},
					{
						field : 'author',
						title : '点赞人',
						width :180,
						formatter:function (value,row,index) {
							return `<span>${row.username}(${row.name})</span>`;
						}
					},
					{
						field : 'likeCreatetime',
						title : '点赞时间',
						width :180
					}]
			});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}