/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
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

//Klassen bygger opp vinduet når du trykker på knappen "Vis/Endre Vikar"
public class EndreVikar extends JPanel{
    private JButton endreVikar, slettVikar;
    private JLabel lbl_velgVikar, lbl_navn, lbl_persnr, lbl_tlfnr, lbl_jobberf, lbl_ref;
    private JLabel lbl_bransje, lbl_utdanning, lbl_epost;
    private JTextField tf_navn, tf_persnr, tf_tlfnr, tf_epost;
    private JTextArea ta_jobberf, ta_ref, utskrift;
    private JRadioButton mann, kvinne;
    private ButtonGroup BG_kjonn;
    
    private Vikarbyraa v;
    private Vikar vikar;
    
    private JComboBox<String> cb_vikar;
    private String[] vikarPersNr;

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
    
    //Konstruktør
    public EndreVikar(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        

        vikarPersNr = v.getVikarRegister().getVikarer();
        
        endreVikar = new JButton("Endre Vikar");
        endreVikar.addActionListener(lytter);
        slettVikar = new JButton("Slett Vikar");
        slettVikar.addActionListener(lytter);
        
        lbl_velgVikar = new JLabel("Velg Vikar:");
        lbl_navn = new JLabel("Navn:");
        lbl_persnr = new JLabel("Personnr:");
        lbl_tlfnr = new JLabel("Telefon:");
        lbl_epost = new JLabel("E-post:");
        lbl_jobberf = new JLabel("Jobberfaring:");
        lbl_ref = new JLabel("Referanse(r):");
        lbl_bransje = new JLabel("Bransje:");
        lbl_utdanning = new JLabel("Utdanning:");
        
        tf_navn = new JTextField("",15);
        tf_persnr = new JTextField("11 siffer",15);
        //Når man trykker på feltet så forsvinner teksten "11 siffer"
        tf_persnr.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                tf_persnr.setText("");
            }
            
