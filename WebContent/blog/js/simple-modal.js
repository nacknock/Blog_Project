var myModal = document.getElementById('modal')
var myInput = document.getElementById('input')

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})