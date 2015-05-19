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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Klassen bygger opp vinduet når knappen "Registrer Arbeidsfohold" er trykket
public class RegistrerArbeidsforhold extends JPanel {
    private JLabel lbl_kunder, lbl_vikariater, lbl_vikar, lbl_arbeidsforhold;
    private JTextArea ta_arbeidsforhold;
    private JComboBox<String> cb_kunder, cb_vikariater, cb_vikarer;
    private String[] kundeNavn, vikariatNr, vikarer;
    private JButton regArbeidsforhold;
        
    private Vikarbyraa v;
    private JTextArea utskrift;
    
    //Konstruktøren
    public RegistrerArbeidsforhold(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        regArbeidsforhold = new JButton("Registrer forhold");
        regArbeidsforhold.addActionListener(lytter);
        
        lbl_kunder = new JLabel("Kunder:");
        lbl_vikariater = new JLabel("Vikariater:");
        lbl_vikar = new JLabel("Vikar id:");
        lbl_arbeidsforhold = new JLabel("Arbeidsforhold:");
        
        ta_arbeidsforhold = new JTextArea(40,15);
        ta_arbeidsforhold.setWrapStyleWord(true);
        ta_arbeidsforhold.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta_arbeidsforhold);
        ta_arbeidsforhold.setEnabled(false);
                
        kundeNavn = v.getKundeRegister().getKundeNavn();
        vikariatNr = v.getVikariatRegister().getOpptatteVikariater();
        vikarer = v.getVikarRegister().getVikarer();
        cb_kunder = new JComboBox<String>(kundeNavn);
        cb_kunder.setMaximumRowCount(9);
        //Setter inn kunder som er registrert fra før i ComboBox'en
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
                            v.getVikariatRegister().skrivOpptatteVikariatListeTilKunde(utskrift, valg);
                            cb_vikariater.removeAllItems();
                            String[] vikariater = v.getVikariatRegister().getOpptatteVikariaterTilKunde(valg);
                            for(int i=0; i < vikariater.length;i++){
                                cb_vikariater.addItem(vikariater[i]);
                            }
                            cb_vikariater.setEnabled(true);
                            ta_arbeidsforhold.setEnabled(true);
                        }
                    }
                }
            }
        );
        cb_vikariater = new JComboBox<String>(vikariatNr);
        cb_vikariater.setMaximumRowCount(9);
        cb_vikariater.setEnabled(false);
        cb_vikariater.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange()==ItemEvent.SELECTED){
                        String valg = (String) cb_vikariater.getSelectedItem();
                        if(valg.matches("---Vikariater---")){
                            cb_vikarer.setSelectedIndex(0);
                            cb_vikarer.setEnabled(false);
                            return;
                        } else {
                            v.getVikarRegister().skrivVikarTilVikariatListe(utskrift, valg);
                            String[] vikar = v.getVikarRegister().getVikarerTilVikariat(Integer.parseInt(valg));
                            cb_vikarer.removeAllItems();
                            cb_vikarer.addItem(vikar[0]);
                            cb_vikarer.setEnabled(true);
                            
                        }
                    }
                }
            }
        );
        cb_vikarer = new JComboBox<String>(vikarer);
        cb_vikarer.setMaximumRowCount(9);
        cb_vikarer.setEnabled(false);
        
        
        
        add(lbl_kunder);
        add(cb_kunder);
        add(lbl_vikariater);
        add(cb_vikariater);
        add(lbl_vikar);
        add(cb_vikarer);
        add(lbl_arbeidsforhold);
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
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(new JPanel());
        add(regArbeidsforhold);
    }//end konstruktør
    
    //Metoden tar i mot info fra felt og mater dem inn i registrering av arbeidsforhold
    public void regArbeidsforhold(){
        Vikariat vikariat = v.getVikariatRegister().finnVikariat(Integer.parseInt((String) cb_vikariater.getSelectedItem()));
        Vikar vikar = v.getVikarRegister().finnVikar((String)cb_vikarer.getSelectedItem());
        if(vikar==null){
            System.out.println("kjshfdakhd");
        }
        String arbeidsforhold = ta_arbeidsforhold.getText();
        
        int arbeidsforholdNr = v.getNesteArbeidsforholdNr();
        v.setNesteArbeidsforholdNr();
        
        Arbeidsforhold af = new Arbeidsforhold(vikariat, vikar, arbeidsforhold, arbeidsforholdNr);
        v.getArbeidsforholdRegister().settInn(af);
        v.getVikarRegister().finnVikar((String) cb_vikarer.getSelectedItem()).setArbeidsforhold(af);
        System.out.println("Registrer Arbeidsforhold");
        utskrift.setText(af.toString());
        resetInput();
    }
    
    //Tilbakestiller infoen til originale tilstand
    private void resetInput(){
        cb_vikariater.setSelectedIndex(0);
        cb_vikarer.setSelectedIndex(0);
        ta_arbeidsforhold.setText("");
    }
    
    //Knytter knappen "Registrer Arbeidsfohold" til lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regArbeidsforhold){
                regArbeidsforhold();
            }
        }
    }
}//end RegistrerArbeidsforhold
