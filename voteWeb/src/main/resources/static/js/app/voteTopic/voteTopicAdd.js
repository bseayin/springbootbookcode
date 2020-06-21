
$(function () {
    var $voteAddForm = $("#voteTopic-add-form");


    $("#voteTopic-add .btn-save").click(function () {
     var name = $(this).attr("name");
     console.log("click save button "+name);

            var flag=true;
            if (flag) {
                if (name === "save") {
                    $.post(ctx + "voteTopic/add", $voteAddForm.serialize(), function (r) {
                        if (r.code === 0) {
                            closeModal();
                            $MB.n_success(r.msg);
                            $MB.refreshTable("voteTable");
                        } else $MB.n_danger(r.msg);
                    });
                }
                if (name === "update") {
                    $.post(ctx + "voteTopic/update", $voteAddForm.serialize(), function (r) {
                        if (r.code === 0) {
                            closeModal();
                            $MB.n_success(r.msg);
                            $MB.refreshTable("voteTable");
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




