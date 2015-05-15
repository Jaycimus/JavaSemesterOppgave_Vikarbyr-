/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;

//Klassen lager vikariat-objekt
public class Vikariat implements Serializable {
    private String adresse;
    private int vikariatNr;
    private String varighetfra, varighettil;
    private String arbeidstid;
    private String stillingstype;
    private String kvalifikasjoner;
    private String lonnsbetingelser;
    private String kontaktinfo;
    private String stillingsInfo;
    private String bransje;
    
    private boolean ledig;
    private ArrayList<Arbeidsforhold> arbeidsforhold = new ArrayList<>();
    private ArrayList<Soknad> soknader = new ArrayList<>();
    
    public Vikariat neste;
    private Kunde kunde;
    
    //Konstruktør
    public Vikariat (Kunde kunde, String arbeidsted, String arbeidstid, 
            String stillingstype, String kvalifikasjoner, String lonnsbetingelser, 
                String kontaktinfo, String stillingsInfo, String varighetfra, String varighettil, 
                    String Bransje, int vikariatNr){
        this.kunde = kunde;
        this.adresse = arbeidsted;
        this.arbeidstid = arbeidstid;
        this.stillingstype = stillingstype;
        this.kvalifikasjoner = kvalifikasjoner;
        this.lonnsbetingelser = lonnsbetingelser;
        this.kontaktinfo = kontaktinfo;
        this.stillingsInfo = stillingsInfo;
        this.varighetfra = varighetfra;
        this.varighettil = varighettil;
        this.bransje = bransje;
        this.vikariatNr = vikariatNr;
        
        ledig = true;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVarighetfra(String varighetfra) {
        this.varighetfra = varighetfra;
    }

    public void setVarighettil(String varighettil) {
        this.varighettil = varighettil;
    }

    public void setArbeidstid(String arbeidstid) {
        this.arbeidstid = arbeidstid;
    }

    public void setStillingstype(String stillingstype) {
        this.stillingstype = stillingstype;
    }

    public void setKvalifikasjoner(String kvalifikasjoner) {
        this.kvalifikasjoner = kvalifikasjoner;
    }

    public void setLonnsbetingelser(String lonnsbetingelser) {
        this.lonnsbetingelser = lonnsbetingelser;
    }

    public void setKontaktinfo(String kontaktinfo) {
        this.kontaktinfo = kontaktinfo;
    }

    public void setStillingsInfo(String stillingsInfo) {
        this.stillingsInfo = stillingsInfo;
    }

    public void setBransje(String bransje) {
        this.bransje = bransje;
    }
        
    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }
    
    //Metoden setter søknad
    public void setSoknad(Soknad s){
        soknader.add(s);
    }

    //Om et vikariat er ledig så returneres det ledig
    public boolean isLedig() {
        return ledig;
    }

    //Setter om et vikariat er ledig
    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }
           
    //Returnerer adressen til vikariatet
    public String getAdresse(){
        return adresse;
    }
    
    //Returnerer tiden vikariatet skal ha
    public String getArbeidstid(){
        return arbeidstid;
    }
    
    //Returnerer stillingstypen vikariat har
    public String getStillingstype(){
        return stillingstype;
    }
    
    //Returnerer kvalifikasjoner jobben skal ha
    public String getKvalifikasjoner(){
        return kvalifikasjoner;
    }
    
    //Returnerer lønnsbetingelsene til jobben
    public String getLonnsbetingelser(){
        return lonnsbetingelser;
    }
    
    //Returnere kontaktinfo til jobben
    public String getKontaktinfo(){
        return kontaktinfo;
    }
    
    //Returnere stillingsinfoen til jobben
    public String getStillingsinfo(){
        return stillingsInfo;
    }
    
    //Returnerer når vikariatet starter
    public String getVarighetfra(){
        return varighetfra;
    }
    
    //Returnerer når vikariatet avsluttes
    public String getVarighettil(){
        return varighettil;
    }
    
    //Returnerer hvem bransje vikariatet er innafor
    public String getBransje(){
        return bransje;
    }
    
    //Returnerer nummeret på vikariatet
    public int getVikariatNr(){
        return vikariatNr;
    }
    
    //Returnerer vikariatnummerstreng
    public String getVikariatNrS(){
        String vikariatNrS = "" + vikariatNr;
        return vikariatNrS;
    }
    
    //Returnerer firmanavn
    public String getKundeNavn(){
        return kunde.getNavn();
    }
    
    //Returnerer en forkortet versjon av info til utskriftområde
    public String toStringShort(){
        String utskrift = "\nKunde Navn: " + kunde + "\nVikariat Nr: " + vikariatNr;
        return utskrift;
    }
    
    //Returnerer innskrvet info til utskriftsområdet
    public String toString(){
        String utskrift = "\nKunde navn: " + kunde.getNavn() + "\nVikariat Nr: " + vikariatNr + "\nAdresse: " + adresse + 
                          "\nVarighet: " + varighetfra + "\nTil: " + varighettil + "\nArbeidstid: " + arbeidstid + 
                          "\nStillingstype: " + stillingstype + "\nKvalifikasjoner: " + kvalifikasjoner + 
                          "\nLønnsbetingelser: " + lonnsbetingelser + "\nKontaktinfo: " + kontaktinfo + 
                          "\nStillingsinfo: " + stillingsInfo;
        return utskrift;
    }
}//end Vikariat
