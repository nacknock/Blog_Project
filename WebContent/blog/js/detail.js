$(document).ready(function() {
    $.ajax({
        url: '/b/reply_list.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            p_idx:$('#p_idx').val(),
        },
        success: function(data) {
            $('#comm-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
});


function prev_page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/b/reply_list.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            p_idx:$('#p_idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
        },
        success: function(data) {
            $('#comm-paging').empty();
            $('#comm-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function page(page) {
	page = parseInt(page,10);
    $.ajax({
        url: '/b/reply_list.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            p_idx:$('#p_idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#comm-paging').empty();
            $('#comm-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}

function next_page(page) {
	page = parseInt(page,10);
							
    $.ajax({
        url: '/b/reply_list.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            p_idx:$('#p_idx').val(),
            pageNum:page,
            amount:$('#amount').val(),
            type:$('#type').val(),
            keyword:$('#keyword').val(),
            term:$('#term').val(),
        },
        success: function(data) {
            $('#comm-paging').empty();
            $('#comm-paging').append(data); // 서버에서 받은 HTML을 추가
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
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