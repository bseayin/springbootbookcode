var prefix = "/shop/category"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                showColumns: true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                singleSelect: false, // 设置为true将禁止多选
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者
                queryParams: function (params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        pid: $("#pid").val(),
                        limit: params.limit,
                        offset: params.offset
                    };
                },
                onLoadSuccess:function(){
                    checkMainPage();
                },
                columns: [
                    {
                        field: 'name',
                        title: '名称'
                    },
                    {
                        field: 'icon',
                        title: '图标',
                        formatter: function (value) {
                            return value == null ? ''
                                : '<img style="height:20px;width:auto;" src="' + value
                                + '"></img>';
                        }
                    },
                    {
                        width: "200px",
                        field: 'updatedTime',
                        title: '更新时间'
                    },{
                        width: "100px",
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
                        width: "100px",
                        field: 'onMainPage',
                        title: '是否首页显示',
                        formatter: function (value,row,index) {
                            let re = `<div class="switch onoffswitch col-sm-2">
                                        <div class="onoffswitch">
                                        <input onchange='onMainPageChange(this)'  id="onMainPage_${row.id}" name="onMainPage_${row.id}" type="checkbox"
                                           value="1"   ${value?"checked=checked":""}   class="onoffswitch-checkbox" >
                                        <label class="onoffswitch-label" for="onMainPage_${row.id}">
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
                        events: {
                            "click .idshow": function (e, value, row, index) {
                                $("#pid").val(row.id);
                                crumbAdd(row);
                            },
                            "click .pidshow": function (e, value, row, index) {
                                crumbRemove(row);
                            }
                        },
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f;
                            if (row.pid == null || row.pid == 0) {
                                f= '<a class="btn btn-primary idshow">下级</a>';
                            } else {
                                f= '<a class="btn btn-primary pidshow">上级</a> <a class="btn btn-primary idshow">下级</a>';
                            }
                            return e + d+f;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

var viewer;

function showPic(v) {
    let viewer = new Viewer(v, {
        inline: false,
        viewed() {
            viewer.zoomTo(1);
        },
    });
    viewer.show();


}

function add() {
    var pid = $('#pid').val();
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + `/add/${pid}`, // iframe的url
        btn: ['添加', '关闭'],
        yes: function(idx, oLayer) {
          if (oLayer.find('iframe').length > 0) {
            oLayer.find('iframe')[0].contentWindow.save();
          }
        },
        btn2: function(index) {
          layer.close(index);
        }
    });
}

function edit(id) {
    layer.open({
        id: 'edit_dialog_' + id,
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id, // iframe的url
        btn: ['修改', '关闭'],
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

function remove(id) {
    layer.confirm('确定要删除选中的分类？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (r) {
                if (r.success) {
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
    var rows = $('#exampleTable').bootstrapTreeTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
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
                if (r.success) {
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
        let item_id=item.attr('id').replaceAll("active_","")
        let postdata ={};
        postdata.id=item_id
        postdata.active=item.prop("checked");
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
function onMainPageChange(item) {
    layer.confirm("确认要修改显示状态吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function (index) {
        item=$(item);
        let item_id=item.attr('id').replaceAll("onMainPage_","")
        let postdata ={};
        postdata.id=item_id
        postdata.onMainPage=item.prop("checked");
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

function crumbRemove(item) {
    let parent_id=$("#crumb_"+item.pid).attr("upcrumb_id");
    $("#crumb_"+item.pid).remove();
    parent_id=='null'?$("#pid").val(null):$("#pid").val(parent_id);
    reLoad();
}
function crumbAdd(item){
    let addDiv=$(`<li class="crumb_" crumb_id="${item.id}" upcrumb_id="${item.pid}" id='crumb_${item.id}'><a href="#">${item.name}</a></li>`)
    $(addDiv).on('click',function(){
        while($(addDiv).next("li").length>0){
            $(addDiv).next("li").remove();
            $("#pid").val($(addDiv).attr("crumb_id"));
            reLoad();
        }
    })
    $(".breadcrumb").append(addDiv);
    reLoad();
}
function crumbRoot(item){
    while($(item).next("li").length>0){
        $(item).next("li").remove();
    }
    $("#pid").val(null);
    reLoad();
}
function checkMainPage(){
    let pid=$("#pid").val();
    if(pid!=null&&pid!=''){
        $('#exampleTable').bootstrapTable('showColumn',"onMainPage");
    }else{
        $('#exampleTable').bootstrapTable('hideColumn',"onMainPage");
    }
}