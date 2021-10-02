package tira.labra.labyrintit;

import tiralabra.domain.Labyrintti;
import java.util.Scanner;

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
        System.out.print("Kirjoita tähän luotavan labyrintin korkeus: ");
        int size = Integer.valueOf(l.nextLine());
        
        Labyrintti lab1 = new Labyrintti(size);
        lab1.tulosta();
        System.out.println("");
        System.out.println("Luodaan labyrintti sidewinder algoritmia käyttäen");
        System.out.println("");
        
        lab1.sideWinder();
        System.out.println("");
        
        System.out.println("Luodaan labyrintti käyttäen Wilsonin algoritmia");
        System.out.println("");
        Labyrintti lab2 = new Labyrintti(size);
        lab2.wilsons();
        
    }
    
}