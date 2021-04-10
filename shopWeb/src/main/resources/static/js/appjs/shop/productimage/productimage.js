var prefix = "/shop/productImage"
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
                postdata.productId=$("#id").val();
                postdata.imageSrc=r.fileName;

                $.ajax({
                    type : "POST",
                    url : `${prefix}/save`,
                    data:postdata,
                    async : false,
                    error : function(request) {
                        parent.layer.alert("Connection error");
                    },
                    success : function(data) {
                        if (data.success) {
                            parent.layer.msg("操作成功");
                            reLoad();
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
                url: prefix + "/list", // 服务器数据的加载地址
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
                queryParams: function (params) {
                    return {
                        limit: params.limit,
                        offset: params.offset,
						productId:$("#id").val()
                    };
                },
                formatNoMatches: function () {
                    return '还没有添加图片，赶快添加吧！！';
                },
                columns: [
                    {
                        field: 'imageSrc',
                        title: '图片',
                        formatter:function(value,row,index){
                            return `<img width="200px"  alt="image" src="${value}"></img>`;
                        }
                    },
                    {
                        field: 'description',
                        title: '描述'
                    },
                    {
                        field: 'active',
                        title: '是否激活',
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
                        title: '操作',
                        field: 'id',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function add() {
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id, // iframe的url
        btn: ['添加', '关闭'],
        yes: function(idx, oLayer) {
            if (oLayer.find('iframe').length > 0) {
                oLayer.find('iframe')[0].contentWindow.update();
            }
        },
        btn2: function(index) {
            layer.close(index);
        }
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
            url : `${prefix}/updateActive`,
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