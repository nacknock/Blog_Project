$(document).ready(function() {
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
        },
        success: function(data) {
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
            $('#cnt-text').text('('+$('#count').val()+')');
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
});


function prev_page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function next_page(page) {
	page = parseInt(page,10);
							
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page_term(term_val) {
							
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:term_val,
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page_type(type_val) {
							
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
            amount:$('#amount').val(),
            type:type_val,
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page_keyword(event) {
    event.preventDefault(); // 기본 제출 동작 방지
    let keyword_val = event.target.keyword.value; // 입력된 키워드 가져오기
    console.log(keyword_val);
							
    $.ajax({
        url: '/manage/post_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            b_idx:$('#b_idx').val(),
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:keyword_val,
            term:$('#term').val(),
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
    return false;
}

function del(button){
    const pidx = $(button).closest('.post-entry-sidebar').find('.pidx');
    $.ajax({
        type:"post",
        url:"/manage/del_post.do",
        data:{
            p_idx:pidx.val(),
            pageNum:$('#nowpage').text(),
            b_idx:$('#b_idx').val(),
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#p-paging').empty();
            $('#p-paging').append(data); // 서버에서 받은 HTML을 추가
        },error:function(){
            alert("通信エーラが発生しました。");
        }
    })
}

function chngePriv(button){
    const icon = $(button).closest('.post-entry-sidebar').find('.pri-i');
    const private = $(button).closest('.post-entry-sidebar').find('.private');
    const pidx = $(button).closest('.post-entry-sidebar').find('.pidx');
    const pri_a = $(button).closest('.post-entry-sidebar').find('.pri-a');
    let pri_bool_val = 0;
    if(private.val() === '0'){
        pri_bool_val = 1;
    }else if(private.val() === '1'){
        pri_bool_val = 0;
    }
    $.ajax({
        type:"post",
        url:"/manage/Pchange_pri.do",
        data:{
            pri_bool:pri_bool_val,
            p_idx:pidx.val(),
        },
        dataType : "json",
        success:function(result){
            if(result.check === "ok"){
                if(pri_bool_val == 0){
                    icon.removeClass();
                    icon.addClass('fa-solid fa-eye pri-i');
                    pri_a.text('非公開');
                    private.val(0);
                }else if(pri_bool_val == 1){
                    icon.removeClass();
                    icon.addClass('fa-solid fa-eye-slash pri-i');
                    pri_a.text('公開');
                    private.val(1);
                }
            }else{
                alert("通信エーラが発生しました。");
            }
            
        },error:function(){
            alert("通信エーラが発生しました。");
        }
    })
}

function chngeB_priv(b_idx){
    $.ajax({
        type:"post",
        url:"/manage/Bchange_pri.do",
        data:{
            pri_bool:$('#p_pri_yn').val(),
            b_idx:b_idx,
        },
        dataType : "json",
        success:function(result){
            if(result.check === "ok"){
                alert("設定を保存しました。");
            }else{
                alert("通信エーラが発生しました。");
            }
            
        },error:function(){
            alert("通信エーラが発生しました。");
        }
    })
}