$(function () {
    var evaluateid = getURLarg("evaluateid")//查看评价
    var reserveid = getURLarg("reserveid")//评价
    $("#operate #back").click(function(){
        window.location.href="/user/reserverecord"
    })
    $("#operate #submit").click(function(){
        var evaluate={
            evaluatedes:$("#context textarea").val(),
            evaluatescore:$("#score select").val(),
            enablestatus:1
        }
        $.ajax({
            url:"/user/addevaluate",
            data:{
                reserveid:reserveid,
                evaluatestr:JSON.stringify(evaluate)
            },
            type:"POST",
            success:function(data){
                if(data.success){
                    alert("success")
                    window.location.href="/user/reserverecord"
                }
                else{
                    alert(data.errormsg)
                }
            }
        })
    })
    if(evaluateid != null){
        $("#context textarea").attr("readonly","readonly")
        $("#score select").attr("disabled","disabled")
        $("#operate #submit").hide()
        $.getJSON("/user/getevaluate?evaluateid="+evaluateid,function(data){
            if(data.success){
                $("#context textarea").val(data.result.evaluatedes);
                $("#score select").val(data.result.evaluatescore);
            }
            else{
                alert(data.errormsg)
            }
        })
    }
    else if(reserveid != null){
        $("#score select").on("change",function(){
            $("#score select").find("option[value='-1']").remove();
        })
    }
    else{
        alert("操作错误")
        window.location.href="/user/reserverecord"
    }
});