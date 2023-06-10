
/**
 * Trieda reprezentuje skóre.
 * Trieda zobrazuje pomocou 7-segmentových čislic aktuálne skóre a aktuálny počet životov.
 * 
 * @author Mário Vydra 
 * @version 6.1.2022
 */
public class Skore {
    private Cislica cisloZivota;
    private Cislica cisloSkore1;
    private Cislica cisloSkore2;
    private Cislica cisloSkore3;
    private int suradnicaX;
    private int suradnicaY;
    private int pocetZivotov;
    private int skore;
    private Obtiaznost obtiaznost;
    
    /**
     * Konštruktor triedy skóre vytvorí inštancie 4 číslic, ktoré budú zobrazovať aktuálne skóre a aktuálny počet životov.
     * Taktiež na základe vybratého enumu určí počet počiatočných životov. 
     * 
     * @param obtiaznost   referencia na Obtiaznost.
     */
    public Skore(Obtiaznost obtiaznost) {
        this.obtiaznost = obtiaznost;
        this.cisloZivota = new Cislica(this.suradnicaX + 430, this.suradnicaY + 660);
        this.cisloSkore1 = new Cislica(this.suradnicaX + 430, this.suradnicaY + 735);
        this.cisloSkore2 = new Cislica(this.suradnicaX + 430 + 40, this.suradnicaY + 735);
        this.cisloSkore3 = new Cislica(this.suradnicaX + 430 + 80, this.suradnicaY + 735);
        if (this.obtiaznost == Obtiaznost.EASY) {
            this.pocetZivotov = 5;
        } else if (this.obtiaznost == Obtiaznost.MEDIUM) {
            this.pocetZivotov = 3;
        } else  if (this.obtiaznost == Obtiaznost.HARD) {
            this.pocetZivotov = 1;
        }
        this.skore = 0;
        this.vykresliPocetZivotov();
        this.vykresliSkore();
    }
    
    /**
     * Metóda vykresliPocetZivotov zobrazuje aktuálny počet životov, pomocou segmentov (resp. pomocou triedy Cislica).
     */
    public void vykresliPocetZivotov() {
        this.cisloZivota.zobraz(this.pocetZivotov);
    }
    
    /**
     * Metóda vykresliSkore zobrazuje aktuálne skóre, pomocou segmentov (resp. pomocou triedy Cislica).
     * Pomocou delenia a modula zobrazí skóre na 3 cifernom zobrazovači.
     */
    public void vykresliSkore() {
        this.cisloSkore1.zobraz(this.skore / 100);
        this.cisloSkore2.zobraz((this.skore % 100) / 10);
        this.cisloSkore3.zobraz(this.skore % 10);
    }
    
    /**
     * Getter atribútu skore.
     * 
     * @return počet skóre.
     */
    public int getSkore() {
        return this.skore;
    }
    
    /**
     * Getter atribútu pocetZivotov.
     * 
     * @return počet životov.
     */
    public int getZivoty() {
        return this.pocetZivotov;
    }
    
    /**
     * Setter atribútu pocetZivotov.
     * 
     * @param paZivoty   nový počet životov.
     */
    public void nastavZivoty(int paZivoty) {
        this.pocetZivotov = paZivoty;
    }

    /**
     * Metóda priratajSkore, priráta k atribútu skóre hodnotu 5.
     * Taktiež vyvolá metódu vykresliSkore().
     */
    public void priratajSkore() {
        this.skore += 5;
        this.vykresliSkore();
    }

    /**
     * Metóda gameOver vracia pravdivostnú hodnotu, či došlo ku koncu hry alebo nie.
     * 
     * @return true - ak pocetZivotov je rovný 0, false - ak pocetZivotov nie je rovný 0.
     */
    public boolean gameOver() {
        if (this.pocetZivotov == 0) {
            return true;
        }
        return false;
    }
}
