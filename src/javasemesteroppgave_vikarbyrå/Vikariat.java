/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

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
    
    public Vikariat neste;
    
    public Vikariat (String kunde, String arbeidsted, String arbeidstid, 
            String stillingstype, String kvalifikasjoner, String lonnsbetingelser, 
                String kontaktinfo, String stillingsInfo, String varighetfra, String varighettil){
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
       
    }
    
    public int getVikariatNr(){
        return vikariatNr;
    }
    
    public String getKundeNavn(){
        return kunde;
    }
    
    public String toStringShort(){
        String utskrift = kunde + "\nAdresse: " + adresse;
       
        return utskrift;
    }
    
    public String toString(){
        String utskrift = "\nKunde navn: " + kunde + "\nAdresse: " + adresse + 
                          "\nArbeidstid: " + arbeidstid + "\nStillingstype: " + stillingstype + 
                          "\nKvalifikasjoner: " + kvalifikasjoner + "\nLønnsbetingelser: " + lonnsbetingelser +
                          "\nKontaktinfo: " + kontaktinfo + "\nStillingsinfo: " + stillingsInfo+
                          "\nVarighet: " + varighetfra + "\nTil: " + varighettil;
        
        return utskrift;
        
    }


    
}
