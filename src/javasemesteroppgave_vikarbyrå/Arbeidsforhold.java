/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 1. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import javax.swing.JTextArea;


public class Arbeidsforhold {
    Vikariat vikariat;
    Vikar vikar;
    private String arbeidsforhold;
    
    Arbeidsforhold neste;
    
    public Arbeidsforhold(Vikariat vikariat, Vikar vikar, String arbeidsforhold){
        this.vikariat = vikariat;
        this.vikar = vikar;
        this.arbeidsforhold = arbeidsforhold;
        
    }
    
    public String toString(){
        String utskrift = "\nVikariat: " + vikariat.toStringShort() + "\nVikar: " +
                vikar.getPersonNr() + "\nArbeidsforhold: " + arbeidsforhold;
        return utskrift;                
    }
}
