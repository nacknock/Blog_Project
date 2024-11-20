$(function() {			
			
    $("#btn_submit").on("click",function(){
        console.log("submit");
        var isValid = true;
            var pw = $("#pw").val();
            // var pwRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{9,13}$/;
            // if(!pwRegex.test(pw1)){
            //     $("#pw1").next(".guideTxt").html("<span style='color:#f00;'>비밀번호는 영문(대문자 구분), 숫자, 특수문자의 조합</span>으로 9~13자로 작성해 주십시오.</span>");
            //     isValid = false;
            // }
            var new_pw = $('#new_pw').val();
            var chk_pw = $('#chk_pw').val();

            if(new_pw === ''){
                alert("新しいパスワードを入力してください。");
                isValid = false;
				return false;
            }

            if(chk_pw === ''){
                alert("確認用パスワードを入力してください。");
                isValid = false;
				return false;
            }

            if(chk_pw !== new_pw){
                alert("新しいパスワードと確認用パスワードが一致しません。もう一度入力してください。");
                isValid = false;
				return false;
            }

            if(isValid){
                $.ajax({
                    type:"post",
                    url:"/manage/pw_updateAction.do",
                    data:{
                        pw:$("#pw").val(),
                        new_pw:$("#new_pw").val(),
                    },
                    dataType:"json",
                    success:function(data){
                        if(data.result == "ok"){
                            alert("パスワードの変更が完了しました");
                            location.href="/manage/main.do";
                        }else if(data.result == "nok0"){
                            alert(" 安全性を高めるために、半角英字数字と記号を組み合わせてパスワードを入力してください。");
                            isValid = false;
                        }else if(data.result == "nok1"){
                            alert(" 現在のパスワードが一致しません。");
                            isValid = false;
                        }else if(data.result == "nok2"){
                            alert(" エーラが発生しました。");
                            isValid = false;
                        }
                    },error:function(){
                        alert("通信エーラが発生しました。");
                        isValid = false;
                    }
                })
            }
        
    });
});