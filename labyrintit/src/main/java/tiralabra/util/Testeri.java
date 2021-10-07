package tiralabra.util;

import java.util.Arrays;
import tiralabra.domain.Labyrintti;

/**
 * Testeri luokka on tehokkuustestejä varten luotu luokka.
 * @author Mirka
 */
public class Testeri {

    /**
     * Taulukko labyrintin kokoja varten, joilla tehokkuustestit pyöritetään.
     */
    private int[] inputs;

    /**
     * Konstruktori, joka alustaa input-taulukon.
     */
    public Testeri() {
        this.inputs = new int[]{10, 100, 1000, 5000};

    }

    /**
     * Metodi, joka pyörittää kaikki tehokkuustestit
     */
    public void testaaTehokkuudet() {
        testaaWilsons();
        testaaSidewinder();
    }

    /**
     * Testaa wilsons-algoritmin. 
     * Testaa jokaisella labyrintin koolla 10 kertaa, jonka jälkeen ottaa lopulliseksi ajaksi taulukon mediaanin. 
     */
    private void testaaWilsons() {
        System.out.println("Wilsonin-algoritmin tehokkuustestit");
        for (int i = 0; i < inputs.length; i++) {
            long[] kerrat = new long[10];
            

            for (int j = 0; j < kerrat.length; j++) {
                Labyrintti lab = new Labyrintti(inputs[i]);
                long start = System.nanoTime();
                lab.wilsons();
                long end = System.nanoTime() - start;
                kerrat[j] = end;
                
            }
            Arrays.sort(kerrat);
            long aika = kerrat[kerrat.length /2];
            System.out.println(inputs[i] + ": " + aika);
            
        }
        System.out.println("");
    }

    /**
     * Testaa wilsons-algoritmin. 
     * Testaa jokaisella labyrintin koolla 10 kertaa, jonka jälkeen ottaa lopulliseksi ajaksi taulukon mediaanin. 
     */
    private void testaaSidewinder() {
        System.out.println("Sidewinder-algoritmin tehokkuustestit");
        for (int i = 0; i < inputs.length; i++) {
            long[] kerrat = new long[10];
            

            for (int j = 0; j < kerrat.length; j++) {
                Labyrintti lab = new Labyrintti(inputs[i]);
                long start = System.nanoTime();
                lab.sideWinder();
                long end = System.nanoTime() - start;
                kerrat[j] = end;
            }
            Arrays.sort(kerrat);
            long aika = kerrat[kerrat.length /2];
            System.out.println(inputs[i] + ": " + aika);
        }
    }
}
