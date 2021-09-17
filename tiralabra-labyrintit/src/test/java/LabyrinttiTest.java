import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirka
 */
public class LabyrinttiTest {
    
    /**
     *
     */
    public LabyrinttiTest() {
    }

    /**
     * Test of sideWinder method, of class Labyrintti.
     */
    @Test
    public void testOnPolku() {
        System.out.println("sideWinder");
        Labyrintti l = new Labyrintti(10);
        l.sideWinder();
        
        
    }
    
}
