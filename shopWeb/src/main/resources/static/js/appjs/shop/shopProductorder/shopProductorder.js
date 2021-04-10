var prefix = "/shop/shopProductorder"
$(function () {
    laydate.render({
        elem: '#searchDatetimeStart',
        done: function(){
            reLoad();
        }
    });
    laydate.render({
        elem: '#searchDatetimeEnd',
        done: function(){
            reLoad();
        }
    });
    load();
});
var productTable;
var table;
function load() {
    table= $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/listOrder", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        status:$('#searchStatus').val(),
                        searchOrdersetid:$('#searchOrdersetid').val(),
                        searchDatetimeStart:$('#searchDatetimeStart').val()!=""?($('#searchDatetimeStart').val()+" 00:00:00"):"",
                        searchDatetimeEnd:$('#searchDatetimeEnd').val()!=""?($('#searchDatetimeEnd').val()+" 00:00:00"):"",
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true,
                        formatter:function(value,row){
                            if(row.status!=4) {
                                return {
                                    disabled: true,
                                }
                            }else{
                                return {
                                    disabled: false,
                                };
                            }
                        }
                    },
                    {
                        field: 'ordersetid',
                        title: '订单号'
                    },
                    {
                        field: 'userName',
                        title: '订单用户'
                    },
                    {
                        field: 'price',
                        title: '金额'
                    },
                    {
                        field: 'transportprice',
                        title: '运费'
                    },
                    {
                        field: 'status',
                        title: '订单状态',// 1 created/2 confirmed/3 paid/4 payRecived/5 transport/6 completed
						formatter: function (value, row, index) {
							if(value==1){return "订单生成中，待确认"}
							if(value==2){return "订单已确认，待付款"}
							if(value==3){return "确认付款中"}
							if(value==4){return "订单已付款"}
							if(value==5){return "配送中"}
							if(value==6){return "已完成"}
						}
                    },{
                        field: 'createdtime',
                        title: '创建时间'
                    },
                    {
                        title: '操作',
                        field: 'status',
                        align: 'center',
                        formatter: function (value, row, index) {
                            let re=[];
                            re.push( '<a class="btn btn-warning btn-sm " href="#" title="查看详情"  mce_href="#" onclick="showProduct(\''
                                + row.ordersetid
                                + '\')">查看详情</a> ');
                            if(row.status==4){//付款成功后 进行发货 '+s_edit_h+'
                                re.push( '<a class="btn btn-primary btn-sm  " href="#" mce_href="#" title="确认发货" onclick="doTransport(\''
                                    + row.ordersetid
                                    + '\')">确认发货</a> ')
                            }

                            return re.join(" ");
                        }
                    }]
            });

    $('#exampleTable').on('check.bs.table uncheck.bs.table load-success.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        $('#batchTransport').prop('disabled', ! $('#exampleTable').bootstrapTable('getSelections').length);
    });
}
function doTransport(ordersetid){

    let postData={
        "ordersetid":ordersetid,
        "status":5
    };
    $.ajax({
        cache : true,
        type : "POST",
        url : "/shop/shopProductorder/updateOrder",
        data :postData,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                layer.msg("操作成功");
                reLoad()

            } else {
                layer.alert(data.msg)
            }

        }
    });

}
function batchTransport(){
    let ordersetids=$.map($("#exampleTable").bootstrapTable('getSelections'), function (row) {
        return row.ordersetid
    });
    let postData={
        "ids":ordersetids.join(","),
        "status":5
    };
    $.ajax({
        cache : true,
        type : "POST",
        url : "/shop/shopProductorder/updateOrderBatch",
        data :postData,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                layer.msg("操作成功");
                reLoad()

            } else {
                layer.alert(data.msg)
            }

        }
    });

}
function showProduct(ordersetid){
    $("#ordersetid").val(ordersetid);
    loadProduct();
    if(!$("#exampleTableClass").hasClass('col-sm-8')){
        $("#exampleTableClass").fadeOut("fast",function(){
           /* for(let name of columnName){
                $('#exampleTable').bootstrapTable('hideColumn',name);
            }*/
            $("#exampleTableClass").hide();
            $("#exampleTableClass").attr("class","col-sm-8");
            $("#exampleTableClass").fadeIn("slow");
            // $(".secondTableClass").fadeIn("fast");
            $("#productTableClass").fadeIn("fast");
        });
    }
}
function loadProduct() {
    if(productTable){
        $('#productTable').bootstrapTable('refresh');
        return;
    }
    productTable=$('#productTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/listProduct", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        ordersetid:$("#ordersetid").val(),
                        limit: params.limit,
                        offset: params.offset
                    };
                },
                columns: [
                    {
                        width:"550px",
                        field: 'titleShort',
                        title: '商品短标题'
                    }, {
                        width:"100px",
                        field: 'productorderMount',
                        title: '数量'
                    },/*{
                        width:"100px",
                        field: 'productorderPrice',
                        title: '现价'
                    },*/{
                        width:"100px",
                        field: 'price',
                        title: '单价'
                    },{
                        width:"100px",
                        field: 'sales',
                        title: '打折价'
                    },
                    {
                        width:"200px",
                        field: 'totalStock',
                        title: '当前库存'
                    },]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function doReset() {
     $(".doreset").val(null);
    reLoad();
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
        content: prefix + '/edit/' + id // iframe的url
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

function resetPwd(id) {
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