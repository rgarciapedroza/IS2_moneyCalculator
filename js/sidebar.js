document.addEventListener('DOMContentLoaded', function(){
    const buttonHome = document.querySelector(".homeTab");
    const buttonProfile = document.querySelector(".profileTab");
    
    buttonHome.addEventListener("click", homeClicked);
    buttonProfile.addEventListener("click", profileClicked);
    
    function homeClicked(){
        buttonProfile.classList.remove('clicked');
        buttonHome.classList.remove('not-clicked')
        buttonHome.classList.add('clicked');
    }

    function profileClicked(){
        buttonProfile.classList.add('clicked');
        buttonHome.classList.add('not-clicked');
    }
});
