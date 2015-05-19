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
    
    public int finnNesteNummer(){
        int nummer = 99;
        Vikar loper = siste;
        while(loper!=null)
        {
            if(nummer < loper.getVikarNr()){
                nummer ++;                
            }           
            else{
                return nummer;
            }
        }
        return nummer;
    }
    
    public boolean slettVikar(String vikar){
        Vikar loper = forste;        
        
        if(forste.getPersonNrS().equals(vikar)){
            forste = forste.neste;
            return true;
        }
        
        if (loper.neste == null){
            forste = null;
            return true;
        }
        
        if(loper.getPersonNrS().equals(vikar)){
            loper = loper.neste;
            return true;
        }
        
        while(loper.neste != null){
            if(loper.neste.getPersonNrS().equals(vikar)){
                loper.neste = loper.neste.neste;
                return true;
            }
            else{
                loper = loper.neste;
            }
        }
        
        loper = finnNestSisteNode();
        if(loper.getPersonNrS().equals(vikar)){
            loper.neste = null;
        }
        
        return false;
    }
    
    public Vikar finnNestSisteNode(){
        Vikar loper = forste;
        boolean ok = true;
        while(ok){
            if(loper.neste.neste!=null){
                loper = loper.neste;
            } else {
                return loper;
            }
        }
        return loper;
    }
    
    //Finner en bestemt vikar
    public Vikar finnVikar(String vikarNr){
        int vikarNummer = Integer.parseInt(vikarNr);
        Vikar loper = forste;
        while(loper!=null){
            if(loper.getVikarNr()==vikarNummer){
                return loper;
            }
            else
                loper = loper.neste;
            
        }
        return null;
    }
    
    public String[] getVikarer(){
        String[] vikarer = new String[1+getAntallNoder()];
        Vikar loper = forste;
        vikarer[0] = "---Vikarer---";
        
        for(int i = 1; i <= getAntallNoder(); i++){
            vikarer[i] = loper.getVikarNrS();
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
                String s = loper.getVikarNrS();
                list.add(s);
            }
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper != null){
                    if(loper.findVikariatNr(vikariatNr) == vikariatNr){
                        String s = loper.getVikarNrS();
                        list.add(s);
                        loper = loper.neste;
                    }
                }
                else
                    ok = false;
            }
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
            vikarListe.setText("VIKAR REGISTER\n");            
            while(loper!=null){                
                vikarListe.append(loper.toString()+"\n");                
                loper = loper.neste;
            }
        }
    }
    
}//end VikarRegister
