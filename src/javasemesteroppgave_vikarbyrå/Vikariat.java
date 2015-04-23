/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
package javasemesteroppgave_vikarbyrå;

public class Vikariat {
    private String firma;
    private String arbeidssted;
    //private int vikariatNr;
    //private Date varighet;
    private String arbeidstid;
    private String stillingstype;
    private String kvalifikasjoner;
    private String lønnsbetingelser;
    private String kontaktinfo;
    private String stillingsInfo;
    //private SoknadsRegister soknadReg;
    
    public Vikariat (String firma, String arbeidssted, String arbeidstid, String stillingstype, String kvalifikasjoner, String lønnsbetingelser, String kontaktinfo, String stillingsInfo){
        this.firma = firma;
        this.arbeidssted = arbeidssted;
        this.arbeidstid = arbeidstid;
        this.stillingstype = stillingstype;
        this.kvalifikasjoner = kvalifikasjoner;
        this.lønnsbetingelser = lønnsbetingelser;
        this.kontaktinfo = kontaktinfo;
        this.stillingsInfo = stillingsInfo;
    }
    
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

    
}
