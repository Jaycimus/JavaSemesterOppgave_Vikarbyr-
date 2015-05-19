/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Jørgen Dyhre


import java.io.Serializable;

//Klassen bygger opp forhold mellom firma og vikar som arbeidsforhold
public class Arbeidsforhold implements Serializable {
    private final int arbeidsforholdNr;
    private Vikariat vikariat;
    private Vikar vikar;
    private String arbeidsforhold;
    
    Arbeidsforhold neste;
    
    //Konstruktør
    public Arbeidsforhold(Vikariat vikariat, Vikar vikar, String arbeidsforhold, int arbeidsforholdNr){
        this.vikariat = vikariat;
        this.vikar = vikar;
        this.arbeidsforhold = arbeidsforhold;
        this.arbeidsforholdNr = arbeidsforholdNr;
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

    public String getArbeidsforhold() {
        return arbeidsforhold;
    }

    public void setArbeidsforhold(String arbeidsforhold) {
        this.arbeidsforhold = arbeidsforhold;
    }
    
    public int getArbeidsforholdNr() {
        return arbeidsforholdNr;
    }
    
    public String getArbeidsforholdNrS() {
        return "" + arbeidsforholdNr;
    }


//Skriver ut informasjonen som har blitt utfylt i utskriftsområdet
    public String toString(){
        String utskrift = "\nArbeidsforhold Nummer: " + arbeidsforholdNr + "\nVikariat: " + vikariat.getVikariatNr() + "\nVikar: " +
                vikar.getVikarNr() + "\nArbeidsforhold: " + arbeidsforhold;
        return utskrift;                
    }
}//end Arbeidforhold
