const autoblock = document.querySelector('.autologinbox');
const checkbox = document.getElementById('auto-login');

checkbox.addEventListener('click', function(event) {

  if (event.target === checkbox) { 
      event.preventDefault();
  }
});
