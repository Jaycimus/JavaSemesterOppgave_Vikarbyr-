/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 7. Mai 2015 AV: Arthur Nordnes
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
                    lbl_lonnsbetingelser, lbl_kontaktinfo, lbl_stillingsinfo, lbl_varighettil, lbl_varighetfra;
    private JTextField tf_adresse, tf_stillingstype, tf_kvalifikasjoner,
                    tf_lonnsbetingelser, tf_kontaktinfo, tf_stillingsinfo, tf_varighettil, tf_varighetfra;
    
    private JTextArea utskrift;
    private Vikarbyraa v;
    
    private JComboBox<String> cb_kunder; 
    private String[] kundeNavn;
    private LocalDate[] varighet;
    private JComboBox<String> cb_timer;
    private final String[] timer =
        {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
            "16","17","18","19","20","21","22","23"};
    private JComboBox<String> cb_timer2;
    private final String[] timer2 =
        {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
            "16","17","18","19","20","21","22","23"};
    private JComboBox<String> cb_minutter;
    private final String[] minutter =
        {"00","05","10","15","20","25","30","35","40","45","50","55"};
    private JComboBox<String> cb_minutter2;
    private final String[] minutter2 =
        {"00","05","10","15","20","25","30","35","40","45","50","55"};
    private JComboBox<String> cb_dag;
    private final String[] dag = 
        {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
            "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private JComboBox<String> cb_dag2;
    private final String[] dag2 = 
        {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
            "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private JComboBox<String> cb_maned;
    private final String[] maned =
        {"Januar","Februar","Mars","April","Mai","Juni","Juli","August","September",
            "Oktober","November","Desember"};
    private JComboBox<String> cb_maned2;
    private final String[] maned2 =
        {"Januar","Februar","Mars","April","Mai","Juni","Juli","August","September",
            "Oktober","November","Desember"};
    private JComboBox<String> cb_ar;
    private final String[] ar =
        {"2015","2016","2017","2018","2019","2020"};
    private JComboBox<String> cb_ar2;
    private final String[] ar2 =
        {"2015","2016","2017","2018","2019","2020"};
    
    
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
        lbl_varighetfra = new JLabel("Varighet(fra): ");
        lbl_varighettil = new JLabel("Varighet(til): ");
        
        tf_adresse = new JTextField("",15);
        tf_stillingstype = new JTextField("",15);
        tf_kvalifikasjoner = new JTextField("",15);
        tf_lonnsbetingelser = new JTextField("",15);
        tf_kontaktinfo = new JTextField("",15);
        tf_stillingsinfo = new JTextField("",15);
        tf_varighetfra = new  JTextField("",10);
        tf_varighettil = new  JTextField("",10);
                
        cb_kunder = new JComboBox<>(kundeNavn);
        cb_kunder.setMaximumRowCount(9);
        cb_timer = new JComboBox<>(timer);
        cb_timer.setMaximumRowCount(16);
        cb_minutter = new JComboBox<>(minutter);
        cb_minutter.setMaximumRowCount(12);
        cb_timer2 = new JComboBox<>(timer2);
        cb_timer2.setMaximumRowCount(16);
        cb_minutter2 = new JComboBox<>(minutter2);
        cb_minutter2.setMaximumRowCount(12);
        cb_dag = new JComboBox<>(dag);
        cb_dag.setMaximumRowCount(20);
        
        JPanel tider = new JPanel(new GridLayout(1,1,2,2));
        tider.add(cb_timer);
        tider.add(cb_minutter);
        tider.add(cb_timer2);
        tider.add(cb_minutter2);
        
       // JPanel fra = new JPanel(new Gridlayout(1,1,2,2));
        //fra.add(cb_)
        
        add(lbl_kunde);
        add(cb_kunder);
        add(lbl_adresse);
        add(tf_adresse);
        add(lbl_arbeidtid);
        add(tider);
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
        add(lbl_varighetfra);
        add(tf_varighetfra);
        add(lbl_varighettil);
        add(tf_varighettil);
       
        add(new JPanel());
        add(regVikariat);
    }
    
    public void regVikariat(){
        String kunde = (String) cb_kunder.getSelectedItem();
        if(kunde.matches("---Kunder---")){
            JOptionPane.showMessageDialog(null, "Kunde ikke valgt");
            return;
        }
        
        String arbeidsted = tf_adresse.getText();
        String arbeidstid = (String) cb_timer.getSelectedItem() + ":" + 
                (String) cb_minutter.getSelectedItem() + " - " + 
                    (String) cb_timer2.getSelectedItem() + ":" + 
                        (String) cb_minutter2.getSelectedItem();
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
