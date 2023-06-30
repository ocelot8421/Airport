import { initMap } from "./googleMap.js";

const searchBtn = document.getElementById("searchBtn");
export const cityJSON = {
    name: '',
    wikiDataId: '',
    coordinates: { longitude: null, latitude: null },
    error: ''
}
/*
wikiDataId example: Paris -> https://www.wikidata.org/wiki/Q90.
This id is neccessary to find exact city in GeoDB.
*/
const cityList = {
    London: { name: 'London', wikiDataId: 'Q84' },
    New_Delhi: { name: 'New Delhi', wikiDataId: 'Q987' },
    New_York: { name: 'New York', wikiDataId: 'Q60' },
    Tokyo: { name: 'Tokyo', wikiDataId: 'Q1490' },
    Paris: { name: 'Paris', wikiDataId: 'Q90' }
}

/*
Add search function to "Search" buttun.
At first, it gets the name of selected city then appers above the button 
at the end of "Selected:" line on the webpage. Afterwards, it is sent to backend.
*/
searchBtn.addEventListener("click", (e) => {
    let city = getSelectedCity();
    sendCityToBackend(city);
})

/*
It gets the name of selected city waht is appers above the button at "Selected:" line on the webpage.
*/
function getSelectedCity() {
    const selectElement = document.querySelector('#select1');
    const output = selectElement.value;

    for (let e in cityList) {
        if (output == `${cityList[e].name}`)
            cityJSON.wikiDataId = `${cityList[e].wikiDataId}`;
    }

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
        .catch((error) => console.error(error))
        .then(data => saveCoordinates(data));
}

function saveCoordinates(data) {
    cityJSON.coordinates.longitude = data.longitude;
    cityJSON.coordinates.latitude = data.latitude;
    cityJSON.error = data.error;
    console.log(cityJSON.error);
    initMap();
}