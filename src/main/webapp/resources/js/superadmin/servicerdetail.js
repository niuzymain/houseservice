$(function(){
    var servicerid = getURLarg("servicerid")
    $.getJSON("/admin/singleservicer?servicerid="+servicerid,function(data){
        if(data.success){
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
            $(".score").append(data.result.servicerscore)
            $(".count").append(data.result.servicecount)
        }
        else{
            alert(data.errormsg)
        }
    })
})