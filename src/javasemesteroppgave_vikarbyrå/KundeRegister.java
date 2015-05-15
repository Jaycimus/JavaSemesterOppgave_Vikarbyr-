/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

//Klassen er for å ha alle de forskjelle kundene i et refister
public class KundeRegister implements Serializable {
    
    public Kunde forste, siste;
    
    //Konstruktør
    public KundeRegister(){
        forste = null;
    }
   
    //Setter inn et kunde-objekt i lista
    public void settInn(Kunde ny){
        if(ny == null){
            return;
        }
        if(forste == null){
            forste = siste = ny;
        }
        else{
            siste.neste= ny;
            siste = ny;
        }
        
    }
    
    //Finner en bestemt kunde
    public Kunde finnKunde(String kundeNavn){
        Kunde loper = forste;
        for(int i = 0; i < getAntallNoder(); i++){
            if(loper.getNavn()==kundeNavn)
                return loper;
            else
                loper = loper.neste;
        } 
        return null;
    }
    
    //Sletter en bestemt kunde hvis funnet
    public boolean slettKunde(String kundeNavn){
        Kunde loper = forste;
        
        if (loper.neste == null){
            forste = null;
            return true;
        }
        
        if(loper.getNavn() == kundeNavn){
            loper = loper.neste;
            return true;
        }
        
        while(loper.neste != null){
            if(loper.neste.getNavn() == kundeNavn){
                loper.neste = loper.neste.neste;
                return true;
            }
            else{
                loper = loper.neste;
            }
        }
        return false;
    }
    
    //Lager en liste med navn på kundene som er registrert
    public String[] getKundeNavn(){
        String[] kundeNavn = new String[1+getAntallNoder()];
        Kunde loper = forste;
        kundeNavn[0] = "---Kunder---";
        for(int i = 1; i <= getAntallNoder(); i++){
            kundeNavn[i] = loper.getNavn();
            loper = loper.neste;
        }
        return kundeNavn;
    }
    
    //Teller antall noder det finnes i lista
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Kunde loper = forste;
        if(loper!=null){
            antall++;
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper!=null){
                    antall++;
                    loper = loper.neste;
                }
                else{
                    ok = false;
                }
            }
        }
        
        return antall;
    }//end getAntallNoder
    
    //Skriver ut enten om det ikke finnes noen kunder, eller alle registrerte kunder
    public void skrivKundeListe(JTextArea kundeListe){
        Kunde loper = forste;
        
        if(forste == null){
            kundeListe.setText("Ingen kunde i registeret!");
        }
        else{
            kundeListe.setText("");
            
            while(loper!=null){
                
                kundeListe.append(loper.toString()+"\n");
                
                loper = loper.neste;
            }                
        }        
    }//end skrivKundeListe()   
}//end KundeRegister
