/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

public class KundeRegister implements Serializable {
    
    public Kunde fforste, fsiste;
    
    public KundeRegister(){
        fforste = null;
    }
   
    public void settInn(Kunde ny){
        if(ny == null){
            return;
        }
        if(fforste == null){
            fforste = fsiste = ny;
        }
        else{
            fsiste.neste= ny;
            fsiste = ny;
        }
        
    }
    
    public Kunde finnKunde(String kundeNavn){
        return null;
    }
    
    public String[] getKundeNavn(){
        String[] kundeNavn = new String[getAntallNoder()];
        Kunde løper = fforste;
        for(int i = 0; i < getAntallNoder(); i++){
            kundeNavn[i] = løper.getNavn();
            løper = løper.neste;
        }
        return kundeNavn;
    }
    
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Kunde løper = fforste;
        if(løper!=null){
            antall++;
            String forsteNavn = løper.getNavn();
            ok = true;
            løper = løper.neste;
            while(ok == true){
                if(løper!=null){
                    if(løper.getNavn()!=forsteNavn){
                        antall++;
                        løper = løper.neste;
                    }
                }
                else{
                    ok = false;
                }
            }
        }
        
        return antall;
    }
    public void skrivKundeListe(JTextArea kundeListe){
        Kunde loper = fforste;
        
        if(fforste == null){
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
