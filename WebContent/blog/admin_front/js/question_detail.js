const to_a_btn = document.getElementById('to-a-btn');
const cancel_btn = document.getElementById('btn-cancel');
function answer(){
    const q_btn_box = document.getElementById('q-btn-box');
    const answer_box = document.getElementById('answer-box');

    if (q_btn_box.style.display === 'block') {

        q_btn_box.style.display = 'none';
        answer_box.style.display = 'block';

    }


}
function cancel(){
    const q_btn_box = document.getElementById('q-btn-box');
    const answer_box = document.getElementById('answer-box');
    const a_txtarea = document.getElementById('a-txtarea');

    if (q_btn_box.style.display !== 'block') {

        q_btn_box.style.display = 'block';
        answer_box.style.display = 'none';
        a_txtarea.value = '';

    }


}

function submit(a_q_idx) {
	a_q_idx = parseInt(a_q_idx,10);
							
    $.ajax({
        url: '/admin/answer_write.do', // Ajax 요청 URL
        type: 'GET',
        data:{
            q_idx:a_q_idx,
            a_content:$('#a-txtarea').val(),
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