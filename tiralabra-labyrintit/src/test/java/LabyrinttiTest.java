import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 *
 * @author Mirka
 */
@RunWith(Suite.class)
@SuiteClasses ({RuutuTest.class})
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
        
        Ruutu r = new Ruutu(0,0);
        
        
    }
    
}
