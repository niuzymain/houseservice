$(function () {
    $("#logout").click(function(){
        $.getJSON("/servicer/logout",function(data){
            if(data.success){
                alert("退出成功")
                window.location.href="/login/servicer"
            }
        })
    })
/////////////////////////////////获取初始信息///////////////////////////////////////////////////////
    $.getJSON("/servicer/getservicerinfo",function(data){
        if(data.success){
/////////////////////////////////////////////加载用户信息////////////////////////////////////////////////////////////
            $("h1 a").append(data.result.servicername)
            $(".phone input").val(data.result.servicerphone)
            $(".accountname input").val(data.result.accountname)
            $(".password input").val(data.result.password)
        }
        else{
            alert(data.errormsg)
        }
    })
//////////////////////////////修改事件//////////////////////////////////////////////
    $(".edit").click(function(){
        $("input").removeAttr("readonly")
    })
////////////////////////////提交事件///////////////////////////////////////////
    $(".submit").click(function () {
        var servicer = {
            servicerphone: $(".phone input").val(),
            accountname: $(".accountname input").val(),
            password: $(".password input").val()
        }
        var formdata = new FormData();
        formdata.append("str", JSON.stringify(servicer))
        $.ajax({
            url: "/servicer/editservicerinfo",
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