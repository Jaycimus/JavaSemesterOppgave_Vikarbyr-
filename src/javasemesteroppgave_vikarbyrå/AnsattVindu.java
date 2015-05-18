/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//Denne klassen bygger opp det vinduet som man ser når man logger inn som en ansatt
public class AnsattVindu extends JFrame{
    private final JPanel meny;
    private JPanel cards, registrering, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10; 
    private final JButton regKunde, regVikariat, regArbForhold, regVikar, vikarVikariat, visEndreKundeReg, visEndreVikariatReg, visEndreArbeisforholdReg, visEndreVikarReg, regSoking, loggUt;
    private final JTextArea utskrift;
    
    private Vikarbyraa v;
    
    private Color bakgrunn;
    
    //Konstruktøren til vinduet man ser når man logger inn med ansatt-id.
    public AnsattVindu(Vikarbyraa v){
        this.v = v;

        bakgrunn = v.getFarge().getBakrunn();
        
        BorderLayout borderLayout = new BorderLayout(10, 10);
        setLayout(borderLayout);
         setLayout(new BorderLayout(10, 10));
        regKunde = new JButton("Registrer Kunde");
            regKunde.setFocusPainted(false);
            regKunde.setContentAreaFilled(false);
        regVikariat = new JButton("Registrer Vikariat");
        regArbForhold = new JButton("Registrer Arbeidsfohold");
        regVikar = new JButton("Registrer Vikar");
        vikarVikariat = new JButton("Vikar->Vikariat");
        visEndreKundeReg = new JButton("Vis/Endre Kundregister");
        visEndreVikariatReg = new JButton("Vis/Endre Vikariatregister");
        visEndreArbeisforholdReg = new JButton("Vis/Endre Arbeisforholdregister");
        visEndreVikarReg = new JButton("Vis/Endre Vikar register");
        regSoking = new JButton("Søk i Registerene");
        loggUt = new JButton("Logg Ut");
        
        Knappelytter lytter = new Knappelytter();
            regKunde.addActionListener(lytter);
            regVikariat.addActionListener(lytter);
            regArbForhold.addActionListener(lytter);
            regVikar.addActionListener(lytter);
            vikarVikariat.addActionListener(lytter);
            visEndreKundeReg.addActionListener(lytter);
            visEndreVikariatReg.addActionListener(lytter);
            visEndreArbeisforholdReg.addActionListener(lytter);
            visEndreVikarReg.addActionListener(lytter);
            regSoking.addActionListener(lytter);
            loggUt.addActionListener(lytter);
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,5));
        meny.setPreferredSize(new Dimension(212, 200));
        meny.setBorder(new EmptyBorder(5,5,5,0));
        meny.add(regKunde);
        meny.add(regVikariat);
        meny.add(regVikar);
        meny.add(vikarVikariat);
        meny.add(regArbForhold);
        meny.add(new JPanel());
        meny.add(visEndreKundeReg);
        meny.add(visEndreVikariatReg);
        meny.add(visEndreVikarReg);
        meny.add(visEndreArbeisforholdReg);
        meny.add(regSoking);
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(loggUt);
        
        utskrift = new JTextArea(0, 0);
        utskrift.setEditable(false);
        utskrift.setText(bruksanvisning());
        JScrollPane sp = new JScrollPane(utskrift);
        sp.setBorder(new EmptyBorder(10,0,10,0));
        
        registrering = new JPanel();
            registrering.setLayout(null);
            registrering.setPreferredSize(new Dimension(500, 500));
        card1 = new RegistrerKunde(utskrift, v);
        card2 = new RegistrerVikariat(utskrift, v);
        card3 = new RegistrerVikar(utskrift, v);
        card4 = new RegistrerVikarTilVikariat(utskrift, v);
        card5 = new RegistrerArbeidsforhold(utskrift, v);
        card6 = new EndreKunde(utskrift, v);
        card7 = new EndreVikariat(utskrift, v);
        card8 = new EndreVikar(utskrift, v);
        card9 = new EndreArbeidsforhold(utskrift, v);
        card10 = new SokningIRegister(utskrift, v);
        
        cards = new JPanel(new CardLayout());
        cards.setBorder(new EmptyBorder(5,0,5,5));
        cards.add(registrering, "Registrering");//Det første blanke feltet som bli opprettet
        cards.add(card1, "RegistrerKunde");
        cards.add(card2, "RegistrerVikariat");
        cards.add(card3, "RegistrerVikar");
        cards.add(card4, "RegistrerVikarTilVikariat");
        cards.add(card5, "RegistrerArbeidsforhold");
        cards.add(card6, "EndreKunde");
        cards.add(card7, "EndreVikariat");
        cards.add(card8, "EndreVikar");
        cards.add(card9, "EndreArbeidsforhold");
        cards.add(card10, "SokningIRegister");
        
        add(cards, BorderLayout.EAST);
        add(meny, BorderLayout.WEST);
        add(sp, BorderLayout.CENTER);
        cardLayoutUpdate();
    }//end AnsattVindu
    
    private void cardLayoutUpdate(){
        card1 = new RegistrerKunde(utskrift, v);
        card2 = new RegistrerVikariat(utskrift, v);
        card3 = new RegistrerVikar(utskrift, v);
        card4 = new RegistrerVikarTilVikariat(utskrift, v);
        card5 = new RegistrerArbeidsforhold(utskrift, v);
        card6 = new EndreKunde(utskrift, v);
        card7 = new EndreVikariat(utskrift, v);
        card8 = new EndreVikar(utskrift, v);
        card9 = new EndreArbeidsforhold(utskrift, v);
        card10 = new SokningIRegister(utskrift, v);
        
        cards.removeAll();
        
        cards.add(registrering, "Registrering");//Det første blanke feltet som bli opprettet
        cards.add(card1, "RegistrerKunde");
        cards.add(card2, "RegistrerVikariat");
        cards.add(card3, "RegistrerVikar");
        cards.add(card4, "RegistrerVikarTilVikariat");
        cards.add(card5, "RegistrerArbeidsforhold");
        cards.add(card6, "EndreKunde");
        cards.add(card7, "EndreVikariat");
        cards.add(card8, "EndreVikar");
        cards.add(card9, "EndreArbeidsforhold");
        cards.add(card10, "SokningIRegister");
    }

    //Skriver ut kunderegister
    private void visKundeReg(){
        v.getKundeRegister().skrivHeleKundeListe(utskrift);
    }
    
    //Skriver ut vikariatregister
    private void visVikariatReg(){
        v.getVikariatRegister().skrivVikariatListe(utskrift);
    }
    
    //Skriver ut arbeidsforholdregister
    private void visArbeisforholdReg(){
        v.getArbeidsforholdRegister().skrivArbeidsforholdiste(utskrift);
    }
    
    //Skriver ut vikarregister
    private void visVikarReg(){
        v.getVikarRegister().skrivVikarListe(utskrift);
    }
    
    //Knytter knappene på venstre siden av menyen til en lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Knappen "Registrer Kunde"
            if(e.getSource()==regKunde){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "RegistrerKunde");
            }
            
            //Knapppen "Registrer Vikariat"
            else if(e.getSource()==regVikariat){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "RegistrerVikariat");
            }
                        
            //Knapppen "Registrer Vikar"
            else if(e.getSource()==regVikar){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "RegistrerVikar");
            }
            //Knappen "vikar->vikariat"
            else if(e.getSource()==vikarVikariat){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "RegistrerVikarTilVikariat");
            }
            
            //Knappen "Registrer Arbeidsforhold"
            else if(e.getSource()==regArbForhold){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "RegistrerArbeidsforhold");
            }
            
            //Knappen "Vis/Endre Kunde"
            else if(e.getSource()==visEndreKundeReg){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "EndreKunde");
                visKundeReg();
            }
            
            //Knappen "Vis/Endre Vikariat"
            else if(e.getSource()==visEndreVikariatReg){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "EndreVikariat");
                visVikariatReg();
            }
            
            //Knappen "Vis/Endre Vikar"
            else if(e.getSource()==visEndreVikarReg){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "EndreVikar");
                visVikarReg();
            }
            
            //Knappen "Vis/Endre Arbeidsfohold"
            else if(e.getSource()==visEndreArbeisforholdReg){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "EndreArbeidsforhold");
                visArbeisforholdReg();
            }
            
            //Knappe "Søk i registerene
            else if(e.getSource()==regSoking){
                cardLayoutUpdate();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "SokningIRegister");
            }
            
            //Knappen "Logg ut"
            else if(e.getSource()==loggUt){
                Logginn logginn = new Logginn(v);
                logginn.setSize(new Dimension(400,180));
                logginn.setVisible(true);
                logginn.setLocationRelativeTo(null);
                logginn.setResizable(false);
                logginn.addWindowListener( new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        logginn.skrivTilFil();                       
                        System.exit(0);
                    }
                });
                setVisible(false);
            }
        }
    }//end Knappelytter
    
    //Det første som er skrevet i utskriftområdet når man begynner programmet
    //er en bruksanvisning som forteller hva som kan gjøres i programmet.
    private String bruksanvisning(){
        String bruksanvisning = 
                    "\t\tBruksanvisning\n"
                +"\nVelg på venstre siden av skjermen om du vil registrere"
                    +"\nKunde, Vikariat, Arbeidsforhold eller Vikar.\n"
                +"\nEtter det så vil det komme tekstfelt som må fylles ut på høyre side.\n"
                +"\nAvslutt med å tryke på registreringsknappen nederst på høyre side."
                +"\n\n\n\n\n\n\n"
                +"På venstre side ";
        
        return bruksanvisning;
    }
}//end AnsattVindu


