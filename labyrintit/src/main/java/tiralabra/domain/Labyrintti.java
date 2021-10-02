package tiralabra.domain;

import java.util.Random;
import tiralabra.util.Pari;
import tiralabra.util.Lista;

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
     *
     * @param y ruudun y-koordinaatti
     * @param x ruudun x-koordinaatti
     * @return
     */
    public Ruutu getRuutu(int y, int x) {
        return this.lab[y][x];
    }

    /**
     * Wilsonin algoritmiä varten, tämä metodi palauttaa ruudun naapurit, ja
     * suunnan mistä siihen on tultu
     *
     * @param r ruutu, jonka naapurit palautetaan
     * @return lista viereisistä ruuduista, Pari muodossa
     */
    public Lista getNaapurit(Ruutu r) {
        Lista<Pari> lista = new Lista<>();

        if (r.getY() + 1 < this.leveys) {
            lista.lisaa(new Pari(getRuutu(r.getY() + 1, r.getX()), 1));
        }
        if (r.getX() - 1 >= 0) {
            lista.lisaa(new Pari(getRuutu(r.getY(), r.getX() - 1), 0));
        }
        if (r.getX() + 1 < this.leveys) {
            lista.lisaa(new Pari(getRuutu(r.getY(), r.getX() + 1), 2));
        }
        if (r.getY() - 1 >= 0) {
            Ruutu ylempi = this.getRuutu(r.getY() - 1, r.getX());
            lista.lisaa(new Pari(getRuutu(r.getY() - 1, r.getX()), 3));

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
     * Luo sisäänkäynnit labyrinttiin.
     * Vasen ylä- ja oikea alanurkka.
     */
    public void luoSisaankaynnit() {
        Ruutu alku = this.lab[0][0];
        Ruutu loppu = this.lab[korkeus - 1][leveys - 1];
        
        alku.poistaSeina(0);
        loppu.poistaSeina(2);
    }

    /**
     * Suorittaa sideWinder-algoritmin tälle labyrintille ja tulostaa ruudulle
     * sokkelon Lisäksi poistaa alku- ja loppuseinän
     */
    public void sideWinder() {
        Random random = new Random();
        int startti = 0;

        luoSisaankaynnit();

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
     * Toinen generointialgoritmi, Wilsonin algoritmi. Luo sokkelon päättömän
     * kävelyn perusteella
     */
    public void wilsons() {

        luoSisaankaynnit();

        int[][] polku = new int[this.korkeus][this.leveys];
        Boolean[][] visited = new Boolean[this.korkeus][this.leveys];

        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                visited[i][j] = false;
                polku[i][j] = -1;
            }
        }

        Random y = new Random();
        Random x = new Random();
        Ruutu alustus = this.lab[y.nextInt(this.korkeus)][x.nextInt(this.leveys)];
        Ruutu nyt = alustus;
        visited[alustus.getY()][alustus.getX()] = true;

        int jaljella = this.korkeus * this.leveys - 1;

        while (jaljella > 0) {

            boolean eiKayty = false;
            while (!eiKayty) {
                nyt = this.lab[y.nextInt(this.korkeus)][x.nextInt(this.leveys)];
                alustus = nyt;
                if (!visited[nyt.getY()][nyt.getX()]) {
                    eiKayty = true;
                }
            }

            boolean kavele = true;

            while (kavele) {
                Lista<Pari> naapurit = getNaapurit(nyt);
                Random rand = new Random();
                Pari randPari = naapurit.arvo(rand.nextInt(naapurit.koko()));
                Ruutu r = randPari.getRuutu();
                int suunta = randPari.getSuunta();

                polku[nyt.getY()][nyt.getX()] = suunta;

                nyt = r;

                if (visited[nyt.getY()][nyt.getX()]) {
                    break;
                }

            }

            Ruutu seuraava = alustus;

            while (true) {

                int suunta = polku[seuraava.getY()][seuraava.getX()];

                switch (suunta) {
                    case 0:
                        this.lab[seuraava.getY()][seuraava.getX()].poistaSeina(0);
                        this.lab[seuraava.getY()][seuraava.getX() - 1].poistaSeina(2);
                        visited[seuraava.getY()][seuraava.getX()] = true;
                        jaljella--;
                        seuraava = this.lab[seuraava.getY()][seuraava.getX() - 1];
                        break;
                    case 1:
                        this.lab[seuraava.getY()][seuraava.getX()].poistaSeina(1);
                        visited[seuraava.getY()][seuraava.getX()] = true;
                        jaljella--;
                        seuraava = this.lab[seuraava.getY() + 1][seuraava.getX()];
                        break;
                    case 2:
                        this.lab[seuraava.getY()][seuraava.getX()].poistaSeina(2);
                        this.lab[seuraava.getY()][seuraava.getX() + 1].poistaSeina(0);
                        visited[seuraava.getY()][seuraava.getX()] = true;
                        jaljella--;
                        seuraava = this.lab[seuraava.getY()][seuraava.getX() + 1];
                        break;
                    case 3:
                        this.lab[seuraava.getY() - 1][seuraava.getX()].poistaSeina(1);
                        visited[seuraava.getY()][seuraava.getX()] = true;
                        jaljella--;
                        seuraava = this.lab[seuraava.getY() - 1][seuraava.getX()];
                        break;
                }
                if (visited[seuraava.getY()][seuraava.getX()]) {
                    break;
                }
            }
        }

        tulosta();
    }
}
