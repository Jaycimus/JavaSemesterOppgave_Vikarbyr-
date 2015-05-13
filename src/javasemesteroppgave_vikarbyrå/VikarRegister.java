/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class VikarRegister implements Serializable {
    public Vikar forste, fsiste;
    
    public VikarRegister(){
        forste = null;
    }
    
    public void settInn(Vikar ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = fsiste = ny;
        else{
            fsiste.neste = ny;
            fsiste = ny;
        }
                    
    }
    
    public String[] getVikarerTilVikariat(String vikariatNr){
        String[] vikarer;
        List<String> list =new ArrayList<String>();
        boolean ok = false;
        Vikar loper = forste;
        if(loper!=null){
            if(loper.findVikariatNr(vikariatNr) == vikariatNr){
                list.add(loper.findVikariatNr(vikariatNr));
            }
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper != null){
                    if(loper.findVikariatNr(vikariatNr) == vikariatNr){
                        list.add(loper.findVikariatNr(vikariatNr));
                        loper = loper.neste;
                    }
                }
                else
                    ok = false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Det er ingen vikariater registrert for tiden.");
        }
        
        vikarer = list.toArray(new String[list.size()]);    
                
        return vikarer;        
    }
    
    public void skrivVikarListe(JTextArea vikarListe){
        Vikar loper = forste;
        
        if(forste == null){
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
