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
    private String soknadsTekst;
    private Vikariat vikariat;
    private Vikar vikar;
    
    public Soknad neste;

    public Soknad(String soknadsTekst, Vikariat vikariat, Vikar vikar) {
        this.soknadsTekst = soknadsTekst;
        this.vikariat = vikariat;
        this.vikar = vikar;
    }
    
    public String getSoknadTekst() {
        return soknadsTekst;
    }

    public void setSoknadTekst(String soknadTekst) {
        this.soknadsTekst = soknadTekst;
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
    
    public String toString(){
        String utskrift = "\nVikar: " + vikar.getNavn() + "(" + vikar.getPersonNr() + ")" +
                          "\nViakriat: " + vikariat.toStringShort() + "\nSøknads tekst: " +
                          soknadsTekst;
        return utskrift;
    }
}
