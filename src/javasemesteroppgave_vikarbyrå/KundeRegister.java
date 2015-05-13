/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 5. Mai 2015 AV: Jørgen Dyhre
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

public class KundeRegister implements Serializable {
    
    public Kunde forste, fsiste;
    
    public KundeRegister(){
        forste = null;
    }
   
    public void settInn(Kunde ny){
        if(ny == null){
            return;
        }
        if(forste == null){
            forste = fsiste = ny;
        }
        else{
            fsiste.neste= ny;
            fsiste = ny;
        }
        
    }
    
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
    
    public void slettKunde(String kundeNavn){
        Kunde loper = forste;
        
        if (loper.neste == null){
            forste = null;
            return;
        }
        
        if(loper.getNavn() == kundeNavn){
            loper = loper.neste.neste;
            return;
        }
        
        for(int i = 0; i < getAntallNoder(); i++){
            if(loper.neste.getNavn() == kundeNavn){
                loper.neste = loper.neste.neste;
                return;
            }
            else{
                loper = loper.neste;
            }
        }
    }
    
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
    }
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
    }   
}
