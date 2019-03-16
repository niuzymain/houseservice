$(function () {
    var reserverow;
    $("#logout").click(function () {
        $.getJSON("/servicer/logout", function (data) {
            if (data.success) {
                alert("退出成功")
                window.location.href = "/login/servicer"
            }
        })
    })
    $.getJSON("/servicer/getservicerinfo", function (data) {
        if (data.success) {
            $("h1 a").append(data.result.servicername)
        }
        else {
            alert(data.errormsg)
        }
    })
    $.getJSON("/servicer/getreservelist?enablestatus=" + 2, function (data) {
        if (data.success) {
            if (data.result.length > 0) {
                for (var i = 0; i < data.result.length; i++) {
                    reserverow = "<tr>" +
                        "<td>" + timeStamp2String(data.result[i].reservetime) + "</td>" +
                        "<td>" + timeStamp2String(data.result[i].endtime) + "</td>" +
                        "<td>" + data.result[i].reservephone + "</td>" +
                        "<td>" + data.result[i].reserveaddr + "</td>" +
                        "<td>" + data.result[i].reservedes + "</td>" +
                        "<td>" + reserveinfo(data.result[i].enablestatus) + "</td>" +
                        "<td><a href=/file" + data.result[i].reservecontract + ">查看合同</a></td>" +
                        "</tr>"
                    $("table tbody").append(reserverow);
                }
            }

        }
        else {
            alert(data.errormsg)
        }
    })
    ////////////////////////////////////////////////////绑定选择框/////////////////////////////////////////////////
    $("select").change(function () {
        $("table tbody").empty();
        var enablestatus = $("select").val();
        $.getJSON("/servicer/getreservelist?enablestatus=" + enablestatus, function (data) {
            if (data.success) {
                if (data.result.length > 0) {
                    for (var i = 0; i < data.result.length; i++) {
                        reserverow = "<tr>" +
                            "<td>" + timeStamp2String(data.result[i].reservetime) + "</td>" +
                            "<td>" + timeStamp2String(data.result[i].endtime) + "</td>" +
                            "<td>" + data.result[i].reservephone + "</td>" +
                            "<td>" + data.result[i].reserveaddr + "</td>" +
                            "<td>" + data.result[i].reservedes + "</td>" +
                            "<td>" + reserveinfo(data.result[i].enablestatus) + "</td>" +
                            "<td><a href=/file" + data.result[i].reservecontract + ">查看合同</a></td>" +
                            "</tr>"
                        $("table tbody").append(reserverow);
                    }
                }
            }
            else {
                alert(data.errormsg)
            }
        })
    })

})