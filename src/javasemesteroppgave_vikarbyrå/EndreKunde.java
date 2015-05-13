/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EndreKunde extends JPanel {
    private JButton endreKunde, slettKunde;
    private JLabel lbl_navn, lbl_adresse, lbl_tlf, lbl_epost;
    private JRadioButton privat, offentlig;
    private ButtonGroup BG_typeSektor;
    private JTextField tf_navn, tf_adresse, tf_tlf, tf_epost;
    private JLabel label;
    private JTextArea utskrift;
    
    private Vikarbyraa v;
    private Kunde kunde;
    
    private JComboBox<String>  cb_kunder; 
    private String[] kundeNavn;
    
    
    
    public EndreKunde(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        //CBlytter cbLytter = new CBlytter();
        
        kundeNavn = v.kundeRegister.getKundeNavn();
        
        endreKunde = new JButton("Registrer kunde");
        endreKunde.addActionListener(lytter);
        slettKunde = new JButton("Slett kunde");
        slettKunde.addActionListener(lytter);
        
        lbl_navn = new JLabel("Kunde navn: ");
        lbl_adresse = new JLabel("Adresse: ");
        lbl_tlf = new JLabel("Telefon: ");
        lbl_epost = new JLabel("E-post: ");
        
        BG_typeSektor = new ButtonGroup();
        privat = new JRadioButton("Privat Sektor", true);
        offentlig = new JRadioButton("Offentlig Sektor", false);
        BG_typeSektor.add(privat);
        BG_typeSektor.add(offentlig);
        
        tf_navn = new JTextField("", 15);
        tf_adresse = new JTextField("", 15);
        tf_tlf = new JTextField("", 15);
        tf_epost = new JTextField("", 15);
        
        
        cb_kunder = new JComboBox<String>(kundeNavn);
        cb_kunder.setMaximumRowCount(9);
        cb_kunder.addItemListener((ItemEvent e) -> {
            String kundeNavn1 = (String) cb_kunder.getSelectedItem();
            Kunde kunde = v.kundeRegister.finnKunde(kundeNavn1);
            tf_navn.setText(kunde.getNavn());
            tf_adresse.setText(kunde.getAdresse());
            tf_tlf.setText(kunde.getTlf());
            tf_epost.setText(kunde.getEpost());
            String sektor = kunde.getTypeSektor();
            if(sektor.matches("Privat")){
                privat.setSelected(true);
            } else if(sektor.matches("Offentlig")) {
                offentlig.setSelected(true);
            }
        });
        
        add(new JPanel());
        add(cb_kunder);
        add(lbl_navn);
        add(tf_navn);
        add(lbl_adresse);
        add(tf_adresse);
        add(privat);
        add(offentlig);
        add(lbl_tlf);
        add(tf_tlf);
        add(lbl_epost);
        add(tf_epost);
        add(new JPanel());
        add(new JPanel());
        add(slettKunde);
        add(endreKunde);
                        
    }
    
    public void endreKunde(){
        Kunde kunde = v.kundeRegister.finnKunde((String) cb_kunder.getSelectedItem());
        
        String navn = tf_navn.getText();
        if(kunde==null)
            System.out.println("kukk");
        kunde.setNavn(navn);
        String adresse = tf_adresse.getText();
        kunde.setAdresse(adresse);
        int tlf;
        String epost = tf_epost.getText();
        kunde.setEpost(epost);
        String sektor;
            if(privat.isSelected()){
                sektor = "Privat";
                kunde.setTypeSektor(sektor);
            }
            else{
                sektor = "Offentlig";
                kunde.setTypeSektor(sektor);
            }   
    }
    
    public void slettKunde(){
        
        String navn = (String)cb_kunder.getSelectedItem();
        if(v.kundeRegister.slettKunde(navn)){
            tf_navn.setText("");
            tf_adresse.setText("");
            tf_tlf.setText("");
            tf_epost.setText("");
            
            cb_kunder.removeItem((String)cb_kunder.getSelectedItem());
        }
        
        
        
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==endreKunde){
                endreKunde();
            }
            else if(e.getSource()==slettKunde){
                slettKunde();
            }
            
            
        }
    }
}