
import java.util.LinkedList;
import org.junit.Assert;
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
        Labyrintti l = new Labyrintti(4);
        l.sideWinder();

        Ruutu alku = l.getRuutu(0, 0);
        Ruutu loppu = l.getRuutu(l.korkeus - 1, l.leveys - 1);
        LinkedList<Ruutu> lista = new LinkedList<>();
        Boolean[][] visited = new Boolean[l.leveys][l.leveys];

        for (int i = 0; i < l.korkeus; i++) {
            for (int j = 0; j < l.leveys; j++) {
                visited[i][j] = false;

            }
        }

        lista.add(alku);
        while (!lista.isEmpty()) {
            Ruutu r = lista.poll();
            if (!visited[r.getY()][r.getX()]) {

                visited[r.getY()][r.getX()] = true;

                if (r.equals(loppu)) {
                    assertTrue(r.equals(loppu));
                    return;

                }
            }
            getNaapurit(l, r, lista);

        }

        fail("polkua ei löytynyt");

    }

    public void getNaapurit(Labyrintti l, Ruutu r, LinkedList<Ruutu> lista) {
        
        if (r.getY() + 1 < l.leveys && !r.getWalls()[1]) {
            lista.add(l.getRuutu(r.getY() + 1, r.getX()));
        }
        if (r.getX() - 1 >= 0 && !r.getWalls()[0]) {
            lista.add(l.getRuutu(r.getY(), r.getX() - 1));
        }
        if (r.getX() + 1 < l.leveys && !r.getWalls()[2]) {
            lista.add(l.getRuutu(r.getY(), r.getX() + 1));
        }
        if (r.getY() - 1 >= 0) {
            Ruutu ylempi = l.getRuutu(r.getY() - 1, r.getX());
            if (!ylempi.getWalls()[1]) {
                lista.add(l.getRuutu(r.getY() - 1, r.getX()));
            }
        }

    }

}
