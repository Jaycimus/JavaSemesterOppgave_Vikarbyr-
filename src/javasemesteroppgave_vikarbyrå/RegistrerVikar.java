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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class RegistrerVikar extends JPanel{
    private JButton regVikar;
    private JLabel lbl_navn, lbl_persnr, lbl_tlfnr, lbl_jobberf, lbl_ref;
    private JLabel lbl_bransje, lbl_utdanning, lbl_epost;
    private JTextField tf_navn, tf_persnr, tf_tlfnr, tf_epost;
    private JTextArea ta_jobberf, ta_ref;
    private JTextArea utskrift;
    private JRadioButton mann, kvinne;
    private ButtonGroup BG_kjonn;
    
    private Vikarbyraa v;
    
    private JComboBox<String> cb_utdanning;
    private final String[] utdanning = 
        {"Ingen","Videregående","Fagskole","Høgskole/Universitet"};
    private JComboBox<String> cb_bransjer;
    private final String[] bransjer = 
        {"Advokattjenester/Prosedyre", "Bankvirksomhet", "Bygg/Anlegg/Entreprenør", 
            "Eiendom/Eiendomsmegling", "Engineering", "Farmasi/Legemiddel", "Finans -verdipapirer/megling", 
                "Forsikring/Assuranse", "Forskning og utvikling", "Helse/Velvære/Trening", "Helsesektor", "Hotell/overnatting", 
                    "Høyteknologi/Elektronikk", "IKT/Telekom", "Industri: Tradisjonell/Prosess/Øvrig", "Ingeniøryrker: Øvrig", "Internett tjenester/E-handel", 
                        "Investment banking", "Investment management", "IT: Hardware/Software", "Juridisk rådgivning", "Kommunikasjon/PR", "Konsulenttjenester: Ingeniør/Teknisk", 
                            "Konsulenttjenester: Øvrig", "Konsultenttjenester: IT", "Kultur/Kunst/Øvrige kreative fag", "Management consulting", "Media/Underholdning", "Merkevarer/Konsumentprodukter", 
                                "NGO - Ikke-statlige organisasjoner", "Non-profit -/interesseorg.", "Olje/Gass/Energi/Kraft", "Regnskap", "Reiseliv/Turisme/Event", "Reklame", "Rekruttering/HR/Bemanning", 
                                    "Restaurant/Servering", "Revisjon", "Salg/Markedsføring", "Shipping/Off-/Onshore/Maritim", "Statlig/Offentlig/Kommunal sektor", "Transport/Distribusjon/Logistikk", "Utdanning/undervisning", 
                                        "Varehandel/Dagligvare/Butikk", "Øvrig"};
    
    public RegistrerVikar(Vikarbyraa v, JTextArea utskrift){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        regVikar = new JButton("Registrer Vikar");
        regVikar.addActionListener(lytter);
        
        lbl_navn = new JLabel("Navn: ");
        lbl_persnr = new JLabel("Personnr: ");
        lbl_tlfnr = new JLabel("Telefon: ");
        lbl_epost = new JLabel("E-post: ");
        lbl_jobberf = new JLabel("Jobberfaring: ");
        lbl_ref = new JLabel("Referanse(r): ");
        lbl_bransje = new JLabel("Bransje: ");
        lbl_utdanning = new JLabel("Utdanning: ");
        
        tf_navn = new JTextField("",15);
        tf_persnr = new JTextField("11 siffer",15);
        tf_persnr.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                tf_persnr.setText("");
            }
            
            public void focusLost(FocusEvent e){
                
            }
        });
            
        
        tf_tlfnr = new JTextField("8 siffer",15);
        tf_tlfnr.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                tf_tlfnr.setText("");
            }
            
            public void focusLost(FocusEvent e){
                
            }
        });
        tf_epost = new JTextField("",15);
        
        ta_jobberf = new JTextArea(4,15);
        JScrollPane sp_jobberf = new JScrollPane(ta_jobberf);
        ta_ref = new JTextArea(4,15);
        JScrollPane sp_ref = new JScrollPane(ta_ref);
        
        BG_kjonn = new ButtonGroup();
        mann = new JRadioButton("Mann",true);
        kvinne = new JRadioButton("Kvinne",true);
        BG_kjonn.add(mann);
        BG_kjonn.add(kvinne);
        
        cb_bransjer = new JComboBox<>(bransjer);
        cb_bransjer.setMaximumRowCount(9);
        cb_utdanning = new JComboBox<>(utdanning);
        cb_utdanning.setMaximumRowCount(3);
        
        add(lbl_navn);
        add(tf_navn);
        add(lbl_persnr);
        add(tf_persnr);
        add(lbl_tlfnr);
        add(tf_tlfnr);
        add(lbl_epost);
        add(tf_epost);
        add(lbl_utdanning);
        add(cb_utdanning);
        add(mann);
        add(kvinne);
        add(lbl_jobberf);
        add(sp_jobberf);
        add(lbl_ref);
        add(sp_ref);
        add(lbl_bransje);
        add(cb_bransjer);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regVikar);
    }
    public JButton getRegVikar(){
        return regVikar;
    }
    
    public void regVikar(){
        String navn = tf_navn.getText();
        long pers;
        int tlf;
        String epost = tf_epost.getText();
        String jobberf = ta_jobberf.getText();
        String ref = ta_ref.getText();
        String jobbkat = (String) cb_bransjer.getSelectedItem();
        String utdan = (String) cb_utdanning.getSelectedItem();
        String kjonn;
            if(mann.isSelected())
                kjonn = "Mann";
            else
                kjonn = "Kvinne";
        
        try{
            if(!Validering.validerNavn(navn)){
                JOptionPane.showMessageDialog(null, "Feil i vikar navn");
            } else if(!Validering.validerPersonnummer(tf_persnr.getText())){
                JOptionPane.showMessageDialog(null, "Feil med personnummeret");
            } else if(!Validering.validerTLF(tf_tlfnr.getText())){
                JOptionPane.showMessageDialog(null, "Feil med telfonnummeret");
            } else {
                tlf = Integer.parseInt(tf_tlfnr.getText());
                pers = Long.parseLong(tf_persnr.getText());
                Vikar vikar = new Vikar(navn,tlf,epost,pers,jobbkat,utdan,kjonn,jobberf,ref);
                v.vikarRegister.settInn(vikar);
                System.out.println("regVikar");
                utskrift.setText(vikar.toString());
                tf_navn.setText("");
                tf_persnr.setText("");
                tf_tlfnr.setText("");
                tf_epost.setText("");
                ta_jobberf.setText("");
                ta_ref.setText("");
            }
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "");
        }
    }
            
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regVikar){
                regVikar();
            }
        }
    }
}
