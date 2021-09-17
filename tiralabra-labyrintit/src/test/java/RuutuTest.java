import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testiluokka Ruudulle
 * @author Mirka
 */
public class RuutuTest {
    
    /**
     *
     */
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
    
}
