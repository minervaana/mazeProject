# Käyttöohje

Tämän projektin jar tiedosto löytyy releasena tästä repositoriosta. Voit ladata sen omalle koneellesi ja komentoriviltä suorittaa komennon 

    java -jar tiralabra-labyrintit-1.0-SNAPSHOT-jar

## Syötteet

Ohjelmassa voit luoda minkä kokoisia neliölabyrintteja tahansa. Ohjelma hyväksyy positiivisia kokonaislukuja, ja ohjelman kysymä koko määrittää labyrintin sivun pituuden.

Koon määrittämisen jälkeen voit päättää kumpaa algoritmia käyttäen labyrintti luodaan (W=wilsonin ja S=sidewinder). 

Sivuhuomautuksena wilsonin algoritmilla ei kannata tehdä yli 6000 kokoista labyrinttiä, ellet ole valmis odottamaan huomattavan kauan sen valmistumista. Lisäksi ohjelma hyväksyy myös 1 kokoisen labyrintin, mutta sen kokoisella ei ymmärrettävästi tule hienoa lanyrinttiä.

Testitiedostot löytyvät releasesta source codesta.