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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RegistrerVikarTilVikariat extends JPanel {
    private JLabel lbl_kunder, lbl_vikaiater, lbl_vikar;
    private JComboBox<String> cb_kunder, cb_vikariater, cb_vikarer;
    private String[] kunder, vikariatNr, vikarer;
    private JButton regVikarTilVikariat;
    
    private Vikarbyraa v;
    private JTextArea utskrift;
    
    public RegistrerVikarTilVikariat(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        regVikarTilVikariat = new JButton("Tildel");
        regVikarTilVikariat.addActionListener(lytter);
        
        lbl_kunder = new JLabel("Kunder:");
        lbl_vikaiater = new JLabel("Vikariater:");
        lbl_vikar = new JLabel("Vikarer:");    
        
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
                            cb_vikarer.setSelectedIndex(0);
                            cb_vikarer.setEnabled(false);
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
        
        add(lbl_kunder);
        add(cb_kunder);
        add(lbl_vikaiater);
        add(cb_vikariater);
        add(new JPanel());
        add(new JPanel());
        add(lbl_vikar);
        add(cb_vikarer);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regVikarTilVikariat);
        
    }//end konstruktør
    
    public void regVikarTilVikariat(){
        String kunde = (String)cb_kunder.getSelectedItem();
        String vikariatNr = (String)cb_vikariater.getSelectedItem();
        String vikar = (String)cb_vikarer.getSelectedItem();
        if (kunde.matches("---Kunder---")){
            JOptionPane.showMessageDialog(null,"Kunde ikke valgt!");
            return;
        } else if(vikariatNr.matches("---Vikariater---")){
            JOptionPane.showMessageDialog(null,"Vikariat ikke valgt!");
            return;
        } else if ( vikar.matches("---Vikarer---")){
            JOptionPane.showMessageDialog(null,"Vikar ikke valgt!");
            return;
        } else {
            int sikker = JOptionPane.showConfirmDialog(null, 
                    "Er du sikker på at du vil tildele vikar: " + vikar + "\nVikariatet: " +
                    vikariatNr + "\nSom tilhører kunden: " + kunde,"Tildel Vikariat Til Vikar",JOptionPane.YES_NO_OPTION);
            
            if(sikker == JOptionPane.YES_OPTION){
                if(v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNr))!=null){
                    System.out.println("Vikariat funnet");
                    if(v.getVikarRegister().finnVikar(vikar)!=null){
                        System.out.println("Vikar funnet");
                        v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNr)).setVikarer(v.getVikarRegister().finnVikar(vikar), false);
                        v.getVikarRegister().finnVikar(vikar).setVikariater(v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariatNr)));
                        resetInput();
                        refresh();
                    }
                }
            }
        }
    }
    
    private void resetInput(){
        cb_kunder.setSelectedIndex(0);
        cb_vikariater.setSelectedIndex(0);
        cb_vikarer.setSelectedIndex(0);
    }
    
    private void refresh(){
        
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regVikarTilVikariat){
                regVikarTilVikariat();
            }
        }
    }
}
