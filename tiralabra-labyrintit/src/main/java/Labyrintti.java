
import java.util.Random;

/**
 * Labyrintin konstruktori, sisältää myös algoritmit
 * @author Mirka
 */
public class Labyrintti {

    /**
     *labyrintin leveys
     */
    final int leveys;

    /**
     * labyrintin korkeus
     */
    final int korkeus;

    /**
     *labyrintin ruudukko
     */
    private Ruutu[][] lab;
    
    /**
     * Luo labyrintin, joka koostuu Ruuduista
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
     * Tulostaa tämän labyrintin.
     * Tulostaa ensin ylimmän seinän, sillä ruuduilla on (tässä vaiheessa) vain kolme seinää
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
     * Suorittaa sideWinder-algoritmin tälle labyrintille ja tulostaa ruudulle sokkelon
     * Lisäksi poistaa alku- ja loppuseinän
     */
    public void sideWinder() {
        Random random = new Random();
        int startti = 0;
        
        Ruutu alku = this.lab[0][0];
        Ruutu loppu = this.lab[korkeus-1][leveys-1];
        alku.poistaSeina(0);
        loppu.poistaSeina(2);

        for (int i = 0; i < this.korkeus; i++) {
            startti = 0;
            
            for (int j = 0; j < this.leveys; j++) {
                int r1 = random.nextInt(2);

                if (i > 0 && (j + 1 == this.leveys || r1 == 0)) {
                    int r2 = random.nextInt(j - startti + 1);
                    Ruutu valittu = lab[i - 1][startti+r2];
                    valittu.poistaSeina(1);
                    startti= j+1;
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
}
