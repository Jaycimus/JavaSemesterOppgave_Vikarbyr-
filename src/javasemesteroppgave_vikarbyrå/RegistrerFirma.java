/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 1. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrerFirma extends JPanel {
    private JButton regFirma;
    private JLabel lbl_navn, lbl_adresse, lbl_bransje, lbl_tlf, lbl_epost;
    private JRadioButton privat, offentlig;
    private ButtonGroup BG_typeSektor;
    private JTextField tf_navn, tf_adresse, tf_tlf, tf_epost;
    private JLabel label;
    private JTextArea utskrift;
    
    private Vikarbyraa v;
    
    private JComboBox<String> cb_bransjer; 
    private final String[] bransjer = 
        {"Advokattjenester/Prosedyre", "Bankvirksomhet", "Helsesektor", "Bygg/Anlegg/Entreprenør", 
            "Eiendom/Eiendomsmegling", "Engineering", "Farmasi/Legemiddel", "Finans -verdipapirer/megling", 
                "Forsikring/Assuranse", "Forskning og utvikling", "Helse/Velvære/Trening", "Helsesektor", "Hotell/overnatting", 
                    "Høyteknologi/Elektronikk", "IKT/Telekom", "Industri: Tradisjonell/Prosess/Øvrig", "Ingeniøryrker: Øvrig", "Internett tjenester/E-handel", 
                        "Investment banking", "Investment management", "IT: Hardware/Software", "Juridisk rådgivning", "Kommunikasjon/PR", "Konsulenttjenester: Ingeniør/Teknisk", 
                            "Konsulenttjenester: Øvrig", "Konsultenttjenester: IT", "Kultur/Kunst/Øvrige kreative fag", "Management consulting", "Media/Underholdning", "Merkevarer/Konsumentprodukter", 
                                "NGO - Ikke-statlige organisasjoner", "Non-profit -/interesseorg.", "Olje/Gass/Energi/Kraft", "Regnskap", "Reiseliv/Turisme/Event", "Reklame", "Rekruttering/HR/Bemanning", 
                                    "Restaurant/Servering", "Revisjon", "Salg/Markedsføring", "Shipping/Off-/Onshore/Maritim", "Statlig/Offentlig/Kommunal sektor", "Transport/Distribusjon/Logistikk", "Utdanning/undervisning", 
                                        "Varehandel/Dagligvare/Butikk", "Øvrig"};
    
    
    public RegistrerFirma(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        regFirma = new JButton("Registrer Firma");
        regFirma.addActionListener(lytter);
        
        lbl_navn = new JLabel("Firma navn: ");
        lbl_adresse = new JLabel("Adresse: ");
        lbl_bransje = new JLabel("Bransje: ");
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
        
        cb_bransjer = new JComboBox<String>(bransjer);
        cb_bransjer.setMaximumRowCount(9);
                
        add(lbl_navn);
        add(tf_navn);
        add(lbl_adresse);
        add(tf_adresse);
        add(privat);
        add(offentlig);
        add(lbl_bransje);
        add(cb_bransjer);
        add(lbl_tlf);
        add(tf_tlf);
        add(lbl_epost);
        add(tf_epost);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regFirma);
                        
    }
    
    public JButton getRegFirma(){
        return regFirma;
    }
    
    public void regFirma(){
        String navn = tf_navn.getText();
        String adresse = tf_adresse.getText();
        int tlf;
        String epost = tf_epost.getText();
        String sektor;
            if(privat.isSelected())
                sektor = "Privat";
            else
                sektor = "Offentlig";
        String bransjer = (String) cb_bransjer.getSelectedItem();
        
        try{
            tlf = Integer.parseInt(tf_tlf.getText());
            
            if(!Validering.validerNavn(navn)){
                JOptionPane.showMessageDialog(null, "Feil med firma navn");
                return;
            } else if(!Validering.validerAdresse(adresse)){
                JOptionPane.showMessageDialog(null, "Feil med adresse");
                return;
            } else if(!Validering.validerTLF(tf_tlf.getText())){
                JOptionPane.showMessageDialog(null, "Feil med telefonnummer");
                return;
            } else if(!Validering.validerEpost(epost)){
                JOptionPane.showMessageDialog(null, "Feil med epost");
                return;
            } else {
                Firma firma = new Firma(navn, sektor, adresse, bransjer, tlf, epost);
                v.firmaRegister.settInn(firma);
                System.out.println("regFirma");
                utskrift.setText(firma.toString());
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Feil med telefonnummer");
        }   
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regFirma){
                regFirma();
            }
        }}
    
}
