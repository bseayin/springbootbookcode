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
                columns: [
                    {
                        field: 'name',
                        title: '名称'
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
                            },
                            "click .select": function (e, value, row, index) {
                                select(row);
                            }
                        },
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary select ' + s_edit_h + '" href="#" mce_href="#" title="选择" ">选择作为父分类</a> ';
                            var f;
                            if (row.pid == null || row.pid == 0) {
                                f= '<a class="btn btn-primary idshow">下级</a> ';
                            } else {
                                f= '<a class="btn btn-primary pidshow">上级</a> <a class="btn btn-primary idshow">下级</a>';
                            }
                            return e +f;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function select(item){
    parent.parentItem(item);
    parent.layer.close( parent.layer.getFrameIndex(window.name));
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