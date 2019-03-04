$(function () {
    $("#logout button").click(function(){
        $.getJSON("/user/userlogout",function(data){
            if(data.success){
                alert("退出成功")
                window.location.href="/user/main"
            }
        })
    })
})