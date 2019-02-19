$(function () {
    $.getJSON("/admin/qualifylist",function(data){
        if(data.success){

        }
        else{
            alert("error:"+data.errormsg);
        }
    })
})