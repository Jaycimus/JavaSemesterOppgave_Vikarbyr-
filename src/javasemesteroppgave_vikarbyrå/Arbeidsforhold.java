/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;

//Klassen bygger opp forhold mellom firma og vikar som arbeidsforhold
public class Arbeidsforhold implements Serializable {
    private Vikariat vikariat;
    private Vikar vikar;
    private String arbeidsforhold;
    
    Arbeidsforhold neste;
    
    //Konstruktør
    public Arbeidsforhold(Vikariat vikariat, Vikar vikar, String arbeidsforhold){
        this.vikariat = vikariat;
        this.vikar = vikar;
        this.arbeidsforhold = arbeidsforhold;
    }
    
    //Returnerer vikariat
    public Vikariat getVikariat(){
        return vikariat;
    }
    
    //Returnerer vikar
    public Vikar getVikar(){
        return vikar;
    }
    
    //Returnerer arbeidsforhold
    public String getArbeidsforhold(){
        return arbeidsforhold;
    }
    
    //Setter ny vikariat gjennom parameter
    public void setVikariat(Vikariat v){
        this.vikariat = v;
    }
    
    //Setter ny vikar gjennom parameteret
    public void setVikar(Vikar v){
        this.vikar = v;
    }
    
    //Setter nytt arbeidsforhold gjennom parameteret
    public void setArbeidsforhold(String forhold){
        this.arbeidsforhold = forhold;
    }
    
    //Skriver ut informasjonen som har blitt utfylt i utskriftsområdet
    public String toString(){
        String utskrift = "\nVikariat: " + vikariat.toStringShort() + "\nVikar: " +
                vikar.getPersonNr() + "\nArbeidsforhold: " + arbeidsforhold;
        return utskrift;                
    }
}//end Arbeidforhold
