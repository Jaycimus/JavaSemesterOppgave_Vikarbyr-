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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Klassen bygger opp vinduet når knappen "Registrer Kunde" blir trykket
public class RegistrerKunde extends JPanel {
    private JButton regKunde;
    private JLabel lbl_navn, lbl_adresse, lbl_tlf, lbl_epost;
    private JRadioButton privat, offentlig;
    private ButtonGroup BG_typeSektor;
    private JTextField tf_navn, tf_adresse, tf_tlf, tf_epost;
    private JTextArea utskrift;
    
    private Vikarbyraa v;
    
    //Konstruktør
    public RegistrerKunde(JTextArea utskrift, Vikarbyraa v){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.v = v;
        this.utskrift = utskrift;
        
        Knappelytter lytter = new Knappelytter();
        
        regKunde = new JButton("Lagre ny kunde");
        regKunde.addActionListener(lytter);
        
        lbl_navn = new JLabel("Kunde navn: ");
        lbl_adresse = new JLabel("Adresse: ");
        lbl_tlf = new JLabel("Telefon: ");
        lbl_epost = new JLabel("E-post: ");
        
        BG_typeSektor = new ButtonGroup();
        privat = new JRadioButton("Privat Sektor", true);
        offentlig = new JRadioButton("Offentlig Sektor", false);
        BG_typeSektor.add(privat);
        BG_typeSektor.add(offentlig);
        
        tf_navn = new JTextField("", 15);
        tf_adresse = new JTextField("", 15);
        tf_tlf = new JTextField("", 15);
        tf_epost = new JTextField("", 15);
                
        add(lbl_navn);
        add(tf_navn);
        add(lbl_adresse);
        add(tf_adresse);
        add(privat);
        add(offentlig);
        add(lbl_tlf);
        add(tf_tlf);
        add(lbl_epost);
        add(tf_epost);
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
        add(regKunde);             
    }//end konstruktør
    
    //Tar i mot info fra tekstfelt og setter det inn i Kunde-objektet
    public void regKunde(){
        String navn = tf_navn.getText();
        if(v.getKundeRegister().finnKunde(navn)!=null){
            JOptionPane.showMessageDialog(this, "Kunde med navn, " + navn + ", ekstrierer allerede!\nSkriv et annet navn.");
            return;
        }
            
        
        String adresse = tf_adresse.getText();
        int tlf;
        String epost = tf_epost.getText();
        String sektor;
            if(privat.isSelected())
                sektor = "Privat";
            else
                sektor = "Offentlig";
        
        //Validering av innlest info
        try{
            if(!Validering.validerNavn(navn)){
                JOptionPane.showMessageDialog(null, "Feil med kunde navn");
            } else if(!Validering.validerAdresse(adresse)){
                JOptionPane.showMessageDialog(null, "Feil med adresse");
            } else if(!Validering.validerTLF(tf_tlf.getText())){
                JOptionPane.showMessageDialog(null, "Feil med telefonnummer");
            } else if(!Validering.validerEpost(epost)){
                JOptionPane.showMessageDialog(null, "Feil med epost");
            } else {
                tlf = Integer.parseInt(tf_tlf.getText());
                Kunde kunde = new Kunde(navn, sektor, adresse, tlf, epost);
                v.getKundeRegister().settInn(kunde);
                System.out.println("regKunde");
                utskrift.setText(kunde.toString());
                resetInput();
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Feil med nummerformat");
        }   
    }//end regKunde()
    
    //Tilbakestiller tekstfeltene til tomme tilstand
    private void resetInput(){
        tf_navn.setText("");
        tf_adresse.setText("");
        tf_tlf.setText("");
        tf_epost.setText("");
    }
    
    //Knytter knappen "Registrer Kunde" til en lytter
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regKunde){
                regKunde();
            }
        }
    }
}//end RegistrerKunde
