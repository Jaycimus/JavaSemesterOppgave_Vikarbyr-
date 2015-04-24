/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AnsattVindu extends JPanel{
    private final JPanel meny, registrering, bunn, topp;
    private final JButton regFirma, regVikariat, regArbForhold, regVikar, visReg, loggUt;
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
            regFirma.setFocusPainted(false);
            regFirma.setMargin(new Insets(0, 0, 0, 0));
            regFirma.setContentAreaFilled(false);
            regFirma.setBorderPainted(false);
            regFirma.setOpaque(false);
        regVikariat = new JButton("Registrer Vikariat");
        regArbForhold = new JButton("Registrer arbeidsForhold");
        regVikar = new JButton("Registrer Vikar");
        visReg = new JButton("Vis Register");
        loggUt = new JButton("Logg Ut");
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,10));
        meny.setPreferredSize(new Dimension(200, 200));
        meny.add(regFirma);
        meny.add(regVikariat);
        meny.add(regArbForhold);
        meny.add(regVikar);
        meny.add(visReg);
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
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
        visReg.addActionListener(lytter);
        loggUt.addActionListener(lytter);
    }
          
    public void utskrift (String tekst){
        utskrift.setText(tekst);
    }
    
    public JTextArea getTextArea(){
        return utskrift;
    }
    
    public void visReg(){
        v.firmaRegister.skrivFirmaListe(utskrift);
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
            else if(e.getSource()==visReg){
                visReg();
            }
            else if(e.getSource()==loggUt){
                
            }
        }
    }
}


