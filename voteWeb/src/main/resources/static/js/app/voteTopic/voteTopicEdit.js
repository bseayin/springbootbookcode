function updateVoteTopic() {
    var selected = $("#VoteTopicTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的投票主题！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个投票主题！');
        return;
    }
    var VoteTopicId = selected[0].id;
    $.post(ctx + "voteTopic/getVoteTopic", {"id": VoteTopicId}, function (r) {
        if (r.code === 0) {
            var $form = $('#VoteTopic-add');

            $form.modal();
            var VoteTopic = r.msg;
            $("#VoteTopic-add-modal-title").html('修改投票主题');
            // 这个地方一定要给主键赋值，否则不能修改成功
            $form.find("input[name='id']").val(VoteTopic.id);
            $form.find("input[name='title']").val(VoteTopic.title);
            $form.find("input[name='status']").val(VoteTopic.status);

            $form.find("input[name='remarks']").val(VoteTopic.remarks);

            $("#VoteTopic-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}