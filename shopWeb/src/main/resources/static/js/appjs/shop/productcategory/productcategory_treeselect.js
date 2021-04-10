var prefix = "/shop/category"
$(function () {
    getMenuTreeData();
});
function loadMenuTree(menuTree) {
    $('#menuTree').jstree({
        "plugins" : [ "wholerow", "checkbox" ],
        'core' : {
            'data' : menuTree
        },
        "checkbox" : {
            //"keep_selected_style" : false,
            //"undetermined" : true
            //"three_state" : false,
            //"cascade" : ' up'
        }
    });
    $('#menuTree').jstree('open_all');
}
function getAllSelectNodes() {
    var ref = $('#menuTree').jstree(true); // 获得整个树
    tempcategorysIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组
    categorysIds=[];
    for(let id of tempcategorysIds){
        if(ref.is_leaf(id)){
            let t=ref.get_node(id);
            categorysIds.push({id:t.id,name:t.text});
        }
    }
    parent.getCategorys(categorysIds);
    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.layer.close(index);
}
function getMenuTreeData() {
    var productId = $('#productId').val();
    $.ajax({
        type : "GET",
        url : "/shop/productInCategory/tree/" + productId,
        success : function(data) {
            loadMenuTree(data);
        }
    });
}