import { cityJSON } from "./search-city.js";

// Initialize and add the map
let map;

//async function initMap() {
export const initMap = async () => {
    // The location
    let position = { lat: cityJSON.coordinates.latitude, lng: cityJSON.coordinates.longitude };
    // Request needed libraries.
    //@ts-ignore
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");

    // The map, centered at Uluru
    map = new Map(document.getElementById("map"), {
        zoom: 4,
        center: position,
        mapId: "MAP_ID",
    });

    // The marker, positioned at Uluru
    const marker = new AdvancedMarkerElement({
        map: map,
        position: position,
        title: "City",
    });
}