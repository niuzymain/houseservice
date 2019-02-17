$(function() {
    var type;
    $("#submit").click(function() {
        type = "管理员";
        var username = $("#username").val();
        var password = $("#password").val();
        var superadmin = {
            "accountname":username,
            "password":password,
        };
        // 这里添加判断验证码是否为空
        var formdata = new FormData();
        formdata.append("loginstr",JSON.stringify(superadmin));
        formdata.append("type",type)
        $.ajax({
            url:"/common/checklogin",
            type:"post",
            data:formdata,
            contentType: false,
            processData: false,
            cache: false,
            success:function(data){
                if(data.success){
                    window.location.href="/admin/main";
                }
                else{
                    alert(data.errormsg);
                }
            }
        })
    })
})