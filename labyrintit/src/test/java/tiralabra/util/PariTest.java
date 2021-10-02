package tiralabra.util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import tiralabra.domain.Ruutu;

/**
 *
 * @author Mirka
 */
public class PariTest {
    
    public PariTest() {
        
    }

    /**
     * Testaa getRuutu() metodia luokasta Pari.
     */
    @Test
    public void testGetRuutu() {
        System.out.println("getRuutu");
        Ruutu uusi = new Ruutu(0,0);
        Pari testipari = new Pari(new Ruutu(0,0), 3);
        Ruutu r = testipari.getRuutu();
        assertTrue(uusi.onSama(r));
        
        
    }

    /**
     *Testaa getSuunta() metodia luokasta Pari.
     */
    @Test
    public void testGetSuunta() {
        System.out.println("getSuunta");
        Pari p = new Pari(new Ruutu(2,3), 3);
        Integer odotettu = 3;
        Integer tulos = p.getSuunta();
        assertEquals(odotettu, tulos);
    }
    
}
