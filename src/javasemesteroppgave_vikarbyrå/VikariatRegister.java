/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;


public class VikariatRegister implements Serializable {
    
    public Vikariat fforste, fsiste;
    
    public VikariatRegister(){
        fforste = null;
    }
    
    public void settInn(Vikariat ny){
        if(ny==null)
            return;
        if(fforste == null)
            fforste = fsiste = ny;
        else{
            fsiste.neste = ny;
            fsiste = ny;
        }
                    
    }
    public void skrivVikariatListe(JTextArea vikariatListe){
        Vikariat loper = fforste;
        
        if(fforste == null){
            vikariatListe.setText("Ingen vikariater i registeret");
        } else {
            vikariatListe.setText("");
            
            while(loper!=null){
                
                vikariatListe.append(loper.toString()+"\n");
                
                loper = loper.neste;
            }
        }
    }
}
