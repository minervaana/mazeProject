# Testikattavuusraportti
## JUnit testaus
Alla olevasta kuvasta näkyy JUnit testien testikattavuus.

![Testikattavuus](./Pictures/testikattavuus2.png)

### Käyttöliittymä ja Testeri-luokka
    Nämä on jätetty JUnit testeistä pois, sillä niitä ei ole syytä testata. 
    Testeri-luokassa on toteutettu tehokkuusvertailut, joten siellä olevat metodit antavat koneesta riippuen eri arvoja.
    Nämä on jätetty testikattavuusraportissa huomioimatta.
    
### Labyrintti
    Labyrintista testataan, että algorimtit tuottavat polut alusta loppuun, eli labyrintti on oikeasti mahdollista ratkaista.
    Polut on testattu useammilla eri koilla (5, 10, 20, 100), mutta tällä hetkellä testauskoko on 100.
    Tulostus- metodi on jätetty Unit testauksesta pois, mutta se on testattu monta kertaa manuaalisesti.
    Muut Labyrintti-luokan metodit on testattu kattavilla yksikkötesteillä.
    
### Ruutu
    Sama juttu kuin Labyrintti-luokassa, tulostus-metodi on testattu manuaalisesti useaan otteeseen 
    ja muut metodit on testattu kattavasti.
    
### Lista ja Pari
    Kattavat metodien yksikkötestit, ja testikattavuus näyttää näiden osalta hyvältä.
    
## Tehokkuustestit
>Tehokkuustestien toteutuksen ja vertailun löydät [täältä](https://github.com/karppienkingi/mazeProject/blob/main/Dokumentaatio/toteutusdokumentti.md#tehokkuustestit)

