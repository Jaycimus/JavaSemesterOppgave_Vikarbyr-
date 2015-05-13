/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

public class SoknadsRegister implements Serializable {
    
    public Soknad forste, fsiste;
    
    public SoknadsRegister(){
        forste = null;        
    }
    
        
    public void settInn(Soknad ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = fsiste = ny;
        else{
            fsiste.neste = ny;
            fsiste = ny;
        }                    
    }
    
    public void skrivVikarListe(JTextArea soknadListe){
        Soknad loper = forste;
        
        if(forste == null){
            soknadListe.setText("Ingen soknad i registeret");
        } else {
            soknadListe.setText("");            
            while(loper!=null){                
                soknadListe.append(loper.toString()+"\n");                
                loper = loper.neste;
            }
        }
    }
    
    
        
    
}
