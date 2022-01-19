$.loginCheck = function () {
    let param = {
        userId : $('#userId').val(),
        password : $("#password").val()
    };

    $.ajax({
        url: "/loginAction",
        type: "POST",
        data: param,
        success: function (data) {
            console.log(data);
        }
    })
}