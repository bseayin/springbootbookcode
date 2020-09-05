
$(function () {
    var $voteTopicAddForm = $("#voteTopic-add-form");
    createVoteTree();

    $("#voteTopic-add .btn-save").click(function () {
     var name = $(this).attr("name");
     console.log("click save button "+name);
            getVote();
            var flag=true;
            if (flag) {
                if (name === "save") {
                    $.post(ctx + "voteTopic/add", $voteTopicAddForm.serialize(), function (r) {
                        if (r.code === 0) {
                            closeModal();
                            $MB.n_success(r.msg);
                            $MB.refreshTable("voteTopicTable");
                        } else $MB.n_danger(r.msg);
                    });
                }
                if (name === "update") {
                    $.post(ctx + "voteTopic/update", $voteTopicAddForm.serialize(), function (r) {
                        if (r.code === 0) {
                            closeModal();
                            $MB.n_success(r.msg);
                            $MB.refreshTable("voteTopicTable");
                        } else $MB.n_danger(r.msg);
                    });
                }
            }
        });

    $("#voteTopic-add .btn-close").click(function () {
        console.log("click close button ");
          $("#voteTopic-add-button").attr("name", "save");
        closeModal();
    });

    function closeModal() {

        $MB.closeAndRestModal("voteTopic-add");
    }

});


function createVoteTree() {
 console.log("click createVoteTree ");
    $.post(ctx + "vote/voteButtonTree", {}, function (r) {
     console.log(r);
        if (r.code === 0) {
            var data = r.msg;
            $('#voteTree').jstree({
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

function getVote() {
    var $voteTree = $('#voteTree');
    var ref = $voteTree.jstree(true);
    var voteIds = ref.get_checked();
    $voteTree.find(".jstree-undetermined").each(function (i, element) {
        voteIds.push($(element).closest('.jstree-node').attr("id"));
    });
    $("[name='voteid']").val(voteIds);
}




