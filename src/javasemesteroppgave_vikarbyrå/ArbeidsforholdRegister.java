/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

public class ArbeidsforholdRegister implements Serializable {
    public Arbeidsforhold fforste, fsiste;
    
    public ArbeidsforholdRegister(){
        fforste = null;
    }
    
    public void settInn(Arbeidsforhold ny){
        if(ny==null)
            return;
        if(fforste == null)
            fforste = fsiste = ny;
        else{
            fsiste.neste = ny;
            fsiste = ny;
        }
                    
    }
    public void skrivArbeidsforholdiste(JTextArea arbeidsforholdiste){
        Arbeidsforhold loper = fforste;
        
        if(fforste == null){
            arbeidsforholdiste.setText("Ingen Arbeidsforhold i registeret");
        } else {
            arbeidsforholdiste.setText("");            
            while(loper!=null){                
                arbeidsforholdiste.append(loper.toString()+"\n");                
                loper = loper.neste;
            }
        }
    }
}
