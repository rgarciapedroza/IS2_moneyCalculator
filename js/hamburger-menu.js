let hamburgerMenu = document.querySelector(".hamburger-menu");
let menu = document.querySelector(".menu");
let formContainer = document.querySelector(".form_container");
let clicked = false;

hamburgerMenu.addEventListener('click', 
    async function () {
        if (clicked) {
            hamburgerMenu.src = "../files/hamburger-menu.png";
            formContainer.style.display = 'block';
            menu.style.display = 'none';
            clicked = false;
        } else {
            hamburgerMenu.src = "../files/close.png";
            formContainer.style.display = 'none';
            menu.style.display = 'block';
            clicked = true;
        }
    }
);