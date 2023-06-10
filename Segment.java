/**
 * Trieda reprezentuje jeden segment, ktorý sa v ďalšej triede využíva pri vytvorení 7-segmentového zobrazovača čísel.
 * Segment môže byť zapnutý alebo vypnutý.
 * 
 * @author Cvičenia 
 * @version 6.1.2022
 */
public class Segment {
    private Obdlznik obdlznik;
    public Segment(int sirka, int vyska, int x, int y) {
        this.obdlznik = new Obdlznik();
        this.obdlznik.zmenStrany(sirka, vyska);
        this.obdlznik.posunVodorovne(x - 60);
        this.obdlznik.posunZvisle(y - 50);
        this.obdlznik.zobraz();
    }
    
    public void zapni() {
        this.obdlznik.zmenFarbu("red");
    }
    
    public void vypni() {
        this.obdlznik.zmenFarbu("black");
    }
}
