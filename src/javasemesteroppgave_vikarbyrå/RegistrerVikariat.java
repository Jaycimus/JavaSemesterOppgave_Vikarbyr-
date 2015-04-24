/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RegistrerVikariat extends JPanel {
    private JButton regVikariat;
    private JLabel lbl_firma, lbl_arbeidsted, lbl_arbeidtid, lbl_stillingstype, lbl_kvalifikasjoner,
                    lbl_lonnsbetingelser, lbl_kontaktinfo, lbl_stillingsinfo;
    private JTextField tf_arbeidsted, tf_arbeidtid, tf_stillingstype, tf_kvalifikasjoner,
                    tf_lonnsbetingelser, tf_kontaktinfo, tf_stillingsinfo;
    
    private JTextArea utskrift;
    private Vikarbyraa v;
    
    private JComboBox<String> cb_firmaer; 
    private String[] firmaNavn;
    
    public RegistrerVikariat (JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.utskrift = utskrift;
        this.v = v;
        
        Knappelytter lytter = new Knappelytter();
        System.out.println("Firma Navn hentet1");
        firmaNavn = v.firmaRegister.getFirmaNavn();
        System.out.println("Firma Navn hentet2");
        regVikariat = new JButton("Registrer Vikariat");
        regVikariat.addActionListener(lytter);
        
        lbl_firma = new JLabel("Firma: ");
        lbl_arbeidsted = new JLabel("Arbeidsted: ");
        lbl_arbeidtid = new JLabel("Arbeidstid: ");
        lbl_stillingstype = new JLabel("Stillingstype: ");
        lbl_kvalifikasjoner = new JLabel("Kvalifikasjoner: ");
        lbl_lonnsbetingelser = new JLabel("Lønnsbetingelser: ");
        lbl_kontaktinfo = new JLabel("Kontaktinfo: ");
        lbl_stillingsinfo = new JLabel("Stillingsinfo: ");
        
        tf_arbeidsted = new JTextField("",15);
        tf_arbeidtid = new JTextField("",15);
        tf_stillingstype = new JTextField("",15);
        tf_kvalifikasjoner = new JTextField("",15);
        tf_lonnsbetingelser = new JTextField("",15);
        tf_kontaktinfo = new JTextField("",15);
        tf_stillingsinfo = new JTextField("",15);
                
        cb_firmaer = new JComboBox<String>(firmaNavn);
        cb_firmaer.setMaximumRowCount(9);
        
        add(lbl_firma);
        add(cb_firmaer);
        add(lbl_arbeidsted);
        add(tf_arbeidsted);
        add(lbl_arbeidtid);
        add(tf_arbeidtid);
        add(lbl_stillingstype);
        add(tf_stillingstype);
        add(lbl_kvalifikasjoner);
        add(tf_kvalifikasjoner);
        add(lbl_lonnsbetingelser);
        add(tf_lonnsbetingelser);
        add(lbl_kontaktinfo);
        add(tf_kontaktinfo);
        add(lbl_stillingsinfo);
        add(tf_stillingsinfo);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regVikariat);
        
        
        
    }
    
    public void regVikariat(){
        
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regVikariat){
                regVikariat();
            }
        }
    }
    
}
