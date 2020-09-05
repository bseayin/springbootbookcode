var $dishesTableForm = $(".dishes-table-form");
$(function () {
    createCategorySelect();

    // 生成table中每行的button
    function AddFunctionDishes() {
        return [
            '<button id="dishesUpdateBtn" type="button" class="btn btn-outline-warning btn-sm" shiro:hasPermission="dishes:update">修改</button> &nbsp&nbsp&nbsp',
            '<button id="dishesUploadBtn" type="button" class="btn btn-outline-primary btn-sm" shiro:hasPermission="dishes:file">上传图片</button>'
        ].join("")
    }

    // button的点击事件
    window.operateEvents = {
        "click #dishesUpdateBtn": function (e, value, row, index) {
            $("#dishes-add-modal-title").html('修改菜品信息');
            getDishesOne(row.spareId);
        },
        "click #dishesUploadBtn": function (e, value, row, index) {
            // 打开模态框
            let $form = $('#dishesUpload');
            $form.modal();
            $("#uploadSpareId").val(row.spareId);
        },
    };

    // 生成菜品table
    var settings = {
        method: 'get',
        url: ctx + "dishes/dishesList",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                spareName: $dishesTableForm.find("input[name='spareNameSearch']").val().trim(),
                spareNameEn: $dishesTableForm.find("input[name='spareNameEnSearch']").val().trim(),
                categoryId: $dishesTableForm.find("select[name='categoryIdSearch']").val(),
                spareStatus: $dishesTableForm.find("select[name='spareStatusSearch']").val(),
                dishesCreateTime: $dishesTableForm.find("input[name='dishesFieldSearch']").val().trim(),
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'spareId',
            visible: false
        }, {
            field: 'spareCode',
            title: '菜品编号'
        }, {
            field: 'spareName',
            title: '菜品名'
        }, {
            field: 'spareNameEn',
            title: '菜品英文名'
        }, {
            field: 'photoPath',
            title: '菜品图片',
            formatter: function (value, row, index) {
                return '<img  src=' + value + ' width="100" height="100" class="img-rounded" >';
            }
        }, {
            field: 'sparePrice',
            title: '单价'
        }, {
            field: 'spareStatus',
            title: '菜品状态',
            formatter: function (value, row, index) {
                if (value === 'SHELVES') return '<span class="badge badge-success">已上架</span>';
                if (value === 'UNSHELVES') return '<span class="badge badge-warning">已下架</span>';
                if (value === 'SELLOUT') return '<span class="badge badge-danger">已售罄</span>';
            }
        }, {
            field: 'Button',
            title: '操作',
            events: operateEvents,// 给按钮注册事件
            formatter: AddFunctionDishes,//在表格中添加按钮
        }

        ]
    };

    $MB.initTable('dishesTable', settings);
    // 选择创建日期
    $MB.calenders('input[name="dishesFieldSearch"]', true, false);
    // 新建菜品
    $("#dishesAddBtn").click(function () {
        // 打开模态框和树
        let $form = $('#dishes-add');
        $form.modal();
        let modelDate = [];
        getCategorySelect();
        // createCompanyTree(false, 1);
        createDishesModelTable("dishesModelTable", modelDate);
        $("#dishes-add-modal-title").html('新增菜品信息');
        $("#dishes-add-button").show();
        $("#dishes-update-button").hide();
        // 关闭显示
        $form.find("div[name='createmandiv']").hide();
        $form.find("div[name='createtimediv']").hide();
        $form.find("div[name='updatemandiv']").hide();
        $form.find("div[name='updatetimediv']").hide();
        $form.find("div[name='spareStatusDiv']").hide()
    })

    $("#dishesImage-holder").val("");
    // 图片上传和预览
    $("#dishesFileUpload").on('change', function () {
        if (typeof (FileReader) != "undefined") {
            let image_holder = $("#dishesImage-holder");
            image_holder.empty();
            let reader = new FileReader();
            reader.onload = function (e) {
                $("<img />", {
                    "src": e.target.result,
                    "class": "thumb-image"
                }).appendTo(image_holder);

            }
            image_holder.show();
            reader.readAsDataURL($(this)[0].files[0]);
        } else {
            alert("你的浏览器不支持FileReader.");
        }
    });
    // 上传
    $("#dishes-upload-button").click(function () {
        upload($("#uploadSpareId").val());
    });
});

function search() {
    $MB.refreshTable('dishesTable');
}

function refresh() {
    $(".dishes-table-form")[0].reset();
    $MB.refreshTable('dishesTable');
}

