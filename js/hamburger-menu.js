let hamburgerMenu = document.querySelector(".hamburger-menu");
let menu = document.querySelector(".menu");
let clicked = false;

let formContainer = document.querySelector(".form_container");

let leftSidebar = document.querySelector(".left-sidebar");

hamburgerMenu.addEventListener('click', 
    async function () {
        clicked = !clicked;
        menu.style.display = !clicked ? 'block' : 'none';

        if (formContainer != null) {
            hamburgerMenu.src = clicked ? "/files/hamburger-menu.png" : "/files/close.png";
            formContainer.style.display = clicked ? 'block' : 'none';
        } else {
            hamburgerMenu.src = clicked ? "/files/hamburger-menu.png" : "/files/close.png";
        }
    }
);