/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 7. Mai 2015 AV: Andreas Stenseng Bjørnrud
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
    public String getTypeSektor(){
        return typeSektor;
    }
    public String getAdresse(){
        return adresse;
    }
    
    public String getTlf(){
        String tlf = "" + this.tlf;
        return tlf;
    }
    public String getEpost(){
        return epost;
    }
    
    public String toString(){
        String utskrift = "\nKunde navn: " + navn + "\nType Sektor: " + typeSektor + 
                          "\nAdresse: " + adresse + 
                          "\nTelefon: " + tlf + "\nE-post: " + epost;
        return utskrift;
    }
}
