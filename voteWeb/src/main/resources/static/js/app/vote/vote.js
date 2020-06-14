$(function () {
    var settings = {
        url: ctx + "vote/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                roleName: $(".role-table-form").find("input[name='title']").val().trim()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'title',
            title: '标题'
        }, {
            field: 'status',
            title: '状态'
        }, {
            field: 'votecount',
            title: '投票次数'
         }, {
        field: 'remarks',
            title: '备注'
        }, {
            
            field: 'createtime',
            title: '创建时间'
        }]
    };

    $MB.initTable('voteTable', settings);
});

function search() {
    $MB.refreshTable('voteTable');
}

function refresh() {
    $(".role-table-form")[0].reset();
    search();
}

function deleteRoles() {
    var selected = $("#voteTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的角色！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].roleId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "删除选中角色将导致该角色对应账户失去相应的权限，确定删除？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'role/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function exportRoleExcel() {
    $.post(ctx + "role/excel", $(".role-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportRoleCsv() {
    $.post(ctx + "role/csv", $(".role-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}