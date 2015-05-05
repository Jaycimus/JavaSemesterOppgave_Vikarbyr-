/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 5. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
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

public class AnsattVindu extends JPanel{
    private final JPanel meny, registrering, bunn, topp;
    private final JButton regKunde, regVikariat, regArbForhold, regVikar, visKundeReg, visVikariatReg, visArbeisforholdReg, visVikarReg, regSoking, loggUt;
    private final JTextArea utskrift;
    private final JFrame ramme; //rammen på programmet
    private BorderLayout borderLayout;
    
    private Vikarbyraa v;
    private RegistrerKunde rf;
    private RegistrerVikariat rv;
    private RegistrerVikar rvv;
    
   public AnsattVindu(Vikarbyraa v, JFrame ramme){
        this.v = v;
        this.ramme = ramme;
        
        borderLayout = new BorderLayout(10, 10);
        setLayout(borderLayout);
                
                
        regKunde = new JButton("Registrer kunde");
            /*regKunde.setFocusPainted(false);
            regKunde.setMargin(new Insets(0, 0, 0, 0));
            regKunde.setContentAreaFilled(false);
            regKunde.setBorderPainted(false);
            regKunde.setOpaque(false);*/
        regVikariat = new JButton("Registrer vikariat");
        regArbForhold = new JButton("Registrer arbeidsForhold");
        regVikar = new JButton("Registrer vikar");
        visKundeReg = new JButton("Vis kunde register");
        visVikariatReg = new JButton("Vis vikariat register");
        visArbeisforholdReg = new JButton("Vis arbeisforhold register");
        visVikarReg = new JButton("Vis vikar register");
        regSoking = new JButton("Søk i registerene");
        loggUt = new JButton("Logg Ut");
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,10));
        meny.setPreferredSize(new Dimension(200, 200));
        meny.add(regKunde);
        meny.add(regVikariat);
        meny.add(regArbForhold);
        meny.add(regVikar);
        meny.add(new JPanel());
        meny.add(visKundeReg);
        meny.add(visVikariatReg);
        meny.add(visArbeisforholdReg);
        meny.add(visVikarReg);
        meny.add(regSoking);
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(loggUt);
        

        utskrift = new JTextArea(10, 10);
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
        visKundeReg.addActionListener(lytter);
        visVikariatReg.addActionListener(lytter);
        visArbeisforholdReg.addActionListener(lytter);
        visVikarReg.addActionListener(lytter);
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
                                
                RegistrerKunde rf = new RegistrerKunde(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rf = rf;
                add(rf, BorderLayout.EAST);
                rf.setVisible(true);
                
                
            }
            else if(e.getSource()==regVikariat){
                registrering.setVisible(false);
                if(rf!=null)
                    AnsattVindu.this.rf.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                
                RegistrerVikariat rv = new RegistrerVikariat(AnsattVindu.this.getTextArea(), v);
                AnsattVindu.this.rv = rv;
                add(rv, BorderLayout.EAST);
                rv.setVisible(true);
            }
            else if(e.getSource()==regArbForhold){
                registrering.setVisible(true);
                if(rf!=null)
                    AnsattVindu.this.rf.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
            }
            else if(e.getSource()==regVikar){
                registrering.setVisible(false);
                if(rf!=null)
                    AnsattVindu.this.rf.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                
                RegistrerVikar rvv = new RegistrerVikar(v, AnsattVindu.this.getTextArea());
                AnsattVindu.this.rvv = rvv;
                add(rvv,BorderLayout.EAST); 
            }
            else if(e.getSource()==visKundeReg){
                visKundeReg();
            }
            else if(e.getSource()==visVikariatReg){
                visVikariatReg();
            }
            else if(e.getSource()==visArbeisforholdReg){
                visArbeisforholdReg();
            }
            else if(e.getSource()==visVikarReg){
                visVikarReg();
                
            }
            else if(e.getSource()==loggUt){
                Logginn logginn = new Logginn(v);
                logginn.setSize(new Dimension(400,220));
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


