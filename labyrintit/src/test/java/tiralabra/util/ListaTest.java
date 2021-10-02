package tiralabra.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirka
 */
public class ListaTest {
    
    private Lista lista = new Lista<>();
    
    public ListaTest() {
        
    }
    
    @Before
    public void setUp() {
        this.lista.lisaa(24);
        this.lista.lisaa(55);
        this.lista.lisaa(1);
        this.lista.lisaa(69);
    }
    
    @After
    public void tearDown() {
        this.lista = new Lista<>();
    }

    /**
     * Testaa lisaa metodia luokasta Lista.
     */
    @Test
    public void testLisaa() {
        
        System.out.println("lisaa");
        Integer arvo = 28;
        
        lista.lisaa(arvo);
        Object odotettu = 28;
        Object tulos = lista.arvo(lista.koko()-1);
        assertEquals(odotettu, tulos); 
    }

    /**
     * Testaa poista metodia luokasta Lista.
     */
    @Test
    public void testPoista() {
        System.out.println("poista");
        lista.poista(1);
        boolean onko = lista.sisaltaa(1);
        if (onko == false) {
            return;
        } 
    }
    
    /**
     * Testaa poista metodia luokasta Lista
     * Arvoja ei poistu, jos listalta poistetaan arvo, joka siellä ei ole.
     */
    @Test
    public void testEiPoista() {
        System.out.println("eiPoista");
        int kokoEnnen = lista.koko();
        lista.poista(200);
        int kokoJalkeen = lista.koko();
        assertEquals(kokoEnnen, kokoJalkeen); 
    }

    /**
     * Testaa veda metodia luokasta Lista.
     */
    @Test
    public void testVeda() {
        System.out.println("veda");
        Object arvo = lista.veda();
        boolean onko = lista.sisaltaa(arvo);
        if (onko == false) {
            return;
        }
    }

    /**
     * Testaa arvo metodia luokasta Lista.
     */
    @Test
    public void testArvo() {
        System.out.println("arvo");        
        lista.lisaa(500);
        int indeksi = lista.koko()-1;
        Object odotettu = 500;
        Object tulos = lista.arvo(indeksi);
        assertEquals(odotettu, tulos);
        
    }
    
    /**
     * Testaa arvo metodia luokasta Lista.
     * Palauttaa null, jos indeksi on listan ulkopuolelta.
     */
    @Test
    public void testArvoListanUlkopuolella() {
        assertNull(lista.arvo(11));
    }

    /**
     * Testaa sisaltaa metodia luokasta Lista.
     * Palauttaa true, jos lista sisältää arvon.
     */
    @Test
    public void testSisaltaa() {
        System.out.println("sisaltaa");
        boolean odotettu = true;
        boolean tulos = lista.sisaltaa(1);
        assertEquals(odotettu, tulos);  
    }
    
    /**
     * Testaa sisaltaa metodia luokasta Lista.
     * Palauttaa false kun listalla ei ole arvoa.
     */
    @Test
    public void testEiSisalla() {
        System.out.println("sisaltaa");
        boolean odotettu = false;
        boolean tulos = lista.sisaltaa(499);
        assertEquals(odotettu, tulos);
        
    }

    /**
     * Testaa onTyhja metodia luokasta Lista.
     */
    @Test
    public void testOnTyhja() {
        System.out.println("onTyhja");
        boolean odotettu = false;
        boolean tulos = lista.onTyhja();
        assertEquals(odotettu, tulos);
    }
    
    /**
     * Testaa onTyhja metodia luokasta Lista.
     * Tarkistaa toimiiko, oikein jos lista on tyhjä.
     */
    @Test
    public void testEiOleTyhja() {
        System.out.println("eiOleTyhja");
        boolean odotettu = true;
        Lista<Integer> apuLista = new Lista<>();
        boolean tulos = apuLista.onTyhja();
        assertEquals(odotettu, tulos);
    }

    /**
     * Testaa arvonIndeksi metodia luokasta Lista.
     */
    @Test
    public void testArvonIndeksi() {
        System.out.println("arvonIndeksi");
        lista.lisaa(2);
        int odotettu = 4;
        int tulos = lista.arvonIndeksi(2);
        assertEquals(odotettu, tulos);    
    }

    /**
     * Testaa koko metodia luokasta Lista.
     */
    @Test
    public void testKoko() {
        System.out.println("koko");
        int odotettu = 4;
        int tulos = lista.koko();
        assertEquals(odotettu, tulos);
    }
    
}
