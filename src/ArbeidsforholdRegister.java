/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.io.Serializable;
import javax.swing.JTextArea;

//Klassen holder register over alle arbeidsforhold
public class ArbeidsforholdRegister implements Serializable {
    public Arbeidsforhold forste, siste;
    
    //Konstruktør
    public ArbeidsforholdRegister(){
        forste = null;
    }
    
    //Setter inn nytt arbeidfohold i listen
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
    
    //Skriver ut en liste med arbeidsforhold (eldst-nyest)
    public void skrivArbeidsforholdiste(JTextArea arbeidsforholdiste){
        Arbeidsforhold loper = forste;
        
        if(forste == null){
            arbeidsforholdiste.setText("Ingen Arbeidsforhold i registeret");
        } else {
            arbeidsforholdiste.setText("ARBEIDSFORHOLD REGISTER\n");            
            while(loper!=null){                
                arbeidsforholdiste.append(loper.toString()+"\n");                
                loper = loper.neste;
            }
        }
    }
}//end ArbeidsforholdRegister
