/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;
import java.util.ArrayList;

//Klassen lager nye registere og holder brukernavn og passord
public class Vikarbyraa implements Serializable {
    public KundeRegister kundeRegister = new KundeRegister();//Register med alle kundene
    public VikariatRegister vikariatRegister = new VikariatRegister();
    public ArbeidsforholdRegister arbeidsforholdRegister = new ArbeidsforholdRegister();
    public VikarRegister vikarRegister = new VikarRegister();
    public SoknadsRegister soknadsRegister = new SoknadsRegister();
    
    ArrayList<String> navneListe1 = new ArrayList<String>();
    ArrayList<String> passordListe1 = new ArrayList<String>();
    ArrayList<String> navneListe2 = new ArrayList<String>();
    ArrayList<String> passordListe2 = new ArrayList<String>();
    
    private int nesteVikariatNr = 10000;
    
    //Konstruktør
    public Vikarbyraa(){
        navneListe1.add("Andreas"); navneListe1.add("Arthur"); navneListe1.add("Jørgen");
        passordListe1.add("andreas"); passordListe1.add("arthur"); passordListe1.add("jørgen");
        navneListe2.add("Vikar");
        passordListe2.add("vikar");
        
        nesteVikariatNr();
    }
    
    //Metoden lager neste vikariatnummer
    public void nesteVikariatNr(){
        int nummer = vikariatRegister.finnNesteNummer();
        
        nesteVikariatNr = ++nummer;
    }
    
    //Metoden returnerer et vikariatnummer
    public int getNesteVikariatNr(){
        return nesteVikariatNr;
    }
    
    //Metoden setter et vikariatnummer
    public void setNesteVikariatNr(){
        nesteVikariatNr++;
    }
}//end Vikarbyraa
