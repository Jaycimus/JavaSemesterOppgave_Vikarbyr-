/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;

public class Vikariat implements Serializable {
    private String kunde;
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
    //private SoknadsRegister soknadReg;
    /*Jobbkategori
    Engasjementets varighet
    Andre arbeidsvilkår?
    Søknads Register*/

    
    public Vikariat neste;
    
    public Vikariat (String kunde, String arbeidsted, String arbeidstid, 
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
       
    }
    public String getAdresse(){
        return adresse;
    }
    
    public String getArbeidstid(){
        return arbeidstid;
    }
    
    public String getStillingstype(){
        return stillingstype;
    }
    
    public String getKvalifikasjoner(){
        return kvalifikasjoner;
    }
    
    public String getLonnsbetingelser(){
        return lonnsbetingelser;
    }
    
    public String getKontaktinfo(){
        return kontaktinfo;
    }
    
    public String getStillingsinfo(){
        return stillingsInfo;
    }
    
    public String getVarighetfra(){
        return varighetfra;
    }
    
    public String getVarighettil(){
        return varighettil;
    }
    
    public String getBransje(){
        return bransje;
    }
    
    
    
    public int getVikariatNr(){
        return vikariatNr;
    }
    
    public String getVikariatNrS(){
        String vikariatNrS = "" + vikariatNr;
        return vikariatNrS;
    }
    
    public String getKundeNavn(){
        return kunde;
    }
    
    public String toStringShort(){
        String utskrift = kunde + "\nAdresse: " + adresse;
       
        return utskrift;
    }
    
    public String toString(){
        String utskrift = "\nKunde navn: " + kunde + "\nVikariat Nr: " + vikariatNr + "\nAdresse: " + adresse + 
                          "\nArbeidstid: " + arbeidstid + "\nStillingstype: " + stillingstype + 
                          "\nKvalifikasjoner: " + kvalifikasjoner + "\nLønnsbetingelser: " + lonnsbetingelser +
                          "\nKontaktinfo: " + kontaktinfo + "\nStillingsinfo: " + stillingsInfo+
                          "\nVarighet: " + varighetfra + "\nTil: " + varighettil;
        
        return utskrift;
        
    }
}
