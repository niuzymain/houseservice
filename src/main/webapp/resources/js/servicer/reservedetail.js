$(function () {
    var reserveid = getURLarg("reserveid")
    $.getJSON("/servicer/getreservedetail?reserveid="+reserveid, function (data) {
        if (data.success) {
            var detailDiv = "<div id='info'>" +
                "<p id='userid' style='display: none'>"+data.result.user.userid+"</p>"+
                "<p id='servicerid' style='display: none'>"+data.result.servicer.servicerid+"</p>"+
                "<p>联系方式:"+data.result.reservephone+"</p>"+
                "<p>预约时间:"+timeStamp2String(data.result.reservetime)+"</p>"+
                "<p>到期时间:"+timeStamp2String(data.result.endtime)+"</p>"+
                "<p>预约地点:"+data.result.reserveaddr+"</p>"+
                "<p>合同信息:<a href=/file"+data.result.reservecontract+">查看合同</a></p>"+
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

})