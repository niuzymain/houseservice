$(function () {
    var headimgid = getURLarg("headimgid")
    var submiturl = "/admin/addheadimg";
    if (headimgid != null) {
        submiturl = "/admin/editheadimg"
        $.getJSON("/admin/singleheadimg?headimgid=" + headimgid, function (data) {
            if (data.success) {
                $("#title").val(data.result.headimgtitle);
                $("#details").val(data.result.headimgdetails)
                $("#priority").val(data.result.priority)
                $("#checkimg").css('display', 'block');
                $("#checkimg").attr("href", "/file" + data.result.headimgurl);
            }
            else {
                alert("error" + data.errormsg)
            }
        })
    }
    $("#submit").click(function () {
        var headimg = {
            headimgid: headimgid,
            headimgtitle: $("#title").val(),
            headimgdetails: $("#details").val(),
            priority: $("#priority").val()
        }
        var imgfile = $("#img")[0].files[0];
        var formdata = new FormData;
        formdata.append("operatestr", JSON.stringify(headimg))
        formdata.append("imgfile", imgfile)
        $.ajax({
            url: submiturl,
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    alert("success");
                    window.location.href = "/admin/headimg";
                }
                else {
                    alert("error：" + data.errormsg);
                }
            }
        })
    })
})