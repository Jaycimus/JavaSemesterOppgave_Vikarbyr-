/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Klassen bygger opp vinduet til "Vis/Endre Vikariat" og tar imot nytt info
public class EndreVikariat extends JPanel {
    private JButton endreVikariat, slettVikariat;
    private JLabel lbl_vikariat, lbl_adresse, lbl_arbeidstid, lbl_stillingstype, lbl_kvalifikasjoner,
            lbl_lonnsbetingelser, lbl_kontaktinfo, lbl_stillingsinfo, lbl_varighetfra, lbl_varighettil,
            lbl_bindestrek, lbl_kolon, lbl_kolon2;
    private JTextField tf_adresse, tf_stillingstype, tf_kvalifikasjoner, tf_lonnsbetingelser,
            tf_kontaktinfo, tf_stillingsinfo;
    private JTextArea utskrift;
    
    private Vikarbyraa v;
    private Vikariat vikariat;
    
    private JComboBox<String> cb_vikariater;
    private String[]vikariatNavn;
    private JComboBox<String> cb_timer, cb_timer2, cb_minutter, cb_minutter2, 
            cb_dag, cb_dag2, cb_maned, cb_maned2, cb_ar, cb_ar2, cb_stillingsTyper;
    private final String[] timer =
        {"--T--","00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
            "16","17","18","19","20","21","22","23"};
    private final String[] minutter =
        {"--M--","00","05","10","15","20","25","30","35","40","45","50","55"};
    private final String[] dag = 
        {"--Dag--","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
            "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private final String[] maned =
        {"--Måned--","Januar","Februar","Mars","April","Mai","Juni","Juli","August","September",
            "Oktober","November","Desember"};
    private final String[] ar =
        {"--År--","2015","2016","2017","2018","2019","2020"};
    private final String[] stillingsTyper = 
        {"---Stillingstype---", "Advokattjenester/Prosedyre", "Bankvirksomhet","Bygg/Anlegg/Entreprenør", 
            "Eiendom/Eiendomsmegling", "Engineering", "Farmasi/Legemiddel", "Finans -verdipapirer/megling", 
                "Forsikring/Assuranse", "Forskning og utvikling", "Helse/Velvære/Trening", "Helsesektor", "Hotell/overnatting", 
                    "Høyteknologi/Elektronikk", "IKT/Telekom", "Industri: Tradisjonell/Prosess/Øvrig", "Ingeniøryrker: Øvrig", "Internett tjenester/E-handel", 
                        "Investment banking", "Investment management", "IT: Hardware/Software", "Juridisk rådgivning", "Kommunikasjon/PR", "Konsulenttjenester: Ingeniør/Teknisk", 
                            "Konsulenttjenester: Øvrig", "Konsultenttjenester: IT", "Kultur/Kunst/Øvrige kreative fag", "Management consulting", "Media/Underholdning", "Merkevarer/Konsumentprodukter", 
                                "NGO - Ikke-statlige organisasjoner", "Non-profit -/interesseorg.", "Olje/Gass/Energi/Kraft", "Regnskap", "Reiseliv/Turisme/Event", "Reklame", "Rekruttering/HR/Bemanning", 
                                    "Restaurant/Servering", "Revisjon", "Salg/Markedsføring", "Shipping/Off-/Onshore/Maritim", "Statlig/Offentlig/Kommunal sektor", "Transport/Distribusjon/Logistikk", "Utdanning/undervisning", 
                                        "Varehandel/Dagligvare/Butikk", "Øvrig"};
    
    //Konstruktør
    public EndreVikariat (JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.utskrift = utskrift;
        this.v = v;
        
        Knappelytter lytter = new Knappelytter();

        vikariatNavn = v.vikariatRegister.getVikariatNr();
        
        endreVikariat = new JButton("Endre Vikariat");
        endreVikariat.addActionListener(lytter);
        slettVikariat = new JButton("Slett Vikariat");
        slettVikariat.addActionListener(lytter);
        
        lbl_vikariat = new JLabel("Vikariat: ");
        lbl_adresse = new JLabel("Arbeidsted: ");
        lbl_arbeidstid = new JLabel("Arbeidstid: ");
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
        
        cb_vikariater = new JComboBox<String>(vikariatNavn);
        
        //lytter for endring i vikariat comboboxen
        cb_vikariater.addItemListener((ItemEvent e) -> {
            String vikariaterNr = (String) cb_vikariater.getSelectedItem();
            if(vikariaterNr.equals("---Vikariater---")){
                resetInput();
                return;
            }
            Vikariat vikariat = v.vikariatRegister.finnVikariat(Integer.parseInt(vikariaterNr));
            tf_adresse.setText(vikariat.getAdresse());
            tf_stillingstype.setText(vikariat.getStillingstype());
            tf_kvalifikasjoner.setText(vikariat.getKvalifikasjoner());
            tf_lonnsbetingelser.setText(vikariat.getLonnsbetingelser());
            tf_kontaktinfo.setText(vikariat.getKontaktinfo());
            tf_stillingsinfo.setText(vikariat.getStillingsinfo()); 
            String varighetFra = vikariat.getVarighetfra();
                for( int i = 0; i < dag.length; i++){
                    String d = varighetFra.substring(0, 2);
                    if(d.matches(dag[i])){
                        cb_dag.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < maned.length; i++){
                    int x = varighetFra.indexOf("-");
                    int y = varighetFra.lastIndexOf("-");
                    String m = varighetFra.substring(++x, y);
                    if(m.matches(maned[i])){
                        cb_maned.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < ar.length; i++){
                    int x = varighetFra.lastIndexOf("-");
                    int y = varighetFra.length();
                    
                    String a = varighetFra.substring(++x, y);
                    if(a.matches(ar[i])){
                        cb_ar.setSelectedIndex(i);
                    }
                }
                
            String varighetTil = vikariat.getVarighettil();
                for( int i = 0; i < dag.length; i++){
                    String d = varighetTil.substring(0, 2);
                    if(d.matches(dag[i])){
                        cb_dag2.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < maned.length; i++){
                    int x = varighetTil.indexOf("-");
                    int y = varighetTil.lastIndexOf("-");
                    String m = varighetTil.substring(++x, y);
                    if(m.matches(maned[i])){
                        cb_maned2.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < ar.length; i++){
                    int x = varighetTil.lastIndexOf("-");
                    int y = varighetTil.length();
                    String a = varighetTil.substring(++x, y);
                    if(a.matches(ar[i])){
                        cb_ar2.setSelectedIndex(i);
                    }
                }
                
            String arbeidstid = vikariat.getArbeidstid();
                for( int i = 0; i < timer.length; i++){
                    String t = arbeidstid.substring(0, 2);
                    if(t.matches(timer[i])){
                        cb_timer.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < minutter.length; i++){
                    String m = arbeidstid.substring(3, 5);
                    if(m.matches(minutter[i])){
                        cb_minutter.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < timer.length; i++){
                    int x = arbeidstid.indexOf("-");
                    int y = arbeidstid.lastIndexOf(":");
                    String t = arbeidstid.substring(2+x, y);
                    if(t.matches(timer[i])){
                        cb_timer2.setSelectedIndex(i);
                    }
                }
                for( int i = 0; i < minutter.length; i++){
                    int x = arbeidstid.lastIndexOf(":");
                    int y = arbeidstid.length();
                    String a = arbeidstid.substring(++x, y);
                    if(a.matches(minutter[i])){
                        cb_minutter2.setSelectedIndex(i);
                    }
                }
            String stillingsType = vikariat.getStillingstype();
                for( int i = 0; i < stillingsTyper.length; i++){
                    if(stillingsType.matches(stillingsTyper[i])){
                        cb_stillingsTyper.setSelectedIndex(i);
                    }
                }
        });//slutten av lytteren
        
        cb_timer = new JComboBox<>(timer);
        cb_timer.setMaximumRowCount(16);
        cb_minutter = new JComboBox<>(minutter);
        cb_minutter.setMaximumRowCount(12);
        cb_timer2 = new JComboBox<>(timer);
        cb_timer2.setMaximumRowCount(16);
        cb_minutter2 = new JComboBox<>(minutter);
        cb_minutter2.setMaximumRowCount(12);
        cb_dag = new JComboBox<>(dag);
        cb_dag.setMaximumRowCount(20);
        cb_dag2 = new JComboBox<>(dag);
        cb_dag2.setMaximumRowCount(20);
        cb_maned = new JComboBox<>(maned);
        cb_maned.setMaximumRowCount(12);
        cb_maned2 = new JComboBox<>(maned);
        cb_maned2.setMaximumRowCount(12);
        cb_ar = new JComboBox<>(ar);
        cb_ar.setMaximumRowCount(5);
        cb_ar2 = new JComboBox<>(ar);
        cb_ar2.setMaximumRowCount(5);

        cb_stillingsTyper = new JComboBox<String>(stillingsTyper);
        cb_stillingsTyper.setMaximumRowCount(9);

        
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
        
        add(lbl_vikariat);
        add(cb_vikariater);
        add(lbl_adresse);
        add(tf_adresse);
        add(lbl_varighetfra);
        add(fra);
        add(lbl_varighettil);
        add(til);
        add(lbl_arbeidstid);
        add(tider);
        add(lbl_stillingstype);
        add(cb_stillingsTyper);
        add(lbl_kvalifikasjoner);
        add(tf_kvalifikasjoner);
        add(lbl_lonnsbetingelser);
        add(tf_lonnsbetingelser);
        add(lbl_kontaktinfo);
        add(tf_kontaktinfo);
        add(lbl_stillingsinfo);
        add(tf_stillingsinfo);
        add(slettVikariat);
        add(endreVikariat);
    }//end kontruktør
    
    //Tar i mot den nye infoen fra tekstfeltene
    public void endreVikariat(){
        String vikariatNr = (String) cb_vikariater.getSelectedItem();
        if(vikariatNr.matches("---Vikariater---")){
            JOptionPane.showMessageDialog(null, "Vikariat ikke valgt");
            return;
        }
        Vikariat vikariat = v.vikariatRegister.finnVikariat(Integer.parseInt(vikariatNr));
        
        String adresse = tf_adresse.getText();
        vikariat.setAdresse(adresse);
        String arbeidstid = (String) cb_timer.getSelectedItem() + ":" + 
                            (String) cb_minutter.getSelectedItem() + " - " + 
                            (String) cb_timer2.getSelectedItem() + ":" + 
                            (String) cb_minutter2.getSelectedItem();
        vikariat.setArbeidstid(arbeidstid);
        String stillingstype = tf_stillingstype.getText();
        vikariat.setStillingstype(stillingstype);
        String kvalifikasjoner = tf_kvalifikasjoner.getText();
        vikariat.setKvalifikasjoner(kvalifikasjoner);
        String lonnsbetingelser = tf_lonnsbetingelser.getText();
        vikariat.setLonnsbetingelser(lonnsbetingelser);
        String kontaktinfo = tf_kontaktinfo.getText();
        vikariat.setKontaktinfo(kontaktinfo);
        String stillingsinfo = tf_stillingsinfo.getText();
        vikariat.setStillingsInfo(stillingsinfo);
        String varighetfra = (String) cb_dag.getSelectedItem() + "-" + 
                             (String) cb_maned.getSelectedItem() + "-" +
                             (String) cb_ar.getSelectedItem();
        vikariat.setVarighetfra(varighetfra);
        String varighettil = (String) cb_dag2.getSelectedItem() + "-" +
                             (String) cb_maned2.getSelectedItem() + "-" +
                             (String) cb_ar2.getSelectedItem();
        vikariat.setVarighettil(varighettil);
        String bransjer = (String) cb_stillingsTyper.getSelectedItem();
        vikariat.setBransje(bransjer);
        JOptionPane.showMessageDialog(null, "Vikariatet har blitt oppdatert!","Oppdatert",JOptionPane.INFORMATION_MESSAGE);
        
        refresh();
        resetInput();
    }//end endreVikariat()
    
    //Sletter det valgte vikariatet
    public void slettVikariat(){
        String vikariatNr = (String)cb_vikariater.getSelectedItem();
        if(vikariatNr.matches("---Vikariater---")){
            JOptionPane.showMessageDialog(null,"Vikariat ikke valgt!");
            return;
        }
        int sikker = JOptionPane.showConfirmDialog(null, "Er du sikker på at du vil slette vikariatet?","Sletting",JOptionPane.YES_NO_OPTION);
        if(sikker == JOptionPane.YES_OPTION){
            if(v.vikariatRegister.finnVikariat(Integer.parseInt(vikariatNr))!=null){
                System.out.println("Vikariat funnet");
                if(v.vikariatRegister.slettVikariat(vikariatNr)){
                    cb_vikariater.removeItem((String)cb_vikariater.getSelectedItem());
                    v.nesteVikariatNr();
                    resetInput();
                    refresh();
                }
            }
        }
    }
    
    private void refresh(){
        v.vikariatRegister.skrivVikariatListe(utskrift);
    }
    
    private void resetInput(){
        //cb_vikariater.setSelectedIndex(0);
        tf_adresse.setText("");
        cb_timer.setSelectedIndex(0);
        cb_timer2.setSelectedIndex(0);
        cb_minutter.setSelectedIndex(0);
        cb_minutter2.setSelectedIndex(0);
        cb_dag.setSelectedIndex(0);
        cb_dag2.setSelectedIndex(0);
        cb_maned.setSelectedIndex(0);
        cb_maned2.setSelectedIndex(0);
        cb_ar.setSelectedIndex(0);
        cb_ar2.setSelectedIndex(0);
        cb_stillingsTyper.setSelectedIndex(0);
        tf_kvalifikasjoner.setText("");
        tf_lonnsbetingelser.setText("");
        tf_kontaktinfo.setText("");
        tf_stillingsinfo.setText("");
    }
    
    //Knytter knappene "Slett Vikariat" og "Endre Vikariat" til lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==endreVikariat){
                endreVikariat();
            }
            else if(e.getSource()==slettVikariat){
                slettVikariat();
            }
        }
    }//end Knappelytter
}//end Endrevikariat
