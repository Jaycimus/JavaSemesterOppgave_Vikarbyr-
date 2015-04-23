
/**
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrerVikar extends JPanel{
    private JButton regVikar;
    private JLabel lbl_navn, lbl_persnr, lbl_tlfnr, lbl_jobberf, lbl_ref;
    private JLabel lbl_bransje, lbl_utdanning;
    private JTextField tf_navn, tf_persnr, tf_tlfnr, tf_jobberf, tf_ref;
    private JTextArea utskrift;
    
    private JComboBox<String> cb_utdanning;
    private final String[] utdanning = 
        {"Ingen","Videregående","Høgskole/Universitet"};
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
    
    public RegistrerVikar(JTextArea utskrift){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        regVikar = new JButton("Registrer Vikar");
        regVikar.addActionListener(lytter);
        
        lbl_navn = new JLabel("Navn: ");
        lbl_persnr = new JLabel("Personnr: ");
        lbl_tlfnr = new JLabel("Telefon: ");
        lbl_jobberf = new JLabel("Jobberfaring: ");
        lbl_ref = new JLabel("Referanse(r): ");
        lbl_bransje = new JLabel("Bransje: ");
        lbl_utdanning = new JLabel("Utdanning: ");
        
        tf_navn = new JTextField("",15);
        tf_persnr = new JTextField("",15);
        tf_tlfnr = new JTextField("",15);
        tf_jobberf = new JTextField("",15);
        tf_ref = new JTextField("",15);
        
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
        add(lbl_utdanning);
        add(cb_utdanning);
        add(lbl_jobberf);
        add(tf_jobberf);
        add(lbl_ref);
        add(tf_ref);
        add(lbl_bransje);
        add(cb_bransjer);
        add(regVikar);
    }
    public JButton getRegVikar(){
        return regVikar;
    }
    
    public void regVikar(){
        String navn = tf_navn.getText();
        String persS = tf_persnr.getText();
        int pers = Integer.parseInt(persS);
        String tlfS = tf_tlfnr.getText();
        int tlf = Integer.parseInt(tlfS);
        String jobberf = tf_jobberf.getText();
        String ref = tf_ref.getText();
        String jobbkat = (String) cb_bransjer.getSelectedItem();
        String utdan = (String) cb_utdanning.getSelectedItem();
        
        Vikar vikar = new Vikar(navn,tlf,pers,jobbkat,utdan,jobberf,ref);
        
        System.out.println("regVikar");
        
        utskrift.setText(vikar.toString());
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regVikar){
                regVikar();
            }
        }
    }
}
