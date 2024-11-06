let ctgr_name_val='';

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
            success:function(data){
                $('#for-box').append(data); // 서버에서 받은 HTML을 추가
                $('#input_box').css('display','none');
                $('#add_box').css('display','flex');
                $('#ctgr_name').val('');
                $('#none-div').css('display','none');
            },error:function(){
                alert("通信エーラが発生しました。");
            }
        })
    }
    
});

function update(button){
    const ctgr_name = $(button).closest('.post-entry-sidebar').find('.ctgr_name');
    const none_input = $(button).closest('.post-entry-sidebar').find('.none-input');
    const cnt_p = $(button).closest('.post-entry-sidebar').find('.cnt-p');
    const btn_cancel = $(button).closest('.post-entry-sidebar').find('.can-btn');
    const btn_submit = $(button).closest('.post-entry-sidebar').find('.sub-btn');
    ctgr_name_val = none_input.val();
    ctgr_name.css('display','none');
    none_input.css('display','flex');
    cnt_p.css('display','none');
    btn_cancel.css('display','block');
    btn_submit.css('display','block');
}
function up_cancel(button){
    const ctgr_name = $(button).closest('.post-entry-sidebar').find('.ctgr_name');
    const none_input = $(button).closest('.post-entry-sidebar').find('.none-input');
    const cnt_p = $(button).closest('.post-entry-sidebar').find('.cnt-p');
    const btn_cancel = $(button).closest('.post-entry-sidebar').find('.can-btn');
    const btn_submit = $(button).closest('.post-entry-sidebar').find('.sub-btn');
    none_input.val(ctgr_name_val);
    ctgr_name.css('display','flex');
    none_input.css('display','none');
    cnt_p.css('display','flex');
    btn_cancel.css('display','none');
    btn_submit.css('display','none');
}
function upAction(button){
    const ctgr_name = $(button).closest('.post-entry-sidebar').find('.ctgr_name');
    const none_input = $(button).closest('.post-entry-sidebar').find('.none-input');
    const cnt_p = $(button).closest('.post-entry-sidebar').find('.cnt-p');
    const btn_cancel = $(button).closest('.post-entry-sidebar').find('.can-btn');
    const btn_submit = $(button).closest('.post-entry-sidebar').find('.sub-btn');

    if(none_input.val().trim() === ''){
        alert("カテゴリを入力してください。");
        none_input.focus();
        return false;
    }

    const ctgridx = $(button).closest('.post-entry-sidebar').find('.ctgridx');
    $.ajax({
        type:"post",
        url:"/manage/ctgrModify.do",
        data:{
            ctgridx:ctgridx.val(),
            ctgr_name:none_input.val(),
        },
        dataType : "json",
        success:function(result){
            if(result.check === "ok"){
                ctgr_name.text(none_input.val());
                ctgr_name.css('display','flex');
                none_input.css('display','none');
                cnt_p.css('display','flex');
                btn_cancel.css('display','none');
                btn_submit.css('display','none');
            }else{
                alert("通信エーラが発生しました。");
            }
            
        },error:function(){
            alert("通信エーラが発生しました。");
        }
    })
}