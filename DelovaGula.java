import javax.swing.JOptionPane;
import java.util.Random;

/**
 * Trieda reprezentuje delovú guľu, ktorá sa posúva v x-ovom a y-ovom smere.
 * Ak delová guľa vyletí z mapy, tak sa respawne.
 * 
 * @author Mário Vydra 
 * @version 6.1.2022
 */
public class DelovaGula {    
    
    private Kruh delovaGula;
    private int poziciaX;
    private int poziciaY;
    private int posunX;
    private int posunY;
    private BrickBreaker brickBreaker;
    private Random random;
    private Stena stena;
    private Skore skore;
            
    /**
     * Konštruktor vytvorí novú delovú guľu, ktorej zmení priemer, zmení farbu a posunie ju na spawnovaciu pozíciu.
     * Ďalej si vytvorí random, ktorý sa využíva pri určovaní smeru pohybu delovej gule.
     * Taktiež inicializuje atribúty, ktoré určujú aktuálnu x-ovú a y-ovú pozíciu delovej gule.
     * 
     * @param brickBreaker   referencia na BrickBreaker
     * @param stena          referencia na Stenu
     * @param skore          referencia na Skore
     */
    public DelovaGula(BrickBreaker brickBreaker, Stena stena, Skore skore) {
        this.skore = skore;
        this.brickBreaker = brickBreaker;
        this.poziciaX = 275;
        this.poziciaY = 550;
        
        this.random = new Random();
        this.smerPohybu();
        
        this.delovaGula = new Kruh();
        this.delovaGula.zmenPriemer(20);
        this.delovaGula.zmenFarbu("magenta");
        this.delovaGula.posunVodorovne(-20 + 275);
        this.delovaGula.pomalyPosunZvisle(-60 + 550);
        this.delovaGula.zobraz();          
        
        this.stena = stena;
    }
    
    /**
     * Metóda posunSa posúva delovú guľu v x-ovom a y-ovom smere.
     * Taktiež prirátava k atribútom x-ovej a y-ovej pozície hodnotu, o ktorú sa delová guľa posunula.
     * Na základe rôznych okolností mení smer, napr. náraz na okraj mapy, náraz do brickov alebo náraz do odrážadla.
     * 
     * @param odrazadlo   referencia na Odrazadlo.
     */
    public void posunSa(Odrazadlo odrazadlo) {
        if (this.poziciaX <= 10 || (this.poziciaX + 10) >= 540) {
            this.posunX = -this.posunX;
        } else if (this.poziciaY <= 10) {
            this.posunY = -this.posunY;
        } else if (this.poziciaY >= 630) {
            this.respawn();            
        } else if (odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) <= 70 && odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) >= 0) {
            this.posunY = -this.posunY;
            if (odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) >= 0 && odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) <= 25) {
                if (this.posunX == 0) {
                    this.posunX = -(this.random.nextInt(3) + 2);
                } else {
                    this.posunX += (this.posunX / 2);
                }
            }
            
            if (odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) > 25 && odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) <= 45) {
                this.posunX = 0;
            }
            
            if (odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) > 45 && odrazadlo.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY + 10) <= 70) {
                if (this.posunX == 0) {
                    this.posunX = this.random.nextInt(3) + 2;
                } else {
                    this.posunX += (this.posunX / 2);
                }
            }
        } else if (this.stena.koliziaSDelovouGulou(this.poziciaX, this.poziciaY + 10)) {
            this.skore.priratajSkore();
            this.posunX = -this.posunX;
        } else if (this.stena.koliziaSDelovouGulou(this.poziciaX + 10, this.poziciaY)) {
            this.skore.priratajSkore();
            this.posunY = -this.posunY;
        }
                             
        this.delovaGula.posunVodorovne(this.posunX);
        this.poziciaX += this.posunX;
        this.delovaGula.posunZvisle(this.posunY);
        this.poziciaY += this.posunY;
    }
    
    /**
     * Metóda respawn vráti delovú guľu na pôvodnú pozíciu a odráta jeden život.
     * Taktiež respawn kontroluje, či hráč prehral alebo vyhral a keď sa tak stane tak vyhodí vyskakovacie okno.
     */
    public void respawn() {
        this.skore.nastavZivoty(this.skore.getZivoty() - 1);
        this.skore.vykresliPocetZivotov();

        if (this.skore.gameOver()) {
            JOptionPane.showMessageDialog(null, "You lost. Your score is: " + this.skore.getSkore() + ".", "GameOver", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else if (this.stena.youWon()) {
            JOptionPane.showMessageDialog(null, "Congratulation! You beated the game. Your score is: " + this.skore.getSkore() + ".", "You won", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        this.delovaGula.posunVodorovne(275 - this.poziciaX);
        this.delovaGula.posunZvisle(550 - this.poziciaY);
        this.poziciaX = 275;
        this.poziciaY = 550;
        this.smerPohybu();
    }
    
    /**
     * Metóda podobná tej z cvičení, len s pozmenenými hodnotami.
     * Metóda smerPohybu určuje veľkosť posunu delovej gule, ktorá je určená na základe náhodnej hodnoty v rozmedzí od 2 do 4.
     * Taktiež na základe random booleanu určí, či bude posun x v kladnom smere alebo v zápornom.
     */
    public void smerPohybu() {
        this.posunX = this.random.nextInt(3) + 2;
        this.posunY = this.random.nextInt(3) + 2;
        if (this.random.nextBoolean()) {
            this.posunX = -this.posunX;
        }
        this.posunY = -this.posunY;
    }
}
