function startFormButtons () {
    const formContainer = document.querySelector('.form_container');
    const signup = document.querySelector('.signup_form_button');
    const login = document.querySelector(".login_form_button");
    
    signup.addEventListener('click', () => {
        formContainer.classList.add('active');
    })
    
    login.addEventListener('click', () => {
        formContainer.classList.remove('active');
    })
}

