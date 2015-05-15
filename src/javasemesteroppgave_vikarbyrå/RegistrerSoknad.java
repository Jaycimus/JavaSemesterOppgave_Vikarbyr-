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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Klassen bygger opp søknadsregistrering i vikar sin vindu
public class RegistrerSoknad extends JPanel{
    private JLabel lbl_vikariater, lbl_vikar, lbl_soknad;
    private JTextArea ta_soknad;
    private JTextField tf_vikar;
    private JComboBox<String> cb_vikariater;
    private String[] vikariatNr;
    private JButton regSoknad;
    
    private Vikarbyraa v;
    private JTextArea utskrift;

    //Konstruktør
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
        add(regSoknad);
    }//end konstruktør
    
    //Metoden tar i mot søknaden og sender den til visning av vikar i ansattvindu
    public void regSoknad(){
        Vikariat vikariat = v.vikariatRegister.finnVikariat(Integer.parseInt((String) cb_vikariater.getSelectedItem()));
        Vikar vikar = v.vikarRegister.finnVikar(Long.parseLong(tf_vikar.getText()));
        String soknadTekst = ta_soknad.getText();
        
        Soknad soknad = new Soknad(soknadTekst, vikariat, vikar);
        v.soknadsRegister.settInn(soknad);
        vikariat.setSoknad(soknad);
        vikar.setVikariat(vikariat);
        System.out.println("Registrer søknad");
        utskrift.setText("Søknad registrert:\n" + soknad.toString());
        resetInput();
    }
    
    //Fjerner teksten fra søknadsfeltet
    private void resetInput(){
        cb_vikariater.setSelectedIndex(0);
        tf_vikar.setText("");
        ta_soknad.setText("");
    }
    
    //Knytter knappen "Registrer Søknad" til enlytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regSoknad){
                regSoknad();
            }
        }
    }
}//end RegistrerSoknad
