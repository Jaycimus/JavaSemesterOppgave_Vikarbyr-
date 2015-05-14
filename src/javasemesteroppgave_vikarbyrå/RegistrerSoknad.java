/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 14. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrerSoknad extends JPanel{
    private JLabel lbl_vikariater, lbl_vikar, lbl_soknad;
    private JTextArea ta_soknad;
    private JTextField tf_vikar;
    private JComboBox<String> cb_vikariater;
    private String[] vikariatNr;
    private JButton regSoknad;
    
    private Vikarbyraa v;
    private JTextArea utskrift;

    public RegistrerSoknad(JTextArea u, Vikarbyraa v) {
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        Knappelytter lytter = new Knappelytter();
        
        this.utskrift = u;
        this.v = v;
        
        regSoknad = new JButton("Registrer Søknad");
        regSoknad.addActionListener(lytter);
        
        lbl_vikariater = new JLabel("Vikariater: ");
        lbl_vikar = new JLabel("Vikar id: ");
        lbl_soknad = new JLabel("Søknadstekst: ");
        
        ta_soknad = new JTextArea(4,15);
        JScrollPane sp = new JScrollPane(ta_soknad);
        
        vikariatNr = v.vikariatRegister.getLedigeVikariater();
        cb_vikariater = new JComboBox<String>(vikariatNr);
        
        tf_vikar = new JTextField("",15);
                
        add(lbl_vikariater);
        add(cb_vikariater);
        add(lbl_vikar);
        add(tf_vikar);
        add(lbl_soknad);
        add(sp);
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regSoknad);
    }
    
    public void regSoknad(){
        
    }
    
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regSoknad){
                regSoknad();
            }
        }
    }
}
