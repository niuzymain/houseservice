$(function(){
    var reserveid=getURLarg("reserveid")
    $("#submit").click(function() {
        var formdata = new FormData;
        var reserve = {
            reserveid:reserveid,
            reservetime:$("#t-reserve").val(),
            endtime:$("#t-end").val()
        }
        var contract = $("#contract")[0].files[0];
        formdata.append("reservestr",JSON.stringify(reserve))
        formdata.append("contract",contract)
        $.ajax({
            url: "/admin/confirmereserve",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("success");
                    window.location.href="/admin/reserve"
                }
                else {
                    alert("error：" + data.errormsg);
                }
            }
        })
    })
})