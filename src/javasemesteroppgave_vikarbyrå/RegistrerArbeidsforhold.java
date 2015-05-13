/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrerArbeidsforhold extends JPanel {
    private JLabel lbl_kunder, lbl_vikariater, lbl_vikar, lbl_arbeidsforhold;
    private JTextArea ta_arbeidsforhold;
    private JComboBox<String> cb_kunder, cb_vikariater, cb_vikarer;
    private String[] kundeNavn, vikariatNr, vikarer;
    private JButton regArbeidsforhold;
        
    private Vikarbyraa v;
    private JTextArea utskrift;
    
    public RegistrerArbeidsforhold(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        regArbeidsforhold = new JButton("Registrer forhold");
        regArbeidsforhold.addActionListener(lytter);
        
        lbl_kunder = new JLabel("Kunder: ");
        lbl_vikariater = new JLabel("Vikariater: ");
        lbl_vikar = new JLabel("Vikar id: ");
        lbl_arbeidsforhold = new JLabel("Arbeidsforhold: ");
                
        kundeNavn = v.kundeRegister.getKundeNavn();
        cb_kunder = new JComboBox<String>(kundeNavn);
        cb_kunder.setMaximumRowCount(9);
        cb_kunder.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        cb_vikariater.removeAllItems();
                        System.out.println((String) cb_kunder.getSelectedItem());
                        vikariatNr = v.vikariatRegister.getVikariaterTilKunde((String) cb_kunder.getSelectedItem());
                        for(int i = 0; i < vikariatNr.length; i++){
                            cb_vikariater.addItem(vikariatNr[i]);
                        }
                        cb_vikariater.setEnabled(true);
                    }
                }
            }
        );
        vikariatNr = new String[0];
        cb_vikariater = new JComboBox<String>(vikariatNr);
        cb_vikariater.setMaximumRowCount(9);
        cb_vikariater.setEnabled(false);
        cb_vikariater.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange()==ItemEvent.SELECTED){
                        
                    }
                }
            }
        );
        vikarer = new String[0];
        cb_vikarer = new JComboBox<String>(vikarer);
        cb_vikarer.setMaximumRowCount(9);
        cb_vikarer.setEnabled(false);
        
        ta_arbeidsforhold = new JTextArea(4,15);
        add(lbl_kunder);
        add(cb_kunder);
        add(lbl_vikariater);
        add(cb_vikariater);
        add(lbl_vikar);
        add(cb_vikarer);
        add(lbl_arbeidsforhold);
        add(ta_arbeidsforhold);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regArbeidsforhold);
    }
    
        
    public void regArbeidsforhold(){
        
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regArbeidsforhold){
                regArbeidsforhold();
            }
        }
    }
}
