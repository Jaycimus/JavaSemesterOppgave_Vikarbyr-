/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 8. Mai 2015 AV: Andreas Stenseng Bjørnrud


import java.io.Serializable;
import java.util.ArrayList;

//Klassen lager nye registere og holder brukernavn og passord
public class Vikarbyraa implements Serializable {
    private KundeRegister kundeRegister = new KundeRegister();//Register med alle kundene
    private VikariatRegister vikariatRegister = new VikariatRegister();
    private ArbeidsforholdRegister arbeidsforholdRegister = new ArbeidsforholdRegister();
    private VikarRegister vikarRegister = new VikarRegister();
    private SoknadsRegister soknadsRegister = new SoknadsRegister();
    private Farge farge = new Farge();
    private Fonts fonts = new Fonts();
    
    ArrayList<String> navneListe1 = new ArrayList<>();
    ArrayList<String> passordListe1 = new ArrayList<>();
    ArrayList<String> navneListe2 = new ArrayList<>();
    ArrayList<String> passordListe2 = new ArrayList<>();
    
    ArrayList<String> vikarHistorikk = new ArrayList<>();
    ArrayList<String> vikariatHistorikk = new ArrayList<>();
    ArrayList<String> kundeHistorikk = new ArrayList<>();
    ArrayList<String> arbeidsforholdHistorikk = new ArrayList<>();
    
    private int nesteVikariatNr = 10000;
    private int nesteArbeidsforholdNr = 10000;
    private int nesteVikarNr = 100;
    
    //Konstruktør
    public Vikarbyraa(){
        navneListe1.add("Andreas"); navneListe1.add("Arthur"); navneListe1.add("Jørgen");
        passordListe1.add("andreas"); passordListe1.add("arthur"); passordListe1.add("jørgen");
        navneListe2.add("Vikar");
        passordListe2.add("vikar");
        
        nesteVikariatNr();
        nesteArbeidsforholdNr();
        nesteVikarNr();
    }
    
    public Fonts getFonts(){
        return fonts;
    }
    
    public Farge getFarge(){
        return farge;
    }

    public KundeRegister getKundeRegister() {
        return kundeRegister;
    }

    public VikariatRegister getVikariatRegister() {
        return vikariatRegister;
    }

    public ArbeidsforholdRegister getArbeidsforholdRegister() {
        return arbeidsforholdRegister;
    }

    public VikarRegister getVikarRegister() {
        return vikarRegister;
    }

    public SoknadsRegister getSoknadsRegister() {
        return soknadsRegister;
    }
    
    //Metoden lager neste vikariatnummer
    public void nesteVikariatNr(){
        int nummer = vikariatRegister.finnNesteNummer();
        nesteVikariatNr = ++nummer;
    }
    
    public void nesteArbeidsforholdNr(){
        int nummer = arbeidsforholdRegister.finnNesteNummer();
        nesteArbeidsforholdNr = ++nummer;
    }
    
    public void nesteVikarNr(){
        int nummer = vikarRegister.finnNesteNummer();
        nesteVikarNr = ++nummer;
    }
    
    //Metoden returnerer et vikariatnummer
    public int getNesteVikariatNr(){
        return nesteVikariatNr;
    }
    
    public int getNesteArbeidsforholdNr(){
        return nesteArbeidsforholdNr;
    }
    
    //Metoden returnerer et vikariatnummer
    public int getNesteVikarNr(){
        return nesteVikarNr;
    }
    
    //Metoden setter et vikariatnummer
    public void setNesteVikariatNr(){
        nesteVikariatNr++;
    }
    
    public void setNesteArbeidsforholdNr(){
        nesteArbeidsforholdNr++;
    }
    
    public void setNesteVikarNr(){
        nesteVikarNr++;
    }
}//end Vikarbyraa
