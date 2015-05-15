/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import javax.swing.JTextArea;

public class ArbeidsforholdRegister implements Serializable {
    public Arbeidsforhold forste, siste;
    
    public ArbeidsforholdRegister(){
        forste = null;
    }
    
    public void settInn(Arbeidsforhold ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = siste = ny;
        else{
            siste.neste = ny;
            siste = ny;
        }
                    
    }
    public void skrivArbeidsforholdiste(JTextArea arbeidsforholdiste){
        Arbeidsforhold loper = forste;
        
        if(forste == null){
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
