$.replyForm = function (e) {
    let index = $('.re_btn').index(e);
    console.log(index);
    $('.reply-form:eq('+ index +')').slideToggle(0);
}

$.replyClose = function (e) {
    let index = $('.cl_btn').index(e);

    $('.reply-form:eq('+ index +')').slideUp(0);
    $('.reply:eq('+ index +')').empty();
}

$.replyCreate = function (e) {
    let index = $('.cr_btn').index(e);

    let param = {
        commentGroup: $('.reply-form:eq('+ index +')').parent().find('.comment_idx').val(),
        boardIdx: $('#idx').val(),
        commentIdx: $('.comment_idx:eq('+ index +')').val(),
        content: $('.reply:eq('+ index +')').val()
    }

    console.log(JSON.stringify(param));

    $.ajax({
        url: "/replyCreateAction",
        type:"POST",
        data:param,
        success: function (data) {
            location.reload();
        },
        error: function () {
            alert("통신실패");
        }
    })
}