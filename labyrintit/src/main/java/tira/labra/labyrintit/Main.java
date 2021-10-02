package tira.labra.labyrintit;

import tiralabra.domain.Labyrintti;
import java.util.Scanner;
//http://weblog.jamisbuck.org/2011/2/3/maze-generation-sidewinder-algorithm.html#

/**
 *
 * @author Mirka
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner l = new Scanner(System.in);
        System.out.print("Koko: ");
        int size = Integer.valueOf(l.nextLine());
        Labyrintti lab = new Labyrintti(size);
        
        lab.tulosta();
        System.out.println("");
        
        lab.sideWinder();
        System.out.println("");
        
        Labyrintti laby = new Labyrintti(size);
        laby.wilsons();
        
    }
    
}