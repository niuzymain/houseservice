$(function () {
////////////////////////////提交事件///////////////////////////////////////////
    $("#submit").click(function () {
        var user = {
            accountname: $(".account .accountname").val(),
            password: $(".account .password").val()
        }
        var formdata = new FormData();
        formdata.append("register", JSON.stringify(user))
        $.ajax({
            url: "/user/adduser",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success:function(data){
                if(data.success){
                    alert("success")
                    window.location.href="/login/user"
                }
                else{
                    alert(data.errormsg)
                }
            }
        })
    })
})
