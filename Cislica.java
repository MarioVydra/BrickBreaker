/**
 * Trieda reprezentuje číslicu.
 * Vytvorí si 7 segmentov a zoradí ich do vzoru 7-segmentového zobrazovača.
 * Dané segmenty sa zapínajú a vypínajú na základe nejakého čisla, ktoré sa potom vykreslí.
 * 
 * @author Cvičenia 
 * @version 6.1.2022
 */
public class Cislica {
    
    private Segment segmentA;
    private Segment segmentB;
    private Segment segmentC;
    private Segment segmentD;
    private Segment segmentE;
    private Segment segmentF;
    private Segment segmentG;
    
    public Cislica(int x, int y) {
        this.segmentA = new Segment(20, 5, 5 + x, 0 + y);
        this.segmentB = new Segment(5, 20, 25 + x, 5 + y);
        this.segmentC = new Segment(5, 20, 25 + x, 30 + y);
        this.segmentD = new Segment(20, 5, 5 + x, 50 + y);
        this.segmentE = new Segment(5, 20, 0 + x, 30 + y);
        this.segmentF = new Segment(5, 20, 0 + x, 5 + y);
        this.segmentG = new Segment(20, 5, 5 + x, 25 + y);
    }
    
    public void zobraz(int n) {
        this.skry();
        switch (n) {
            case 1:
                this.segmentB.zapni();
                this.segmentC.zapni();
                break;
            case 2:
                this.segmentA.zapni();
                this.segmentB.zapni();
                this.segmentG.zapni();
                this.segmentE.zapni();
                this.segmentD.zapni();
                break;
            case 3:
                this.segmentA.zapni();
                this.segmentB.zapni();
                this.segmentG.zapni();
                this.segmentC.zapni();
                this.segmentD.zapni();
                break;
            case 4:
                this.segmentF.zapni();
                this.segmentB.zapni();
                this.segmentG.zapni();
                this.segmentC.zapni();
                break;
            case 5:
                this.segmentA.zapni();
                this.segmentF.zapni();
                this.segmentG.zapni();
                this.segmentC.zapni();
                this.segmentD.zapni();
                break;
            case 6:
                this.segmentA.zapni();
                this.segmentF.zapni();
                this.segmentG.zapni();
                this.segmentE.zapni();
                this.segmentD.zapni();
                this.segmentC.zapni();
                break;
            case 7:
                this.segmentA.zapni();
                this.segmentB.zapni();
                this.segmentC.zapni();
                break;
            case 8:
                this.segmentA.zapni();
                this.segmentB.zapni();
                this.segmentC.zapni();
                this.segmentD.zapni();
                this.segmentE.zapni();
                this.segmentF.zapni();
                this.segmentG.zapni();
                break;
            case 9:
                this.segmentA.zapni();
                this.segmentB.zapni();
                this.segmentC.zapni();
                this.segmentD.zapni();
                this.segmentF.zapni();
                this.segmentG.zapni();
                break;
            case 0:
                this.segmentA.zapni();
                this.segmentB.zapni();
                this.segmentC.zapni();
                this.segmentD.zapni();
                this.segmentF.zapni();
                this.segmentE.zapni();
                break;
        }
    }
    
    public void skry() {
        this.segmentA.vypni();
        this.segmentF.vypni();
        this.segmentG.vypni();
        this.segmentE.vypni();
        this.segmentD.vypni();
        this.segmentC.vypni();
        this.segmentB.vypni();
    }
}