function deleteDishes() {
    var selected = $("#dishesTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要下架的菜品！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].spareId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定下架选中的菜品？",
        confirmButtonText: "确定下架"
    }, function () {
        $.post(ctx + 'dishes/dishesDelete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}


// 动态加载下拉框
function createCategorySelect() {
    $.get(ctx + "category/categoryList", {}, function (r) {
        if (r.code === 0) {
            $("#categoryIdSearch").append("<option value='' selected>所有</option>");//添加第一个option值
            for (let i = 0; i < r.msg.length; i++) {
                $("#categoryIdSearch").append("<option value='" + r.msg[i].categoryId + "'>" + r.msg[i].categoryName + "</option>");
            }
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

// 修改显示菜品详细（菜品id）
function getDishesOne(dishesId) {
    $.get(ctx + "dishes/getDishes/" + dishesId, function (r) {
        if (r.code === 0) {
            // 打开模态框
            let $form = $('#dishes-add');
            $form.modal();
            let dishes = r.msg;
            $("#dishes-add-button").hide();
            $("#dishes-update-button").show();
            // 赋值
            $form.find("input[name='spareId']").val(dishesId);
            $form.find("input[name='spareCode']").val(dishes.spareCode);
            $form.find("input[name='spareName']").val(dishes.spareName);
            $form.find("input[name='spareNameEn']").val(dishes.spareNameEn);
            $form.find("input[name='spareModel']").val(dishes.spareModel);
            $form.find("input[name='sparePrice']").val(dishes.sparePrice);
            $form.find("input[name='remark']").val(dishes.remark);
            $form.find("input[name='createman']").val(dishes.spareCreateman);
            $form.find("input[name='createtime']").val(dishes.spareCreatetime);
            $form.find("input[name='updateman']").val(dishes.spareUpdateman);
            $form.find("input[name='updatetime']").val(dishes.spareUpdatetime);
            $("#spareStatus option[value='" + dishes.spareStatus + "']").prop("selected", true);
            // 显示
            $form.find("div[name='createmandiv']").show();
            $form.find("div[name='createtimediv']").show();
            $form.find("div[name='updatemandiv']").show();
            $form.find("div[name='updatetimediv']").show();
            $form.find("div[name='spareStatusDiv']").show()
        } else {
            $MB.n_danger(r.msg);
        }
    });
    // 获取菜品父类
    $.ajax({
        url: ctx + "category/categoryListByDishes/" + dishesId,
        async: false,
        type: "get",
        contentType: 'application/json',
        dataType: 'json',
        success: function (category) {
            if (category.code === 0) {
                let $form = $('#dishes-add');
                let categoryArr = [];
                for (let i = 0; i < category.msg.length; i++) {
                    categoryArr.push(category.msg[i].categoryId);
                }
                console.log(categoryArr)
                // 自动勾菜品父类
                $form.find("select[name='categorySelect']").multipleSelect('setSelects', categoryArr);
                $form.find("input[name='categoryIds']").val($form.find("select[name='categorySelect']").val());
            } else {
                $MB.n_danger(category.msg);
            }
        }
    }, 10);
    // 获取菜品规格
    $.get(ctx + "dishes/dishesModelListPage/" + dishesId, function (model) {
        createDishesModelTable("dishesModelTable", model.rows);
        $('#dishesModelTable').bootstrapTable('load', model.rows);
    });
}

// 动态加载菜品规格表
function createDishesModelTable(id, modelData) {
    function AddFunctionDishesModel() {
        return [
            '<button id="ModelDelete" type="button" class="btn btn-outline-danger btn-sm" shiro:hasPermission="dishes:delete">删除</button>',
        ].join("")
    }

    window.modelEvents = {
        "click #ModelDelete": function (e, value, row, index) {
            row.deleteFlag = "true";
            // 删除选定的行
            $('#' + id).bootstrapTable('remove', {field: "deleteFlag", values: ["true"]});
        },
    };
    $('#' + id).bootstrapTable({
        toolbar: '#toolbar',
        row: modelData,
        pageSize: 3,
        clickEdit: true,
        pagination: true,       //显示分页条
        columns: [{
            field: 'dishesModel',
            title: '商品规格名称'
        }, {
            field: 'dishesModelEn',
            title: '英文名称'
        }, {
            field: 'dishesPrice',
            title: '单价'
        }, {
            field: 'Button',
            title: '操作',
            align: 'center',
            events: modelEvents,// 给按钮注册事件
            formatter: AddFunctionDishesModel,//在表格中添加按钮
        }, {
            field: 'deleteFlag',
            visible: false
        }],
        /**
         * @param {点击列的 field 名称} field
         * @param {点击列的 value 值} value
         * @param {点击列的整行数据} row
         * @param {td 元素} $element
         */
        onClickCell: function (field, value, row, $element) {
            $element.attr('contenteditable', true);
            $element.blur(function () {
                let index = $element.parent().data('index');
                let tdValue = $element.html();
                $('#' + id).bootstrapTable('updateCell', {
                    index: index,       //行索引
                    field: field,       //列名
                    value: tdValue        //cell值
                })
            })
        }
    });

}

/**
 * 上传图片
 */
function upload(dishesId) {
    if ($("#dishesFileUpload").val() == '') {
        return;
    }
    let formData = new FormData();
    formData.append('photo', document.getElementById('dishesFileUpload').files[0]);
    $.ajax({
        url:ctx + "dishes/dishesFileUpload/"+dishesId,
        type:"post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(data) {
            if (data.code === 0) {
                $("#dishes-upload-closeButton").click();
                $MB.n_success("上传图片成功");
                $MB.refreshTable("dishesTable");
            } else $MB.n_danger(data.msg);
        }
    });
}


