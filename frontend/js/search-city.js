const searchBtn = document.getElementById("searchBtn");
const cityJSON = {
    name: '',
    coordinates: { long: null, width: null }
}

/*
Add search function to "Search" button.
At first, it gets the name of selected city then appears above the button
at the end of "Selected:" line on the webpage. Afterwards, it is sent to backend.
*/
searchBtn.addEventListener("click", (e) => {
    let city = getSelectedCity();
    sendCityToBackend(city);

})

/*
It gets the name of selected city wait is appears above the button at "Selected:" line on the webpage.
*/
function getSelectedCity() {
    const selectElement = document.querySelector('#select1');
    const output = selectElement.value;
    document.querySelector('.output').textContent = output;
    return output;
}

/*
Send city name to backend.
*/
function sendCityToBackend(city) {
    cityJSON.name = city;

    let fetchOptions = {
        method: "POST",
        mode: "cors",
        cache: "no-cache",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cityJSON)
    };
    fetch(`http://localhost:8081/search/city`, fetchOptions)
        .then(response => response.json())
        .catch((error) => console.error(error));
}

