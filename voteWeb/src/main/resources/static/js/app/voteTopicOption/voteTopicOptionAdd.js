
$(function () {
    var $voteTopicOptionAddForm = $("#voteTopicOption-add-form");
    createVoteTopicTree();

    $("#voteTopicOption-add .btn-save").click(function () {
     var name = $(this).attr("name");
     console.log("click save button "+name);
            getVoteTopic();
            var flag=true;
            if (flag) {
                if (name === "save") {
                    $.post(ctx + "voteTopicOption/add", $voteTopicOptionAddForm.serialize(), function (r) {
                        if (r.code === 0) {
                            closeModal();
                            $MB.n_success(r.msg);
                            $MB.refreshTable("voteTopicOptionTable");
                        } else $MB.n_danger(r.msg);
                    });
                }
                if (name === "update") {
                    $.post(ctx + "voteTopicOption/update", $voteTopicOptionAddForm.serialize(), function (r) {
                        if (r.code === 0) {
                            closeModal();
                            $MB.n_success(r.msg);
                            $MB.refreshTable("voteTopicOptionTable");
                        } else $MB.n_danger(r.msg);
                    });
                }
            }
        });

    $("#voteTopicOption-add .btn-close").click(function () {
        console.log("click close button ");
          $("#voteTopicOption-add-button").attr("name", "save");
        closeModal();
    });

    function closeModal() {

        $MB.closeAndRestModal("voteTopicOption-add");
    }

});


function createVoteTopicTree() {

    $.post(ctx + "voteTopic/voteTopicButtonTree", {}, function (r) {
     console.log(r);
        if (r.code === 0) {
            var data = r.msg;
            $('#voteTopicTree').jstree({
                "core": {
                    'data': data.children,
                    // 单选
                     'multiple': false

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

function getVoteTopic() {
    var $voteTree = $('#voteTopicTree');
    var ref = $voteTree.jstree(true);
    var voteIds = ref.get_checked();
    $voteTree.find(".jstree-undetermined").each(function (i, element) {
        voteIds.push($(element).closest('.jstree-node').attr("id"));
    });
    $("[name='topicid']").val(voteIds);
}




