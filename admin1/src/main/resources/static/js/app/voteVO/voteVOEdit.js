function updatevoteVO() {
    var selected = $("#voteVOTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的投票主题！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个投票主题！');
        return;
    }
    var voteVOId = selected[0].id;
    $.post(ctx + "voteVO/getvoteVO", {"id": voteVOId}, function (r) {
        if (r.code === 0) {
            var $form = $('#voteVO-add');

            $form.modal();
            var voteVO = r.msg;
            $("#voteVO-add-modal-title").html('修改投票主题');
            // 这个地方一定要给主键赋值，否则不能修改成功
            $form.find("input[name='id']").val(voteVO.id);
            $form.find("input[name='title']").val(voteVO.title);
            $form.find("input[name='kinds']").val(voteVO.kinds);
            $form.find("input[name='kinds']").val(voteVO.kinds);
            $form.find("input[name='voteid']").val(voteVO.voteid);
            $("#voteVO-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}