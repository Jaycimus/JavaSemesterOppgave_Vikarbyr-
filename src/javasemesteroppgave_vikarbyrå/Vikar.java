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
    
    private ArrayList<Vikariat> vikariatNr = new ArrayList<>();
        
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
    
    public int findVikariatNr(int vikariatNr){
        for(int i = 0; i < this.vikariatNr.size(); i++){
            if(this.vikariatNr.get(i).getVikariatNr() == vikariatNr)
                return this.vikariatNr.get(i).getVikariatNr();
        }
        return 0;
    }

    public void setVikariat(Vikariat v){
        vikariatNr.add(v);
    }
    
    public ArrayList<Vikariat> getVikariatNr() {
        return vikariatNr;
    }

    public String getNavn() {
        return navn;
    }

    public int getTlf() {
        return tlf;
    }

    public long getPersonNr() {
        return personNr;
    }

    public String getOnsketBransjer() {
        return onsketBransjer;
    }

    public String getUtdanning() {
        return utdanning;
    }

    public String getJobberfaring() {
        return jobberfaring;
    }

    public String getReferanser() {
        return referanser;
    }

    public String getKjonn() {
        return kjonn;
    }

    public String getEpost() {
        return epost;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public void setPersonNr(long personNr) {
        this.personNr = personNr;
    }

    public void setOnsketBransjer(String onsketBransjer) {
        this.onsketBransjer = onsketBransjer;
    }

    public void setUtdanning(String utdanning) {
        this.utdanning = utdanning;
    }

    public void setJobberfaring(String jobberfaring) {
        this.jobberfaring = jobberfaring;
    }

    public void setReferanser(String referanser) {
        this.referanser = referanser;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
    
    public String toString(){
        String utskrift = "\nVikar navn: " + navn + "\nTelefonnr.: " + tlf + "\nE-post: " + epost +
                          "\nPersonnummer: " + personNr + "\nØnsket bransje: " + onsketBransjer +
                          "\nUtdanning: " + utdanning + "\nKjønn: " + kjonn +
                          "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser;
        return utskrift;
    }
}
