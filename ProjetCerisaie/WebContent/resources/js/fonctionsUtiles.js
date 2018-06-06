function currentMenu() {
// Get the container element
    var listeMenus = document.getElementById("menus");

// Get all buttons with class="btn" inside the container
    var menu = listeMenus.getElementsByClassName("menu");

// Loop through the buttons and add the active class to the current/clicked button
    for (var i = 0; i < menu.length; i++) {
        menu[i].addEventListener("click", function () {
            var current = document.getElementsByClassName("active");
            current[0].className = current[0].className.replace(" active", "");
            this.className += " active";
        });
    }
}