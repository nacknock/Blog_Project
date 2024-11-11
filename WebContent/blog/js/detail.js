$(document).ready(function() {
    $.ajax({
        url: '/b/reply_list.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            p_idx:$('#p_idx').val(),
            b_idx:$('#blog').val(),
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
            b_idx:$('#blog').val(),
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
            b_idx:$('#blog').val(),
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
            b_idx:$('#blog').val(),
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
        url:"/b/reply_del.do",
        data:{
            r_idx:r_idx,
        },
        success: function(data) {
            if(data.check === 'ok'){
                location.href="/b/detail.do?blog="+$('#blog').val()+"&&p="+$('#p_idx').val();
            }else if(data.check === 'nok'){
                alert("通信エーラが発生しました。");
            }
        },error:function(){
            alert("通信エーラが発生しました。");
        }
    })
}

function re_reply(button){ 
    const form = $(button).closest('.comment-body').find('.re_re_form');
    $(button).closest('.comment-body').find('.r_con').val('');
    form.css('display','block');
}

function re_update(button){
    const form = $(button).closest('.comment-body').find('.re_up_form');
    const r_con_input = $(button).closest('.comment-body').find('.r_con_hidden').val();
    $(button).closest('.comment-body').find('.r_con').val(r_con_input);
    form.css('display','block');
}

function cancelRE(button){
    const form = $(button).closest('.comment-body').find('.re_re_form');
    form.css('display','none');
}

function cancelUP(button){
    const form = $(button).closest('.comment-body').find('.re_up_form');
    form.css('display','none');
}