var $dishesAddForm = $("#dishes-add-form");
var $categorySelect = $dishesAddForm.find("select[name='categorySelect']");
var $categoryIds = $dishesAddForm.find("input[name='categoryIds']");

$(function () {
    validateRuleDishes();
    getCategorySelect();
    // $("#dishesImage-holder").val("");
    // // 图片上传和预览
    // $("#dishesFileUpload").on('change', function () {
    //     if (typeof (FileReader) != "undefined") {
    //         let image_holder = $("#dishesImage-holder");
    //         image_holder.empty();
    //         let reader = new FileReader();
    //         reader.onload = function (e) {
    //             $("<img />", {
    //                 "src": e.target.result,
    //                 "class": "thumb-image"
    //             }).appendTo(image_holder);
    //
    //         }
    //         image_holder.show();
    //         reader.readAsDataURL($(this)[0].files[0]);
    //     } else {
    //         alert("你的浏览器不支持FileReader.");
    //     }
    // });
    // 菜品规格表格
    let $modeltable = $("#dishesModelTable");

    // 新建保存
    $("#dishes-add-button").click(function () {
        var validator = $dishesAddForm.validate();
        var flag = validator.form();
        if (flag) {
            let dishesModelTableData = $('#dishesModelTable').bootstrapTable('getData');
            let dateForm = {
                "spareCode": $dishesAddForm.find("input[name='spareCode']").val().trim(),
                "spareName": $dishesAddForm.find("input[name='spareName']").val().trim(),
                "spareNameEn": $dishesAddForm.find("input[name='spareNameEn']").val().trim(),
                "spareModel": $dishesAddForm.find("input[name='spareModel']").val().trim(),
                "sparePrice": $dishesAddForm.find("input[name='sparePrice']").val().trim(),
                "spareStatus": "SHELVES",
                "categoryIds": getSelectValue($dishesAddForm.find("select[name='categorySelect']").val()),
                "remark": $dishesAddForm.find("input[name='remark']").val().trim(),
            }
            let modelForm = {
                "dishesModelList":dishesModelTableData,
            }
            $.ajax({
                    url: ctx + "dishes/dishesAdd",
                    async: false,
                    type: "POST",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(dateForm),
                    success: function (data) {
                        if (data.code === 0) {
                            // 保存图片
                            // upload(data.msg);
                            // 新建规格
                            $.ajax({
                                url: ctx + "dishes/dishesModelAdd/"+data.msg,
                                async: false,
                                type: "POST",
                                contentType: 'application/json',
                                dataType: 'json',
                                data: JSON.stringify(modelForm),
                                success: function (data) {
                                    if (data.code === 0) {
                                        closeModal();
                                        $MB.n_success("菜品添加成功");
                                        $MB.refreshTable("dishesTable");
                                    } else $MB.n_danger(data.msg);
                                }
                            });
                        } else $MB.n_danger(data.msg);
                    }
                });
        }

    });
    // 修改保存
    $("#dishes-update-button").click(function () {
        var validator = $dishesAddForm.validate();
        var flag = validator.form();
        if (flag) {
            let dishesModelTableData = $('#dishesModelTable').bootstrapTable('getData');
            let dateForm = {
                "spareId":$dishesAddForm.find("input[name='spareId']").val().trim(),
                "spareCode": $dishesAddForm.find("input[name='spareCode']").val().trim(),
                "spareName": $dishesAddForm.find("input[name='spareName']").val().trim(),
                "spareNameEn": $dishesAddForm.find("input[name='spareNameEn']").val().trim(),
                "spareModel": $dishesAddForm.find("input[name='spareModel']").val().trim(),
                "sparePrice": $dishesAddForm.find("input[name='sparePrice']").val().trim(),
                "spareStatus": "SHELVES",
                "categoryIds": getSelectValue($dishesAddForm.find("select[name='categorySelect']").val()),
                "remark": $dishesAddForm.find("input[name='remark']").val().trim(),
            }
            let modelForm = {
                "dishesModelList":dishesModelTableData,
            }
            $.ajax({
                url: ctx + "dishes/dishesUpdate",
                async: false,
                type: "POST",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(dateForm),
                success: function (data) {
                    if (data.code === 0) {
                        // 保存图片
                        // upload(dateForm.spareId);
                        // 修改规格
                        $.ajax({
                            url: ctx + "dishes/dishesModelUpdate/"+dateForm.spareId,
                            async: false,
                            type: "POST",
                            contentType: 'application/json',
                            dataType: 'json',
                            data: JSON.stringify(modelForm),
                            success: function (data) {
                                if (data.code === 0) {
                                    closeModal();
                                    $MB.n_success("菜品修改成功");
                                    $MB.refreshTable("dishesTable");
                                } else $MB.n_danger(data.msg);
                            }
                        });
                    } else $MB.n_danger(data.msg);
                }
            });
        }

    });
    $("#dishes-add .btn-close").click(function () {
        closeModal();
    });

    // 规格添加按钮
    $("#modelAddBtn").click(function () {
        $modeltable.bootstrapTable('insertRow', {
            index: 0,
            row: {
                dishesModel: '',
                dishesModelEn: '',
                dishesPrice: '',
            }
        });
    })


});

// 关闭模态框
function closeModal() {
    validator.resetForm();
    $categorySelect.multipleSelect('setSelects', []);
    $categorySelect.multipleSelect("refresh");
    $MB.closeAndRestModal("dishes-add");
}

// 规则
function validateRuleDishes() {
    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    validator = $dishesAddForm.validate({
        rules: {
            categoryIds: {
                required: true
            }
        },
        messages: {
            categoryIds: icon + "请选择菜品分类",
        }
    });
}

// 生成菜品分类多选下拉菜单
function getCategorySelect() {
    $.get(ctx + "category/categoryList", {}, function (r) {
        if (r.code === 0) {
            let data = r.msg;
            let option = "";
            for (let i = 0; i < data.length; i++) {
                option += "<option value='" + data[i].categoryId + "'>" + data[i].categoryName + "</option>"
            }
            $categorySelect.html("").append(option);
            let options = {
                selectAllText: '所有菜品分类',
                allSelected: '所有菜品分类',
                width: '100%',
                onClose: function () {
                    $categoryIds.val($categorySelect.val());
                    validator.element("input[name='categoryIds']");
                }
            };
            $categorySelect.multipleSelect(options);
        } else {
            $MB.n_warning(r.msg);
        }

    });
}

// 获取select所选值
function getSelectValue(value) {
    let categoryIds = [];
    value.forEach(function (item) {
        categoryIds.push(item);
    })
    return categoryIds;
}

/**
 * 上传图片
 */
// function upload(dishesId) {
//     if ($("#dishesFileUpload").val() == '') {
//         return;
//     }
//     let formData = new FormData();
//     formData.append('photo', document.getElementById('dishesFileUpload').files[0]);
//     $.ajax({
//         url:ctx + "dishes/dishesFileUpload/"+dishesId,
//         type:"post",
//         data: formData,
//         contentType: false,
//         processData: false,
//         success: function(data) {
//             console.log(data)
//             if (data.code === 0) {
//                 closeModal();
//                 $MB.n_success("菜品修改成功");
//                 $MB.refreshTable("dishesTable");
//             } else $MB.n_danger(data.msg);
//             if (data.type == "success") {
//                 $("#preview_photo").attr("src", data.filepath+data.filename);
//                 $("#productImg").val(data.filename);
//             } else {
//                 alert(data.msg);
//             }
//         }
//     });
// }


