$(function(){
    $.getJSON("/servicer/getservicerinfo",function(data){
        if(data.success){
            $(".name").append(data.result.servicername)
            $(".idnum").append(data.result.serviceridnum)
            $(".age").append(data.result.servicerage)
            $(".sex").append(sexinfo(data.result.servicersex))
            $(".phone").append(data.result.servicerphone)
            $(".img").append("<a href=/file"+data.result.servicerimg+">查看文件</a>")
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