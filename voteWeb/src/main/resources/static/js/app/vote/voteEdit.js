function updateVote() {
    var selected = $("#voteTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的投票项目！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个投票项目！');
        return;
    }
    var voteId = selected[0].id;
    $.post(ctx + "vote/getVote", {"id": voteId}, function (r) {
        if (r.code === 0) {
            var $form = $('#vote-add');

            $form.modal();
            var vote = r.msg;
            $("#vote-add-modal-title").html('修改投票项目');
            // 这个地方一定要给主键赋值，否则不能修改成功
            $form.find("input[name='id']").val(vote.id);
            $form.find("input[name='title']").val(vote.title);
            $form.find("input[name='status']").val(vote.status);

            $form.find("input[name='remarks']").val(vote.remarks);

            $("#vote-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}