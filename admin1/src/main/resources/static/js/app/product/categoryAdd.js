var $categoryAddForm = $("#category-add-form");

$(function () {
    // 新增保存
    $("#category-add-button").click(function () {
        getDept();
        let dateForm = {
            "categoryName": $categoryAddForm.find("input[name='categoryName']").val().trim(),
            "categoryCompanyid": $categoryAddForm.find("input[name='categoryCompanyid']").val().trim(),
            "categoryNameEn": $categoryAddForm.find("input[name='categoryNameEn']").val().trim(),
        }
        $.ajax({
            url: ctx + "category/categoryAdd",
            async: false,
            type: "POST",
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(dateForm),
            success: function (data) {
                if (data.code === 0) {
                    closeModal();
                    $MB.n_success(data.msg);
                    $MB.refreshTable("categoryTable");
                } else $MB.n_danger(data.msg);
            }
        });
    });
    // 修改保存
    $("#category-update-button").click(function () {
        getDept();
        let dateUpdateForm = {
            "categoryId": $categoryAddForm.find("input[name='categoryId']").val().trim(),
            "categoryName": $categoryAddForm.find("input[name='categoryName']").val().trim(),
            "categoryCompanyid": $categoryAddForm.find("input[name='categoryCompanyid']").val().trim(),
            "categoryNameEn": $categoryAddForm.find("input[name='categoryNameEn']").val().trim(),
        }
        $.ajax({
            url: ctx + "category/categoryUpdate",
            async: false,
            type: "POST",
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(dateUpdateForm),
            success: function (data) {
                if (data.code === 0) {
                    closeModal();
                    $MB.n_success(data.msg);
                    $MB.refreshTable("categoryTable");
                } else $MB.n_danger(data.msg);
            }
        });
    });

    $("#category-add .btn-close").click(function () {
        closeModal();
    });

});

// 关闭模态框
function closeModal() {
    $MB.resetJsTree("companyTree");
    $MB.closeAndRestModal("category-add");
}

// 生成树
function createCompanyTree(isSelect, companyId, isDisable) {
    $.post(ctx + "dept/tree", {}, function (r) {
        if (r.code === 0) {
            var data = r.msg;
            $('#companyTree').jstree({
                "core": {
                    'data': data.children,
                    'multiple': false // 取消多选

                },
                "state": {
                    "disabled": true
                },
                "checkbox": {
                    "three_state": false // 取消选择父节点后选中所有子节点
                },
                "plugins": ["wholerow", "checkbox"]
            });
            if (isSelect) {
                $('#companyTree').jstree().open_all();
                $('#companyTree').jstree('select_node', companyId, true);
            }
        } else {
            $MB.n_danger(r.msg);
        }
    })
}

function getDept() {
    var ref = $('#companyTree').jstree(true);
    $("[name='categoryCompanyid']").val(ref.get_selected()[0]);
}