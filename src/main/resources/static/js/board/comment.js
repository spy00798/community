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
    console.log(index);

    $("#comment-area > ul > li").has('.up_btn').eq(index).find('pre').replaceWith("<textarea style='margin-left: 40px; width: 520px; min-height: 50px; word-break: break-all; white-space: normal; resize: none; margin-top: 20px;' class='mod_comment'>" + $("#comment-area > ul > li").has('.up_btn').eq(index).find('.comment').text() + "</textarea>");
    $("#comment-area > ul > li").has('.up_btn').eq(index).find('.del_btn').replaceWith('<input type="button" value="취소" class="del_btn" style="float: right; margin: 0 10px;" onclick="$.commentUpdateCancel(' + index + ') ">')
    $("#comment-area > ul > li").has('.up_btn').eq(index).find('.up_btn').replaceWith('<input type="button" value="완료" class="up_btn" style="float: right;" onclick="$.commentUpdate(' + index + ')">')
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



$.commentUpdateCancel = function (i) {
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('textarea').replaceWith("<pre style='padding-left: 40px; width: 530px; min-height: 50px; word-break: break-all; white-space: normal;' class='comment'>" + $('.mod_comment').val() + "</pre>");
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.up_btn').replaceWith('<input type="button" value="수정" class="up_btn" style="float: right;" onclick="$.commentUpdateForm(this)">');
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.del_btn').replaceWith('<input type="button" value="삭제" class="del_btn" style="float: right; margin: 0 10px;" onclick="$.commentDelete()">')
    $("#comment-area > ul > li").has('.up_btn').eq(i).find('.re_btn').css({"display": "block"})
    $("#comment-area > ul li").has('.up_btn').not(":eq(" + i + ")").children('.btn_area').css({"display": "block"});
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

$(document).ready(function () {
    let param = {
        boardIdx: $('#idx').val()
    };

    $.ajax({

    })
})