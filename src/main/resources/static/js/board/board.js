/**
 * FUNCTION:: 게시글 생성처리
  */

$.boardCreate = function() {
    let form = $("#createForm")[0];
    let data = new FormData(form);

    data.append('title', $('#title').val());
    data.append('content', $("#content").val());

    if ( $('#title').val().trim() == "") {
        alert("제목을 입렧해주세요");
        return;
    } else if ($('#content').val().trim() == "") {
        alert("내용을 입력해주세요");
        return;
    } else {
        $.ajax({
            url : "/createAction",
            type : "POST",
            data : data,
            processData: false,
            contentType: false,
            cache:false,
            success : function (data) {
                if (data == "success"){
                    alert("등록 완료");
                    location.replace("/list");
                } else if (data == "database error") {
                    alert("글을 저장하는 도중 오류가 발생하였습니다.");
                    return;
                }
            },
            error : function () {
                alert("통신 실패");
            }
        })
    }


}

$.boardUpdate = function() {
    let updateForm = $("#updateForm")[0];
    let data = new FormData(updateForm);

    data.append("id", $("#idx").val());
    data.append("title", $("#title").val());
    data.append("content", $("#content").val());

    if ($('#title').val().trim() == "") {
        alert("제목을 입력해주세요");
        return;
    } else if ($('#content').val().trim() == "") {
        alert("내용을 입력해주세요");
        return;
    } else {
        $.ajax({
            url: "/updateAction",
            type: "PUT",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            success: function (data) {
                if (data == "success") {
                    alert("수정 완료");
                    location.replace("/list");
                } else {
                    alert("수정 실패")
                    return;
                }
            },
            error: function () {
                alert("통신 실패")
            }
        });

    }
}

$.boardDelete = function () {
    let param = {
        id: $('#idx').val()
    };

   let del_yn =  confirm("삭제하시겠습니까?");

    if (del_yn == true) {
        $.ajax({
            url: "/deleteAction",
            type: "DELETE",
            data: param,
            success: function (data) {
                if (data == "success") {
                    alert("삭제 완료");
                    location.replace("/list");
                } else {
                    alert("삭제 실패")
                }
            }, error: function () {
                alert("통신실패")
            }
        })    
    }
}