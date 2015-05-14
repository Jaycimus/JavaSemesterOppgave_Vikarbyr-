/**
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */

//Sist endret 14. Mai 2015 AV: Jørgen Dyhre
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;

public class Soknad implements Serializable{
    private String soknadTekst;
    private Vikariat vikariat;
    private Vikar vikar;
    
    public Soknad neste;

    public String getSoknadTekst() {
        return soknadTekst;
    }

    public void setSoknadTekst(String soknadTekst) {
        this.soknadTekst = soknadTekst;
    }

    public Vikariat getVikariat() {
        return vikariat;
    }

    public void setVikariat(Vikariat vikariat) {
        this.vikariat = vikariat;
    }

    public Vikar getVikar() {
        return vikar;
    }

    public void setVikar(Vikar vikar) {
        this.vikar = vikar;
    }
    
    
    
    public Soknad(String soknadTekst)
    {
        this.soknadTekst=soknadTekst;
        neste = null;
    }
}
