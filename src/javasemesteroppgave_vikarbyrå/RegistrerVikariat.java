/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 5. Mai 2015 AV: Jørgen Dyhre
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.time.format.DateTimeFormatter;


public class RegistrerVikariat extends JPanel {
    private JButton regVikariat;
    private JLabel lbl_kunde, lbl_adresse, lbl_arbeidtid, lbl_stillingstype, lbl_kvalifikasjoner,
                    lbl_lonnsbetingelser, lbl_kontaktinfo, lbl_stillingsinfo, lbl_varighet;
    private JTextField tf_adresse, tf_arbeidtid, tf_stillingstype, tf_kvalifikasjoner,
                    tf_lonnsbetingelser, tf_kontaktinfo, tf_stillingsinfo, tf_varighettil, tf_varighetfra;
    
    private JTextArea utskrift;
    private Vikarbyraa v;
    
    private JComboBox<String> cb_kunder; 
    private String[] kundeNavn;
    private LocalDate[] varighet;
    
    
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.ENGLISH);
    
    public RegistrerVikariat (JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.utskrift = utskrift;
        this.v = v;
        
        Knappelytter lytter = new Knappelytter();

        kundeNavn = v.kundeRegister.getKundeNavn();
        
        regVikariat = new JButton("Registrer vikariat");
        regVikariat.addActionListener(lytter);
        
        lbl_kunde = new JLabel("Kunde: ");
        lbl_adresse = new JLabel("Arbeidsted: ");
        lbl_arbeidtid = new JLabel("Arbeidstid: ");
        lbl_stillingstype = new JLabel("Stillingstype: ");
        lbl_kvalifikasjoner = new JLabel("Kvalifikasjoner: ");
        lbl_lonnsbetingelser = new JLabel("Lønnsbetingelser: ");
        lbl_kontaktinfo = new JLabel("Kontaktinfo: ");
        lbl_stillingsinfo = new JLabel("Stillingsinfo: ");
        lbl_varighet = new JLabel("Varighet: ");
        
        tf_adresse = new JTextField("",15);
        tf_arbeidtid = new JTextField("",15);
        tf_stillingstype = new JTextField("",15);
        tf_kvalifikasjoner = new JTextField("",15);
        tf_lonnsbetingelser = new JTextField("",15);
        tf_kontaktinfo = new JTextField("",15);
        tf_stillingsinfo = new JTextField("",15);
        tf_varighetfra = new  JTextField("",10);
        tf_varighettil = new  JTextField("",10);
                
        cb_kunder = new JComboBox<String>(kundeNavn);
        cb_kunder.setMaximumRowCount(9);
        
        add(lbl_kunde);
        add(cb_kunder);
        add(lbl_adresse);
        add(tf_adresse);
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
        add(lbl_varighet);
        add(tf_varighetfra);
        add(new JPanel());
        add(tf_varighettil);
       
        add(new JPanel());
        add(regVikariat);
    }
    
    public void regVikariat(){
        String kunde = (String) cb_kunder.getSelectedItem();
        String arbeidsted = tf_adresse.getText();
        String arbeidstid = tf_arbeidtid.getText();
        String stillingstype = tf_stillingstype.getText();
        String kvalifikasjoner = tf_kvalifikasjoner.getText();
        String lonnsbetingelser = tf_lonnsbetingelser.getText();
        String kontaktinfo = tf_kontaktinfo.getText();
        String stillingsinfo = tf_stillingsinfo.getText();
        
        String varighetfra = tf_varighetfra.getText();
        String varighettil = tf_varighettil.getText();
        
        
        
        LocalDate fra = LocalDate.parse(varighetfra, format);
        LocalDate til = LocalDate.parse(varighettil, format);
        
        varighet = new LocalDate[2];
        varighet[0] =fra;
        varighet[1]=til;
        
        
        
        if(!Validering.validerAdresse(arbeidsted)){
            JOptionPane.showMessageDialog(null, "Feil med arbeidsted");
            return;
        } else if(!Validering.validerArbeidstid(arbeidstid)){
            JOptionPane.showMessageDialog(null, "Feil med arbeidstid");
            return;
        }
        
        
        else{
            Vikariat vikariat = new Vikariat(kunde, arbeidsted, arbeidstid, 
                    stillingstype, kvalifikasjoner, lonnsbetingelser, kontaktinfo,
                        stillingsinfo,varighet);
            v.vikariatRegister.settInn(vikariat);
            System.out.println("RegVikariat");
            utskrift.setText(vikariat.toString());
        }
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regVikariat){
                regVikariat();
            }
        }
    }
    
}
