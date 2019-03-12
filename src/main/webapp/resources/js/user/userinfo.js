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
            $(".u-accountname td:first").after("<td>"+data.result.accountname+"</td>")
            $(".u-email td:first").after("<td>"+data.result.useremail+"</td>")
            $(".u-phone td:first").after("<td>"+data.result.userphone+"</td>")
        }
        else{
            alert(dta.errormsg)
        }
    })
})