var prefix = "/shop/product"
var prefix_img = "/shop/productImage"
var prudoctId="";
var columnName=['titleLong','productCategoryName','price','sales','totalStock','active'];
$(function () {
    load();

    layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        var uploadInst = upload.render({
            elem: '#uploadBtn', //绑定元素
            url: '/common/sysFile/upload', //上传接口
            size: 1000,
            accept: 'file',
            done: function (r) {
                let postdata ={};
                postdata.productId=prudoctId;
                postdata.imageSrc=r.fileName;

                $.ajax({
                    type : "POST",
                    url : `${prefix_img}/save`,
                    data:postdata,
                    async : false,
                    error : function(request) {
                        parent.layer.alert("Connection error");
                    },
                    success : function(data) {
                        if (data.success) {
                            layer.msg("操作成功");
                            reLoad();
                            $(".secondIframeClass")[0].contentWindow.reLoad();
                        } else {
                            parent.layer.alert(data.msg)
                        }

                    }
                });


            },
            error: function (r) {
                layer.msg(r.msg);
            }
        });
    });

});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/listSimple", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                smartDisplay:false,
                queryParams: function (params) {
                    return {
                        searchName: $("#searchName").val(),
                        searchCategoryId: $("#searchCategoryId").val(),
                        limit: params.limit,
                        offset: params.offset
                    };
                },
                onLoadSuccess:function(){
                    getCategorys();
                },
                columns: [
                    {
                        width:"550px",
                        field: 'titleShort',
                        title: '短标题'
                    },
                    {
                        width:"200px",
                        field: 'productCategoryName',
                        title: '分类',
                        formatter: function (value,row,index){
                            if(value==null||value==''){
                                return "暂无";
                            }
                            return value;
                        }
                    },
                 /*   {
                        field: 'titleLong',
                        title: '长标题'
                    },*/
                    {
                        width:"100px",
                        field: 'price',
                        title: '原价'
                    },
                    {
                        width:"100px",
                        field: 'sales',
                        title: '打折价'
                    },
                    {
                        width:"160px",
                        field: 'sales',
                        title: '收藏数/游览数',
                        formatter: function (value,row,index){
                            return row.favoriteNum+"/"+row.browseNum;
                        }
                    },
                    {
                        width:"200px",
                        field: 'totalStock',
                        title: '商品库存'
                    },
                    {
                        width:"120px",
                        field: 'active',
                        title: '是否可见',
						formatter: function (value,row,index){
							let re = `<div class="switch onoffswitch col-sm-2">
                                        <div class="onoffswitch">
                                        <input onchange='activeChange(this)' type="checkbox" 
                                        id="active_${row.id}" name="active_${row.id}"
                                           value="1"   ${value?"checked=checked":""}   class="onoffswitch-checkbox" >
                                        <label class="onoffswitch-label" for="active_${row.id}">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                        </label>
                                        </div>
                                    </div>`;
							return re;
						}
                    },
                    {
                        width:"160px",
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        events:{
                            'click .edit_info':function(e, value, row, index) {
                                hideTable();
                                prudoctId=value;
                                editInfo();
                            },
                            'click .edit_pic':function(e, value, row, index) {
                                hideTable();
                                prudoctId=value;
                                editPicture();
                            },
                            'click .remove_product':function(e, value, row, index) {
                              removeProduct(row);
                            },
                        },
                        formatter: function (value, row, index) {
                            let a=[];
                            a.push('<a class="edit_info btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="修改详情"><i class="fa fa-info"></i></a> ');
                            a.push('<a class="edit_pic btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="修改图片"><i class="fa fa-file-image-o"></i></a> ');
                            // a.push('<a class="remove_product btn btn-primary btn-sm ' + s_remove_h + '" href="#" mce_href="#" title="删除商品"><i class="fa fa-times"></i> </a> ');
                            // a.push('<a class="edit_size btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="修改尺寸"><i class="fa fa-server"></i></a> ');
                            return a.join(" ");
                        }
                    }]
            });
}
function hideTable(){
    prudoctId="";
    if(!$("#exampleTableClass").hasClass('col-sm-3')){
        $("#exampleTableClass").fadeOut("fast",function(){
            for(let name of columnName){
                $('#exampleTable').bootstrapTable('hideColumn',name);
            }
            menuHide();
            $("#exampleTableClass").hide();
            $("#exampleTableClass").attr("class","col-sm-3");
            if ( $('#exampleTable').bootstrapTable('getOptions').cardView === false) {
                $('#exampleTable').bootstrapTable('toggleView');
            }
            $("#exampleTableClass").fadeIn("slow");
            $(".secondTableClass").fadeIn("fast");
        });
    }
}
function showTable(){
    if($("#exampleTableClass").hasClass('col-sm-3')){
        $(".secondTableClass").fadeOut("fast",function(){
            $("#exampleTableClass").hide();
            for(let name of columnName){
                $('#exampleTable').bootstrapTable('showColumn',name);
            }
            menuShow();
            $("#exampleTableClass").attr("class","col-sm-10");
            if ( $('#exampleTable').bootstrapTable('getOptions').cardView === true) {
                $('#exampleTable').bootstrapTable('toggleView');
            }
            $("#exampleTableClass").fadeIn("slow");
        });
    }
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function doSave(){
    $(".secondIframeClass")[0].contentWindow.save();
}
function doBack(){
    showTable();
}

function menuHide(){
    $(".menuClass").hide();
}
function menuShow(){
    $(".menuClass").show();
}
function editPicture(){
    $(".edit_").hide();
    $(".edit_pic").show();
    $(".secondIframeClass").remove()
    $(".secondTableClass").append(`<iframe class="secondIframeClass" src="${prefix_img}?id=${prudoctId}"></iframe>`)
}
function editInfo(){
    $(".edit_").hide();
    $(".edit_info").show();
    $(".secondIframeClass").remove();
    $(".secondTableClass").append(`<iframe class="secondIframeClass" src="${prefix}/edit/${prudoctId}"></iframe>`)
}
function add() {
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['100%', '100%'],
        content: prefix + '/add' ,// iframe的url
        btn: ['保存','保存，继续为商品添加图片', '取消'],
        yes: function(idx, oLayer) {
            if (oLayer.find('iframe').length > 0) {
                oLayer.find('iframe')[0].contentWindow.save();
            }
            return false;
        },
        btn2: function(idx, oLayer) {
            if (oLayer.find('iframe').length > 0) {
                oLayer.find('iframe')[0].contentWindow.save(addPicture);
            }
            return false;
        },
        btn3: function(index) {
            layer.close(index);
        }
    });
}
function addPicture(productId) {
    layer.open({
        type: 2,
        title: '商品图片',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['100%', '100%'],
        content: prefix_img+ `?doAdd=true&id=${productId}` ,// iframe的url
        btn: ['关闭'],
        btn3: function(index) {
            layer.close(index);
        }
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
            success: function (r) {
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


function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

    });
}


function activeChange(item) {
	layer.confirm("确认要修改激活状态吗？", {
		btn: ['确定', '取消']
		// 按钮
	}, function (index) {
		item=$(item);
		let item_id=item.attr('id').replace("active_","")
		let postdata ={};
		postdata.id=item_id
		postdata.active=item.prop("checked");
		$.ajax({
			type : "POST",
			url : `/shop/product/updateActive`,
			data:postdata,
			async : false,
			error : function(request) {
				parent.layer.alert("Connection error");
			},
			success : function(data) {
				if (data.code == 0) {
					parent.layer.msg("操作成功");
				} else {
					parent.layer.alert(data.msg)
				}
				layer.close(index);
			}
		});
	}, function (index) {
		$(item).prop("checked",!$(item).prop("checked"))
		layer.close(index);
	});
}

function getCategorys(){
    let tableData=$('#exampleTable').bootstrapTable("getData");
    let i=0;
    for(let t of tableData){
        $.ajax({
            type : "GET",
            url : "/shop/productInCategory/list/" +t.id,
            success : function(data) {
                let hasCategorys=[];
                for(let t of data.body.categorys ){
                    hasCategorys.push(t.name)
                }
                // t.productCategoryName=
                $('#exampleTable').bootstrapTable('updateCell', {
                    index: i,
                    field:"productCategoryName",
                    value:hasCategorys.join(",")
                });
                // $('#exampleTable').bootstrapTable("load",tableData);
            }
        });
    }
}
// function removeProduct(){
//
// }