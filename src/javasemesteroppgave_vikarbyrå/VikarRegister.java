/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Klassen setter vikar-objektene i registeret
public class VikarRegister implements Serializable {
    public Vikar forste, siste;
    
    //Konstruktør
    public VikarRegister(){
        forste = null;
    }
    
    //Setter inn vikaren i lista
    public void settInn(Vikar ny){
        if(ny==null)
            return;
        if(forste == null)
            forste = siste = ny;
        else{
            siste.neste = ny;
            siste = ny;
        }
    }
    
    //Finner en bestemt vikar
    public Vikar finnVikar(long personNr){
        Vikar loper = forste;
        boolean ok = true;
        while(ok){
            if(loper != null && loper.getPersonNr()==personNr){
                return loper;
            }
            else if(loper.neste!=null)
                loper = loper.neste;
            else
                ok = false;
        }
        return null;
    }
    
    public String[] getVikarer(){
        String[] vikarer = new String[1+getAntallNoder()];
        Vikar loper = forste;
        vikarer[0] = "---Vikarer---";
        for(int i = 1; i <= getAntallNoder(); i++){
            vikarer[i] = loper.getNavn();
            loper = loper.neste;
        }
        return vikarer;
    }
    
    public Vikar[] getVikarerObjekter(){
        Vikar[] vikarer = new Vikar[getAntallNoder()];
        Vikar loper = forste;
        for(int i = 0; i < getAntallNoder(); i++){
            vikarer[i] = loper;
            loper = loper.neste;
        }
        return vikarer;
    }
    
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Vikar loper = forste;
        if(loper!=null){
            antall++;
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper!=null){
                    antall++;
                    loper = loper.neste;
                }
                else{
                    ok = false;
                }
            }
        }
        
        return antall;
    }//end getAntallNoder
    
    //
    public String[] getVikarerTilVikariat(int vikariatNr){
        String[] vikarer;
        List<String> list =new ArrayList<String>();
        boolean ok = false;
        Vikar loper = forste;
        if(loper!=null){
            if(loper.findVikariatNr(vikariatNr) == vikariatNr){
                String s = "" + vikariatNr;
                list.add(s);
            }
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper != null){
                    if(loper.findVikariatNr(vikariatNr) == vikariatNr){
                        String s = "" + vikariatNr;
                        list.add(s);
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

    public String skrivVikarTilVikariatListe(JTextArea utskrift, String vikariatNr){
        Vikar loper = forste;
        
        if(forste == null){
            utskrift.setText("Ingen vikar i registeret");
        } else {
            utskrift.setText("");            
            while(loper!=null){   
                String vikariat = "" + loper.findVikariatNr(Integer.parseInt(vikariatNr)); 
                if(vikariat.equals(vikariatNr)){
                    utskrift.setText(loper.toStringUtenVikariat());
                    return "" + loper.getPersonNr();
                } else 
                    loper = loper.neste;
            }
        }
        return null;
    }
    
    //Skriver ut en liste med vikarer
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
    
}//end VikarRegister
