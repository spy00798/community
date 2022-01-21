/**
 * FUNCTION:: ID입력칸에 입력한 데이터를 변경 시 ID 중복체크 값 초기화
 */
$.removeIdCheck = function () {
    $("#userId").attr('idCheck', "");
}

/**
 * FUNCTION:: 로그인 체크
 */
$.loginCheck = function () {
    let param = {
        userId : $('#userId').val(),
        password : $("#userPw").val()
    };

    $.ajax({
        url: "/loginAction",
        type: "POST",
        data: param,
        success: function (data) {
            console.log(data);
            if (data == "success") {
                location.replace("/list");
            } else if(data == "failed") {
                alert("비밀번호를 확인해주세요");
                return;
            } else {
                alert("존재하지 않는 아이디입니다");
                return;
            }
        }
    })
}

/**
 * FUNCTION:: ID 중복체크
 */
$.idDuplicateCheck = function () {
     
    let param = {
        userId : $('#userId').val()
    };

    if($('#userId').val().trim() == "") {
        alert("아이디를 먼저 입력해주세요.");
        return;
    }
    $.ajax({
        url: "/idCheckAction",
        type: "POST",
        data: param,
        success: function (data) {
            if (data == "duplicated") {
                alert("이미 사용 중인 아이디입니다.");
                $('#userId').attr('idCheck', 'N'); // LINE:: ID 중복체크 속성 값을 N으로 변경
                $('#userId').focus();
            } else {
                alert("사용 가능한 아이디입니다.")
                $('#userId').attr('idCheck', 'Y'); // LINE:: ID 중복체크 속성 값을 Y로 변경
            }
        }
    })
}

/**
 * FUNCTION:: 공백입력 막기
 */
$.spaceBar = function () {
    let keyCode = event.keyCode;
    if (keyCode == 32)
        event.returnValue = false;
}

/**
 * FUNCTION:: 회원가입 처리
 */
$.createUser = function () {
    let param = {
        userId: $('#userId').val(),
        password: $('#userPw').val(),
        userName: $('#userNm').val()
    };

    // 유효성 검사
    if($('#userId').val().trim() == "") {
        alert("아이디가 입력되지 않았습니다.");
        return;
    } else if ($('#userPw').val().trim() == "") {
        alert("패스워드가 입력되지 않았습니다.");
        return;
    } else if ($('#userId').attr('idCheck') == "" || $('#userId').attr('idCheck') == "N") {
        alert("아이디 중복확인을 하지 않았습니다.");
        return;
    } else {
        $.ajax({
            url:"/joinAction",
            type: "POST",
            data: param,
            success: function (data) {
                if(data == "success") {
                    alert("가입완료");
                    location.replace("/login");
                }
            },
            error: function () {
                alert("통신 실패");
            }

        });
    }


}



