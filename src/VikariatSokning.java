/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 17. Mai 2015 AV: Andreas Stenseng Bjørnrud


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class VikariatSokning extends JPanel {
    private JPanel kunde,vikariat;
    private final JTextField tf_kunde,  tf_vikariat;
    private final JLabel lbl_skrivHerKunde, lbl_skrivHerVikariat, lbl_kundeAlternativ, lbl_vikariatAlternativ;
    private final JComboBox<String> cb_kunder, cb_vikariater;
    private final String[] kundeVariabler = 
        {"Alternativer", "Navn", "Sektor", "Adresse", "E-post", "TLF", "Vikariater"};
    private final String[] vikariatVariable = 
        {"Alternativer", "Vikariat Nr.", "Varighet", "Arbeidstid", "Stillingstype", 
            "Kvalifikasjoner", "Lønnsbetingelser", "Kontaktinfo", "StillingsInfo", 
            "Ledig", "Arbeidsforhold", "Søknader", "Vikar"};           
    private final JButton sok;
    private final JTextArea utskrift;
    
    Border blackline;
    TitledBorder titleKunde, titleVikariat;
    
    private Vikarbyraa v;
    
    public VikariatSokning(JTextArea utskrift, Vikarbyraa v){
        this.v = v;
        this.utskrift = utskrift;
        setLayout(new GridLayout(0,1,20,25));
        setPreferredSize(new Dimension(500,500));
        
        blackline = BorderFactory.createLineBorder(Color.black);
        
        titleKunde = BorderFactory.createTitledBorder(blackline,"Søk i Kunde Register");
        titleKunde.setTitleJustification(TitledBorder.CENTER);
        titleVikariat = BorderFactory.createTitledBorder(blackline,"Søk i Vikariat Register");
        titleVikariat.setTitleJustification(TitledBorder.CENTER);
        
        sok = new JButton("Søk");
        Knappelytter lytter = new Knappelytter();
        sok.addActionListener(lytter);
        
        lbl_kundeAlternativ = new JLabel("Søk Etter Kunde I Registeret:");
        lbl_vikariatAlternativ = new JLabel("Søk Etter Vikariat I Registeret:");
        lbl_skrivHerKunde = new JLabel("Skriv her:");
        lbl_skrivHerVikariat = new JLabel("Skriv her:");
        
        tf_kunde = new JTextField("",15);
        tf_kunde.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                tf_kunde.setText("");
            }
            
            public void focusLost(FocusEvent e){
                
            }
        });
        tf_vikariat = new JTextField("",15);
        tf_vikariat.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                tf_vikariat.setText("");
            }
            
            public void focusLost(FocusEvent e){
                
            }
        });
        
        cb_kunder = new JComboBox<>(kundeVariabler);
        cb_kunder.setMaximumRowCount(9);
        cb_kunder.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String valg = (String) cb_kunder.getSelectedItem();
                        if(valg.matches("Alternativer")){
                            tf_kunde.setText("");
                            return;
                        } else if(valg.matches("Navn")) {
                            tf_kunde.setText("Eks: Ola Nordmann");
                        } else if(valg.matches("Sektor")) {
                            tf_kunde.setText("Eks: Privat/Offentlig");
                        } else if(valg.matches("Adresse")) {
                            tf_kunde.setText("Eks: Tullebakken 5");
                        } else if(valg.matches("E-post")) {
                            tf_kunde.setText("Eks: eks@eks.no");
                        } else if(valg.matches("TLF")) {
                            tf_kunde.setText("Eks: 00000000 (8 siffer)");
                        } else if(valg.matches("Vikariater")) {
                            tf_kunde.setText("Eks: 10005 (5 siffer)");
                        }
                    }
                }
            }
        );
        cb_vikariater = new JComboBox(vikariatVariable);
        cb_vikariater.setMaximumRowCount(9);
        cb_vikariater.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String valg = (String) cb_vikariater.getSelectedItem();
                        if(valg.matches("Alternativer")){
                            tf_vikariat.setText("");
                            return;
                        } else if(valg.matches("Vikariat Nr.")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("Varighet")) {
                            tf_vikariat.setText("Eks: Privat/Offentlig");
                        } else if(valg.matches("Arbeidstid")) {
                            tf_vikariat.setText("Eks: Tullebakken 5");
                        } else if(valg.matches("Stillingstype")) {
                            tf_vikariat.setText("Eks: Regnskap");
                        } else if(valg.matches("Kvalifikasjoner")) {
                            tf_vikariat.setText("Eks: 00000000 (8 siffer)");
                        } else if(valg.matches("Lønnsbetingelser")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("Kontaktinfo")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("StillingsInfo")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("Ledig")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("Arbeidsforhold")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("Søknader")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        } else if(valg.matches("Vikar")) {
                            tf_vikariat.setText("Eks: 10005 (5 siffer)");
                        }
                    }
                }
            }
        );
        
                        
        opprettKundePanel();
        opprettVikariatPanel();
        
        add(kunde);
        add(vikariat);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(sok);
    }
            
    private void opprettKundePanel(){
        kunde = new JPanel(new GridLayout(0,2,5,5));
        kunde.setBorder(titleKunde);
        kunde.add(lbl_kundeAlternativ);
        kunde.add(cb_kunder);
        kunde.add(lbl_skrivHerKunde);
        kunde.add(tf_kunde);
    }
    
    private void opprettVikariatPanel(){
        vikariat = new JPanel(new GridLayout(2,2,5,5));
        vikariat.setBorder(titleVikariat);
        vikariat.add(lbl_vikariatAlternativ);
        vikariat.add(cb_vikariater);
        vikariat.add(lbl_skrivHerVikariat);
        vikariat.add(tf_vikariat);
    } 
    
    
    
    private void sokning(){
        String kundeValg = (String) cb_kunder.getSelectedItem();
        String vikariatValg = (String) cb_vikariater.getSelectedItem();
        if(!kundeValg.matches("Kunde alternativer")){
            if (cb_kunder.getSelectedIndex() == 1){
                if(tf_kunde.getText().matches("")){
                    v.getKundeRegister().skrivHeleKundeListe(utskrift);
                } else {
                    v.getKundeRegister().skrivKunde(utskrift, tf_kunde.getText());
                }
            } else if (cb_kunder.getSelectedIndex() == 2){
                if(tf_kunde.getText().matches("")){
                    v.getKundeRegister().skrivHeleKundeListe(utskrift);
                } else {
                    v.getKundeRegister().skrivKundeListeSektor(utskrift, tf_kunde.getText());
                }
            } else if (cb_kunder.getSelectedIndex()==3){
                if(tf_kunde.getText().matches("")){
                    v.getKundeRegister().skrivHeleKundeListe(utskrift);
                } else {
                    v.getKundeRegister().skrivKundeAdresse(utskrift, tf_kunde.getText());
                }
            } else if (cb_kunder.getSelectedIndex()==4){
                if(tf_kunde.getText().matches("")){
                    v.getKundeRegister().skrivHeleKundeListe(utskrift);
                } else {
                    v.getKundeRegister().skrivKundeEpost(utskrift, tf_kunde.getText());
                }
            } else if (cb_kunder.getSelectedIndex()==5){
                if(tf_kunde.getText().matches("")){
                    v.getKundeRegister().skrivHeleKundeListe(utskrift);
                } else {
                    v.getKundeRegister().skrivKundeTlf(utskrift, tf_kunde.getText());
                }
            } else if (cb_kunder.getSelectedIndex()==6){
                if(tf_kunde.getText().matches("")){
                    v.getKundeRegister().skrivHeleKundeListe(utskrift);
                } else {
                    utskrift.setText(v.getVikariatRegister().finnVikariat(Integer.parseInt(tf_kunde.getText())).getKundeToString());
                }
            }
            return;
        } else if (!vikariatValg.matches("Vikariat alternativer")){
            if (cb_kunder.getSelectedIndex() == 1){
                if(tf_kunde.getText().matches("")){
                    v.getVikariatRegister().skrivVikariatListe(utskrift);
                } else {
                    v.getKundeRegister().skrivKunde(utskrift, tf_kunde.getText());
                }
            }
            return;
        }  else {
            JOptionPane.showMessageDialog(null, "Ingen av alternativene er valgt!");
        }
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==sok){
                sokning();
            }
        }
    }
}
