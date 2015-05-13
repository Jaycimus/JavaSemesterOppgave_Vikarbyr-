/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 7. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
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
                    lbl_lonnsbetingelser, lbl_kontaktinfo, lbl_stillingsinfo, lbl_varighettil, lbl_varighetfra,
                    lbl_bindestrek, lbl_kolon, lbl_kolon2;
    private JTextField tf_adresse, tf_stillingstype, tf_kvalifikasjoner,
                    tf_lonnsbetingelser, tf_kontaktinfo, tf_stillingsinfo;
    
    private JTextArea utskrift;
    private Vikarbyraa v;
    
    private JComboBox<String> cb_kunder; 
    private String[] kundeNavn;
    private JComboBox<String> cb_timer;
    private final String[] timer =
        {"--T--","00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
            "16","17","18","19","20","21","22","23"};
    private JComboBox<String> cb_timer2;
    private final String[] timer2 =
        {"--T--","00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
            "16","17","18","19","20","21","22","23"};
    private JComboBox<String> cb_minutter;
    private final String[] minutter =
        {"--M--","00","05","10","15","20","25","30","35","40","45","50","55"};
    private JComboBox<String> cb_minutter2;
    private final String[] minutter2 =
        {"--M--","00","05","10","15","20","25","30","35","40","45","50","55"};
    private JComboBox<String> cb_dag;
    private final String[] dag = 
        {"--Dag--","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
            "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private JComboBox<String> cb_dag2;
    private final String[] dag2 = 
        {"--Dag--","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
            "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private JComboBox<String> cb_maned;
    private final String[] maned =
        {"--Måned--","Januar","Februar","Mars","April","Mai","Juni","Juli","August","September",
            "Oktober","November","Desember"};
    private JComboBox<String> cb_maned2;
    private final String[] maned2 =
        {"-Måned-","Januar","Februar","Mars","April","Mai","Juni","Juli","August","September",
            "Oktober","November","Desember"};
    private JComboBox<String> cb_ar;
    private final String[] ar =
        {"--År--","2015","2016","2017","2018","2019","2020"};
    private JComboBox<String> cb_ar2;
    private final String[] ar2 =
        {"--År--","2015","2016","2017","2018","2019","2020"};
    
    private JComboBox<String>cb_bransjer;
    private final String[] bransjer = 
        {"---Stillingstype---","Advokattjenester/Prosedyre", "Bankvirksomhet","Bygg/Anlegg/Entreprenør", 
            "Eiendom/Eiendomsmegling", "Engineering", "Farmasi/Legemiddel", "Finans -verdipapirer/megling", 
                "Forsikring/Assuranse", "Forskning og utvikling", "Helse/Velvære/Trening", "Helsesektor", "Hotell/overnatting", 
                    "Høyteknologi/Elektronikk", "IKT/Telekom", "Industri: Tradisjonell/Prosess/Øvrig", "Ingeniøryrker: Øvrig", "Internett tjenester/E-handel", 
                        "Investment banking", "Investment management", "IT: Hardware/Software", "Juridisk rådgivning", "Kommunikasjon/PR", "Konsulenttjenester: Ingeniør/Teknisk", 
                            "Konsulenttjenester: Øvrig", "Konsultenttjenester: IT", "Kultur/Kunst/Øvrige kreative fag", "Management consulting", "Media/Underholdning", "Merkevarer/Konsumentprodukter", 
                                "NGO - Ikke-statlige organisasjoner", "Non-profit -/interesseorg.", "Olje/Gass/Energi/Kraft", "Regnskap", "Reiseliv/Turisme/Event", "Reklame", "Rekruttering/HR/Bemanning", 
                                    "Restaurant/Servering", "Revisjon", "Salg/Markedsføring", "Shipping/Off-/Onshore/Maritim", "Statlig/Offentlig/Kommunal sektor", "Transport/Distribusjon/Logistikk", "Utdanning/undervisning", 
                                        "Varehandel/Dagligvare/Butikk", "Øvrig"};
    
    
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
        lbl_bindestrek = new JLabel("-");
        lbl_kolon = new JLabel(":");
        lbl_kolon2 = new JLabel(":");
        
        tf_adresse = new JTextField("",15);
        tf_stillingstype = new JTextField("",15);
        tf_kvalifikasjoner = new JTextField("",15);
        tf_lonnsbetingelser = new JTextField("",15);
        tf_kontaktinfo = new JTextField("",15);
        tf_stillingsinfo = new JTextField("",15);
                
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
        cb_dag2 = new JComboBox<>(dag2);
        cb_dag2.setMaximumRowCount(20);
        cb_maned = new JComboBox<>(maned);
        cb_maned.setMaximumRowCount(12);
        cb_maned2 = new JComboBox<>(maned2);
        cb_maned2.setMaximumRowCount(12);
        cb_ar = new JComboBox<>(ar);
        cb_ar.setMaximumRowCount(5);
        cb_ar2 = new JComboBox<>(ar2);
        cb_ar2.setMaximumRowCount(5);

        cb_bransjer = new JComboBox<String>(bransjer);
        cb_bransjer.setMaximumRowCount(9);

        
        JPanel kolon = new JPanel(new FlowLayout());
        kolon.add(lbl_kolon);
        
        JPanel kolon2 = new JPanel(new FlowLayout());
        kolon2.add(lbl_kolon2);
        
        JPanel bindestrek = new JPanel(new FlowLayout());
        bindestrek.add(lbl_bindestrek);

                
        JPanel tider = new JPanel(new FlowLayout(FlowLayout.LEFT,-2,-2));
        tider.add(cb_timer);
        cb_timer.setBackground(Color.white);
        tider.add(kolon);
        tider.add(cb_minutter);
        cb_minutter.setBackground(Color.white);
        tider.add(bindestrek);
        tider.add(cb_timer2);
        cb_timer2.setBackground(Color.white);
        tider.add(kolon2);
        tider.add(cb_minutter2);
        cb_minutter2.setBackground(Color.white);
        
        JPanel fra = new JPanel(new GridLayout(1,1,2,2));
        fra.add(cb_dag);
        fra.add(cb_maned);
        fra.add(cb_ar);
        
        JPanel til = new JPanel(new GridLayout(1,1,2,2));
        til.add(cb_dag2);
        til.add(cb_maned2);
        til.add(cb_ar2);
        
        add(lbl_kunde);
        add(cb_kunder);
        add(lbl_adresse);
        add(tf_adresse);
        add(lbl_arbeidtid);
        add(tider);
        add(lbl_stillingstype);
        add(cb_bransjer);
        add(lbl_kvalifikasjoner);
        add(tf_kvalifikasjoner);
        add(lbl_lonnsbetingelser);
        add(tf_lonnsbetingelser);
        add(lbl_kontaktinfo);
        add(tf_kontaktinfo);
        add(lbl_stillingsinfo);
        add(tf_stillingsinfo);
        add(lbl_varighetfra);
        add(fra);
        add(lbl_varighettil);
        add(til);
       
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
        String varighetfra = (String) cb_dag.getSelectedItem() + "-" + 
                             (String) cb_maned.getSelectedItem() + "-" +
                             (String) cb_ar.getSelectedItem();
        String varighettil = (String) cb_dag2.getSelectedItem() + "-" +
                             (String) cb_maned2.getSelectedItem() + "-" +
                             (String) cb_ar2.getSelectedItem();
        //IF TEST OM VALGENE AV VARIGHET ER RIKTIGE
        if(cb_ar2.getSelectedIndex() > cb_ar.getSelectedIndex()){
            //Ingen problemer kan oppstå med inputt av varigheten til vikariatet
        } else if(cb_ar2.getSelectedIndex() == cb_ar.getSelectedIndex()){
            if(cb_maned2.getSelectedIndex() > cb_maned.getSelectedIndex()){
                
            } else if(cb_maned2.getSelectedIndex() == cb_maned.getSelectedIndex()) {
                if(cb_dag2.getSelectedIndex() > cb_dag.getSelectedIndex()){
                    
                } else if(cb_dag2.getSelectedIndex() == cb_dag.getSelectedIndex()){
                    
                } else {
                    JOptionPane.showMessageDialog(null,"Feil med varighet - dag");
                    return;
                }
            } else{
                JOptionPane.showMessageDialog(null,"Feil med varighet - måned");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null,"Feil med varighet - år");
            return;
        }
        
        String bransjer = (String) cb_bransjer.getSelectedItem();
        if(bransjer.matches("---Stillingstype---")){
            JOptionPane.showMessageDialog(null, "Stillingstype ikke valgt!");
            return;
        }
                
        int vikariatNr = v.getNesteVikariatNr();
        v.setNesteVikariatNr();

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
                        stillingsinfo,varighetfra,varighettil, bransjer, vikariatNr);
            v.vikariatRegister.settInn(vikariat);
            System.out.println("RegVikariat");
            utskrift.setText(vikariat.toString());
            utskrift.setText(vikariat.toString());
            resetInput();
        }
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regVikariat){
                regVikariat();
            }
        }
    }
    
    private void resetInput(){
        tf_adresse.setText("");
        tf_stillingstype.setText("");
        tf_kvalifikasjoner.setText("");
        tf_lonnsbetingelser.setText("");
        tf_kontaktinfo.setText("");
        tf_stillingsinfo.setText("");
        cb_kunder.setSelectedIndex(0);
        cb_dag.setSelectedIndex(0);
        cb_maned.setSelectedIndex(0);
        cb_ar.setSelectedIndex(0);
        cb_dag2.setSelectedIndex(0);
        cb_maned2.setSelectedIndex(0);
        cb_ar2.setSelectedIndex(0);
        cb_bransjer.setSelectedIndex(0);
        cb_timer.setSelectedIndex(0);
        cb_minutter.setSelectedIndex(0);
        cb_timer2.setSelectedIndex(0);
        cb_minutter2.setSelectedIndex(0);
    } 
}
