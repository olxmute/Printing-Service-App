const form = document.querySelector('.register-form form');

const password1 = document.getElementById('password');
const password2 = document.getElementById('con-pass');

const emailError = document.querySelector('#con-pass + .error-holder');

password2.addEventListener('input', function (event) {
    if (password1.value === password2.value) {
        emailError.innerHTML = '';
    } else {
        emailError.textContent = "Passwords don't match";
    }
});

form.addEventListener('submit', function (event) {
    if (password1.value !== password2.value) {
        emailError.textContent = "Passwords don't match";
        event.preventDefault();
    }
});