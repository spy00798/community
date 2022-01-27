$(document).ready(function () {
    let param = {
        boardIdx: $('#idx').val()
    };

    $.ajax({
        url: "/commentList",
        type: "POST",
        data: param,
        success: function (data) {
            [].forEach.call(data, item => {
                let formatDate = new Date(item.commentDate);
                console.log(item);
                let str = ' <li class="comment">' +
                    '                    <p>' +
                    '                        <input type="hidden" class="comment_idx" value="'+ item.idx +'">' +
                    '                        <span class="comment_writer">'+ item.writer +'</span>' +
                    '                        <span class="comment_date">'+ formatDate.getUTCFullYear() + "-" + ('0' +(formatDate.getUTCMonth() + 1)).slice(-2) + "-" + ('0' + formatDate.getUTCDate()).slice(-2) + "&nbsp;" + ('0' + formatDate.getUTCHours()).slice(-2) + ":" + ('0' + formatDate.getUTCMinutes()).slice(-2) + ":" + ('0' + formatDate.getUTCSeconds()).slice(-2) +'</span>' +
                    '                    </p>' +
                    '                    <pre class="comment_text">'+ item.comment +'</pre>' +
                    // '                    <c:if test="${sessionScope.user != null}">' +
                    '                        <div style="width: 100%; height: 30px;" class="btn_area">' +
                    // '                            <c:if test="${comment.userId == sessionScope.user.userId}">' +
                    '                                <input type="button" value="삭제" class="del_btn" style="float: right; margin: 0 10px;"' +
                    '                                       onclick="$.commentDelete(this)">' +
                    '                                <input type="button" value="수정" class="up_btn"' +
                    '                                       onclick="$.commentUpdateForm(this)">' +
                    // '                            </c:if>' +
                    '                            <input type="button" value="답글" class="re_btn" style="float: right;margin-right: 10px;"' +
                    '                                   onclick="$.replyForm(this)">' +
                    '                        </div>' +
                    // '                    </c:if>' +
                    '                    <div class="reply-form">' +
                    '                        <p><span style="margin: 20px;">'+ item.writer +' 님께 답글 작성</span></p>' +
                    '                        <textarea class="reply"></textarea>' +
                    '                        <div class="btn_area">' +
                    '                            <input type="button" value="취소" class="cl_btn" onclick="$.replyClose(this)">' +
                    '                            <input type="button" value="완료" class="cr_btn" onclick="$.replyCreate(this)">' +
                    '                        </div>' +
                    '                    </div>' +
                    '                </li>'

                $("#comment-area > ul").append(str);
            })
        },error() {
            alert("통신실패");
        }
    })
});

$.commentCreate = function () {
    let form = $('#commentForm')[0];
    let data = new FormData(form);

    data.append('comment', $('#comment').val());
    data.append('boardIdx', $('#idx').val());

    $.ajax({
        url: "/commentCreateAction",
        type: "POST",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            location.reload();
        },
        error: function () {
            alert("통신실패");
        }
    })
}

$.commentUpdateForm = function (e) {
    let index = $('.up_btn').index(e);
    let orgText = $("#comment-area > ul > li").has('.up_btn').eq(index).find('.comment_text').text()
    console.log(index);

    $("#comment-area > ul > li").has('.up_btn').eq(index).find('.comment_text').replaceWith("<textarea class='mod_comment'>" + orgText + "</textarea>");
    $("#comment-area > ul > li").has('.up_btn').eq(index).find('.del_btn').replaceWith('<input type="button" value="취소" class="del_btn" onclick="$.commentUpdateCancel(' + index + ',' + '`' + orgText + '`) ">')
    $("#comment-area > ul > li").has('.up_btn').eq(index).find('.up_btn').replaceWith('<input type="button" value="완료" class="up_btn" onclick="$.commentUpdate(' + index + ')">')
    $("#comment-area > ul > li").has('.up_btn').eq(index).find('.re_btn').css({"display": "none"})
    $("#comment-area > ul li").has('.up_btn').not(":eq(" + index + ")").children('.btn_area').css({"display": "none"});

}

$.commentUpdate = function (i) {
    let param = {
        idx: $("#comment-area > ul > li").has('.up_btn').eq(i).find('.comment_idx').val(),
        comment: $('.mod_comment').val()
    };

    $.ajax({
        url: "/commentUpdateAction",
        type: "POST",
        data: param,
        success: function () {
            location.reload();
        },
        error: function () {
            alert("통신 실패");
        }
    })
}



$.commentUpdateCancel = function (i, text) {

    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.mod_comment').replaceWith("<pre class='comment_text'>" + text + "</pre>");
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.up_btn').replaceWith('<input type="button" value="수정" class="up_btn" onclick="$.commentUpdateForm(this)">');
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.del_btn').replaceWith('<input type="button" value="삭제" class="del_btn" onclick="$.commentDelete()">')
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.re_btn').css({"display": "block"})
    $("#comment-area > ul li").has('.up_btn').not(":eq(" + i + ")").children('.btn_area').css({"display": "block"});

    $(".mod_comment").empty();
}

$.commentDelete = function (e) {
    let index = $('.del_btn').index(e);
    let del_yn = confirm("댓글을 삭제하시겠습니까?");

    if (del_yn == true) {
        let param = {
            idx: $("#comment-area > ul > li").has('.del_btn').eq(index).find('.comment_idx').val()
        };
        console.log(param.idx);


        $.ajax({
            url: "/commentDeleteAction",
            type: "POST",
            data: param,
            success: function (data) {
                alert("삭제완료");
                location.reload();
            },
            error: function () {
                alert("통신실패")
            }
        });
    }
}
