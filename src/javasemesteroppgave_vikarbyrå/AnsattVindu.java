/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 1. Mai 2015 AV: Andreas Stenseng Bjørnrud
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
import javax.swing.JTextArea;

public class AnsattVindu extends JPanel{
    private final JPanel meny, registrering, bunn, topp;
    private final JButton regFirma, regVikariat, regArbForhold, regVikar, visFirmaReg, visVikariatReg, visArbeisforholdReg, visVikarReg, regSoking, loggUt;
    private final JTextArea utskrift;
    private final JFrame ramme; //rammen på programmet
    private BorderLayout borderLayout;
    
    private Vikarbyraa v;
    private RegistrerFirma rf;
    private RegistrerVikariat rv;
    private RegistrerVikar rvv;
    
   public AnsattVindu(Vikarbyraa v, JFrame ramme){
        this.v = v;
        this.ramme = ramme;
        
        borderLayout = new BorderLayout(10, 10);
        setLayout(borderLayout);
                
                
        regFirma = new JButton("Registrer Firma");
            /*regFirma.setFocusPainted(false);
            regFirma.setMargin(new Insets(0, 0, 0, 0));
            regFirma.setContentAreaFilled(false);
            regFirma.setBorderPainted(false);
            regFirma.setOpaque(false);*/
        regVikariat = new JButton("Registrer Vikariat");
        regArbForhold = new JButton("Registrer arbeidsForhold");
        regVikar = new JButton("Registrer Vikar");
        visFirmaReg = new JButton("Firma register");
        visVikariatReg = new JButton("Vikariat register");
        visArbeisforholdReg = new JButton("Arbeisforhold register");
        visVikarReg = new JButton("Vikar register");
        regSoking = new JButton("Søk i registerene");
        loggUt = new JButton("Logg Ut");
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,10));
        meny.setPreferredSize(new Dimension(200, 200));
        meny.add(regFirma);
        meny.add(regVikariat);
        meny.add(regArbForhold);
        meny.add(regVikar);
        meny.add(new JPanel());
        meny.add(visFirmaReg);
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
        add(utskrift, BorderLayout.CENTER);
        add(registrering, BorderLayout.EAST);
        add(bunn, BorderLayout.SOUTH);
        
        Knappelytter lytter = new Knappelytter();
        regFirma.addActionListener(lytter);
        regVikariat.addActionListener(lytter);
        regArbForhold.addActionListener(lytter);
        regVikar.addActionListener(lytter);
        visFirmaReg.addActionListener(lytter);
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
    
    public void visFirmaReg(){
        v.firmaRegister.skrivFirmaListe(utskrift);
    }
    
    public void visVikariatReg(){
        v.vikariatRegister.skrivVikariatListe(utskrift);
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regFirma){
                registrering.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                                
                RegistrerFirma rf = new RegistrerFirma(AnsattVindu.this.getTextArea(), v);
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
                
                RegistrerVikar rvv = new RegistrerVikar(AnsattVindu.this.getTextArea());
                AnsattVindu.this.rvv = rvv;
                add(rvv,BorderLayout.EAST); 
            }
            else if(e.getSource()==visFirmaReg){
                visFirmaReg();
            }
            else if(e.getSource()==visVikariatReg){
                visVikariatReg();
            }
            else if(e.getSource()==loggUt){
                Logginn logginn = new Logginn(v);
                logginn.setSize(new Dimension(400,220));
                logginn.setVisible(true);
                logginn.setLocationRelativeTo(null);
                logginn.setResizable(false);
                logginn.addWindowListener( new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                ramme.setVisible(false);
            }
        }
    }
}


