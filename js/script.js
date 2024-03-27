window.onload = function () {
    const formContainer = document.querySelector('.form_container');
    const signup = document.querySelector('.signup_form_button');
    const login = document.querySelector(".login_form_button")
    
    signup.addEventListener('click', () => {
        formContainer.classList.add('active');
    })
    
    login.addEventListener('click', () => {
        formContainer.classList.remove('active');
    })

    let currentDevice;
    var deviceTypes = ['desktop', 'mobile'];
    function determineClass() {
        var screenWidth = window.innerWidth;
        if (screenWidth > 390) {
            return 'desktop';
        } else {
            return 'mobile';
        }
    }

    function applyResponsiveClasses() {
        let buffer = determineClass();
        if (buffer !== currentDevice) {
            currentDevice = buffer.slice();
            let others = deviceTypes.slice();
            others.splice(deviceTypes.indexOf(currentDevice), 1);
    
            // Iterate through all elements in the DOM
            var allElements = document.getElementsByTagName('*');
            for (var i = 0; i < allElements.length; i++) {
                var element = allElements[i];
                element.classList.add(currentDevice);
                for (var j in others) {
                    element.classList.remove(others[j]);
                }
            }
        }
    }
    
    // Call applyResponsiveClasses function on page load
    applyResponsiveClasses();
    
    // Add event listener for window resize event
    window.addEventListener('resize', function() {
        // Call applyResponsiveClasses function whenever window is resized
        applyResponsiveClasses();
    });
}

