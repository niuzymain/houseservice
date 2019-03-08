$(function () {
    var servicerid = getURLarg("servicerid")
   $.getJSON("/admin/getqualifydetail?servicerid="+servicerid,function(data){
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
           alert(data.errormsg);
       }
   })
    $("#pass").click(function(){
        var msg = $("#message").val();
        var formdata = new FormData();
        if(msg != ""){
            var adminmsg = {
                adminmsgdes:msg,
                type:0,
                servicer:{
                    servicerid:servicerid
                }
            }
            formdata.append("adminmsg",JSON.stringify(adminmsg));
        }
        var servicer = {
            servicerid:servicerid,
            checkstatus:1
        }
        formdata.append("servicer",JSON.stringify(servicer));
        $.ajax({
            url:"/admin/qualifyoperate",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success:function(data){
                if(data.success){
                    alert("success")
                    window.location.href="/admin/qualify"
                }
                else{
                    alert("error:"+data.errormsg)
                }
            }
        })
    })

    $("#back").click(function(){
        var msg = $("#message").val();
        var formdata = new FormData();
        if(msg == ""){
            alert("请填写不通过原因");
            return false;
        }
        var adminmsg = {
            adminmsgdes:msg,
            type:0,
            servicer:{
                servicerid:servicerid
            }
        }
        formdata.append("adminmsg",JSON.stringify(adminmsg));
        var servicer = {
            servicerid:servicerid,
            checkstatus:-1
        }
        formdata.append("servicer",JSON.stringify(servicer));
        $.ajax({
            url:"/admin/qualifyoperate",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success:function(data){
                if(data.success){
                    alert("success")
                    window.location.href="/admin/qualify"
                }
                else{
                    alert("error:"+data.errormsg)
                }
            }
        })
    })
})