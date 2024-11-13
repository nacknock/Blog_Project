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