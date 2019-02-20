$(function() {
    var type;
    $("#submit").click(function() {
        type = "admin";
        var username = $("#username").val();
        var password = $("#password").val();
        var checkcode = $("#checkcode").val();
        if(!username){
            alert("请输入用户名")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        if(!password){
            alert("请输入密码")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        if(!checkcode){
            alert("请输入验证码")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        var superadmin = {
            "accountname":username,
            "password":password,
        };
        // 这里添加判断验证码是否为空
        var formdata = new FormData();
        formdata.append("loginstr",JSON.stringify(superadmin));
        formdata.append("type",type)
        formdata.append("checkcode",checkcode);
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
                    changecode(document.getElementById("checkcodeimg"))
                }
            }
        })
    })
})