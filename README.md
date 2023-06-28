# Specification
Fejlesztési feladat
Egy szabadon választott technológia segítségével (android, java/spring, php/html, python / tkiner, asp.net stb) egy bejelentkező webes felületet kellene implementálni. A felületen felhasználónév és jelszó adatok megadására lenne lehetőség. A felhasználónév és a jelszó legyen a kódba „beégetve”. A bejelentkezés gombra kattintva, ha helyesen lettek megadva a bejelentkezési adatok (Ellenkező esetben jelenjen meg, hogy „Hibás belépési adatok”), nyíljon meg egy új ablak, ahol jelenjen meg egy lenyíló választó menü 5db városnévvel. Lenyitás után kiválasztunk egy várost és a keresés gombra kattintva küldjük el a városnevet egy POST kéréssel a http://geodb-cities-api.wirefreethought.com/docs/api/find-places weboldal API-jának, ahonnan válaszként a paraméterek között visszaérkezik a város szélességi és hosszúsági koordinátája. A koordinátákat az oldal jelenítse meg egy google térképen.
A megoldás elküldéséhez szükség lesz egy privát github repository-ra, amin megnézzük a megoldás kódját.

# Operations
| Operation             | description                                            |
|-----------------------|--------------------------------------------------------|
| GET    /login/submit  | Retrieve username and password - non secured!   //TODO |    
| POST   /intakes/add 	 | ADD a new MedicationIntake series via JSON.            |

# Used code sources:
- https://medium.com/swlh/how-to-create-your-first-login-page-with-html-css-and-javascript-602dd71144f1
- https://www.geeksforgeeks.org/how-to-get-selected-value-in-dropdown-list-using-javascript/