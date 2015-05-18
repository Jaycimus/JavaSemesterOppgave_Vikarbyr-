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
    private String onsketBransjer;
    private String utdanning;
    private String jobberfaring;
    private String referanser;
    private String kjonn;
    private String epost;
    
    Vikar neste;
    
    private ArrayList<Vikariat> vikariatNr = new ArrayList<>();
    private ArrayList<Soknad> soknader = new ArrayList<>();
        
    //Konstruktør
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
    
    //Finner vikariatnummer
    public int findVikariatNr(int vikariatNr){
        for(int i = 0; i < this.vikariatNr.size(); i++){
            if(this.vikariatNr.get(i).getVikariatNr() == vikariatNr)
                return this.vikariatNr.get(i).getVikariatNr();
        }
        return 0;
    }

    public void setSoknad(Soknad s){
        soknader.add(s);
    }
    
    //Setter inn vikariat
    public void setVikariat(Vikariat v){
        vikariatNr.add(v);
    }
    
    //Returnerer vikariatnummer fra lista
    public ArrayList<Vikariat> getVikariatListe() {
        return vikariatNr;
    }

    //Returnerer navn når den er kalt på
    public String getNavn() {
        return navn;
    }

    //Returnerer telefonnummer når den blir kalt på
    public int getTlf() {
        return tlf;
    }

    //Returnerer personnummer når den blir kalt på
    public long getPersonNr() {
        return personNr;
    }

    //Returnerer ønsket bransje vikaren vil jobbe på
    public String getOnsketBransjer() {
        return onsketBransjer;
    }

    //Returnerer utdanningen som vikaren har
    public String getUtdanning() {
        return utdanning;
    }

    //Returnerer jobberfaringen vikaren har
    public String getJobberfaring() {
        return jobberfaring;
    }

    //Returnerer referansen(e) vikaren har
    public String getReferanser() {
        return referanser;
    }

    //Returnerer kjønnet til vikaren
    public String getKjonn() {
        return kjonn;
    }

    //Returnerer e-posten til vikaren
    public String getEpost() {
        return epost;
    }

    //Setter navn på vikaren
    public void setNavn(String navn) {
        this.navn = navn;
    }

    //Setter telefonummeret på vikaren
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    //Setter personnummeret på vikaren
    public void setPersonNr(long personNr) {
        this.personNr = personNr;
    }

    //Settet vikarens ønsker til bransjen
    public void setOnsketBransjer(String onsketBransjer) {
        this.onsketBransjer = onsketBransjer;
    }

    //Setter hvem utdanning vikaren har
    public void setUtdanning(String utdanning) {
        this.utdanning = utdanning;
    }

    //Setter jobberfaringen(e) vikaren har
    public void setJobberfaring(String jobberfaring) {
        this.jobberfaring = jobberfaring;
    }

    //Setter referansen(e) vikaren har
    public void setReferanser(String referanser) {
        this.referanser = referanser;
    }

    //Setter kjønnet på vikaren
    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    //Setter e-post adressen på vikaren
    public void setEpost(String epost) {
        this.epost = epost;
    }
    
    public String toStringShort(){
        String utskrift = "\nVikar navn: " + navn + "\nPersonnummer: " + personNr;
        return utskrift;
    }
    
    public String toStringUtenVikariat(){
        String utskrift = "\nVikar navn: " + navn + "\nTelefonnr.: " + tlf + "\nE-post: " + epost +
                          "\nPersonnummer: " + personNr + "\nØnsket bransje: " + onsketBransjer +
                          "\nUtdanning: " + utdanning + "\nKjønn: " + kjonn +
                          "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser;
        return utskrift;
    }

    //Skriver ut info om vikaren i utskriftområdet
    public String toString(){
        String utskrift = "\nVikar navn: " + navn + "\nTelefonnr.: " + tlf + "\nE-post: " + epost +
                          "\nPersonnummer: " + personNr + "\nØnsket bransje: " + onsketBransjer +
                          "\nUtdanning: " + utdanning + "\nKjønn: " + kjonn +
                          "\nJobberfaring: " + jobberfaring + "\nReferanser: " + referanser + "\nViakriarer: ";
                          if(vikariatNr.size()!=0){
                              for(int i=0;i<vikariatNr.size();i++){
                              utskrift += "\t" + vikariatNr.get(i).toStringShort();
                              } 
                          }else
                              utskrift += "Ingen vikariater";
        return utskrift;
    }
}//end Vikar
