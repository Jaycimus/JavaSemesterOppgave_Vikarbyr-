/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;

public class Vikariat implements Serializable {
    private String firma;
    private String arbeidsted;
    //private int vikariatNr;
    //private Date varighet;
    private String arbeidstid;
    private String stillingstype;
    private String kvalifikasjoner;
    private String lonnsbetingelser;
    private String kontaktinfo;
    private String stillingsInfo;
    //private SoknadsRegister soknadReg;
    /*Arbeidssted
    Jobbkategori
    Engasjementets varighet
    Arbeidstid
    Stillingstype
    Kvalifikasjoner
    Lønnsbetingelser
    Andre arbeidsvilkår?
    Kontaktinfo
    Stillings Beskrivelse
    Søknads Register*/
    
    public Vikariat neste;
    
    public Vikariat (String firma, String arbeidsted, String arbeidstid, 
            String stillingstype, String kvalifikasjoner, String lonnsbetingelser, 
                String kontaktinfo, String stillingsInfo){
        this.firma = firma;
        this.arbeidsted = arbeidsted;
        this.arbeidstid = arbeidstid;
        this.stillingstype = stillingstype;
        this.kvalifikasjoner = kvalifikasjoner;
        this.lonnsbetingelser = lonnsbetingelser;
        this.kontaktinfo = kontaktinfo;
        this.stillingsInfo = stillingsInfo;
    }
    
    public String toStringShort(){
        String utskrift = firma + "\nAdresse: " + arbeidsted;
       
        return utskrift;
    }
    
    public String toString(){
        String utskrift = "\nFirma navn: " + firma + "\nAdresse: " + arbeidsted + 
                          "\nArbeidstid: " + arbeidstid + "\nStillingstype: " + stillingstype + 
                          "\nKvalifikasjoner: " + kvalifikasjoner + "\nLønnsbetingelser: " + lonnsbetingelser +
                          "\nKontaktinfo: " + kontaktinfo + "\nStillingsinfo: " + stillingsInfo;
        
        return utskrift;
        
    }


    
}
