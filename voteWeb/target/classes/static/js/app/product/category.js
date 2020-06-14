$(function () {


    var $categoryTableForm = $(".category-table-form");

    function AddFunctionCategory() {
        return [
            '<button id="categoryUpdate" type="button" class="btn btn-outline-warning btn-sm" shiro:hasPermission="category:update">修改</button> &nbsp&nbsp&nbsp',
            '<button id="categoryDelete" type="button" class="btn btn-outline-danger btn-sm" shiro:hasPermission="category:delete">删除</button>'
        ].join("")
    }

    window.operateEvents = {
        "click #categoryUpdate": function (e, value, row, index) {
            createCompanyTree(true, row.categoryCompanyid);
            getCategoryOne(row.categoryId, '修改菜单分类');
        },
        "click #categoryDelete": function (e, value, row, index) {
            deleteCategory(row.categoryId);
        }
    };
    var settings = {
        method: 'get',
        url: ctx + "category/categoryListPage",
        pageSize: 10,
        //传递参数（*）
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                categoryName: $categoryTableForm.find("input[name='categoryNameSearch']").val().trim(),
                categoryNameEn: $categoryTableForm.find("input[name='categoryNameEnSearch']").val().trim(),
                categoryCreateTime: $categoryTableForm.find("input[name='categoryFieldSearch']").val().trim(),
            };
        },
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        columns: [{
            field: 'categoryId',
            visible: false
        }, {
            field: 'categoryName',
            title: '菜品分类名称'
        }, {
            field: 'categoryNameEn',
            title: '菜品分类英文名称'
        }, {
            field: 'categoryCompanyid',
            title: '所属店铺',
            visible: false
        }, {
            field: 'createtime',
            title: '创建时间'
        }, {
            field: 'Button',
            title: '操作',
            events: operateEvents,// 给按钮注册事件
            formatter: AddFunctionCategory,//在表格中添加按钮
        }

        ]
    };


    $MB.initTable('categoryTable', settings);
    // 选择创建日期
    $MB.calenders('input[name="categoryFieldSearch"]', true, false);

    // 新建
    $("#addCategory").click(function () {
        // 打开模态框和树
        let $form = $('#category-add');
        $form.modal();
        createCompanyTree(false, 1);
        $("#category-add-modal-title").html('新增菜品分类');
        $("#category-add-button").show();
        $("#category-update-button").hide();
        // 关闭显示
        $form.find("div[name='createmandiv']").hide();
        $form.find("div[name='createtimediv']").hide();
        $form.find("div[name='updatemandiv']").hide();
        $form.find("div[name='updatetimediv']").hide();
    })
});


function search() {
    $MB.refreshTable('categoryTable');
}

function refresh() {
    $(".category-table-form")[0].reset();
    $MB.refreshTable('categoryTable');
}

// 删除菜品分类
function deleteCategory(categoryId) {
    $MB.confirm({
        text: "确定删除选中菜品分类？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'category/categoryDelete/' + categoryId, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

// 修改显示菜品父类详细（父类id，标题）
function getCategoryOne(categoryId, title) {
    $.get(ctx + "category/getCategory/" + categoryId, function (r) {
        if (r.code === 0) {
            // 打开模态框和树
            let $form = $('#category-add');
            // let $companyTree = $('#companyTree');
            $form.modal();
            let category = r.msg;
            $("#category-add-button").hide();
            $("#category-update-button").show();
            // 自动勾所属店铺
            // $companyTree.jstree().open_all();
            // $companyTree.jstree('select_node', category.categoryCompanyid, true);
            // 动态添加标题
            $("#category-add-modal-title").html(title);
            // 赋值
            $form.find("input[name='categoryName']").val(category.categoryName);
            $form.find("input[name='categoryNameEn']").val(category.categoryNameEn);
            $form.find("input[name='categoryCompanyid']").val(category.categoryCompanyid);
            $form.find("input[name='categoryId']").val(category.categoryId);
            $form.find("input[name='createman']").val(category.createman);
            $form.find("input[name='createtime']").val(category.createtime);
            $form.find("input[name='updateman']").val(category.updateman);
            $form.find("input[name='updatetime']").val(category.updatetime);
            // 显示
            $form.find("div[name='createmandiv']").show();
            $form.find("div[name='createtimediv']").show();
            $form.find("div[name='updatemandiv']").show();
            $form.find("div[name='updatetimediv']").show();
        } else {
            $MB.n_danger(r.msg);
        }
    });
}
