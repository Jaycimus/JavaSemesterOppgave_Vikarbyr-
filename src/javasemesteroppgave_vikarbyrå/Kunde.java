/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 13. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Font;
import java.io.Serializable;

public class Kunde implements Serializable{
    private String navn;
    private String typeSektor;
    private String adresse;
    
    private int tlf;
    private String epost;
    
    public Kunde neste;
    
    public Kunde(String navn, String typeSektor, String adresse, 
                    int tlf, String epost){
        this.navn = navn;
        this.typeSektor = typeSektor;
        this.adresse = adresse;
        
        this.tlf = tlf;
        this.epost = epost;
        this.neste = null;
    }

    public String getNavn(){
        return navn;
    }
    
    public void setNavn(String navn){
        this.navn = navn;
    }
    
    public String getTypeSektor(){
        return typeSektor;
    }
    
    public void setTypeSektor(String typeSektor){
        this.typeSektor = typeSektor;
    }
    
    public String getAdresse(){
        return adresse;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public String getTlf(){
        String tlf = "" + this.tlf;
        return tlf;
    }
    
    public void setTlf(int tlf){
        this.tlf = tlf;
    }
    
    public String getEpost(){
        return epost;
    }
    
    public void setEpost(String epost){
        this.epost = epost;
    }
   
    public String toString(){
        String utskrift = "\nKunde navn: " + navn + "\nType Sektor: " + typeSektor + 
                          "\nAdresse: " + adresse + 
                          "\nTelefon: " + tlf + "\nE-post: " + epost;
        return utskrift;
    }
}
