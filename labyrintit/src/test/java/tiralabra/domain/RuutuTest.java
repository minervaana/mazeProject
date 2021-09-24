package tiralabra.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirka
 */
public class RuutuTest {
    
    public RuutuTest() {
    }
    
    /**
     * Test of getX method, of class Ruutu.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Ruutu r = new Ruutu(2,3);
        int expResult = 3;
        int result = r.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Ruutu.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Ruutu r = new Ruutu(2,3);
        int expResult = 2;
        int result = r.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of poistaSeina method, of class Ruutu.
     */
    @Test
    public void testPoistaSeina() {
        System.out.println("poistaSeina");
        int i = 0;
        Ruutu r = new Ruutu(4,5);
        r.poistaSeina(i);
        boolean a = r.getWalls()[0];
        assertEquals(a, false);
    }
    /**
     * Test of getWalls method, of class Ruutu.
     */
    @Test
    public void testGetWalls() {
        System.out.println("getWalls");
        Ruutu instance = null;
        boolean[] expResult = null;
        boolean[] result = instance.getWalls();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    

    /**
     * Test of tulostaRuutu method, of class Ruutu.
     */
    @Test
    public void testTulostaRuutu() {
        System.out.println("tulostaRuutu");
        Ruutu instance = null;
        instance.tulostaRuutu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Ruutu.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Ruutu r = null;
        Ruutu instance = null;
        boolean expResult = false;
        boolean result = instance.equals(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
