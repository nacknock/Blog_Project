$(document).ready(function() {
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        success: function(data) {
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
});


function prev_page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#q_list_p').empty();
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
}

function page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#q_list_p').empty();
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
}

function next_page(page) {
	page = parseInt(page,10);
							
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#q_list_p').empty();
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
}

function page_term(term_val) {
							
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:term_val,
        },
        success: function(data) {
            $('#q_list_p').empty();
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
}

function page_type(type_val) {
							
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            amount:$('#amount').val(),
            type:type_val,
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#q_list_p').empty();
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
}

function page_keyword(event) {
    event.preventDefault(); // 기본 제출 동작 방지
    let keyword_val = event.target.keyword.value; // 입력된 키워드 가져오기
    console.log(keyword_val);
							
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:keyword_val,
            term:$('#term').val(),
        },
        success: function(data) {
            $('#q_list_p').empty();
            $('#q_list_p').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('Q&A 목록을 불러오는 데 실패했습니다.');
        }
    });
    return false;
}