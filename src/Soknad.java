/**
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Jørgen Dyhre


import java.io.Serializable;

//Klassen lager et Søknads-objekt
public class Soknad implements Serializable{
    private String soknadsTekst;
    private Vikariat vikariat;
    private Vikar vikar;
    
    Soknad neste;
    
    //Konstruktør
    public Soknad(String soknadsTekst, Vikariat vikariat, Vikar vikar) {
        this.soknadsTekst = soknadsTekst;
        this.vikariat = vikariat;
        this.vikar = vikar;
    }
    
    //Returnerer søknadsteksten når metoden blir kalt
    public String getSoknadTekst() {
        return soknadsTekst;
    }

    //Setter inn søknadsteksten
    public void setSoknadTekst(String soknadTekst) {
        this.soknadsTekst = soknadTekst;
    }

    //Returnere vikariat når den blir kalt
    public Vikariat getVikariat() {
        return vikariat;
    }

    //Setter inn vikariat
    public void setVikariat(Vikariat vikariat) {
        this.vikariat = vikariat;
    }

    //Returnerer vikar når den blir kalt
    public Vikar getVikar() {
        return vikar;
    }

    //Setter inn vikar
    public void setVikar(Vikar vikar) {
        this.vikar = vikar;
    }
    
    //Skriver ut info og søknadstekst i utskriftområdet
    public String toString(){
        String utskrift = "\nVikar: " + vikar.getNavn() + "(" + vikar.getPersonNr() + ")" +
                          "\nViakriat: " + vikariat.toStringShort() + "\nSøknads tekst: " +
                          soknadsTekst;
        return utskrift;
    }
}//end Soknad
