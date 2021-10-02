package tiralabra.util;

/**
 *
 * @author Mirka Tietorakenne listalle
 * @param <T>
 */
public class Lista<T> {

    /**
     * Taulukkolista
     */
    private T[] arvot;

    /**
     * Listan sisältämien arvojen määrä
     */
    private int arvoja;

    /**
     * Listan Konstruktori, joka alustaa tyhjän listan 10 kokoiseksi
     */
    public Lista() {
        this.arvot = (T[]) new Object[10];
        this.arvoja = 0;
    }

    /**
     * Lisää tälle listalle arvon listan loppuun
     *
     * @param arvo listalle lisättävä arvo.
     */
    public void lisaa(T arvo) {

        if (this.arvoja == this.arvot.length) {
            kasvata();
        }

        this.arvot[this.arvoja] = arvo;
        this.arvoja++;
    }

    /**
     * Poistaa listalta halutun alkion
     *
     * @param arvo Listan elementti, joka halutaan poistaa
     */
    public void poista(T arvo) {
        int arvonIndeksi = arvonIndeksi(arvo);
        if (arvonIndeksi < 0) {
            return;
        }

        siirraVasemmalle(arvonIndeksi);
        this.arvoja--;
    }

    /**
     * Palauttaa ja poistaa listan ensimmäisen alkion
     *
     * @return palauttaa listan ensimmäisen alkion.
     */
    public T veda() {
        T arvo = this.arvot[0];
        poista(arvo);
        return arvo;
    }

    /**
     * Haetaan indeksin osoittama arvo
     *
     * @param indeksi listan indeksi, jonka arvo halutaan.
     * @return palauttaa alkion halutussa indeksissä, tai antaa
     * virheilmoituksen.
     */
    public T arvo(int indeksi) {
        try {
            return this.arvot[indeksi];
        } catch (Exception e) {
            System.out.println("Indeksi on listan ulkopuolella");
        }
        return null;
    }

    /**
     * Tarkistetaan onko listalla haluttua arvoa.
     *
     * @param arvo tarkistetaan onko listassa tämä arvo.
     * @return palautetaan tosi, jos arvon indeksi on suurempi tai yhtä suuri
     * kuin 0.
     */
    public boolean sisaltaa(T arvo) {
        return arvonIndeksi(arvo) >= 0;
    }

    /**
     * Tarkistaa onko lista tyhjä
     * @return tosi jos lista on tyhjä, muuten false.
     */
    public boolean onTyhja() {
        return this.arvoja == 0;
    }

    /**
     * Haetaan arvon indeksi.
     *
     * @param arvo arvo, jonka indeksi halutaan
     * @return palautetaan parametrina annetun arvon indeksi listassa.
     */
    public int arvonIndeksi(T arvo) {
        for (int i = 0; i < this.arvoja; i++) {
            if (this.arvot[i].equals(arvo)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @return palauttaa listan koon.
     */
    public int koko() {
        return this.arvoja;
    }

    /**
     *
     * @param indeksi indeksi, josta lähtien listan alkioita siirretään
     * vasemmalle.
     */
    private void siirraVasemmalle(int indeksi) {
        for (int i = indeksi; i < this.arvoja - 1; i++) {
            this.arvot[i] = this.arvot[i + 1];
        }
    }

    /**
     * Luo uuden isomman listan ja kopioi vanhat tiedot siihen.
     */
    private void kasvata() {
        int uusiKoko = this.arvot.length + this.arvot.length / 2;
        T[] uusi = (T[]) new Object[uusiKoko];

        for (int i = 0; i < this.arvot.length; i++) {
            uusi[i] = this.arvot[i];
        }

        this.arvot = uusi;
    }

}
