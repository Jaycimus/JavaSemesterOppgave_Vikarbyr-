/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Klassen setter vikariat.objektene i registeret
public class VikariatRegister implements Serializable {
    
    public Vikariat forste, siste;
    
    //Konstruktør
    public VikariatRegister(){
        forste = null;
    }
    
    //Setter inn vikariat i lista
    public void settInn(Vikariat ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = siste = ny;
        else{
            siste.neste = ny;
            siste = ny;
        }
                    
    }
    
    //Finner et bestemt vikariat
    public Vikariat finnVikariat(int vikariatNr){
        Vikariat loper = forste;
        boolean ok = true;
        while(ok){
            if(loper != null && loper.getVikariatNr()==vikariatNr){
                return loper;
            }
            else
                loper = loper.neste;
        }
        return null;
    }
    
    //Metode for å finne ledige vikariater for en vikar
    public String[] getLedigeVikariater(){
        String[] vikariater;
        List<String> list = new ArrayList<>();
        list.add("---Vikariater---");
        boolean ok = false;
        Vikariat loper = forste;
        if(loper!=null){
            if(loper.isLedig()){
                list.add(loper.getVikariatNrS());
            }
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper != null && loper.isLedig()){
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
    }//end getLedigeViakriater()
    
    //Metode for å finne vikariater som tilhører en kunde
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
    }//end getVikariaterTilKunde
    
    //Lager neste vikariatnummer
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
    
    //Skriver ut vikariatliste
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
    
    //Skriver ut de vikariatene med ledig stilling
    public void skrivLedigVikariatListe(JTextArea utskrift){
        Vikariat loper = forste;
        
        if(forste == null){
            utskrift.setText("Ingen vikariater i registeret");
        } else {
            utskrift.setText("");
            
            while(loper!=null){
                if(loper.isLedig())
                    utskrift.append(loper.toString()+"\n");
                
                loper = loper.neste;
            }
        }
    }
}//end VikarRegister
