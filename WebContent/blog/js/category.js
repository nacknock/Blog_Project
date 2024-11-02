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