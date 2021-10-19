package tiralabra.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import tiralabra.util.Lista;
import tiralabra.util.Pari;

/**
 *
 * @author Mirka
 */
public class LabyrinttiTest {

    public LabyrinttiTest() {
    }

    /**
     * Testaa getRuutu metodia luokasta Labyrintti.
     */
    @Test
    public void testGetRuutu() {
        System.out.println("getRuutu");
        int y = 0;
        int x = 0;
        Labyrintti lab = new Labyrintti(20);
        Ruutu odotettu = new Ruutu(0, 0);
        Ruutu tulos = lab.getRuutu(y, x);
        assertTrue(odotettu.onSama(tulos));
    }

    /**
     * Testaa getNaapurit metodia luokasta Labyrintti.
     */
    @Test
    public void testGetNaapurit() {
        System.out.println("getNaapurit");
        Labyrintti lab = new Labyrintti(5);
        Ruutu r = new Ruutu(2, 3);
        Lista<Pari> tulos = lab.getNaapurit(r);
        boolean sama = true;
        Lista<Pari> odotettu = new Lista<>();
        odotettu.lisaa(new Pari(new Ruutu(3, 3), 1));
        odotettu.lisaa(new Pari(new Ruutu(2, 2), 0));
        odotettu.lisaa(new Pari(new Ruutu(2, 4), 2));
        odotettu.lisaa(new Pari(new Ruutu(1, 3), 3));
        for (int i = 0; i < tulos.koko(); i++) {
            if (!odotettu.arvo(i).getRuutu().onSama(tulos.arvo(i).getRuutu()) && odotettu.arvo(i).getSuunta() != tulos.arvo(i).getSuunta()) {
                sama = false;
            }
        }
        assertTrue(sama);

    }

    /**
     * Testaa sidewinder metodia luokasta Labyrintti. Tarkistaa, että polku
     * löytyy labyrintin halki.
     */
    @Test
    public void testSidewinder() {
        System.out.println("sideWinder");
        Labyrintti l = new Labyrintti(100);
        l.sideWinder();

        Ruutu alku = l.getRuutu(0, 0);
        Ruutu loppu = l.getRuutu(l.korkeus - 1, l.leveys - 1);
        Lista<Ruutu> lista = new Lista<>();
        Boolean[][] visited = new Boolean[l.leveys][l.leveys];

        for (int i = 0; i < l.korkeus; i++) {
            for (int j = 0; j < l.leveys; j++) {
                visited[i][j] = false;

            }
        }

        lista.lisaa(alku);
        while (!lista.onTyhja()) {
            Ruutu r = lista.veda();
            if (!visited[r.getY()][r.getX()]) {

                visited[r.getY()][r.getX()] = true;

                if (r.equals(loppu)) {
                    assertTrue(r.equals(loppu));
                    System.out.println("toimii");
                    return;

                }
                haeNaapurit(l, r, lista);
            }

        }

        fail("polkua ei löytynyt");

    }

    /**
     * sideWinderin testauksen apuna, käytettävä metodi, jolla lisätään listaan
     * ruudun naapureita
     *
     * @param l Labyrinttiolio
     * @param r Ruutu, jonka viereiset ruudut halutaan lisätä listaan
     * @param lista Ruuduista koostuva lista, johon lisätään naapurit
     */
    private void haeNaapurit(Labyrintti l, Ruutu r, Lista<Ruutu> lista) {

        if (r.getY() + 1 < l.leveys && !r.getSeinat()[0]) {
            lista.lisaa(l.getRuutu(r.getY() + 1, r.getX()));
        }
        if (r.getX() - 1 >= 0) {
            Ruutu edellinen = l.getRuutu(r.getY(), r.getX() - 1);
            if (!edellinen.getSeinat()[1]) {
                lista.lisaa(l.getRuutu(r.getY(), r.getX() - 1));
            }
        }
        if (r.getX() + 1 < l.leveys && !r.getSeinat()[1]) {
            lista.lisaa(l.getRuutu(r.getY(), r.getX() + 1));
        }
        if (r.getY() - 1 >= 0) {
            Ruutu ylempi = l.getRuutu(r.getY() - 1, r.getX());
            if (!ylempi.getSeinat()[0]) {
                lista.lisaa(l.getRuutu(r.getY() - 1, r.getX()));
            }
        }
    }

    /**
     * Testaa wilsons metodia luokasta Labyrintti. Tarkistaa, että polku löytyy
     */
    @Test
    public void testWilsons() {
        System.out.println("wilsons");
        Labyrintti l = new Labyrintti(100);
        l.wilsons();

        Ruutu alku = l.getRuutu(0, 0);
        Ruutu loppu = l.getRuutu(l.korkeus - 1, l.leveys - 1);
        Lista<Ruutu> lista = new Lista<>();
        Boolean[][] visited = new Boolean[l.leveys][l.leveys];

        for (int i = 0; i < l.korkeus; i++) {
            for (int j = 0; j < l.leveys; j++) {
                visited[i][j] = false;

            }
        }

        lista.lisaa(alku);
        while (!lista.onTyhja()) {
            Ruutu r = lista.veda();
            if (!visited[r.getY()][r.getX()]) {

                visited[r.getY()][r.getX()] = true;

                if (r.equals(loppu)) {
                    assertTrue(r.equals(loppu));
                    return;

                }
                haeNaapurit(l, r, lista);
            }

        }

        fail("polkua ei löytynyt");
    }

}
