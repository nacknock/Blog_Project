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

let startPage_let = $('#startPage').val();
let endPage_let = $('#endPage').val();
let amount_let = $('#amount').val();
let type_let = $('#type').val();
let term_let = $('#term').val();
let keyword_let = $('#keyword').val();

function prev_page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/manage/q_paging.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page+1,
            amount:amount_let,
            type:type_let,
            keyword:keyword_let,
            term:term_let,
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
            pageNum:page - 1,
            amount:amount_let,
            type:type_let,
            keyword:keyword_let,
            term:term_let,
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
            amount:amount_let,
            type:type_let,
            keyword:keyword_let,
            term:term_let,
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