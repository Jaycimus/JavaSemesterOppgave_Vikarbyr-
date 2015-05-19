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
    
    public void finnVikariatOgSLettVikar(String personNr){
        Vikariat loper = forste;
        while(loper!=null){
            if(loper.getVikar().getPersonNrS().equals(personNr)){
                loper.setVikarer(null, true);
                return;
            }
            else
                loper = loper.neste;
        }
    }
    
    //Metode for å finne ledige vikariater
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
        
        vikariater = list.toArray(new String[list.size()]);    
                
        return vikariater;        
    }//end getLedigeViakriater()
    
    public String[] getOpptatteVikariater(){
        String[] vikariater;
        List<String> list = new ArrayList<>();
        list.add("---Vikariater---");
        boolean ok = false;
        Vikariat loper = forste;
        if(loper!=null){
            if(!loper.isLedig()){
                list.add(loper.getVikariatNrS());
            }
            ok = true;
            loper = loper.neste;
            while(ok == true){
                if(loper != null && !loper.isLedig()){
                    list.add(loper.getVikariatNrS());
                    loper = loper.neste;
                }
                else
                    ok = false;
            }
        }
        
        vikariater = list.toArray(new String[list.size()]);    
                
        return vikariater;        
    }//end getLedigeViakriater()
    
    //metode som henter alle vikariater
    public String[] getVikariatNr(){
        String[] vikariatNavn = new String[1+getAntallNoder()];
        Vikariat loper = forste;
        vikariatNavn[0] = "---Vikariater---";
        for(int i = 1; i <= getAntallNoder(); i++){
            vikariatNavn[i] = "" + loper.getVikariatNr();
            loper = loper.neste;
        }
        return vikariatNavn;
    }
    
    //metode for å finne antall noder i register
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Vikariat loper = forste;
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
    
    //Metode for å finne vikariater som tilhører en kunde
    public String[] getVikariaterTilKunde(String kundeNavn){
        System.out.println(kundeNavn);
        String[] vikariater;
        List<String> list = new ArrayList<>();
        Vikariat loper = forste;
        if(loper!=null){
            boolean ok = true;
            if(loper.getKundeNavn().matches(kundeNavn)){
                list.add(loper.getVikariatNrS());
            }
            loper = loper.neste;
            while(ok){
                System.out.println("while");
                if(loper!=null){
                    System.out.println("if");
                    if(loper.getKundeNavn().equals(kundeNavn)){
                        list.add(loper.getVikariatNrS());
                        loper = loper.neste;
                        System.out.println("das");
                    } else
                        loper = loper.neste;
                }
                else {
                    ok = false;
                    System.out.println("else");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Kunde har ingen registrerte vikariater");
        }
        
        vikariater = list.toArray(new String[list.size()]);    
        return vikariater;        
    }//end getVikariaterTilKunde
    
    public String[] getLedigeVikariaterTilKunde(String kundeNavn){
        System.out.println(kundeNavn);
        String[] vikariater;
        List<String> list = new ArrayList<>();
        list.add("---Vikariater---");
        Vikariat loper = forste;
        if(loper!=null){
            boolean ok = true;
            if(loper.isLedig() && loper.getKundeNavn().matches(kundeNavn)){
                list.add(loper.getVikariatNrS());
            }
            loper = loper.neste;
            while(ok){
                System.out.println("while");
                if(loper!=null){
                    System.out.println("if");
                    if(loper.isLedig() && loper.getKundeNavn().equals(kundeNavn)){
                        list.add(loper.getVikariatNrS());
                        loper = loper.neste;
                        System.out.println("das");
                    } else
                        loper = loper.neste;
                }
                else {
                    ok = false;
                    System.out.println("else");
                }
            }
        }
        
        vikariater = list.toArray(new String[list.size()]);    
        return vikariater;        
    }//end getVikariaterTilKunde
    
    //Lager neste vikariatnummer
    public int finnNesteNummer(){
        int nummer = 9999;
        Vikariat loper = siste;
        while(loper!=null){
            if(nummer < loper.getVikariatNr()){
                nummer ++;                
            }           
            else{
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
            vikariatListe.setText("VIKARIAT REGISTER\n");
            
            while(loper!=null){
                
                vikariatListe.append(loper.toString()+"\n");
                
                loper = loper.neste;
            }
        }
    }
    
    public String[] getOpptatteVikariaterTilKunde(String kundeNavn){
        System.out.println(kundeNavn);
        String[] vikariater;
        List<String> list = new ArrayList<>();
        list.add("---Vikariater---");
        Vikariat loper = forste;
        if(loper!=null){
            boolean ok = true;
            if(!loper.isLedig() && loper.getKundeNavn().matches(kundeNavn)){
                list.add(loper.getVikariatNrS());
            }
            loper = loper.neste;
            while(ok){
                System.out.println("while");
                if(loper!=null){
                    System.out.println("if");
                    if(!loper.isLedig() && loper.getKundeNavn().equals(kundeNavn)){
                        list.add(loper.getVikariatNrS());
                        loper = loper.neste;
                        System.out.println("das");
                    } else
                        loper = loper.neste;
                }
                else {
                    ok = false;
                    System.out.println("else");
                }
            }
        }
        vikariater = list.toArray(new String[list.size()]);    
        return vikariater;  
    }
    
    public void skrivOpptatteVikariatListeTilKunde(JTextArea vikariatListe, String navn){
        String[] vikariater;
        List<String> list = new ArrayList<>();
        Vikariat loper = forste;
        if(loper!=null){
            boolean ok = true;
            if(!loper.isLedig() && loper.getKundeNavn().matches(navn)){
                list.add(loper.toString());
            }
            loper = loper.neste;
            while(ok){
                System.out.println("while");
                if(loper!=null){
                    System.out.println("if");
                    if(!loper.isLedig() && loper.getKundeNavn().equals(navn)){
                        list.add(loper.toString());
                        loper = loper.neste;
                        System.out.println("das");
                    } else
                        loper = loper.neste;
                }
                else {
                    ok = false;
                    System.out.println("else");
                }
            }
            vikariater = list.toArray(new String[list.size()]); 
            String utskrift = "";
            for(int i = 0; i < vikariater.length; i++){
                utskrift += vikariater[i].toString() + "\n";
            }
            if(utskrift.matches("")){
                vikariatListe.setText("Ingen registrerte vikariater til kunde: " +  navn);
                return;
            }
            vikariatListe.setText(utskrift);
        }
        else{
            JOptionPane.showMessageDialog(null, "Det er ingen vikariater registrert for tiden.");
        }
    }
    
    //Skriver ut vikariatliste til kunde
    public void skrivLedigVikariatListeTilKunde(JTextArea vikariatListe, String navn){
        String[] vikariater;
        List<String> list = new ArrayList<>();
        Vikariat loper = forste;
        if(loper!=null){
            boolean ok = true;
            if(loper.isLedig() && loper.getKundeNavn().matches(navn)){
                list.add(loper.toString());
            }
            loper = loper.neste;
            while(ok){
                System.out.println("while");
                if(loper!=null){
                    System.out.println("if");
                    if(loper.isLedig() && loper.getKundeNavn().equals(navn)){
                        list.add(loper.toString());
                        loper = loper.neste;
                        System.out.println("das");
                    } else
                        loper = loper.neste;
                }
                else {
                    ok = false;
                    System.out.println("else");
                }
            }
            vikariater = list.toArray(new String[list.size()]); 
            String utskrift = "";
            for(int i = 0; i < vikariater.length; i++){
                utskrift += vikariater[i].toString() + "\n";
            }
            if(utskrift.matches("")){
                vikariatListe.setText("Ingen registrerte vikariater til kunde: " +  navn);
                return;
            }
            vikariatListe.setText(utskrift);
        }
        else{
            JOptionPane.showMessageDialog(null, "Det er ingen vikariater registrert for tiden.");
        }
    }
    
    //Sletting av vikariater til et firma som blir fjernet
    public boolean slettVikariat(String vikariatNr){
        Vikariat loper = forste;        
        
        if(forste.getVikariatNrS().equals(vikariatNr)){
            forste = forste.neste;
            return true;
        }
        
        if (loper.neste == null){
            forste = null;
            return true;
        }
        
        if(loper.getVikariatNrS().equals(vikariatNr)){
            loper = loper.neste;
            return true;
        }
        
        while(loper.neste != null){
            if(loper.neste.getVikariatNrS().equals(vikariatNr)){
                loper.neste = loper.neste.neste;
                return true;
            }
            else{
                loper = loper.neste;
            }
        }
        
        loper = finnNestSisteNode();
        if(loper.getVikariatNrS().equals(vikariatNr)){
            loper.neste = null;
        }
        
        return false;
    }
    
    public Vikariat finnNestSisteNode(){
        Vikariat loper = forste;
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
    
    public boolean slettVikariaterTilKunde(String kundeNavn){
        Vikariat loper = forste;
        if(loper==null){
            //JOptionPane.showMessageDialog(null, "Ingen registrerte vikariater");
            return false;
        } else if (loper.neste == null && loper.getKundeNavn().equals(kundeNavn)){
            forste = null;
            System.out.println("Slette eneste vikraiat");
            return true;
        } else {
            while(loper.neste != null){
                if(loper.neste.getKundeNavn().equals(kundeNavn)){
                    loper.neste = loper.neste.neste;
                    System.out.println("Vikariatnavn passet 2");
                    if(forste.getKundeNavn().equals(kundeNavn))
                        forste = forste.neste;
        
                } else {
                    loper = loper.neste;
                }
            }
        }
        return false;
        
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
