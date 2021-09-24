package tiralabra.util;

import tiralabra.domain.Ruutu;

/**
 * Pari koostuu Ruudusta ja suunnasta, josta on tultu
 * @author Mirka
 */
public class Pari {
    
    /**
     * Ruutu
     */
    private Ruutu r;

    /**
     * suunta
     */
    private Character suunta;
    
    /**
     *
     * @param r Pariin kuuluva ruutu
     * @param suunta Pariin kuuluva suunta
     */
    public Pari(Ruutu r, Character suunta) {
        this.r = r;
        this.suunta = suunta;
    }
    
    /**
     *
     * @return palauttaa Ruudun
     */
    public Ruutu getRuutu() {
        return this.r;
    }
    
    /**
     *
     * @return palauttaa suunnan
     */
    public Character getSuunta() {
        return this.suunta;
    }
    
}
