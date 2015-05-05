/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

public class VikarRegister implements Serializable {
    public Vikar fforste, fsiste;
    
    public VikarRegister(){
        fforste = null;
    }
    
    public void settInn(Vikar ny){
        if(ny==null)
            return;
        if(fforste == null)
            fforste = fsiste = ny;
        else{
            fsiste.neste = ny;
            fsiste = ny;
        }
                    
    }
    public void skrivVikarListe(JTextArea vikarListe){
        Vikar loper = fforste;
        
        if(fforste == null){
            vikarListe.setText("Ingen vikar i registeret");
        } else {
            vikarListe.setText("");            
            while(loper!=null){                
                vikarListe.append(loper.toString()+"\n");                
                loper = loper.neste;
            }
        }
    }
    
}
