# tamk-ohsyte-2024

TAMK / Ohjelmoinnin syventävät tekniikat 2024

## Java

Olio-ohjelmointia Javalla.

### Arvo-olio eli value object

Arvo-olio on luokan suunnittelumalli, jossa tallennetaan 
jokin alkeistyypin (näissä esimerkeissä
`int`) arvo ja valvotaan, että se pysyy tietyissä rajoissa.

Abstrakti luokka `IntRange` sisältää kaikki tällaisten
luokkien tarvitsemat mekanismit. Tästä luokasta ei voi tehdä
olioita, vaan siitä periytetään aliluokka käyttämällä Javan
`extends`-avainsanaa (kts. esim. `Year`, `Month` ja `Day`-luokat).

Tämän mallin avulla voi luoda arvo-olioita eri sovellusalueille.
Esimerkkeinä ovat aliluokat `Volume` ja `Pan`, jotka eivät liity 
mitenkään päiväyksiin tai kellonaikoihin.

### Rajapinta

Rajapinta eli interface on kokoelma metodien määrityksiä, joilla
ei ole konkreettista toteutusta. Kun jokin luokka ilmoittaa
toteuttavansa rajapinnan, sen pitää sisältää toteutukset tässä
rajapinnassa mainituille metodeille, joko suoraan tai perittyinä
joltain omalta yliluokaltaan.

Rajapintaa käytetään kun halutaan määritellä yhteiset toiminnot
joillekin luokille, joilla saattaa olla aivan erilainen luokkahierarkia.
Javassa ei ole moniperintää, joten rajapinnan käyttäminen on ainoa
tapa saada toteutettua useita tällaisia toimintojoukkoja.

Javan standardikirjastoissa käytetään rajapintoja erittäin paljon,
kts. esim. `java.util.Comparable`. Myös graafisen käyttöliittymän
ohjelmoinnissa käytetään rajapintoja paljon tapahtumankäsittelijöissä
(esim. JavaFX-kirjaston ChangeListener).

### Geneeriset tyypit

Javassa yleisimmin käytetyt tietorakenteet on määritelty pakkauksessa
`java.util`. Ne perustuvat geneerisyyteen, eli esimerkiksi listan
sisältämien alkioiden tyyppi annetaan geneerisenä parametrina:

    List<Event> events = new ArrayList<>();

Tietorakenteet on määritelty rajapintoina, eli esimerkiksi `List`-rajapinnasta
ei voi tehdä konkreettista toteutusta, vaan käytetään `ArrayList`-luokkaa,
joka toteuttaa `List<T>`-rajapinnan (tai jotain muuta vastaavaa luokkaa).

Ohjenuora: "program to the interface, not to the implementation"

Kun käytetään rajapintaa tietotyyppinä, konkreettista toteutusta on helppo
vaihtaa tarvittaessa.

### Singleton-suunnittelumalli

Singleton tarkoittaa luokkaa, josta voi olla olemassa vain yksi olio koko
ohjelmassa. Tämä saadaan aikaan piilottamalla luokan rakentaja, tekemällä
luokan sisäinen staattinen olio siitä itsestään, ja palauttamalla pyydettäessä
viite tähän sisäiseen olioon. Sen pitää olla `final`, jotta viitteen saaja
ei pysty muuttamaan sitä.

Tässä repositoriossa `java/Generics/EventManager.java` on esimerkki
singleton-suunnittelumallin käytöstä.

### Strategy-suunnittelumalli

Strategy-suunnittelumallin avulla on helppo vaihtaa toteutusta tarpeen
mukaan. Strategioille määritellään yhteinen rajapinta, ja sitten tehdään
yksi tai useampia luokkia, jotka toteuttavat rajapinnan. Toteutusluokka
voidaan antaa käyttäjälle joko rakentajan parametrina tai erillisellä
setterillä. Parametrin tyyppinä käytetään määriteltyä rajapintaa, ei mitään
konkreettista luokkaa. Käyttäjä ei tiedä eikä välitä miten strategia on
toteutettu, vaan käyttää sitä tunnetun rajapinnan kautta.

Tässä repositoriossa `java/Strategy/EventManager.java` sekä rajapinta
`EventProvider` ja sen toteuttavat luokat ovat esimerkki strategy-suunnittelumallin
käytöstä.
