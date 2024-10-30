let certiCheck = 0;
		
		$(function() {			
			
			$("#user_id").blur(function(){
				if(!$("#user_id").val()) {
					alert("IDを入力してください。");
				}
			})

			$("#nickname").blur(function(){
				if(!$("#nickname").val()) {
					alert("ニックネームを入力してください。");
				}
			})
			
			$("#email").blur(function(){
					if(!$("#email").val()) {
						alert("メールアドレスを入力してください。");
					}
			});
			
			$("#btn-email").on("click",function(){
				if($("#email").val() == ""){
					alert("メールアドレスを入力してください。");
					return false;
				}
				
				$.ajax({
					type:'post',
					url:'/manage/emailsend.do',
					data:{email:$('#email').val()},
					dataType:'json',
					success:function(data){
						alert(data.msg);
						$('#btn-email').disabled = true;
					},error: function(){
						alert("通信エーラが発生しました。");
					}
				})
			});
			
			$("#certinumber").blur(function(){
				if(!$("#certinumber").val()) {
					alert("認証コードを入力してください。");
				}
			});
			
			$("#email_ok").on("click",function(){
				if($("#certinumber").val() == ""){
					alert("認証コードを入力してください。");
					$$("#certinumber").focus();
					return false;
				}
				
				$.ajax({
					type:"post",
					url:"/manage/certiCheck.do",
					data:{"certinumber":$("#certinumber").val()},
					dataType:"json",
					success:function(data){
						alert(data.msg);
						$('#email_ok').disabled = true;
						if(data.check === 'ok'){
							certiCheck = 1;
							console.log("certicheck : "+certiCheck);
						}
					},error: function(){
						alert("通信エーラが発生しました。");
					}
				})
			});
		});

function check() {
	if(update.user_id.value=="") {
		alert("IDを入力してください。");
		update.user_id.focus();
		return false;
	}
	if(update.nickname.value=="") {
		alert("ニックネームを入力してください。");
		update.nickname.focus();
		return false;
	}
	if(update.b_title.value=="") {
		alert("タイトルを入力してください。");
		update.b_title.focus();
		return false;
	}
	if(update.one_liner.value=="") {
		alert("説明を入力してください。");
		update.one_liner.focus();
		return false;
	}
	if(certiCheck==0) {
		alert("メール認証を完了してください。");
		return false;
	}
	return true;
}

//이미지 미리보기
document.addEventListener('DOMContentLoaded', function() {
    const fileInput = document.getElementById('img');
    const preview = document.getElementById('preview');

    fileInput.addEventListener('change', function(event) {
        const file = event.target.files[0];
        console.log(file);

        if (file) {
            console.log(1234);
            const reader = new FileReader();

            reader.onload = function(e) {
                preview.src = e.target.result; // 읽은 데이터 URL을 이미지 src에 설정
            }

            reader.readAsDataURL(file); // 파일을 Data URL로 읽기
        }
    });
});