            public void focusLost(FocusEvent e){
                
            }
        });
            
        
        tf_tlfnr = new JTextField("8 siffer",15);
        //Når man trykker på feltet så forsvinner teksten "8 siffer"
        tf_tlfnr.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                tf_tlfnr.setText("");
            }
            
            public void focusLost(FocusEvent e){
                
            }
        });
        tf_epost = new JTextField("",15);
        
        ta_jobberf = new JTextArea(1,15);
        JScrollPane sp_jobberf = new JScrollPane(ta_jobberf);
        ta_ref = new JTextArea(1,15);
        JScrollPane sp_ref = new JScrollPane(ta_ref);
        
        BG_kjonn = new ButtonGroup();
        mann = new JRadioButton("Mann",true);
        kvinne = new JRadioButton("Kvinne",true);
        BG_kjonn.add(mann);
        BG_kjonn.add(kvinne);
        
        cb_bransjer = new JComboBox<>(bransjer);
        cb_bransjer.setMaximumRowCount(9);
        cb_utdanning = new JComboBox<>(utdanning);
        cb_utdanning.setMaximumRowCount(4);

        cb_vikar = new JComboBox<>(vikarPersNr);
        cb_vikar.setMaximumRowCount(9);
        cb_vikar = new JComboBox<>(vikarPersNr);
        cb_vikar.setMaximumRowCount(9);
        cb_vikar.addItemListener((ItemEvent e)-> {
            String vikarNavn = (String) cb_vikar.getSelectedItem();
            if(vikarNavn.equals("---Vikarer---")){
                tf_persnr.setText("");
                tf_tlfnr.setText("");
                tf_epost.setText("");
                mann.setSelected(false);
                kvinne.setSelected(false);
                ta_jobberf.setText("");
                ta_ref.setText("");
                return;
            }
            
            Vikar vikar = v.getVikarRegister().finnVikar((String) cb_vikar.getSelectedItem());
            tf_navn.setText(vikar.getNavn());
            tf_persnr.setText("" + vikar.getPersonNr());
            tf_tlfnr.setText("" + vikar.getTlf());
            tf_epost.setText(vikar.getEpost());
            String stillingsType = vikar.getUtdanning();
                for( int i = 0; i < utdanning.length; i++){
                    if(stillingsType.matches(utdanning[i])){
                        cb_utdanning.setSelectedIndex(i);
                    }
                }
            String kjonn = vikar.getKjonn();
            if(kjonn.matches("Mann")){
                mann.setSelected(true);
            } else if(kjonn.matches("Kvinne")){
                kvinne.setSelected(true);
            }
            ta_jobberf.setText(vikar.getJobberfaring());
            ta_ref.setText(vikar.getReferanser());
            
            String bransje = vikar.getOnsketBransje();
                for( int i = 0; i < bransjer.length; i++){
                    if(bransje.matches(bransjer[i])){
                        cb_bransjer.setSelectedIndex(i);
                    }
                }
        });
        
        add(lbl_velgVikar);
        add(cb_vikar);
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
        add(slettVikar);
        add(endreVikar);
    }//end kontruktør
    
    //Leser inn den nye infoen som blir skrevet inn i tekstfelt
    public void endreVikar(){
        String personNr = (String)cb_vikar.getSelectedItem();
        if(personNr.matches("---Vikarer---")){
            JOptionPane.showMessageDialog(null,"Vikar ikke valgt!");
            return;
        }
        String navn = tf_navn.getText();
        long pers;
        int tlf;
        String epost = tf_epost.getText();
        String jobberf = ta_jobberf.getText();
        String ref = ta_ref.getText();
        String onsketBransje = (String) cb_bransjer.getSelectedItem();
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
                vikar = v.getVikarRegister().finnVikar(personNr);
                vikar.setNavn(navn);
                vikar.setTlf(tlf);
                vikar.setPersonNr(pers);
                vikar.setOnsketBransje(onsketBransje);
                vikar.setUtdanning(utdan);
                vikar.setJobberfaring(jobberf);
                vikar.setReferanser(ref);
                vikar.setKjonn(kjonn);
                vikar.setEpost(epost);
            }
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Feil i tallformat!");
        }
        JOptionPane.showMessageDialog(null, "Vikar har blitt oppdatert!","Oppdatert",JOptionPane.INFORMATION_MESSAGE);
        endreKundeTilVikariater(personNr);
    
    }//end regVikar()
    
    //Sletter den valgte vikaren når "Slett Vikar"-knappen blir trykket
    public void slettVikar(){
        String personNr = (String)cb_vikar.getSelectedItem();
        if(personNr.matches("---Vikarer---")){
            JOptionPane.showMessageDialog(null,"Vikar ikke valgt!");
            return;
        }
        int sikker = JOptionPane.showConfirmDialog(null, "Er du sikker på at du vil slette vikaren?","Sletting",JOptionPane.YES_NO_OPTION);
        if(sikker == JOptionPane.YES_OPTION){
            v.getVikariatRegister().finnVikariatOgSLettVikar(personNr);
            if(v.getVikarRegister().slettVikar(personNr)){
                cb_vikar.removeItem((String)cb_vikar.getSelectedItem());
                resetInput();
                refresh();
                
            }
        }
    }
    
    private void resetInput(){
        //cb_vikariater.setSelectedIndex(0);
        tf_navn.setText("");
        cb_vikar.setSelectedIndex(0);
        cb_utdanning.setSelectedIndex(0);
        cb_bransjer.setSelectedIndex(0);
        tf_persnr.setText("");
        tf_tlfnr.setText("");
        tf_epost.setText("");
        ta_jobberf.setText("");
        ta_ref.setText("");
    }
    
    
    private void refresh(){
        v.getVikarRegister().skrivVikarListe(utskrift);
    }
            
    //Knytter "Endre Vikar" og "Slett Vikar" knappene til lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==endreVikar){
                endreVikar();
            } else if(e.getSource()==slettVikar){
                slettVikar();
            }
        }
    }//end Knappelytter
    
    public void endreKundeTilVikariater(String personNr){
        Vikariat loper = v.getVikariatRegister().forste;
        if(loper==null){
            return;
        } else {
            while(loper!=null){
                if(loper.getVikar().getPersonNrS().equals(personNr)){
                    loper.setVikarer(vikar, false);
                } else 
                    loper = loper.neste;
            }
        }//end else
    }//end endreKundeTilVikariater
}//end EndreVikar
