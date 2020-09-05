$(function () {
    var settings = {
        url: ctx + "voteVO/listResult",
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
            
            field: 'voteoptioncount',
            title: '票数'
        }




        ]
    };

    $MB.initTable('voteResultVOTable', settings);
});

function search() {
    $MB.refreshTable('voteResultVOTable');
}

function refresh() {
    $(".voteVO-table-form")[0].reset();
    search();
}

function deleteVote() {
    var selected = $("#voteResultVOTable").bootstrapTable('getSelections');
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
    var selected = $("#voteResultVOTable").bootstrapTable('getSelections');
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