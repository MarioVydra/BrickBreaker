/**
 * Trieda reprezentuje pozadie hry.
 * 
 * @author Mário Vydra 
 * @version 6.1.2022
 */
public class Pozadie {
    
    private Obdlznik pozadieZadne;
    private Obrazok pozadiePredne;
    private Obdlznik pozadieSpodne;
    private Obdlznik pozadieSpodne2;
    private Obrazok nazovHry;
    private Obrazok skore;
    private Obrazok zivoty;
    private Obrazok srdce;
    private Obrazok ovladanie;
    /**
     * Konštruktor si vytvorí nové obrázky, ktoré potom na základe posunov zobrazí na plátne, na určitom mieste.
     */
    public Pozadie() {
        this.pozadieZadne = new Obdlznik();
        this.pozadieZadne.posunVodorovne(-60);
        this.pozadieZadne.posunZvisle(-50);
        this.pozadieZadne.zmenStrany(550, 650);
        this.pozadieZadne.zmenFarbu("blue");
        this.pozadieZadne.zobraz();
                        
        this.pozadiePredne = new Obrazok("pics/background2.jpg");
        this.pozadiePredne.zmenPolohu(275, 330);
        this.pozadiePredne.zobraz();
        
        this.pozadieSpodne = new Obdlznik();
        this.pozadieSpodne.posunVodorovne(-60);
        this.pozadieSpodne.posunZvisle(-50 + 650);
        this.pozadieSpodne.zmenStrany(550, 150);
        this.pozadieSpodne.zmenFarbu("magenta");
        this.pozadieSpodne.zobraz();   
        
        this.pozadieSpodne2 = new Obdlznik();
        this.pozadieSpodne2.posunVodorovne(-60 + 5);
        this.pozadieSpodne2.posunZvisle(-50 + 655);
        this.pozadieSpodne2.zmenStrany(540, 140);
        this.pozadieSpodne2.zmenFarbu("black");
        this.pozadieSpodne2.zobraz();
        
        this.nazovHry = new Obrazok("pics/názov.png");
        this.nazovHry.posunVodorovne(-100 + 10);
        this.nazovHry.posunZvisle(-100 + 655);
        this.nazovHry.zobraz();
        
        this.ovladanie = new Obrazok("pics/controls.png");
        this.ovladanie.posunVodorovne(-100 + 10);
        this.ovladanie.posunZvisle(-100 + 725);
        this.ovladanie.zobraz();
        
        this.zivoty = new Obrazok("pics/lives.png");
        this.zivoty.posunVodorovne(-100 + 330);
        this.zivoty.posunZvisle(-100 + 695);
        this.zivoty.zobraz();
        
        this.skore = new Obrazok("pics/score.png");
        this.skore.posunVodorovne(-100 + 330);
        this.skore.posunZvisle(-100 + 770);
        this.skore.zobraz();
        
        this.srdce = new Obrazok("pics/srdce.jpg");
        this.srdce.posunVodorovne(-100 + 475);
        this.srdce.posunZvisle(-100 + 660);
        this.srdce.zobraz();        
    }
}