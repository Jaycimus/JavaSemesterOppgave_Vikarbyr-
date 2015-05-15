/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 13. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;

public class Arbeidsforhold implements Serializable {
    private Vikariat vikariat;
    private Vikar vikar;
    private String arbeidsforhold;
    
    Arbeidsforhold neste;
    
    public Arbeidsforhold(Vikariat vikariat, Vikar vikar, String arbeidsforhold){
        this.vikariat = vikariat;
        this.vikar = vikar;
        this.arbeidsforhold = arbeidsforhold;
    }
    
    public Vikariat getVikariat(){
        return vikariat;
    }
    public Vikar getVikar(){
        return vikar;
    }
    public String getArbeidsforhold(){
        return arbeidsforhold;
    }
    
    public void setVikariat(Vikariat v){
        this.vikariat = v;
    }
    public void setVikar(Vikar v){
        this.vikar = v;
    }
    public void setArbeidsforhold(String forhold){
        this.arbeidsforhold = forhold;
    }
    
    public String toString(){
        String utskrift = "\nVikariat: " + vikariat.toStringShort() + "\nVikar: " +
                vikar.getPersonNr() + "\nArbeidsforhold: " + arbeidsforhold;
        return utskrift;                
    }
}
