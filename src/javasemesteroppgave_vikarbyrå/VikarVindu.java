/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//Klassen bygger opp vinduet når du logger inn med vikar
public class VikarVindu extends JFrame{
    
    private final JPanel meny, cards;
    private final JButton visVikariatListe,regSoking, loggUt;
    private final JTextArea utskrift;
    
    private Vikarbyraa v;
    
    
    //Konstruktør
    public VikarVindu(Vikarbyraa v){
        this.v = v;
        
        setLayout(new BorderLayout(10, 10));
        
        regSoking = new JButton("Registrer Søknad");
        loggUt = new JButton("Logg ut");
        visVikariatListe = new JButton("Vis ledige vikariater");
        
        Knappelytter lytter = new Knappelytter();
        
        regSoking.addActionListener(lytter);
        loggUt.addActionListener(lytter);
        visVikariatListe.addActionListener(lytter);
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,10));
        meny.setPreferredSize(new Dimension(212,200));
        meny.setBorder(new EmptyBorder(5,5,5,0));
        meny.add(visVikariatListe);
        meny.add(regSoking);
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(loggUt);
        
        utskrift = new JTextArea(0,0);
        utskrift.setEditable(false);
        utskrift.setText("Vikarbruksanvisning");
        JScrollPane sp = new JScrollPane(utskrift);
        sp.setBorder(new EmptyBorder(10,0,10,0));
        
        JPanel registrering = new JPanel();
        registrering.setLayout(null);
        registrering.setPreferredSize(new Dimension(500, 500));
        
        JPanel card1 = new RegistrerSoknad(utskrift, v);
        
        cards = new JPanel(new CardLayout());
        cards.setBorder(new EmptyBorder(5,0,5,5));
        cards.add(registrering, "Registrering");//Det første blanke feltet som bli opprettet
        cards.add(card1, "RegistrerSøknad");
        
        add(meny, BorderLayout.WEST);
        add(sp, BorderLayout.CENTER);
        add(cards, BorderLayout.EAST);
    }//end Konstruktør
    
    //Viser vikariatliste i utskfriftsområdet
    public void visVikariatListe(){
        v.getVikariatRegister().skrivVikariatListe(utskrift);
    }
    
    //Returnerer teksten som i utskriftsområdet
    private JTextArea getTextArea(){
        return utskrift;
    }
    
    //Viser registrerte og ledige vikariater for vikarer
    private void visLedigeVikariatReg(){
        v.getVikariatRegister().skrivLedigVikariatListe(utskrift);
    }
    
    //Knytter de forskjellige knappene til lyttere
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regSoking){
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "RegistrerSøknad");
                visLedigeVikariatReg();
              
            }
            else if(e.getSource()==visVikariatListe){
                visVikariatListe();
            }
            else if(e.getSource()==loggUt){
                Logginn logginn = new Logginn(v);
                logginn.setSize(new Dimension(400,180));
                logginn.setVisible(true);
                logginn.setLocationRelativeTo(null);
                logginn.setResizable(false);
                logginn.addWindowListener( new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        logginn.skrivTilFil();
                        System.exit(0);
                    }
                });
                setVisible(false);
            }
        }
    }//end Knappelytter
}//end VikarVindu
