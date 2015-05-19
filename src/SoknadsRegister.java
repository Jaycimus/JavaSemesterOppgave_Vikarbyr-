/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Jørgen Dyhre


import java.io.Serializable;
import javax.swing.JTextArea;

//Klassen holder alle søknads-objektene i et register
public class SoknadsRegister implements Serializable {
    
    public Soknad forste, siste;
    
    //Konstruktør
    public SoknadsRegister(){
        forste = null;        
    }
    
    //Setter inn en ny søknad inn i lista
    public void settInn(Soknad ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = siste = ny;
        else{
            siste.neste = ny;
            siste = ny;
        }                    
    }
    
    //Skriver ut søknadene som registrert
    public void skrivSoknadTilVikariatListe(JTextArea soknadListe, String vikariatNr){
        Soknad loper = forste;
        
        if(forste == null){
            soknadListe.setText("Ingen soknader inne");
        } else {
            soknadListe.setText("");            
            while(loper!=null){                
                if(loper.getVikariat().getVikariatNrS().equals(vikariatNr))
                soknadListe.append(loper.toString()+"\n");                
                loper = loper.neste;
            }
        }
    } 
}//end SoknadsRegister
