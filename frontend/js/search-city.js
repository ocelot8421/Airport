const searchBtn = document.getElementById("searchBtn");
const cityJSON = {
    name: '',
    coordinates: { long: null, width: null }
}

/*
Add search function to "Search" buttun.
At first, it gets the name of selected city then appers above the button 
at the end of "Selected:" line on the webpage. Afterwards, it is sent to backend.
*/
searchBtn.addEventListener("click", (e) => {
    let city = getSelectedCity();
    getSelectedCity();
    //sendCityToBackend(city);

})

/*
It gets the name of selected city waht is appers above the button at "Selected:" line on the webpage.
*/
function getSelectedCity() {
    selectElement = document.querySelector('#select1');
    output = selectElement.value;
    document.querySelector('.output').textContent = output;
    //return output;
}

/*

*/
//function sendCityToBackend(city) {
//    cityJSON.name = city;

//    let tr = button.parentElement.parentElement.parentElement;
//    let data = collectConnections(tr);
//    let fetchOptions = {
//        method: "POST",
//        mode: "cors",
//        cache: "no-cache",
//        headers: {
//            "Content-Type": "application/json"
//        },
//        body: JSON.stringify(data)
//    };
//    fetch(`http://localhost:8080/medicines/put/${data.id}`, fetchOptions)
//        .then(response => response.json())
//        .catch((error) => console.error(error))
//        .finally(() => startGetMedication());

//}

