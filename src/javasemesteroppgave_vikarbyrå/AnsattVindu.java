/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
public class AnsattVindu extends JPanel{
    private final JPanel meny, registrering, bunn, topp, a, b, c; //a,b,c er tomme paneler som tilhører meny
    private final JButton regKunde, regVikariat, regArbForhold, regVikar, vikarVikariat, visEndreKundeReg, visEndreVikariatReg, visEndreArbeisforholdReg, visEndreVikarReg, regSoking, loggUt;
    private final JTextArea utskrift;
    private final JFrame ramme; //rammen på programmet
    
    private Vikarbyraa v;
    
    private RegistrerKunde rk;
    private RegistrerVikariat rv;
    private RegistrerArbeidsforhold raf;
    private RegistrerVikar rvv;
    private RegistrerVikarTilVikariat rvtv;
    private EndreKunde ek;
    private EndreVikariat evt;
    //private EndreArbeidsforhold eaf;
    private EndreVikar ev;
    //private Sokning s;
    
    private final Color bakgrunn;
    
    //Konstruktøren til vinduet man ser når man logger inn med ansatt-id.
    public AnsattVindu(Vikarbyraa v, JFrame ramme){
        this.v = v;
        this.ramme = ramme;
        bakgrunn = v.farge.getBakrunn();
        
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(0, 5, 0, 5));
        
        this.setBackground(bakgrunn);
        
        regKunde = new JButton("Registrer Kunde");
            /*regKunde.setFocusPainted(false);
            regKunde.setMargin(new Insets(0, 0, 0, 0));
            regKunde.setContentAreaFilled(false);
            regKunde.setBorderPainted(false);
            regKunde.setOpaque(false);*/
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
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,10));
        meny.setPreferredSize(new Dimension(212, 200));
        meny.add(regKunde);
        meny.add(regVikariat);
        meny.add(regVikar);
        meny.add(vikarVikariat);
        meny.add(regArbForhold);
        a = new JPanel();
        a.setBackground(bakgrunn);
        meny.add(a);
        meny.add(visEndreKundeReg);
        meny.add(visEndreVikariatReg);
        meny.add(visEndreVikarReg);
        meny.add(visEndreArbeisforholdReg);
        meny.add(regSoking);
        b = new JPanel();
        b.setBackground(bakgrunn);
        meny.add(b);
        c = new JPanel();
        c.setBackground(bakgrunn);
        meny.add(c);
        meny.add(loggUt);
        meny.setBackground(bakgrunn);
        
        utskrift = new JTextArea(0, 0);
        utskrift.setEditable(false);
        utskrift.setText(bruksanvisning());
        JScrollPane sp = new JScrollPane(utskrift);
                
        registrering = new JPanel();
        registrering.setLayout(null);
        registrering.setPreferredSize(new Dimension(500, 500));
        
        bunn = new JPanel();
        bunn.setLayout(null);
        bunn.setPreferredSize(new Dimension(50, 0));
        
        
        topp = new JPanel();
        topp.setLayout(null);
        topp.setPreferredSize(new Dimension(50,0));
        
        add(topp, BorderLayout.NORTH);
        add(meny, BorderLayout.WEST);
        add(sp, BorderLayout.CENTER);
        add(registrering, BorderLayout.EAST);
        add(bunn, BorderLayout.SOUTH);
        
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
    }//end AnsattVindu
          
    //Setter en tekst i utskriftområdet.
    public void utskrift (String tekst){
        utskrift.setText(tekst);
    }
    
    //Returnerer utskriftrorådet med tekst
    public JTextArea getTextArea(){
        return utskrift;
    }
    
    //Skriver ut kunderegister
    public void visKundeReg(){
        v.kundeRegister.skrivKundeListe(utskrift);
    }
    
    //Skriver ut vikariatregister
    public void visVikariatReg(){
        v.vikariatRegister.skrivVikariatListe(utskrift);
    }
    
    //Skriver ut arbeidsforholdregister
    public void visArbeisforholdReg(){
        v.arbeidsforholdRegister.skrivArbeidsforholdiste(utskrift);
    }
    
    //Skriver ut vikarregister
    public void visVikarReg(){
        v.vikarRegister.skrivVikarListe(utskrift);
    }
    
    //Knytter knappene på venstre siden av menyen til en lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Knappen "Registrer Kunde"
            if(e.getSource()==regKunde){
                registrering.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                RegistrerKunde rk = new RegistrerKunde(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rk = rk;
                add(rk, BorderLayout.EAST);
                rk.setVisible(true);
            }
            
            //Knapppen "Registrer Vikariat"
            else if(e.getSource()==regVikariat){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                RegistrerVikariat rv = new RegistrerVikariat(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rv = rv;
                add(rv, BorderLayout.EAST);
                rv.setVisible(true);
            }
            
            //Knappen "Registrer Arbeidsforhold"
            else if(e.getSource()==regArbForhold){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                RegistrerArbeidsforhold raf = new RegistrerArbeidsforhold(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.raf = raf;
                add(raf, BorderLayout.EAST);
                raf.setVisible(true);
            }
            
            //Knapppen "Registrer Vikar"
            else if(e.getSource()==regVikar){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                RegistrerVikar rvv = new RegistrerVikar(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rvv = rvv;
                add(rvv,BorderLayout.EAST); 
            }
            //Knappen "vikar->vikariat"
            else if(e.getSource()==vikarVikariat){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                
                RegistrerVikarTilVikariat rvtv = new RegistrerVikarTilVikariat(AnsattVindu.this.getTextArea(),v);
                AnsattVindu.this.rvtv = rvtv;
                add(rvtv,BorderLayout.EAST);
            }
            
            //Knappen "Vis/Endre Kunde"
            else if(e.getSource()==visEndreKundeReg){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                EndreKunde ek = new EndreKunde(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.ek = ek;
                add(ek,BorderLayout.EAST);
                visKundeReg();
            }
            
            //Knappen "Vis/Endre Vikariat"
            else if(e.getSource()==visEndreVikariatReg){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                EndreVikariat evt = new EndreVikariat(AnsattVindu.this.getTextArea(),v);
                AnsattVindu.this.evt = evt;
                add(evt,BorderLayout.EAST);
                visVikariatReg();
            }
            
            //Knappen "Vis/Endre Arbeidsfohold"
            else if(e.getSource()==visEndreArbeisforholdReg){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                visArbeisforholdReg();
            }
            
            //Knappen "Vis/Endre Vikar"
            else if(e.getSource()==visEndreVikarReg){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(rvtv!=null)
                    AnsattVindu.this.rvtv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(evt!=null)
                    AnsattVindu.this.evt.setVisible(false);
                //if(eaf!=null)
                //    AnsattVindu.this.ev.setVisible(false);
                //if(s!=null)
                //    AnsattVindu.this.s.setVisible(false);
                visVikarReg();
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
                ramme.setVisible(false);
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


