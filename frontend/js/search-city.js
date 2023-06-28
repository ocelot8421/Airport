const searchBtn = document.getElementById("searchBtn");

searchBtn.addEventListener("click", (e) => {
    const username = loginForm.username.value;
    const password = loginForm.password.value;

    if (username === "user" && password === "web_dev") {
        getOption();
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})

function getOption() {
    selectElement = document.querySelector('#select1');
    output = selectElement.value;
    document.querySelector('.output').textContent = output;
}

