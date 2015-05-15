/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;

//Klassen lager et kunde-objekt
public class Kunde implements Serializable{
    private String navn;
    private String typeSektor;
    private String adresse;
    private String epost;
    private int tlf;
       
    public Kunde neste;
    
    //Kontruktør
    public Kunde(String navn, String typeSektor, String adresse, 
                    int tlf, String epost){
        this.navn = navn;
        this.typeSektor = typeSektor;
        this.adresse = adresse;
        this.tlf = tlf;
        this.epost = epost;
        this.neste = null;
    }

    //Returnerer navn når metoden blir kalt på
    public String getNavn(){
        return navn;
    }
    
    //Setter navn på kunden
    public void setNavn(String navn){
        this.navn = navn;
    }
    
    //Returnerer om kunden er i privat eller offentlig sektor
    public String getTypeSektor(){
        return typeSektor;
    }
    
    //Setter sektor på kunden om det er valgt "privat" eller "offentlig"
    public void setTypeSektor(String typeSektor){
        this.typeSektor = typeSektor;
    }
    
    //Returnerer adressen til kunden når metoden blir kalt
    public String getAdresse(){
        return adresse;
    }
    
    //Setter innlest adresse på kunden
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    //Returnerer telfonnummeret til kunden når metoden blir kalt
    public String getTlf(){
        String tlf = "" + this.tlf;
        return tlf;
    }
    
    //Setter innlest telefonnummer på kunden
    public void setTlf(int tlf){
        this.tlf = tlf;
    }
    
    //Returnerer e-post adressen til kuneden når metoden blir kalt
    public String getEpost(){
        return epost;
    }
    
    //Setter innlest e-post adresse på kunden
    public void setEpost(String epost){
        this.epost = epost;
    }
    
    //Skriver ut all innlest informasjon til utskriftsområdet
    public String toString(){
        String utskrift = "\nKunde navn: " + navn + "\nType Sektor: " + typeSektor + 
                          "\nAdresse: " + adresse + 
                          "\nTelefon: " + tlf + "\nE-post: " + epost;
        return utskrift;
    }
}//end Kunde
