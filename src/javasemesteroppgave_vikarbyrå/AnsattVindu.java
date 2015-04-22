/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AnsattVindu extends JPanel{
    private final JPanel meny, registrering, bunn;
    private JButton regFirma, regVikariat, regArbForhold, regVikar, visReg, loggUt;
    private JTextArea utskrift;
    private JLabel lbl_header;
    private JFrame ramme; //rammen på programmet
    private BorderLayout borderLayout;
    private FlowLayout flowLayout;
    private Container c;
    
    private Knappelytter lytter;
    private Vikarbyraa v;
    private RegistrerFirma rf;
    private RegistrerVikariat rv;
    private RegistrerVikar rvv;
    
    private Font font;    
    
    public AnsattVindu(Vikarbyraa v, JFrame ramme){
        this.v = v;
        this.ramme = ramme;
        
        borderLayout = new BorderLayout(10, 10);
        setLayout(borderLayout);
                
        Icon logo = new ImageIcon(getClass().getResource("Bilder/VikarbyråHeader.gif"));
        lbl_header = new JLabel("",logo,SwingConstants.CENTER);
                
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
        meny.add(loggUt);
        

        utskrift = new JTextArea(10, 10);
        utskrift.setEditable(false);
                
        registrering = new JPanel();
        registrering.setLayout(null);
        registrering.setPreferredSize(new Dimension(500, 500));
        
        bunn = new JPanel();
        bunn.setLayout(null);
        bunn.setPreferredSize(new Dimension(50, 0));
                
        add(lbl_header, BorderLayout.NORTH);
        add(meny, BorderLayout.WEST);
        add(utskrift, BorderLayout.CENTER);
        add(registrering, BorderLayout.EAST);
        add(bunn, BorderLayout.SOUTH);
        
        Knappelytter lytter = new Knappelytter();
        this.lytter = lytter;
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
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regFirma){
                registrering.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rvv!=null)
                    AnsattVindu.this.rvv.setVisible(false);
                
                RegistrerFirma rf = new RegistrerFirma(AnsattVindu.this.getTextArea());
                add(rf, BorderLayout.EAST);
                rf.setVisible(true);
                
                AnsattVindu.this.rf = rf;
            }
            else if(e.getSource()==regVikariat){
                registrering.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rf.setVisible(false);
                
                RegistrerVikariat rv = new RegistrerVikariat(AnsattVindu.this.getTextArea());
                add(rv, BorderLayout.EAST);
                
                AnsattVindu.this.rv = rv;
            }
            else if(e.getSource()==regArbForhold){
                
            }
            else if(e.getSource()==regVikar){
                registrering.setVisible(false);
                if(rv!=null)
                    AnsattVindu.this.rv.setVisible(false);
                if(rf!=null)
                    AnsattVindu.this.rf.setVisible(false);
                
                RegistrerVikar rvv = new RegistrerVikar(AnsattVindu.this.getTextArea());
                add(rvv,BorderLayout.EAST);
                
                AnsattVindu.this.rvv = rvv;
            }
            else if(e.getSource()==visReg){
                
            }
            else if(e.getSource()==loggUt){
                
            }
        }
    }
}


