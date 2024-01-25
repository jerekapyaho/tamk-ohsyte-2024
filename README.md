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
