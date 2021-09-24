package tiralabra.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import tiralabra.util.Pari;
//https://people.cs.ksu.edu/~ashley78/wiki.ashleycoleman.me/index.php/Wilson's_Algoritm.html

/**
 * Labyrintin konstruktori, sisältää myös algoritmit
 *
 * @author Mirka
 */
public class Labyrintti {

    /**
     * labyrintin leveys
     */
    final int leveys;

    /**
     * labyrintin korkeus
     */
    final int korkeus;

    /**
     * labyrintin ruudukko
     */
    private Ruutu[][] lab;

    /**
     * Luo labyrintin, joka koostuu Ruuduista
     *
     * @param leveys määrittää labyrintin korkeuden ja leveyden.
     */
    public Labyrintti(int leveys) {
        this.leveys = leveys;
        this.korkeus = leveys;
        this.lab = new Ruutu[korkeus][leveys];
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                lab[i][j] = new Ruutu(i, j);
            }
        }
    }
    
    /**
     * Palauttaa labyrintin ruudun koordinaattien mukaan
     * @param y ruudun y-koordinaatti
     * @param x ruudun x-koordinaatti
     * @return 
     */
    public Ruutu getRuutu(int y, int x) {
        return this.lab[y][x];
    }
    
    /**
     * Wilsonin algoritmiä varten, tämä metodi palauttaa ruudun naapurit, ja suunnan mistä siihen on tultu
     * @param r ruutu, jonka naapurit palautetaan
     * @return lista viereisistä ruuduista, Pari muodossa
     */
    public LinkedList getNaapurit(Ruutu r) {
        LinkedList<Pari> lista = new LinkedList<>();
        
        if (r.getY() + 1 < this.leveys) {
            lista.add(new Pari(getRuutu(r.getY() + 1, r.getX()), 'e'));
        }
        if (r.getX() - 1 >= 0) {
            lista.add(new Pari(getRuutu(r.getY(), r.getX() - 1), 'l'));
        }
        if (r.getX() + 1 < this.leveys) {
            lista.add(new Pari(getRuutu(r.getY(), r.getX() + 1), 'i'));
        }
        if (r.getY() - 1 >= 0) {
            Ruutu ylempi = this.getRuutu(r.getY() - 1, r.getX());
            if (!ylempi.getWalls()[1]) {
                lista.add(new Pari(getRuutu(r.getY() - 1, r.getX()), 'p'));
                
            }
        }
        
        return lista;
    }

    /**
     * Tulostaa tämän labyrintin. Tulostaa ensin ylimmän seinän, sillä ruuduilla
     * on (tässä vaiheessa) vain kolme seinää
     */
    public void tulosta() {
        for (int i = 0; i < this.leveys; i++) {
            System.out.print(" _ ");
        }
        System.out.println("");
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                Ruutu r = this.lab[i][j];
                r.tulostaRuutu();
                if (j == this.korkeus - 1) {
                    System.out.println("");
                }
                
            }
        }
    }

    /**
     * Suorittaa sideWinder-algoritmin tälle labyrintille ja tulostaa ruudulle
     * sokkelon Lisäksi poistaa alku- ja loppuseinän
     */
    public void sideWinder() {
        Random random = new Random();
        int startti = 0;
        
        Ruutu alku = this.lab[0][0];
        Ruutu loppu = this.lab[korkeus - 1][leveys - 1];
        alku.poistaSeina(0);
        loppu.poistaSeina(2);
        
        for (int i = 0; i < this.korkeus; i++) {
            startti = 0;
            
            for (int j = 0; j < this.leveys; j++) {
                int r1 = random.nextInt(2);
                
                if (i > 0 && (j + 1 == this.leveys || r1 == 0)) {
                    int r2 = random.nextInt(j - startti + 1);
                    Ruutu valittu = lab[i - 1][startti + r2];
                    valittu.poistaSeina(1);
                    startti = j + 1;
                } else if (j + 1 < this.leveys) {
                    Ruutu ka = this.lab[i][j];
                    Ruutu seuraava = this.lab[i][j + 1];
                    ka.poistaSeina(2);
                    seuraava.poistaSeina(0);
                    
                }
            }
        }
        
        tulosta();
    }
    
    /**
     * Toinen generointialgoritmi, Wilsonin algoritmi.
     * Luo sokkelon päättömän kävelyn perusteella
     */
    public void wilsons() {
        
        LinkedList<Pari> polku = new LinkedList<>();
        
        Boolean[][] visited = new Boolean[this.korkeus][this.leveys];
        
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                visited[i][j] = false;
                
            }
        }
        
        Random y = new Random();
        Random x = new Random();
        Ruutu alku = this.lab[y.nextInt(this.korkeus)][x.nextInt(this.leveys)];
        Ruutu nyt = alku;
        visited[alku.getY()][alku.getX()] = true;   //Choose a random cell and add it to the visited list

        int jaljella = this.korkeus * this.leveys - 1;
        
        while (jaljella > 0) {
            
            boolean eikayty = false;
            while (!eikayty) {
                nyt = this.lab[y.nextInt(this.korkeus)][x.nextInt(this.leveys)];
                if (!visited[nyt.getY()][nyt.getX()]) {
                    eikayty = true; //Choose another random cell (Don’t add to visited list). This is the current cell
                }
            }
            
            LinkedList<Pari> lista = getNaapurit(nyt);
            Collections.shuffle(lista);
            Character suunta = lista.get(0).getSuunta();
            
            polku.add(new Pari(nyt, suunta)); //Save the direction that you traveled on the previous cell

            nyt = lista.get(0).getRuutu(); //Choose a random cell that is adjacent to the current cell (Don’t add to visited list). This is your new current cell.

            if (!visited[nyt.getY()][nyt.getX()]) {
                continue; // If the current cell is not in the visited cells list. Go to 3
            } else {
                
                while (!polku.isEmpty()) {
                    Pari p = polku.poll();
                    Ruutu r = p.getRuutu();
                    Character s = p.getSuunta();
                    
                    switch (s) {
                        case 'p':
                            Ruutu ylempi = getRuutu(r.getY() - 1, r.getX());
                            ylempi.poistaSeina(1);
                            break;
                        case 'e':
                            p.getRuutu().poistaSeina(1);
                            break;
                        case 'l':
                            p.getRuutu().poistaSeina(1);
                            Ruutu vasen = getRuutu(r.getY(), r.getX() - 1);
                            vasen.poistaSeina(2);
                        //poista vasemman itäinen/oikea seinä
                        case 'i':
                            p.getRuutu().poistaSeina(2);
                            Ruutu oikea = getRuutu(r.getY(), r.getX() + 1);
                            oikea.poistaSeina(0);
                        //poista seuraavan läntinen/vasen seinä
                    }

                    visited[r.getY()][r.getX()] = true;
                    jaljella--;
            
                }
                //Starting at the cell selected in step 2, follow the arrows and remove the edges that are crossed.
                //Add all cells that are passed into the visited list
            }
            
            //If all cells have not been visited. Go to 2
            

        }
        tulosta();
    }
}

