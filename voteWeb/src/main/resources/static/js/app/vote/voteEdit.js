function updatevoteTopic() {
    var selected = $("#voteTopicTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的投票项目！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个投票项目！');
        return;
    }
    var voteTopicId = selected[0].id;
    $.post(ctx + "voteTopic/getvoteTopic", {"id": voteTopicId}, function (r) {
        if (r.code === 0) {
            var $form = $('#voteTopic-add');

            $form.modal();
            var voteTopic = r.msg;
            $("#voteTopic-add-modal-title").html('修改投票项目');
            // 这个地方一定要给主键赋值，否则不能修改成功
            $form.find("input[name='id']").val(voteTopic.id);
            $form.find("input[name='title']").val(voteTopic.title);
            $form.find("input[name='status']").val(voteTopic.status);

            $form.find("input[name='remarks']").val(voteTopic.remarks);

            $("#voteTopic-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}