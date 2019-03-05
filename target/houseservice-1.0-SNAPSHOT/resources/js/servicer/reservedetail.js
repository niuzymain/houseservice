$(function () {
    var reserveid = getURLarg("reserveid")
    $.getJSON("/servicer/getreservedetail?reserveid="+reserveid, function (data) {
        if (data.success) {
            var detailDiv = "<div id='info'>" +
                "<p id='userid' style='display: none'>"+data.result.user.userid+"</p>"+
                "<p id='servicerid' style='display: none'>"+data.result.servicer.servicerid+"</p>"+
                "<p>联系方式:"+data.result.reservephone+"</p>"+
                "<p>预约时间:"+timeStamp2String(data.result.reservetime)+"</p>"+
                "<p>预约地点:"+data.result.reserveaddr+"</p>"+
                "<p>预约备注:"+data.result.reservedes+"</p>" +
                "</div>"
            $("#detail").prepend(detailDiv)
            $("#msg").val(data.result.reservemsg);
            if(data.result.enablestatus == -1 || data.result.enablestatus == 1 ){
                $("#accept").hide();
                $("#refuse").hide();
                $("#msg").attr("readonly","readonly")
            }
        }
        else {
            alert(data.errormsg)
        }
    })
    $("#refuse").click(function(){
        var reservemsg = $("#msg").val();
        if(!reservemsg){
            alert("请填写拒绝原因")
            return false;
        }
        var reserve={
            reserveid:reserveid,
            reservemsg:reservemsg,
            enablestatus:-1
        }
        var formdata = new FormData;
        formdata.append("status","refuse")
        formdata.append("reservestr",JSON.stringify(reserve));
        $.ajax({
            url:"/servicer/operatereserve",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("success");
                    window.location.href="/servicer/reserve"
                }
                else {
                    alert("error：" + data.errormsg);
                }
            }
        })
    })
    $("#accept").click(function(){
        var reservemsg = $("#msg").val();
        var reserve={
            reserveid:reserveid,
            servicer:{
                servicerid:$("#servicerid").text()
            },
            reservemsg:reservemsg,
            enablestatus:1
        }
        var formdata = new FormData;
        formdata.append("status","accept")
        formdata.append("reservestr",JSON.stringify(reserve));
        $.ajax({
            url:"/servicer/operatereserve",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("success");
                    window.location.href="/servicer/reserve"
                }
                else {
                    alert("error：" + data.errormsg);
                }
            }
        })
    })

})