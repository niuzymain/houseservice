$(function(){
    $(".am-btn-primary").click(function(){
        window.location.href="/user/main"
    })
    $(".am-btn-default").click(function(){
        alert("thanks")
    })
    var headimgid=getURLarg("headimgid")
    $.getJSON("/user/getspecificheadimg?headimgid="+headimgid,function(data){
        if(data.success){
            $("#title").append(data.result.headimgtitle);
            $("img").attr("src","/file"+data.result.headimgurl)
            $("#des p").append(data.result.headimgdetails);
            $("#date").append(timeStamp2String(data.result.lastedittime))
        }
        else{
            alert(data.errormsg)
        }
    })
})