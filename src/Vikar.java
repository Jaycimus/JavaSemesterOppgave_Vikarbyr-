/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.io.Serializable;
import java.util.ArrayList;

//Klassen lager et vikar-objekt
public class Vikar implements Serializable{
    private String navn;
    private int tlf;
    private long personNr;
    private String onsketBransje;
    private String utdanning;
    private String jobberfaring;
    private String referanser;
    private String kjonn;
    private String epost;
    
    Vikar neste;
    
    private ArrayList<Vikariat> vikariater = new ArrayList<>();
    private ArrayList<Soknad> soknader = new ArrayList<>();
        
    //Konstruktør
    public Vikar(String navn, int tlf, String epost, long personNr, 
            String onsketBransje, String utdanning, String kjonn, String jobberfaring, 
            String referanser){
        this.navn = navn;
        this.tlf = tlf;
        this.epost = epost;
        this.personNr = personNr;
        this.onsketBransje = onsketBransje;
        this.utdanning = utdanning;
        this.kjonn = kjonn;
        this.jobberfaring = jobberfaring;
        this.referanser = referanser;
        neste = null;
    }
    
    //Finner vikariatnummer
    public int findVikariatNr(int vikariatNr){
        for(int i = 0; i < this.vikariater.size(); i++){
            if(this.vikariater.get(i).getVikariatNr() == vikariatNr)
                return this.vikariater.get(i).getVikariatNr();
        }
        return 0;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public long getPersonNr() {
        return personNr;
    }
    
    public String getPersonNrS(){
        return "" + personNr;
    }

    public void setPersonNr(long personNr) {
        this.personNr = personNr;
    }

    public String getOnsketBransje() {
        return onsketBransje;
    }

    public void setOnsketBransje(String onsketBransje) {
        this.onsketBransje = onsketBransje;
    }

    public String getUtdanning() {
        return utdanning;
    }

    public void setUtdanning(String utdanning) {
        this.utdanning = utdanning;
    }

    public String getJobberfaring() {
        return jobberfaring;
    }

    public void setJobberfaring(String jobberfaring) {
        this.jobberfaring = jobberfaring;
    }

    public String getReferanser() {
        return referanser;
    }

    public void setReferanser(String referanser) {
        this.referanser = referanser;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public Vikar getNeste() {
        return neste;
    }

    public void setNeste(Vikar neste) {
        this.neste = neste;
    }

    public ArrayList<Vikariat> getVikariatNr() {
        return vikariater;
    }

    public void setVikariater(Vikariat vikar) {
        this.vikariater.add(vikar);
    }

    public ArrayList<Soknad> getSoknader() {
        return soknader;
    }

    public void setSoknader(Soknad soknad) {
        this.soknader.add(soknad);
    }

    
    
    public String toStringShort(){
        String utskrift = "\nVikar navn: " + navn + "\nPersonnummer: " + personNr;
        return utskrift;
    }
    
    public String toStringUtenVikariat(){
        String utskrift = "\nVikar navn: " + navn + "\nTelefonnr.: " + tlf + "\nE-post: " + epost +
                          "\nPersonnummer: " + personNr + "\nØnsket bransje: " + onsketBransje +
                          "\nUtdanning: " + utdanning + "\nKjønn: " + kjonn +
                          "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser;
        return utskrift;
    }

    //Skriver ut info om vikaren i utskriftområdet
    public String toString(){
        String utskrift = "\nVikar navn: " + navn + "\nTelefonnr.: " + tlf + "\nE-post: " + epost +
                          "\nPersonnummer: " + personNr + "\nØnsket bransje: " + onsketBransje +
                          "\nUtdanning: " + utdanning + "\nKjønn: " + kjonn +
                          "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser + "\nVikariater: ";
                          if(vikariater.size()!=0){
                              for(int i=0;i<vikariater.size();i++){
                              utskrift += "\t" + vikariater.get(i).toStringShort();
                              } 
                          }else
                              utskrift += "Ingen vikariater";
        return utskrift;
    }
}//end Vikar
