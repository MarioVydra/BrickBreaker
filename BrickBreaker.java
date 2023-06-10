import javax.swing.JOptionPane;

/**
 * Trieda reprezentuje hru BrickBreaker.
 * Vytvorí všetky komponenty programu a spravuje ich cez manažéra.
 * 
 * @author Mário Vydra 
 * @version 6.1.2022
 */
public class BrickBreaker {
    
    private DelovaGula delovaGula;
    private Stena stena;
    private Pozadie pozadie;
    private Odrazadlo odrazadlo;
    private Skore skore;
    
    /**
     * Konštruktor inicializuje atribúty, čím vytvorí všetky súčasti hry.
     * Taktiež na základe výberu vyskakovacieho okna, určí akú obtiažnosť hra bude mať.
     */
    public BrickBreaker() {
        Obtiaznost obtiaznost = null;
        Obtiaznost[] moznosti = new Obtiaznost[] {Obtiaznost.EASY, Obtiaznost.MEDIUM, Obtiaznost.HARD};
        Object vyber = JOptionPane.showInputDialog(null, "Please select difficulty:", "Welcome to the BrickBreaker", JOptionPane.PLAIN_MESSAGE, null, moznosti, 0);
        if (vyber.equals(Obtiaznost.EASY)) {
            obtiaznost = Obtiaznost.EASY;
        } else if (vyber.equals(Obtiaznost.MEDIUM)) {
            obtiaznost = Obtiaznost.MEDIUM;
        } else if (vyber.equals(Obtiaznost.HARD)) {
            obtiaznost = Obtiaznost.HARD;
        }
        
        this.pozadie = new Pozadie();        
        this.stena = new Stena();
        this.skore = new Skore(obtiaznost);
        this.delovaGula = new DelovaGula(this, this.stena, this.skore);
        this.odrazadlo = new Odrazadlo(this);
        this.aktivuj();
    }
    
    /**
     * Metóda aktivuj vytvorí nového manažéra a pošle manažérovi správu, aby spravoval danú triedu (resp. objekt).
     */
    public void aktivuj() {                
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(this);
    }
    
    /**
     * Metóda tik je v podstate správa, ktorú posiela manažér.
     * Každým tikom sa loptička posunie o nejaký hodnotu.
     */
    public void tik() {
        this.delovaGula.posunSa(this.odrazadlo);
    }
    
    /**
     * Metóda zrus slúži na ukončenie aplikácie pomocou manažéra cez tlačidlo "Esc".
     */
    public void zrus() {
        System.exit(0);
    }
    
    /**
     * Metóda posunVpravo slúži na posun odrážadla do pravého smeru pomocou pravej šípky.
     */
    public void posunVpravo() {
        this.odrazadlo.posunVpravo();
    }
    
    /**
     * Metóda posunVlavo slúži na posun odrážadla do ľavého smeru pomocou ľavej šípky.
     */
    public void posunVlavo() {
        this.odrazadlo.posunVlavo();
    }
}
