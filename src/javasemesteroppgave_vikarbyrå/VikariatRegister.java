/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 13. Mai 2015 AV: Jørgen DYhre
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class VikariatRegister implements Serializable {
    
    public Vikariat forste, fsiste;
    
    public VikariatRegister(){
        forste = null;
    }
    
    public void settInn(Vikariat ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = fsiste = ny;
        else{
            fsiste.neste = ny;
            fsiste = ny;
        }
                    
    }
    
    public String[] getVikariaterTilKunde(String kundeNavn){
        String[] vikariater;
        List<String> list = new ArrayList<>();
        boolean ok = false;
        Vikariat loper = forste;
        if(loper!=null){
            if(loper.getKundeNavn().matches(kundeNavn)){
                list.add(loper.getVikariatNrS());
            }
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper != null && loper.getKundeNavn() == kundeNavn){
                    list.add(loper.getVikariatNrS());
                    loper = loper.neste;
                }
                else
                    ok = false;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Det er ingen vikariater registrert for tiden.");
        }
        
        vikariater = list.toArray(new String[list.size()]);    
                
        return vikariater;        
    }
    
    public int finnNesteNummer(){
        int nummer = 10000;
        Vikariat loper = forste;
        while(loper!=null)
        {
            if(nummer <= loper.getVikariatNr())
            {
                nummer = loper.getVikariatNr();
                return nummer;
            }
        }
        return nummer;
    }
    
    public void skrivVikariatListe(JTextArea vikariatListe){
        Vikariat loper = forste;
        
        if(forste == null){
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
