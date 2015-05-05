/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.Date;

public class Vikariat implements Serializable {
    private String kunde;
    private String adresse;
    //private int vikariatNr;
    private Date[] varighet;
    private String arbeidstid;
    private String stillingstype;
    private String kvalifikasjoner;
    private String lonnsbetingelser;
    private String kontaktinfo;
    private String stillingsInfo;
    //private SoknadsRegister soknadReg;
    /*Jobbkategori
    Engasjementets varighet
    Andre arbeidsvilkår?
    Søknads Register*/
    
    public Vikariat neste;
    
    public Vikariat (String kunde, String arbeidsted, String arbeidstid, 
            String stillingstype, String kvalifikasjoner, String lonnsbetingelser, 
                String kontaktinfo, String stillingsInfo){
        this.kunde = kunde;
        this.adresse = arbeidsted;
        this.arbeidstid = arbeidstid;
        this.stillingstype = stillingstype;
        this.kvalifikasjoner = kvalifikasjoner;
        this.lonnsbetingelser = lonnsbetingelser;
        this.kontaktinfo = kontaktinfo;
        this.stillingsInfo = stillingsInfo;
    }
    
    /*public int getVikariatNr(){
        return vikariatNr;
    }*/
    
    public String toStringShort(){
        String utskrift = kunde + "\nAdresse: " + adresse;
       
        return utskrift;
    }
    
    public String toString(){
        String utskrift = "\nKunde navn: " + kunde + "\nAdresse: " + adresse + 
                          "\nArbeidstid: " + arbeidstid + "\nStillingstype: " + stillingstype + 
                          "\nKvalifikasjoner: " + kvalifikasjoner + "\nLønnsbetingelser: " + lonnsbetingelser +
                          "\nKontaktinfo: " + kontaktinfo + "\nStillingsinfo: " + stillingsInfo;
        
        return utskrift;
        
    }


    
}
