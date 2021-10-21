package tira.labra.labyrintit;

import tiralabra.domain.Labyrintti;
import java.util.Scanner;
import tiralabra.util.Testeri;

/**
 *
 * @author Mirka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner l = new Scanner(System.in);
        

        while (true) {
            System.out.print("Kirjoita tähän luotavan labyrintin korkeus tai jätä tyhjäksi jos haluat lopettaa: ");
            try {
            int size = Integer.valueOf(l.nextLine());
            
            Labyrintti lab = new Labyrintti(size);
            System.out.println("Ennen algoritmien suorittamista, labyrintti näyttää tältä.");
            lab.tulosta();

            System.out.println("");
            System.out.println("Kumpaa algoritmia haluat käyttää? Kirjoita S tai W.");
            System.out.println("(S = sidewinder algoritmi ja W = wilson's algoritmi)");
            String algoritmi = l.nextLine();
            if (algoritmi.equals("S")) {
                System.out.println("");
                System.out.println("Luodaan labyrintti sidewinder algoritmia käyttäen");
                System.out.println("");

                lab.sideWinder();
                lab.tulosta();
                System.out.println("");
            } else if (algoritmi.equals("W")) {
                System.out.println("");
                System.out.println("Luodaan labyrintti käyttäen Wilsonin algoritmia");
                System.out.println("");

                lab.wilsons();
                lab.tulosta();
                System.out.println("");
            }
            
            System.out.println("");
            } catch (Exception e) {
                System.out.println("Kokoa ei annettu, lopetetaan...");
                break;
            }
        }

        //Testeri t = new Testeri(); //tehokkuustestit, jos haluat testata poista kauttamerkit
        //t.testaaTehokkuudet();

    }

}
