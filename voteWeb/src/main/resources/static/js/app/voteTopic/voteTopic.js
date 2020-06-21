$(function () {
    var settings = {
        url: ctx + "voteTopic/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                title: $(".voteTopic-table-form").find("input[name='title']").val().trim()
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
            field: 'title',
            title: '标题'
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
                     field: 'optioncount',
                     title: '选项个数'
                  },

         {
        field: 'remarks',
            title: '备注'
        }, {
            
            field: 'createtime',
            title: '修改时间'
        }




        ]
    };

    $MB.initTable('voteTopicTable', settings);
});

function search() {
    $MB.refreshTable('voteTopicTable');
}

function refresh() {
    $(".voteTopic-table-form")[0].reset();
    search();
}

function deleteVote() {
    var selected = $("#voteTopicTable").bootstrapTable('getSelections');
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
        $.post(ctx + 'voteTopic/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function exportvoteTopicExcel() {
    $.post(ctx + "voteTopic/excel", $(".voteTopic-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportvoteTopicCsv() {
    $.post(ctx + "voteTopic/csv", $(".voteTopic-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}