/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;

public class Vikar implements Serializable{
    private String navn;
    private int tlf;
    private int personNr;
    private String onsketBransjer;
    private String utdanning;
    private String jobberfaring;
    private String referanser;
    
    Vikar neste;
    
    private ArrayList<Arbeidsforhold> arbeidsforhold = new ArrayList<Arbeidsforhold>();
        
    public Vikar(String navn, int tlf, int personNr, String onsketBransjer, String utdanning, String jobberfaring, String referanser){
        this.navn = navn;
        this.tlf = tlf;
        this.personNr = personNr;
        this.onsketBransjer = onsketBransjer;
        this.utdanning = utdanning;
        this.jobberfaring = jobberfaring;
        this.referanser = referanser;
        neste = null;
        
    }
    
    public int getPersonNr(){
        return personNr;
    }
    
    public String toString(){
        String utskrift;
        String arbeidsforholdString = "";
        
        for(int i = 0; i < arbeidsforhold.size();i++){
            arbeidsforholdString += arbeidsforhold.toString();
        }
        
        utskrift = "\nNavn; " + navn + "\nTelefon: " + tlf + "\nPersonNr: " + personNr + 
                   "\nØnskede bransjer: " + onsketBransjer + "\nUtdanning: " + utdanning +
                   "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser +
                   "\nArbiedsforhold: " + arbeidsforholdString;
        
        return utskrift;
    }
}
