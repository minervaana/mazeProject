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
    private Integer suunta;
    
    /**
     *
     * @param r Pariin kuuluva ruutu
     * @param suunta Pariin kuuluva suunta
     */
    public Pari(Ruutu r, Integer suunta) {
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
    public Integer getSuunta() {
        return this.suunta;
    }
    
}
