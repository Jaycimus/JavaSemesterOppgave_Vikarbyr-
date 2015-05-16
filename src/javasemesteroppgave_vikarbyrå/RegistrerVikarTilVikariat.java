/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

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
        
        kunder = v.kundeRegister.getKundeNavn();
        vikariatNr = v.vikariatRegister.getLedigeVikariater();
        vikarer = v.vikarRegister.getVikarer();
        cb_kunder = new JComboBox<String>(kunder);
        cb_kunder.setMaximumRowCount(9);
        cb_kunder.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        
                    }
                }
            }
        );
        cb_vikariater = new JComboBox<String>(vikariatNr);
        cb_vikariater.setMaximumRowCount(9);
        cb_vikariater.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        
                    }
                }
            }
        );
        cb_vikarer = new JComboBox<String>(vikarer);
        cb_vikarer.setMaximumRowCount(9);
        cb_vikarer.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        
                    }
                }
            }
        );
        
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
                if(v.vikariatRegister.finnVikariat(Integer.parseInt(vikariatNr))!=null){
                    System.out.println("Vikariat funnet");
                    if(v.vikarRegister.finnVikar(Long.parseLong(vikar))!=null){
                        System.out.println("Vikar funnet");
                        v.vikariatRegister.finnVikariat(Integer.parseInt(vikariatNr)).setVikarer(v.vikarRegister.finnVikar(Long.parseLong(vikar)));
                        v.vikarRegister.finnVikar(Long.parseLong(vikar)).setVikariat(v.vikariatRegister.finnVikariat(Integer.parseInt(vikariatNr)));
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
