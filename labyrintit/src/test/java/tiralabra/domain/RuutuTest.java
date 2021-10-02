package tiralabra.domain;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Mirka
 */
public class RuutuTest {
    
    private Ruutu r;
    
    public RuutuTest() {
    }
    
    @Before
    public void setUp() {
        r = new Ruutu(2,3);
    }
    
    /**
     * Testaa getX metodia luokasta Ruutu.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        int expResult = 3;
        int result = r.getX();
        assertEquals(expResult, result);
    }

    /**
     * Testaa getY metodia luokasta Ruutu.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        int expResult = 2;
        int result = r.getY();
        assertEquals(expResult, result);
    }

    /**
     * Testaa poistaSeina metodia luokasta Ruutu.
     */
    @Test
    public void testPoistaSeina() {
        System.out.println("poistaSeina");
        int i = 0;
        r.poistaSeina(i);
        boolean a = r.getSeinat()[0];
        assertEquals(a, false);
    }
    
    /**
     * Testaa getSeinat metodia luokasta Ruutu.
     */
    @Test
    public void testGetSeinat() {
        System.out.println("getWalls");
        boolean[] odotettu = {true, true, true};
        boolean[] tulos = r.getSeinat();
        assertArrayEquals(odotettu, tulos);
    }

    /**
     * Testaa onSama metodia luokasta Ruutu.
     */
    @Test
    public void testOnSama() {
        System.out.println("equals");
        Ruutu uusi = new Ruutu(2,3);
        boolean sama = r.onSama(uusi);
        
        assertEquals(true, sama);
    }
    
}
