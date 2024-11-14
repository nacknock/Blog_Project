function raiting(rating_num) {
							
    $.ajax({
        url: '/manage/raiting.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            a_idx:$('#a_idx').val(),
            raiting:rating_num,
        },
        success: function(data) {
            console.log(data.result+" : result");
            if(data.result === 'ok'){
                window.location.href = window.location.href;
            }else if(data.result === 'nok'){
                alert('通信エーラが発生しました。');
            }
        },
        error: function() {
            alert('通信エーラが発生しました。');
        }
    });
}