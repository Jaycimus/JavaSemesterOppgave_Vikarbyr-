/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 13. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
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

public class AnsattVindu extends JPanel{
    private final JPanel meny, registrering, bunn, topp;
    private final JButton regKunde, regVikariat, regArbForhold, regVikar, visEndreKundeReg, visEndreVikariatReg, visEndreArbeisforholdReg, visEndreVikarReg, regSoking, loggUt;
    private final JTextArea utskrift;
    private final JFrame ramme; //rammen på programmet
    private BorderLayout borderLayout;
    
    private Vikarbyraa v;
    private RegistrerKunde rk;
    private RegistrerVikariat rv;
    private RegistrerVikar rvv;
    private RegistrerArbeidsforhold raf;
    private EndreKunde ek;
    private EndreVikariat ev;
    
    public AnsattVindu(Vikarbyraa v, JFrame ramme){
        this.v = v;
        this.ramme = ramme;
        
        borderLayout = new BorderLayout(10, 10);
        setLayout(borderLayout);
        setBorder(new EmptyBorder(0, 5, 0, 5)); 
                
        regKunde = new JButton("Registrer Kunde");
            /*regKunde.setFocusPainted(false);
            regKunde.setMargin(new Insets(0, 0, 0, 0));
            regKunde.setContentAreaFilled(false);
            regKunde.setBorderPainted(false);
            regKunde.setOpaque(false);*/
        regVikariat = new JButton("Registrer Vikariat");
        regArbForhold = new JButton("Registrer Arbeidsfohold");
        regVikar = new JButton("Registrer Vikar");
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
        meny.add(regArbForhold);
        meny.add(regVikar);
        meny.add(new JPanel());
        meny.add(visEndreKundeReg);
        meny.add(visEndreVikariatReg);
        meny.add(visEndreArbeisforholdReg);
        meny.add(visEndreVikarReg);
        meny.add(regSoking);
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(loggUt);
        

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
        visEndreKundeReg.addActionListener(lytter);
        visEndreVikariatReg.addActionListener(lytter);
        visEndreArbeisforholdReg.addActionListener(lytter);
        visEndreVikarReg.addActionListener(lytter);
        regSoking.addActionListener(lytter);
        loggUt.addActionListener(lytter);
    }
          
    public void utskrift (String tekst){
        utskrift.setText(tekst);
    }
    
    public JTextArea getTextArea(){
        return utskrift;
    }
    
    public void visKundeReg(){
        v.kundeRegister.skrivKundeListe(utskrift);
    }
    
    public void visVikariatReg(){
        v.vikariatRegister.skrivVikariatListe(utskrift);
    }
    
    public void visArbeisforholdReg(){
        v.arbeidsforholdRegister.skrivArbeidsforholdiste(utskrift);
    }
    
    public void visVikarReg(){
        v.vikarRegister.skrivVikarListe(utskrift);
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regKunde){
                registrering.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                RegistrerKunde rk = new RegistrerKunde(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rk = rk;
                add(rk, BorderLayout.EAST);
                rk.setVisible(true);
                
                
            }
            else if(e.getSource()==regVikariat){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                RegistrerVikariat rv = new RegistrerVikariat(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rv = rv;
                add(rv, BorderLayout.EAST);
                rv.setVisible(true);
            }
            else if(e.getSource()==regArbForhold){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                RegistrerArbeidsforhold raf = new RegistrerArbeidsforhold(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.raf = raf;
                add(raf, BorderLayout.EAST);
                raf.setVisible(true);
            }
            else if(e.getSource()==regVikar){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ek!=null)
                    AnsattVindu.this.ek.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                RegistrerVikar rvv = new RegistrerVikar(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rvv = rvv;
                add(rvv,BorderLayout.EAST); 
            }
            else if(e.getSource()==visEndreKundeReg){
                registrering.setVisible(false);
                if(rk!=null)
                    AnsattVindu.this.rk.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                if(raf!=null)
                    AnsattVindu.this.raf.setVisible(false);
                if(ev!=null)
                    AnsattVindu.this.ev.setVisible(false);
                EndreKunde ek = new EndreKunde(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.ek = ek;
                add(ek,BorderLayout.EAST);
                visKundeReg();
            }
            else if(e.getSource()==visEndreVikariatReg){
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
                EndreVikariat ev = new EndreVikariat(AnsattVindu.this.getTextArea(),v);
                AnsattVindu.this.ev = ev;
                add(ev,BorderLayout.EAST);
                visVikariatReg();
            }
            else if(e.getSource()==visEndreArbeisforholdReg){
                visArbeisforholdReg();
            }
            else if(e.getSource()==visEndreVikarReg){
                visVikarReg();
                
            }
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
    }
    
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
}


