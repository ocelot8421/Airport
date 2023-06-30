<img src="screenshots/login.JPG" height="450"><img src="screenshots/mapAfterSearch.JPG" height="450">

# Specification (hungarian)
Fejlesztési feladat
Egy szabadon választott technológia segítségével (android, java/spring, php/html, python / tkiner, asp.net stb) egy bejelentkező webes felületet kellene implementálni. A felületen felhasználónév és jelszó adatok megadására lenne lehetőség. A felhasználónév és a jelszó legyen a kódba „beégetve”. A bejelentkezés gombra kattintva, ha helyesen lettek megadva a bejelentkezési adatok (Ellenkező esetben jelenjen meg, hogy „Hibás belépési adatok”), nyíljon meg egy új ablak, ahol jelenjen meg egy lenyíló választó menü 5db városnévvel. Lenyitás után kiválasztunk egy várost és a keresés gombra kattintva küldjük el a városnevet egy POST kéréssel a http://geodb-cities-api.wirefreethought.com/docs/api/find-places weboldal API-jának, ahonnan válaszként a paraméterek között visszaérkezik a város szélességi és hosszúsági koordinátája. A koordinátákat az oldal jelenítse meg egy google térképen.
A megoldás elküldéséhez szükség lesz egy privát github repository-ra, amin megnézzük a megoldás kódját.

# Operations
backend port: 8081

| Operation | Url           | description                                            |
|-----------|---------------|--------------------------------------------------------|
| POST      | /login/submit | Retrieve username and password - non secured!   //TODO |    
| POST      | /search/city  | Search city name in GeoDB (using wkik-data-id)         |

# Documentations
- GoeDB: https://github.com/wirefreethought/geodb-java-client

# Layers
```mermaid
sequenceDiagram
    participant Frontend
    participant SearchControll
    participant SearchService
    participant GeoDBApiService
    participant GeoDbApi
        
    Frontend-->>SearchControll: { Paris, Q90 }
    
    activate SearchControll
    Note right of SearchControll: cityDTO<br/>searchCity<br/>(cityDTO)<br/>/JSON -> cityDTO/
    SearchControll-->>SearchService: Paris, Q90
    deactivate SearchControll
    
    activate SearchService
    Note right of SearchService: cityDTO <br/> askCoordinates <br/> (cityDTO)
    SearchService-->>GeoDBApiService: Paris, Q90
    deactivate SearchService
    
    activate GeoDBApiService
    Note right of GeoDBApiService: PopulatedPlaceSummary <br/> findPopulatedPlaces <br/>(cityDTO)
    GeoDBApiService-->>GeoDbApi: Paris (string)
    activate GeoDbApi
    rect rgb(50, 50, 50)
    Note left of GeoDbApi: PopulatedPlacesResponse<br/>findPlaces<br/>(FindPlacesRequest)
    activate GeoDBApiService
        GeoDbApi-->>GeoDBApiService: Paris ...
        GeoDbApi-->>GeoDBApiService: Parish of<br/>Saint Andrew  ...
        GeoDbApi-->>GeoDBApiService: arrondissements<br/>of Paris ...
        GeoDbApi-->>GeoDBApiService: ... (50 results) 
    end
    
    deactivate GeoDbApi
    Note right of GeoDBApiService: PopulatedPlaceSummary<br/> findCityData<br/>(PopulatedPlacesResponse)
    deactivate GeoDBApiService
    
    activate GeoDBApiService
    Note right of GeoDBApiService: void printNumOfAllResult()<br/>/metadata, citiName/
    deactivate GeoDBApiService
    
    GeoDBApiService-->>SearchService: Paris summary data<br/>(PopulatedPlaceSummary)
    deactivate GeoDBApiService
    
    activate SearchService
    Note right of SearchService: cityDTO<br/>askCoordinates<br/>(cityDTO)
    activate SearchService
    Note right of SearchService: CityDTO<br/>saveCoordinates<br/>(PopulatedPlaceSummary)<br/>/No result check/
    deactivate SearchService
    rect rgb(50, 50, 50)
        SearchService-->>SearchControll: Paris<br/>Q90<br/>lat: 48.856666666<br/>lng: 2.35222222
    end
    deactivate SearchService
    
    activate SearchControll
    Note right of SearchControll: cityDTO<br/>searchCity<br/>(cityDTO)<br/>/cityDTO -> JSON/
    SearchControll-->>Frontend: Paris, Q90,<br/>lat: 48.856666666,<br/>lng: 2.35222222
    deactivate SearchControll

```

`+: Public`
`-: Private`
`#: Protected`
`~: Package/Internal`
(More info about mermaid sequenceDiagram: https://mermaid.js.org/syntax/sequenceDiagram.html)

## Used code sources:
- https://medium.com/swlh/how-to-create-your-first-login-page-with-html-css-and-javascript-602dd71144f1
- https://www.geeksforgeeks.org/how-to-get-selected-value-in-dropdown-list-using-javascript/
- https://developers.google.com/maps/documentation/javascript/adding-a-google-map#maps_add_map-javascript