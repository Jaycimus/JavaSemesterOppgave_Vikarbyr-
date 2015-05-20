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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Klassen bygger opp vinduet når knappen "Registrer Arbeidsfohold" er trykket
public class EndreArbeidsforhold extends JPanel {
    private JLabel lbl_kunder, lbl_vikariater, lbl_vikar, lbl_arbeidsforhold, lbl_arbeidsforholdNr;
    private JTextArea ta_arbeidsforhold;
    private JComboBox<String> cb_kunder, cb_vikariater, cb_vikarer, cb_arbeidsforholdNr;
    private String[] kundeNavn, vikariatNr, vikarer, arbeidsforholdNr;
    private JButton endreArbeidsforhold, slettArbeidsforhold;
        
    private Vikarbyraa v;
    private JTextArea utskrift;
    private Arbeidsforhold arbeidsforhold;
    
    //Konstruktøren
    public EndreArbeidsforhold(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(11,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        endreArbeidsforhold = new JButton("Endre forhold");
        endreArbeidsforhold.addActionListener(lytter);
        slettArbeidsforhold = new JButton("Slett forhold");
        slettArbeidsforhold.addActionListener(lytter);
        
        lbl_kunder = new JLabel("Kunder:");
        lbl_vikariater = new JLabel("Vikariater:");
        lbl_vikar = new JLabel("Vikar id:");
        lbl_arbeidsforhold = new JLabel("Arbeidsforhold:");
        lbl_arbeidsforholdNr = new JLabel("Arbeisforhold Nr:");
                
        kundeNavn = v.getKundeRegister().getKundeNavn();
        cb_kunder = new JComboBox<String>(kundeNavn);
        cb_kunder.setMaximumRowCount(9);
        //Setter inn kunder som er registrert fra før i ComboBox'en
        cb_kunder.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String kundeNavn = (String)cb_kunder.getSelectedItem();
                        if(kundeNavn.matches("---Kunder---")){
                            System.out.println("Ingen kunde valgt");
                            resetInput();
                        } else{
                            cb_vikariater.removeAllItems();
                            vikariatNr = v.getVikariatRegister().getVikariaterTilKunde((String) cb_kunder.getSelectedItem());
                            cb_vikariater.addItem("---Vikariater---");
                            cb_vikariater.setEnabled(true);
                            for(int i = 0; i < vikariatNr.length; i++){
                                cb_vikariater.addItem(vikariatNr[i]);
                            }
                        }
                    }
                }
            }
        );
        vikariatNr = new String[0];
        cb_vikariater = new JComboBox<String>(vikariatNr);
        cb_vikariater.addItem("---Vikariater---");
        cb_vikariater.setMaximumRowCount(9);
        cb_vikariater.setEnabled(false);
        //Setter inn vikariatnr. som er registrert fra før av i ComboBox'en
        cb_vikariater.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange()==ItemEvent.SELECTED){
                        String vikariatNr = (String)cb_vikariater.getSelectedItem();
                        if(vikariatNr.matches("---Vikariater---")){
                            System.out.println("Ingen vikariat valgt");
                            cb_vikarer.setSelectedIndex(0);
                            cb_vikarer.setEnabled(false);
                            cb_arbeidsforholdNr.setSelectedIndex(0);
                            cb_arbeidsforholdNr.setEnabled(false);
                            ta_arbeidsforhold.setText("");
                            ta_arbeidsforhold.setEnabled(false);    
                            return;
                        }
                        
                        cb_vikarer.removeAllItems();
                        ta_arbeidsforhold.setText("");
                        String vikariat = (String) cb_vikariater.getSelectedItem();
                        vikarer = v.getVikarRegister().getVikarerTilVikariat(Integer.parseInt(vikariat));
                        cb_vikarer.addItem("---Vikarer---");
                        for(int i = 0; i < vikarer.length; i++){
                            cb_vikarer.addItem(vikarer[i]);
                        }
                        cb_vikarer.setEnabled(true);
                        
                    }//end getStateChanged
                }//end itemStateChanged
            }
        );//end itemlistener
        
        vikarer = new String[0];
        cb_vikarer = new JComboBox<String>(vikarer);
        cb_vikarer.addItem("---Vikarer---");
        cb_vikarer.setMaximumRowCount(9);
        cb_vikarer.setEnabled(false);
        cb_vikarer.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String vikarNr = (String)cb_vikarer.getSelectedItem();
                        if(vikarNr.matches("---Vikarer---")){
                            System.out.println("Ingen vikar valgt");
                            cb_arbeidsforholdNr.setSelectedIndex(0);
                            cb_arbeidsforholdNr.setEnabled(false);
                            ta_arbeidsforhold.setText("");
                            ta_arbeidsforhold.setEnabled(false);  
                            return;
                        } else {
                            cb_arbeidsforholdNr.setEnabled(true);
                            String vikariat = (String) cb_vikariater.getSelectedItem();
                            ArrayList<Arbeidsforhold> arbeidsforholdTilVikariat = v.getVikariatRegister().finnVikariat(Integer.parseInt(vikariat)).getArbeidsforhold();
                            for(int i = 0; i < arbeidsforholdTilVikariat.size(); i++){
                                if(arbeidsforholdTilVikariat.get(i).getVikar().getVikarNr() == Integer.parseInt((String)cb_vikarer.getSelectedItem())){
                                    cb_arbeidsforholdNr.addItem(arbeidsforholdTilVikariat.get(i).getArbeidsforholdNrS());
                                }
                            }//end for loop
                        }
                    }
                }
            }
        );
        
        arbeidsforholdNr = new String[0];
        cb_arbeidsforholdNr = new JComboBox<String>(arbeidsforholdNr);
        cb_arbeidsforholdNr.addItem("---Arbeidsforhold---");
        cb_arbeidsforholdNr.setEnabled(false);
        cb_arbeidsforholdNr.addItemListener(
            new ItemListener(){
                public void itemStateChanged(ItemEvent event){
                    if(event.getStateChange() == ItemEvent.SELECTED){
                        String arbeidsforholdNr = (String)cb_arbeidsforholdNr.getSelectedItem();
                        if(arbeidsforholdNr.matches("---Arbeidsforhold---")){
                            ta_arbeidsforhold.setText("");
                            ta_arbeidsforhold.setEnabled(false);  
                            return;
                        }
                        ta_arbeidsforhold.setEnabled(true);
                        ta_arbeidsforhold.setText(v.getArbeidsforholdRegister().finnArbeidsforhold((String)cb_arbeidsforholdNr.getSelectedItem()).getArbeidsforhold());
                    }//end getStateChanged
                }//end itemStateChanged
            }
        );//end itemlistener
                
        ta_arbeidsforhold = new JTextArea(40,15);
        ta_arbeidsforhold.setEnabled(false);
        ta_arbeidsforhold.setWrapStyleWord(true);
        ta_arbeidsforhold.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta_arbeidsforhold);
        
        add(lbl_kunder);
        add(cb_kunder);
        add(lbl_vikariater);
        add(cb_vikariater);
        add(lbl_vikar);
        add(cb_vikarer);
        add(lbl_arbeidsforholdNr);
        add(cb_arbeidsforholdNr);
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
        add(slettArbeidsforhold);
        add(endreArbeidsforhold);
    }//end konstruktør
    
    //Metoden tar i mot info fra felt og mater dem inn i registrering av arbeidsforhold
    private void endreArbeidsforhold(){
        /*Vikariat vikariat = v.getVikariatRegister().finnVikariat(Integer.parseInt((String) cb_vikariater.getSelectedItem()));
        Vikar vikar = v.getVikarRegister().finnVikar((String) cb_vikarer.getSelectedItem());
        if(vikariat==null||vikar==null){
            JOptionPane.showMessageDialog(null,"Finner ikke vikariat/vikar");
            return;
        }*/
        String arbeidsforholdNr = (String) cb_arbeidsforholdNr.getSelectedItem();
        String arbeidsforholdTekst = ta_arbeidsforhold.getText();
        
        Arbeidsforhold arbeidsforhold = v.getArbeidsforholdRegister().finnArbeidsforhold(arbeidsforholdNr);
        arbeidsforhold.setArbeidsforhold(arbeidsforholdTekst);
        
        utskrift.setText(arbeidsforhold.toString());
        resetInput();
    }
    
    private void slettArbeidsforhold(){
        String ArbeidsforholdNummer = (String) cb_arbeidsforholdNr.getSelectedItem();
        
        int sikker = JOptionPane.showConfirmDialog(null, "Er du sikker på at du vil slette arbeidsforholdet?","Sletting",JOptionPane.YES_NO_OPTION);
        if(sikker == JOptionPane.YES_OPTION){
            v.getArbeidsforholdRegister().slettArbeidsforhold(ArbeidsforholdNummer);
            cb_arbeidsforholdNr.removeItem((String)cb_arbeidsforholdNr.getSelectedItem());
        }
    }
    
    //Tilbakestiller infoen til originale tilstand
    private void resetInput(){
        cb_kunder.setSelectedIndex(0);
        cb_vikariater.setEnabled(false);
        cb_vikarer.setEnabled(false);
        cb_arbeidsforholdNr.setEnabled(false);
        ta_arbeidsforhold.setText("");
        ta_arbeidsforhold.setEnabled(false);
    }

    
    //Knytter knappen "Registrer Arbeidsfohold" til lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==endreArbeidsforhold){
                endreArbeidsforhold();
            } else if(e.getSource()==slettArbeidsforhold){
                slettArbeidsforhold();
            }
        }
    }
}//end RegistrerArbeidsforhold
