/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;

public class Vikar implements Serializable{
    private String navn;
    private int tlf;
    private long personNr;
    private String onsketBransjer;
    private String utdanning;
    private String jobberfaring;
    private String referanser;
    private String kjonn;
    private String epost;
    
    Vikar neste;
    
    private ArrayList<String> vikariatNr = new ArrayList<>();
        
    public Vikar(String navn, int tlf, String epost, long personNr, String onsketBransjer, String utdanning, String kjonn, String jobberfaring, String referanser){
        this.navn = navn;
        this.tlf = tlf;
        this.epost = epost;
        this.personNr = personNr;
        this.onsketBransjer = onsketBransjer;
        this.utdanning = utdanning;
        this.kjonn = kjonn;
        this.jobberfaring = jobberfaring;
        this.referanser = referanser;
        neste = null;
        
    }
    
    public String findVikariatNr(String vikariatNr){
        for(int i = 0; i < this.vikariatNr.size(); i++){
            if(this.vikariatNr.get(i).matches(vikariatNr))
                return this.vikariatNr.get(i);
        }
        
        return null;
    }
    
    public long getPersonNr(){
        return personNr;
    }
    
    public String getVikariatNr(){
        return null;
    }
    
    public String toString(){
        String utskrift = "\nVikar navn: " + navn + "\nTelefonnr.: " + tlf + "\nE-post: " + epost +
                          "\nPersonnummer: " + personNr + "\nØnsket bransje: " + onsketBransjer +
                          "\nUtdanning: " + utdanning + "\nKjønn: " + kjonn +
                          "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser;
        return utskrift;
    }
}
