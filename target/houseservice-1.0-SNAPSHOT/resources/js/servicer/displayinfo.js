$(function(){
    $("#logout").click(function(){
        $.getJSON("/servicer/logout",function(data){
            if(data.success){
             alert("退出成功")
                window.location.href="/login/servicer"
            }
        })
    })
    $.getJSON("/servicer/getservicerinfo",function(data){
        if(data.success){
            if(data.result.checkstatus != -1){
                $("#modify").hide()
            }
            $("#modify").click(function(){
                window.location.href="/servicer/register?servicerid="+data.result.servicerid
            })
            $("#img img").attr("src","/file"+data.result.servicerimg)
            $(".status .c-status").append(checkinfo(data.result.checkstatus))
            $(".status .w-status").append(statusinfo(data.result.enablestatus))
            $("h1 a").append(data.result.servicername)
            $(".name").append(data.result.servicername)
            $(".idnum").append(data.result.serviceridnum)
            $(".age").append(data.result.servicerage)
            $(".sex").append(sexinfo(data.result.servicersex))
            $(".phone").append(data.result.servicerphone)
            $(".experience").append(experienceinfo(data.result.servicerexperience))
            $(".salary").append(data.result.servicerprice)
            $(".des").append(data.result.servicerdes)
            $(".file").append("<a href=/file"+data.result.servicerfile+">查看文件</a>")
            $(".area").append(data.result.city.workareaname+"-"+data.result.local.workareaname)
            $(".lastedittime").append(timeStamp2String(data.result.lastedittime))
            $(".degree").append(data.result.degree.degreename)
            $(".type").append(data.result.servicetype.servicetypename)
        }
        else{
            alert(data.errormsg)
        }
    })
})