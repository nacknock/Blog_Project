var myModal = document.getElementById('logoutModal');
var myInput = document.getElementById('warn-btn');

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})