$(function () {
    var servicerid = getURLarg("servicerid")
    $("#submit").click(function(){
        var reserve = {
            reserveaddr:$("#inputaddr").val(),
            reservedes:$("#inputdes").val(),
            reservephone:$("#inputphone").val(),
            servicer:{
                servicerid:servicerid
            }
        }
        var formdata = new FormData;
        formdata.append("reservestr",JSON.stringify(reserve))
        $.ajax({
            url: "/user/addreserve",
            data: formdata,
            type: "post",
            contentType: false,
            processData: false,
            cache: false,
            success:function(data){
                if(data.success){
                    alert("success")
                    window.location.href="/user/servicerpage"
                }
                else{
                    alert(data.errormsg)
                }
            }
        })
    })

    $("#back").click(function(){
        window.location.href="/user/servicerdetail?servicerid="+servicerid
    })

})