$(document).ready(function() {
    $.ajax({
        url: '/b/search_paging_p.do', // Ajax 요청 URL
        type: 'GET',
		data:{
            bp_keyword:$('#bp_keyword').val(),
        },
        success: function(data) {
            $('#post-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
	$.ajax({
        url: '/b/search_paging_b.do', // Ajax 요청 URL
        type: 'GET',
		data:{
            bp_keyword:$('#bp_keyword').val(),
        },
        success: function(data) {
            $('#blog-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
});


function prev_page_b(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/b/search_paging_b.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            bp_keyword:$('#bp_keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#blog-box').empty();
            $('#blog-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page_b(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/b/search_paging_b.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            bp_keyword:$('#bp_keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#blog-box').empty();
            $('#blog-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function next_page_b(page) {
	page = parseInt(page,10);
							
    $.ajax({
        url: '/b/search_paging_b.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            bp_keyword:$('#bp_keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#blog-box').empty();
            $('#blog-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function prev_page_p(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/b/search_paging_p.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            bp_keyword:$('#bp_keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#post-box').empty();
            $('#post-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page_p(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/b/search_paging_p.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            bp_keyword:$('#bp_keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#post-box').empty();
            $('#post-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function next_page_p(page) {
	page = parseInt(page,10);
							
    $.ajax({
        url: '/b/search_paging_p.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            bp_keyword:$('#bp_keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#post-box').empty();
            $('#post-box').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}