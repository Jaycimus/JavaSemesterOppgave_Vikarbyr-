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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class RegistrerVikarTilVikariat extends JPanel {
    private JLabel lbl_kunder, lbl_vikaiater, lbl_vikar, lbl_kunder2, lbl_vikaiater2, lbl_vikar2;
    private JComboBox<String> cb_kunder, cb_vikariater, cb_vikarer, cb_kunder2, cb_vikariater2, cb_vikarer2;
    private String[] kunder, vikariatNr, vikarer, vikariatNr2, vikarer2;
    private JButton tildelVikariat, fjernVikar;
    private JPanel overst, nederst;
    private Vikarbyraa v;
    private JTextArea utskrift;
    private TitledBorder borderTildelVikariat, borderFjerningVikariat;
    
    public RegistrerVikarTilVikariat(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,1,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        borderTildelVikariat = BorderFactory.createTitledBorder(null,"Tildel Vikar Til Vikariat");
        borderTildelVikariat.setTitleJustification(TitledBorder.CENTER);
        borderFjerningVikariat = BorderFactory.createTitledBorder(null,"Fjern Vikar Fra Vikariat");
        borderFjerningVikariat.setTitleJustification(TitledBorder.CENTER);
        
        Knappelytter lytter = new Knappelytter();
        tildelVikariat = new JButton("Tildel");
        tildelVikariat.addActionListener(lytter);
        fjernVikar = new JButton("Fjern Vikar");
        fjernVikar.addActionListener(lytter);
        
        lbl_kunder = new JLabel("Kunder:");
        lbl_vikaiater = new JLabel("Ledige Vikariater:");
        lbl_vikar = new JLabel("Ledige Vikarer:");    
        lbl_kunder2 = new JLabel("Kunder:");
        lbl_vikaiater2 = new JLabel("Opptatte Vikariater:");
        lbl_vikar2 = new JLabel("Vikaren på vikariatet:");    
        
        kunder = v.getKundeRegister().getKundeNavn();
        vikariatNr = v.getVikariatRegister().getLedigeVikariater();
        vikarer = v.getVikarRegister().getVikarer();
        cb_kunder = new JComboBox<>(kunder);
        cb_kunder.setMaximumRowCount(9);
        cb_kunder.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String valg = (String) cb_kunder.getSelectedItem();
                        if(valg.matches("---Kunder---")){
                            cb_vikariater.setSelectedIndex(0);
                            cb_vikariater.setEnabled(false);
                            return;
                        } else {
                            v.getVikariatRegister().skrivLedigVikariatListeTilKunde(utskrift, valg);
                            cb_vikariater.removeAllItems();
                            String[] vikariater = v.getVikariatRegister().getLedigeVikariaterTilKunde(valg);
                            for(int i=0; i < vikariater.length;i++){
                                cb_vikariater.addItem(vikariater[i]);
                            }
                            cb_vikariater.setEnabled(true);
                        }
                    }
                }
            }
        );
        cb_vikariater = new JComboBox<>(vikariatNr);
        cb_vikariater.setMaximumRowCount(9);
        cb_vikariater.setEnabled(false);
        cb_vikariater.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String valg = (String) cb_vikariater.getSelectedItem();
                        if(valg.matches("---Vikariater---")){
                            cb_vikarer.setSelectedIndex(0);
                            cb_vikarer.setEnabled(false);
                            return;
                        } else {
                            v.getSoknadsRegister().skrivSoknadTilVikariatListe(utskrift, valg);
                            cb_vikarer.setEnabled(true);
                        }
                    }
                }
            }
        );
        cb_vikarer = new JComboBox<>(vikarer);
        cb_vikarer.setMaximumRowCount(9);
        cb_vikarer.setEnabled(false);
        
        vikariatNr2 = new String[0];
        vikarer2 = new String[0];
        cb_kunder2 = new JComboBox<>(kunder);
        cb_kunder2.setMaximumRowCount(9);
        cb_kunder2.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String valg = (String) cb_kunder2.getSelectedItem();
                        if(valg.matches("---Kunder---")){
                            cb_vikariater2.setSelectedIndex(0);
                            cb_vikariater2.setEnabled(false);
                            return;
                        } else {
                            v.getVikariatRegister().skrivLedigVikariatListeTilKunde(utskrift, valg);
                            cb_vikariater2.removeAllItems();
                            String[] vikariater = v.getVikariatRegister().getOpptatteVikariaterTilKunde(valg);
                            for(int i=0; i < vikariater.length;i++){
                                cb_vikariater2.addItem(vikariater[i]);
                            }
                            cb_vikariater2.setEnabled(true);
                        }
                    }
                }
            }
        );
        cb_vikariater2 = new JComboBox<>(vikariatNr2);
        cb_vikariater2.setMaximumRowCount(9);
        cb_vikariater2.setEnabled(false);
        cb_vikariater2.addItem("---Vikariater---");
        cb_vikariater2.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String valg = (String) cb_vikariater2.getSelectedItem();
                        if(valg.matches("---Vikariater---")){
                            cb_vikarer2.setSelectedIndex(0);
                            cb_vikarer2.setEnabled(false);
                            return;
                        } else {
                            Vikar vikar = v.getVikarRegister().getVikarTilVikariat(Integer.parseInt((String) cb_vikariater2.getSelectedItem()));
                            if(vikar==null){
                                System.out.println("Fant ikke vikar til vikariat - RegistrerVikarTilVikariat");
                                return;
                            } else{
                                cb_vikarer2.addItem(vikar.getVikarNrS());
                                cb_vikarer2.setEnabled(true);
                            }
                        }
                    }
                }
            }
        );
        cb_vikarer2 = new JComboBox<>(vikarer2);
        cb_vikarer2.setMaximumRowCount(9);
        cb_vikarer2.setEnabled(false);
        cb_vikarer2.addItem("---Vikarer---");
        
        overst = new JPanel(new GridLayout(0,2,20,25));
        overst.setBorder(borderTildelVikariat);
        overst.add(lbl_kunder);
        overst.add(cb_kunder);
        overst.add(lbl_vikaiater);
        overst.add(cb_vikariater);
        overst.add(lbl_vikar);
        overst.add(cb_vikarer);
        overst.add(new JPanel());
        overst.add(new JPanel());
        overst.add(new JPanel());
        overst.add(tildelVikariat);
        
        nederst = new JPanel(new GridLayout(0,2,20,25));
        nederst.setBorder(borderFjerningVikariat);
        nederst.add(lbl_kunder2);
        nederst.add(cb_kunder2);
        nederst.add(lbl_vikaiater2);
        nederst.add(cb_vikariater2);
        nederst.add(lbl_vikar2);
        nederst.add(cb_vikarer2);
        nederst.add(new JPanel());
        nederst.add(new JPanel());
        nederst.add(new JPanel());
        nederst.add(fjernVikar);
        
        add(overst);
        add(nederst);
    }//end konstruktør
    
    public void regVikarTilVikariat(){
        String kunde = (String)cb_kunder.getSelectedItem();
        String vikariatNummer = (String)cb_vikariater.getSelectedItem();
        String vikar = (String)cb_vikarer.getSelectedItem();
        if (kunde.matches("---Kunder---")){
            JOptionPane.showMessageDialog(null,"Kunde ikke valgt!");
            return;
        } else if(vikariatNummer.matches("---Vikariater---")){
            JOptionPane.showMessageDialog(null,"Vikariat ikke valgt!");
            return;
        } else if ( vikar.matches("---Vikarer---")){
            JOptionPane.showMessageDialog(null,"Vikar ikke valgt!");
            return;
        } else {
            int sikker = JOptionPane.showConfirmDialog(null, 
                    "Er du sikker på at du vil tildele vikar: " + vikar + "\nVikariatet: " +
                    vikariatNummer + "\nSom tilhører kunden: " + kunde,"Tildel Vikariat Til Vikar",JOptionPane.YES_NO_OPTION);
            
            if(sikker == JOptionPane.YES_OPTION){
                if(v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNummer))!=null){
                    System.out.println("Vikariat funnet");
                    if(v.getVikarRegister().finnVikar(vikar)!=null){
                        System.out.println("Vikar funnet");
                        v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNummer)).setVikarer(v.getVikarRegister().finnVikar(vikar), false);
                        v.getVikarRegister().finnVikar(vikar).setVikariater(v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNummer)));
                        resetInput();
                    }
                }
            }
        }
    }
    
    private void fjernVikar(){
        String vikariatNr = (String)cb_vikariater2.getSelectedItem();
        String vikar = (String)cb_vikarer2.getSelectedItem();
        
        if(vikariatNr.matches("---Vikariater---")){
            JOptionPane.showMessageDialog(null,"Vikariat ikke valgt!");
            return;
        } else if ( vikar.matches("---Vikarer---")){
            JOptionPane.showMessageDialog(null,"Vikar ikke valgt!");
            return;
        } else {
            v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNr)).setVikarer(null, true);
            v.getVikarRegister().finnVikar(vikar).slettVikariat(Integer.parseInt(vikariatNr));
            cb_vikarer2.removeItem((String)cb_vikarer2.getSelectedItem());
            resetInput2();
        }
    }
    
    private void resetInput(){
        cb_kunder.setSelectedIndex(0);
        cb_vikariater.setSelectedIndex(0);
        cb_vikarer.setSelectedIndex(0);
    }
    
    private void resetInput2(){
        cb_kunder2.setSelectedIndex(0);
        cb_vikariater2.setSelectedIndex(0);
        cb_vikarer2.setSelectedIndex(0);
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==tildelVikariat){
                regVikarTilVikariat();
            } 
            else if(e.getSource()==fjernVikar){
                fjernVikar();
            }
        }
    }
}
