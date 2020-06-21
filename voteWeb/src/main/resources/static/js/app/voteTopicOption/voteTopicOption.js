$(function () {
    var settings = {
        url: ctx + "voteTopicOption/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                title: $(".voteTopicOption-table-form").find("input[name='title']").val().trim()
            };
        },
        columns: [
        {
                 checkbox: true
             }, 
             {
                 field: 'id',
                 title: '序号'
             },

              {
                 field: 'voteid',
                 title: '投票项目'
               },
             {
                field: 'topicid',
                title: '主题ID'
            },
               {
                            field: 'options',
                            title: '选项内容'
                },

            {
            
            field: 'createtime',
            title: '修改时间'
        }




        ]
    };

    $MB.initTable('voteTopicOptionTable', settings);
});

function search() {
    $MB.refreshTable('voteTopicOptionTable');
}

function refresh() {
    $(".voteTopicOption-table-form")[0].reset();
    search();
}

function deleteVote() {
    var selected = $("#voteTopicOptionTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的投票主题！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].id;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "删除选中投票主题将导致该投票主题对应账户失去相应的权限，确定删除？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'voteTopicOption/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function exportvoteTopicOptionExcel() {
    $.post(ctx + "voteTopicOption/excel", $(".voteTopicOption-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportvoteTopicOptionCsv() {
    $.post(ctx + "voteTopicOption/csv", $(".voteTopicOption-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}