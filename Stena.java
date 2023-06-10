/**
 * Trieda reprezentuje stenu.
 * Stena je tvorená z 2-rozmerného poľa brickov.
 * 
 * @author Mário Vydra
 * @version 6.1.2022
 */
public class Stena {
    private Obrazok[][] stena;
    
    /**
     * Konštruktor vytvorí 2-rozmerné pole s počtom riadkom 10 a počtom stĺpcov 14.
     * Pomocou vnoreného cyklu na každý prvok poľa vytvorí nový brick.
     */
    public Stena() {
        this.stena = new Obrazok[14][10];
        for (int riadok = 0; riadok < this.stena.length; riadok++) {
            for (int stlpec = 0; stlpec < this.stena[riadok].length; stlpec++) {
                this.stena[riadok][stlpec] = new Obrazok("pics/brick2.jpg");
                this.stena[riadok][stlpec].posunVodorovne(-100 + stlpec * 39 + 80);
                this.stena[riadok][stlpec].posunZvisle(-100 + riadok * 29 + 75);
                this.stena[riadok][stlpec].zobraz();
            }
        }
    }

    /**
     * Metóda youWon vracia pravdivostnú hodnotu, či sme vyhrali alebo nie.
     * 
     * @return false - ak nejaký brick je viditeľný, true - ak všetky bricky v poli sú skryté.
     */
    public boolean youWon() {
        for (int riadok = 0; riadok < this.stena.length; riadok++) {
            for (int stlpec = 0; stlpec < this.stena[riadok].length; stlpec++) {
                if (this.stena[riadok][stlpec].jeViditelny()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Metóda koliziaSDelovouGulou zisťuje na základe podmienok, či došlo ku kolízii s nejakým objektom ( alebo nie.
     * 
     * @return false - ak nedošlo ku kolízii, true - ak ku kolízii došlo.
     * 
     * @param x x-ová súradnica nejakého objektu (delová guľa)
     * @param y y-ová súradnica nejakého objektu (delová guľa)
     */
    public boolean koliziaSDelovouGulou(int x, int y) {
        int stlpec = (x - 80) / 39;
        int riadok = (y - 75) / 29;

        if (stlpec >= this.stena[0].length || stlpec < 0 || riadok >= this.stena.length || riadok < 0) {
            return false;
        }

        Obrazok tehla = this.stena[riadok][stlpec];

        if (!tehla.jeViditelny()) {
            return false;
        }

        tehla.skry();
        return true;
    }
}