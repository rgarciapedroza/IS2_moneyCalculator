window.onload = function () {
    const formContainer = document.querySelector('.form_container');
    const signup = document.querySelector('.signup_form_button');
    const login = document.querySelector(".login_form_button");
    const deviceTypes = ['desktop', 'mobile'];
    
    signup.addEventListener('click', () => {
        formContainer.classList.add('active');
    })
    
    login.addEventListener('click', () => {
        formContainer.classList.remove('active');
    })

    function arraysEqual(a, b) {
        if (a === b) return true;
        if (a == null || b == null) return false;
        if (a.length !== b.length) return false;
      
        for (var i = 0; i < a.length; ++i) {
          if (a[i] !== b[i]) return false;
        }
        return true;
      }

    let currentDevice;

    function determineClass() {
        let returner = [];
        var screenWidth = window.innerWidth;
        if (screenWidth > 390) {
            returner.push('desktop');
        } else {
            returner.push('mobile');
        }
        return returner;
    }

    function applyResponsiveClasses() {
        //Get array of all classes that apply to current circumstances
        let buffer = determineClass();
        //Determine if we need to change classes
        if (!arraysEqual(buffer, currentDevice)) {
            console.log(currentDevice)
            //If we do, update current device
            currentDevice = buffer.slice();
    
            // Iterate through all elements in the DOM
            var allElements = document.getElementsByTagName('*');
            for (var i = 0; i < allElements.length; i++) {
                var element = allElements[i];
                //Remove all device classes
                for (var j in deviceTypes) element.classList.remove(deviceTypes[j]);
                //Add current device classes
                for (var j in currentDevice) element.classList.add(currentDevice[j]);
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

