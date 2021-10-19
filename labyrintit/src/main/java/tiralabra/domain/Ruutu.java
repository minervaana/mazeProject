package tiralabra.domain;

/**
 * Ruutu edustaa yhtä labyrintin ruutua.
 *
 * @author Mirka
 */
public class Ruutu {

    /**
     * tämän ruudun seinien "arvot".
     */
    private boolean walls[];

    /**
     * tämän ruudun x-koordinaatti.
     */
    private int x;

    /**
     * tämän ruudun y-koordinaatti.
     */
    private int y;

    /**
     * Ruudun konstruktori luo Ruudun, jolla on 2 seinää.
     *
     * @param y palauttaa y-koordinaatin
     * @param x x-koordinaatin
     */
    public Ruutu(int y, int x) {

        this.walls = new boolean[2];
        for (int i = 0; i < this.walls.length; i++) {
            this.walls[i] = true;
        }
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return palauttaa tämän ruudun x-koordinaatin.
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return palauttaa tämän ruudun y-koordinaatin.
     */
    public int getY() {
        return this.y;
    }

    /**
     *
     * @return palauttaa tämän ruudun seinät.
     */
    public boolean[] getSeinat() {
        return this.walls;
    }

    /**
     * Poistaa halutun seinän, seinän omasta taulukosta.
     *
     * @param i Viittaa haluttuun seinään (0 = vasen, 1 = ala ja 2 = oikea
     * seinä).
     */
    public void poistaSeina(int i) {
        this.walls[i] = false;
    }

    /**
     * Tulostaa tämän ruudun seinät ja mahdolliset kulkuaukot.
     */
    public void tulostaRuutu() {

        if (this.walls[0]) {
            System.out.print("_");
        } else {
            System.out.print(" ");
        }

        if (this.walls[1]) {
            System.out.print("|");
        } else {
            System.out.print("_");
        }
    }

    /**
     * Käytetään kahden ruudun vertailuun, kun halutaan tietää sijaitseeko ne samassa paikassa
     * @param r vertailtava ruutu
     * @return palauttaa true jos on ja false jos ei ole sama ruutu
     */
    public boolean onSama(Ruutu r) {
        return this.x == r.getX() && this.y == r.getY();
    }
}
