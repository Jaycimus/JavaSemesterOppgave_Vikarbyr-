/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.io.Serializable;
import javax.swing.JTextArea;

//Klassen er for å ha alle de forskjelle kundene i et refister
public class KundeRegister implements Serializable {
    
    public Kunde forste, siste;
    
    //Konstruktør
    public KundeRegister(){
        forste = null;
    }
   
    //Setter inn et kunde-objekt i lista
    public void settInn(Kunde ny){
        if(ny == null){
            return;
        }
        if(forste == null){
            forste = siste = ny;
        }
        else{
            siste.neste = ny;
            siste = ny;
        }
        
    }
    
    //Finner en bestemt kunde
    public Kunde finnKunde(String kundeNavn){
        Kunde loper = forste;
        for(int i = 0; i < getAntallNoder(); i++){
            if(loper.getNavn().equals(kundeNavn))
                return loper;
            else
                loper = loper.neste;
        } 
        return null;
    }
    
    //Sletter en bestemt kunde hvis funnet
    public boolean slettKunde(String kundeNavn){
        Kunde loper = forste;        
        
        if(forste.getNavn().equals(kundeNavn)){
            forste = forste.neste;
            return true;
        }
        
        if (loper.neste == null){
            forste = null;
            return true;
        }
        
        if(loper.getNavn().equals(kundeNavn)){
            loper = loper.neste;
            return true;
        }
        
        while(loper.neste != null){
            if(loper.neste.getNavn().equals(kundeNavn)){
                loper.neste = loper.neste.neste;
                return true;
            }
            else{
                loper = loper.neste;
            }
        }
        
        loper = finnNestSisteNode();
        if(loper.getNavn().equals(kundeNavn)){
            loper.neste = null;
        }
        
        return false;
    }
    
    //Lager en liste med navn på kundene som er registrert
    public String[] getKundeNavn(){
        String[] kundeNavn = new String[1+getAntallNoder()];
        Kunde loper = forste;
        kundeNavn[0] = "---Kunder---";
        for(int i = 1; i <= getAntallNoder(); i++){
            kundeNavn[i] = loper.getNavn();
            loper = loper.neste;
        }
        return kundeNavn;
    }
    
    //Teller antall noder det finnes i lista
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Kunde loper = forste;
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
    
    public Kunde finnNestSisteNode(){
        Kunde loper = forste;
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
    
    //Skriver ut enten om det ikke finnes noen kunder, eller alle registrerte kunder
    public void skrivHeleKundeListe(JTextArea utskrift){
        Kunde loper = forste;
        
        if(forste == null){
            utskrift.setText("Ingen kunde i registeret!");
        }
        else{
            utskrift.setText("KUNDEREGISTER\n");
            
            while(loper!=null){
                
                utskrift.append(loper.toString()+"\n");
                
                loper = loper.neste;
            }                
        }        
    }//end skrivKundeListe()  
    
    public void skrivKunde(JTextArea utskrift, String kundeNavn){
        Kunde loper = forste;
        
        if(forste == null){
            utskrift.setText("Ingen kunder i registeret!");
        }
        else{
            while(loper!=null){
                if(loper.getNavn().equals(kundeNavn)){
                        utskrift.setText(loper.toString());
                        return;
                }
                loper = loper.neste;
            }
            utskrift.setText("Ingen kunder i registeret med navnet: " + kundeNavn);
        }        
    }
    
    //metode skriver ut alle kunder med gitt sektor
    public void skrivKundeListeSektor(JTextArea utskrift, String sektor){
        Kunde loper = forste;
        String u = "";
        if(forste == null){
            utskrift.setText("Ingen kunde i registeret!");
        }
        else{
            while(loper!=null){
                if(loper.getTypeSektor().equals(sektor))
                    u += loper.toString() + "\n";
                
                loper = loper.neste;
            }   
        }
        if(u.matches("")){
            utskrift.setText("Ingen registrerte kunder innen for denne sektoren");
            return;
        } else {
            utskrift.setText(u);
        }
    }//end skrivKundeListeSektor()
    
    public void skrivKundeAdresse(JTextArea utskrift, String adresse){
        Kunde loper = forste;
        String u = "";
        if(forste == null){
            utskrift.setText("Ingen kunde i registeret!");
        }
        else{
            utskrift.setText("");
            
            while(loper!=null){
                if(loper.getAdresse().equals(adresse))
                    u += loper.toString() + "\n";
                
                loper = loper.neste;
            }
            
        }
        if(u.matches("")){
            utskrift.setText("Ingen registrerte kunder innen for denne sektoren");
            return;
        } else {
            utskrift.setText(u);
        }
    }
    
    public void skrivKundeEpost(JTextArea utskrift, String epost){
        Kunde loper = forste;
        String u = "";
        if(forste == null){
            utskrift.setText("Ingen kunde i registeret!");
        }
        else{
            utskrift.setText("");
            
            while(loper!=null){
                if(loper.getEpost().equals(epost))
                    u += loper.toString()+"\n";
                
                loper = loper.neste;
            }                
        } 
        if(u.matches("")){
            utskrift.setText("Ingen registrerte kunder innen for denne sektoren");
            return;
        } else {
            utskrift.setText(u);
        }
    }
    
    public void skrivKundeTlf(JTextArea utskrift, String tlf){
        Kunde loper = forste;
        
        if(forste == null){
            utskrift.setText("Ingen kunder i registeret!");
        }
        else{
            while(loper!=null){
                if(loper.getTlf().equals(tlf)){
                        utskrift.setText(loper.toString());
                        return;
                }
                loper = loper.neste;
            }
            utskrift.setText("Ingen kunder i registeret med tlf: " + tlf);
        }        
    }
}//end KundeRegister
