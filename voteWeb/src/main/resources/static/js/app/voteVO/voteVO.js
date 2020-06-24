$(function () {
    var settings = {
        url: ctx + "voteVO/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                title: $(".voteVO-table-form").find("input[name='title']").val().trim()
            };
        },
        columns: [
        {
                 checkbox: true
             },
              {
                  field: 'optionId',
                   title: '选项序号'
              },
             {
                 field: 'voteName',
                 title: '投票项目'
             },

              {
                         field: 'topicName',
                         title: '投票主题'
                     },
         {
            field: 'option',
            title: '选项内容'
        },

 {
            field: 'kinds',
            title: '类型',
            formatter: function (value, row, index) {
                if (value == '0') return '<span class="badge badge-success">单选</span>';
                if (value == '1') return '<span class="badge badge-primary">多选</span>';

            }
         },

         {
                    field: 'status',
                    title: '状态',
                    formatter: function (value, row, index) {
                        if (value == '0') return '<span class="badge badge-success">草稿</span>';
                        if (value == '1') return '<span class="badge badge-primary">已发布</span>';
                        if (value == '2') return '<span class="badge badge-warning">结束</span>';
                    }
                 },




        {
            
            field: 'createtime',
            title: '创建时间'
        }




        ]
    };

    $MB.initTable('voteVOTable', settings);
});

function search() {
    $MB.refreshTable('voteVOTable');
}

function refresh() {
    $(".voteVO-table-form")[0].reset();
    search();
}

function deleteVote() {
    var selected = $("#voteVOTable").bootstrapTable('getSelections');
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
        $.post(ctx + 'voteVO/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}


function submitVote() {
    var selected = $("#voteVOTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要的投票！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].optionId;
        if (i !== (selected_length - 1)) ids += ",";
    }

        $.post(ctx + 'voteVO/submitvote', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });

}

function exportvoteVOExcel() {
    $.post(ctx + "voteVO/excel", $(".voteVO-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportvoteVOCsv() {
    $.post(ctx + "voteVO/csv", $(".voteVO-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}