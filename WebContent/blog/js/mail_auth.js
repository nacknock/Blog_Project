const first = document.getElementById('first');
const second = document.getElementById('second');
const third = document.getElementById('third');
const fourth = document.getElementById('fourth');
const fifth = document.getElementById('fifth');
const sixth = document.getElementById('sixth');
const warning = document.getElementById('warning');

$(function() {
    $("#postbtn").on("click",function(){
        console.log("submit");
        if($("#first").val().trim() === ''){
            $("#warning").style.display = 'block';
        }
        else if($("#second").val().trim() === ''){
            $("#warning").style.display = 'block';
        }
        else if($("#third").val().trim() === ''){
            $("#warning").style.display = 'block';
        }
        else if($("#fourth").val().trim() === ''){
            $("#warning").style.display = 'block';
        }
        else if($("#fifth").val().trim() === ''){
            $("#warning").style.display = 'block';
        }
        else if($("#sixth").val().trim() === ''){
            $("#warning").style.display = 'block';
        }
        else{
            let number = "";
            number += $("#first").val();
            number += $("#second").val();
            number += $("#third").val();
            number += $("#fourth").val();
            number += $("#fifth").val();
            number += $("#sixth").val();
            $.ajax({
                type:"post",
                url:"/sign/mail_authAction.do",
                data:{
                    auth_num:number,
                },
                dataType:"json",
                success:function(data){
                    if(data.check === "ok"){
                        alert(data.msg);
                        location.href="/";
                    }else{
                        alert(data.msg);
                    }
                },error:function(){
                    alert("통신에러!");
                }
            })
        }
        
    });
});