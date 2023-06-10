 /**
 * Trieda reprezentuje odrážadlo.
 * Odrážadlom vieme pohybovať do dvoch smerov (vpravo a vľavo v x-ovom smere).
 * 
 * @author Cvičenia, Mário Vydra 
 * @version 6.1.2022
 */
public class Odrazadlo {
    
    private Obdlznik odrazadlo;
    private int poziciaX;
    private BrickBreaker brickBreaker;
    /**
     * Konštruktor vytvorí inštanciu obdĺžnika, ktorý posunie na určitú pozíciu, zmení mu farbu a rozmery.
     * Taktiež inicializuje atribút poziciaX, ktorý reprezentuje aktuálnu pozíciu odrážadla.
     * 
     * @param brickBreaker   referencia na BrickBreaker.
     */
    public Odrazadlo(BrickBreaker brickBreaker) {
        this.brickBreaker = brickBreaker;        
        this.poziciaX = 240;
        this.odrazadlo = new Obdlznik();
        this.odrazadlo.posunVodorovne(-60 + 240);
        this.odrazadlo.posunZvisle(-50 + 620);
        this.odrazadlo.zmenFarbu("blue");
        this.odrazadlo.zmenStrany(70, 10);
        this.odrazadlo.zobraz();
    }
    
    /**
     * Metóda vytvorená na cvičeniach s pozmenenými hodnotami.
     * Metóda posunVpravo, posúva daný obdĺžnik po x-ovej osi v kladnom smere.
     * Taktiež prirátava k atribútu hodnotu, o ktorú sa daný obdĺžnik posunul.
     * Metóda je ošetrená podmienkou, že poziciaX nemôže mať vyššiu hodnotu ako pravý okraj hry,tým pádom odrážadlom už ďalej nepohneme.
     */
    public void posunVpravo() {
        if (this.poziciaX <= 540 - 70) {
            this.odrazadlo.posunVodorovne(20);
            this.poziciaX += 20;
        }
    }
    
    /**
     * Metóda vytvorená na cvičeniach s pozmenenými hodnotami.
     * Metóda posunVlavo, posúva daný obdĺžnik po x-ovej osi v zápornom smere.
     * Taktiež odpočítava od atribútu hodnotu, o ktorú sa daný obdĺžnik posunul.
     * Metóda je ošetrená podmienkou, že poziciaX nemôže mať menšiu hodnotu ako ľavý okraj hry,tým pádom odrážadlom už ďalej nepohneme.
     */
    public void posunVlavo() {
        if (this.poziciaX >= 10) {
            this.odrazadlo.posunVodorovne(-20);
            this.poziciaX -= 20;
        }
    }
    
    /**
     * Metóda vytvorená na cvičeniach s pozmenenými hodnotami.
     * Metóda koliziaSDelovouGulou na základe podmienky, určuje, či došlo ku kolízii s nejakým objektom (v našom prípade delovou guľou) alebo nie.
     * Ak áno, tak vráti hodnotu miesta, kde sa objekt/delová guľa odrazila na odrážadle.
     * 
     * @return vráti buď x-ovú hodnotu miesta na odrážadle, kde sa objekt/delová guľa odrazila (0 - 70) alebo vráti hodnotu 10000.
     * 
     * @param x x-ová pozícia nejakého objektu (delová guľa)
     * @param y y-ová pozícia nejakého objektu (delová guľa)
     */
    public double koliziaSDelovouGulou(int x, int y) {
        if (y > 610 && y < 620) {
            return (x - this.poziciaX);            
        } else {
            return 10000;
        }
    }
}
