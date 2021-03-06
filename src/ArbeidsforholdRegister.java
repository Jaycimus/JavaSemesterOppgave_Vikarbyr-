/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Jørgen Dyhre


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
    
    public boolean slettArbeidsforhold(String arbeidsforholdNr){
        Arbeidsforhold loper = forste;        
        
        if(forste.getArbeidsforholdNrS().equals(arbeidsforholdNr)){
            forste = forste.neste;
            return true;
        }
        
        if (loper.neste == null){
            forste = null;
            return true;
        }
        
        if(loper.getArbeidsforholdNrS().equals(arbeidsforholdNr)){
            loper = loper.neste;
            return true;
        }
        
        while(loper.neste != null){
            if(loper.neste.getArbeidsforholdNrS().equals(arbeidsforholdNr)){
                loper.neste = loper.neste.neste;
                return true;
            }
            else{
                loper = loper.neste;
            }
        }
        
        loper = finnNestSisteNode();
        if(loper.getArbeidsforholdNrS().equals(arbeidsforholdNr)){
            loper.neste = null;
        }
        
        return false;
    }
   
    public Arbeidsforhold finnNestSisteNode(){
        Arbeidsforhold loper = forste;
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
    
    public Arbeidsforhold finnArbeidsforhold(String arbeidsforholdNr){
        int arbeidsforholdNummer = Integer.parseInt(arbeidsforholdNr);
        Arbeidsforhold loper = forste;
        while(loper!=null){
            if(loper.getArbeidsforholdNr()==arbeidsforholdNummer){
                return loper;
            }
            else
                loper = loper.neste;
            
        }
        return null;
    }
    
    public String[] getArbeidsforhold(){
        String[] arbeidsforhold = new String[1+getAntallNoder()];
        Arbeidsforhold loper = forste;
        arbeidsforhold[0] = "---Arbeidsforhold---";
        
        for(int i = 1; i <= getAntallNoder(); i++){
            arbeidsforhold[i] = "" + loper.getArbeidsforholdNr();
            loper = loper.neste;
        }
        return arbeidsforhold;
    }
    
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Arbeidsforhold loper = forste;
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
    
    public String[] getArbeidsforholdTilVikar(int vikarNr){
        String[] arbeidsforhold = new String[1+getAntallNoderTilVikar(vikarNr)];
        Arbeidsforhold loper = forste;
        arbeidsforhold[0] = "---Arbeidsforhold---";
        
        for(int i = 1; i <= getAntallNoder(); i++){
            arbeidsforhold[i] = "" + loper.getArbeidsforholdNr();
            loper = loper.neste;
        }
        return arbeidsforhold;
    }
    
    public int getAntallNoderTilVikar(int vikariatNr){
        int antall = 0;
        Arbeidsforhold loper = forste;
        while(loper!=null){
            if(1>2){
                antall++;
                loper = loper.neste;
            }
        }
        return antall;
    }//end getAntallNoder
    
    public String[] getArbeidsforholdTilVikariat(int vikariatNr){
        String[] arbeidsforhold = new String[1+getAntallNoderTilVikariat(vikariatNr)];
        Arbeidsforhold loper = forste;
        arbeidsforhold[0] = "---Arbeidsforhold---";
        
        for(int i = 1; i <= getAntallNoder(); i++){
            arbeidsforhold[i] = "" + loper.getArbeidsforholdNr();
            loper = loper.neste;
        }
        return arbeidsforhold;
    }
    
    public int getAntallNoderTilVikariat(int vikariatNr){
        int antall = 0;
        Arbeidsforhold loper = forste;
        while(loper!=null){
            if(loper.getVikariat().getVikariatNr()==vikariatNr){
                antall++;
                loper = loper.neste;
            }
        }
        return antall;
    }//end getAntallNoder
    
    public int finnNesteNummer(){
        int nummer = 99999;
        Arbeidsforhold loper = siste;
        while(loper!=null)
        {
            if(nummer < loper.getArbeidsforholdNr()){
                nummer ++;                
            }           
            else{
                return nummer;
            }
        }
        return nummer;
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
