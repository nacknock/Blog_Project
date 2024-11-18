$(document).ready(function() {
    $.ajax({
        url: '/manage/reply_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            idx:$('#idx').val(),
            b_idx:$('#b_idx').val(),
        },
        success: function(data) {
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
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
        url: '/manage/reply_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            idx:$('#idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
            b_idx:$('#b_idx').val(),
        },
        success: function(data) {
            $('#reply-paging').empty();
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/manage/reply_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            idx:$('#idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
            b_idx:$('#b_idx').val(),
        },
        success: function(data) {
            $('#reply-paging').empty();
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function next_page(page) {
	page = parseInt(page,10);
							
    $.ajax({
        url: '/manage/reply_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            idx:$('#idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
            b_idx:$('#b_idx').val(),
        },
        success: function(data) {
            $('#reply-paging').empty();
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page_term(term_val) {
							
    $.ajax({
        url: '/manage/reply_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            idx:$('#idx').val(),
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            b_idx:$('#b_idx').val(),
            term:term_val,
        },
        success: function(data) {
            $('#reply-paging').empty();
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
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
        url: '/manage/reply_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            idx:$('#idx').val(),
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:keyword_val,
            term:$('#term').val(),
            b_idx:$('#b_idx').val(),
        },
        success: function(data) {
            $('#reply-paging').empty();
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
    return false;
}

function del(r_idx){
    $.ajax({
        type:"post",
        url:"/manage/reply_del.do",
        data:{
            r_idx:r_idx,
            pageNum:$('#nowpage').text(),
            idx:$('#idx').val(),
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#reply-paging').empty();
            $('#reply-paging').append(data); // 서버에서 받은 HTML을 추가
        },error:function(){
            alert("通信エーラが発生しました。");
        }
    })
}