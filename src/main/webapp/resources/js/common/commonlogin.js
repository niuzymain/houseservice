$(function () {
    $("#submit").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        var checkcode = $("#checkcode").val();
        var type = $('input:radio[name="type"]:checked').val();
        var formdata = new FormData();
        if (!username) {
            alert("请输入用户名")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        if (!password) {
            alert("请输入密码")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        if (!checkcode) {
            alert("请输入验证码")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        formdata.append("type", type)
        formdata.append("checkcode", checkcode)
        var account = {
            accountname: username,
            password: password
        }
        formdata.append("loginstr",JSON.stringify(account))
        $.ajax({
            url: "/common/checklogin",
            type: "post",
            data: formdata,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("success 后端返回跳转界面")
                }
                else {
                    alert(data.errormsg);
                    changecode(document.getElementById("checkcodeimg"))
                }
            }
        })
    })
})