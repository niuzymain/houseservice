$(function(){
    var index=0;
    $("#itemmenulist").hide();
    $("#itemmanager").click(function(){
        if(index == 0){
            index = 1;
        }
        else{
            index = 0;
        }
        if(index == 0){
            $("#itemmenulist").hide();
        }
        else{
            $("#itemmenulist").show();
        }

    })

})