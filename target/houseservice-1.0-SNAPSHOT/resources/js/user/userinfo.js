$(function () {
    $("#logout button").click(function(){
        $.getJSON("/user/userlogout",function(data){
            if(data.success){
                alert("退出成功")
                window.location.href="/user/main"
            }
        })
    })
    $.getJSON("/user/getuserinfo",function(data){
        if(data.success){
            $("h1 a").append(data.result.accountname)
            $(".u-accountname td:first").after("<td>"+data.result.accountname+"</td>")
            $(".u-email td:first").after("<td>"+data.result.useremail+"</td>")
            $(".u-phone td:first").after("<td>"+data.result.userphone+"</td>")
        }
        else{
            alert(dta.errormsg)
        }
    })
$(" table tbody button").click(function(){
    var user={}
    var formdata = new FormData;
    if($(this).attr("id") == "m-account"){
        var edit = prompt("新用户名")
        if(edit){
            user.accountname=edit;
        }
        else if(edit == ""){
            alert("修改不能为空")
        }
    }
    else if($(this).attr("id") == "m-pass"){
        var edit = prompt("新密码")
        if(edit){
            user.password=edit;
        }
        else if(edit == ""){
            alert("修改不能为空")
        }
    }
    else if($(this).attr("id") == "m-phone"){
        var edit = prompt("新手机号")
        if(edit){
            user.userphone=edit;
        }
        else if(edit == ""){
            alert("修改不能为空")
        }
    }
    else if($(this).attr("id") == "m-email"){
        var edit = prompt("新邮箱号")
        if(edit){
            user.useremail=edit;
        }
        else if(edit == ""){
            alert("修改不能为空")
        }
    }
    formdata.append("userstr",JSON.stringify(user))
    $.ajax({
        url: "/user/operateuserinfo",
        data: formdata,
        type: "post",
        contentType: false,
        processData: false,
        cache: false,
        success:function(data){
            if(data.success){
                alert("success")
                window.location.reload()
            }
            else{
                alert(data.errormsg)
            }
        }
    })
})

})