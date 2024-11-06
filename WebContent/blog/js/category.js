document.getElementById('addbtn').addEventListener('click', function() {
    // 입력 폼을 보이게 하고 추가 버튼 숨기기
    document.getElementById('input_box').style.display = 'flex';
    document.getElementById('add_box').style.display = 'none';
});

document.getElementById('cancel_btn').addEventListener('click', function() {

    document.getElementById('input_box').style.display = 'none';
    document.getElementById('add_box').style.display = 'flex';
    // 입력 필드 비우기
    document.getElementById('ctgr_name').value = '';
});

$("#submit_btn").on("click",function(){
    var isValid = true;
    if($("#ctgr_name").val().trim() === ''){
        alert("カテゴリを入力してください。");
        isValid = false;
        $("#ctgr_name").focus();
    }
    
    if(isValid){
        $.ajax({
            type:"post",
            url:"/manage/ctgrAdd.do",
            data:{
                b_idx:$("#b_idx").val(),
                ctgr_name:$("#ctgr_name").val(),
            },
            dataType:"json",
            success:function(data){
                $('#for-box').append(data); // 서버에서 받은 HTML을 추가
                $('#input_box').style.display = 'none';
                $('#add_box').style.display = 'flex';
                $('#none-div').style.display = 'none';
            },error:function(){
                alert("通信エーラが発生しました。");
            }
        })
    }
    
});