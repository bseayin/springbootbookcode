var validator;
var $voteAddForm = $("#vote-add-form");
var $statusSelect = $voteAddForm.find("select[name='status']");

$(function () {
    initStatus();


    $("#vote-add .btn-save").click(function () {
        var name = $(this).attr("name");
        getMenu();
        var validator = $roleAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "role/add", $roleAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("roleTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "role/update", $roleAddForm.serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("roleTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#vote-add .btn-close").click(function () {
        closeModal();
    });

});

function closeModal() {
    $("#vote-add-button").attr("name", "save");
    $("#vote-add-modal-title").html('新增投票');
    validator.resetForm();
    $MB.resetJsTree("menuTree");
    $MB.closeAndRestModal("vote-add");
}

function validateRule() {
    var icon = "<i class='zmdi zmdi-close-circle zmdi-hc-fw'></i> ";
    validator = $roleAddForm.validate({
        rules: {
            roleName: {
                required: true,
                minlength: 3,
                maxlength: 10,
                remote: {
                    url: "role/checkRoleName",
                    type: "get",
                    dataType: "json",
                    data: {
                        roleName: function () {
                            return $("input[name='roleName']").val().trim();
                        },
                        oldRoleName: function () {
                            return $("input[name='oldRoleName']").val().trim();
                        }
                    }
                }
            },
            remark: {
                maxlength: 50
            },
            menuId: {
                required: true
            }
        },
        messages: {
            roleName: {
                required: icon + "请输入投票名称",
                minlength: icon + "投票名称长度3到10个字符",
                remote: icon + "该投票名已经存在"
            },
            remark: icon + "投票描述不能超过50个字符",
            menuId: icon + "请选择相应菜单权限"
        }
    });
}

function createMenuTree() {
    $.post(ctx + "menu/menuButtonTree", {}, function (r) {
        if (r.code === 0) {
            var data = r.msg;
            $('#menuTree').jstree({
                "core": {
                    'data': data.children
                },
                "state": {
                    "disabled": true
                },
                "checkbox": {
                    "three_state": false
                },
                "plugins": ["wholerow", "checkbox"]
            });
        } else {
            $MB.n_danger(r.msg);
        }
    })

}

function getMenu() {
    var $menuTree = $('#menuTree');
    var ref = $menuTree.jstree(true);
    var menuIds = ref.get_checked();
    $menuTree.find(".jstree-undetermined").each(function (i, element) {
        menuIds.push($(element).closest('.jstree-node').attr("id"));
    });
    $("[name='menuId']").val(menuIds);
}


function initStatus() {
    $.post(ctx + "dict/list", {tableName:"fieldName",fieldName:"STATUS"}, function (r) {
        var data = r.rows;
        var option = "";
        for (var i = 0; i < data.length; i++) {
            option += "<option value='" + data[i].keyy + "'>" + data[i].valuee + "</option>"
        }
        $statusSelect.html("").append(option);

    });
}