$(function () {
    var settings = {
        url: ctx + "vote/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                title: $(".vote-table-form").find("input[name='title']").val().trim()
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
            field: 'title',
            title: '标题'
        },

        {
            field: 'votecount',
            title: '投票次数'
         }, {
        field: 'remarks',
            title: '备注'
        }, {
            
            field: 'createtime',
            title: '修改时间'
        },
        {
            field: 'status',
            title: '状态',
            formatter: function (value, row, index) {
                if (value == '0') return '<span class="badge badge-success">草稿</span>';
                if (value == '1') return '<span class="badge badge-primary">已发布</span>';
                if (value == '2') return '<span class="badge badge-warning">结束</span>';
            }
         }

        ]
    };

    $MB.initTable('voteTable', settings);
});

function search() {
    $MB.refreshTable('voteTable');
}

function refresh() {
    $(".vote-table-form")[0].reset();
    search();
}

function deleteVote() {
    var selected = $("#voteTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的投票项目！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].id;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "删除选中投票项目将导致该投票项目对应账户失去相应的权限，确定删除？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'vote/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function exportVoteExcel() {
    $.post(ctx + "vote/excel", $(".vote-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportVoteCsv() {
    $.post(ctx + "vote/csv", $(".vote-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}