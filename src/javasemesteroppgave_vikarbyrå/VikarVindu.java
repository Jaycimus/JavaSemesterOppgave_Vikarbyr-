/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
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
    
    private final JPanel meny, registrering, bunn, topp;
    private final JButton visVikariatListe,regSoking, loggUt;
    private final JTextArea utskrift;
    //private final JFrame ramme; //rammen på programmet
    private BorderLayout borderLayout;
    
    private Vikarbyraa v;
    
    private RegistrerSoknad rs;
    
    //Konstruktør
    public VikarVindu(Vikarbyraa v){
        this.v = v;
        //this.ramme = ramme;
        
        borderLayout = new BorderLayout(10, 10);
        setLayout(borderLayout);
        //setBorder(new EmptyBorder(0, 5, 0, 5));
        
        regSoking = new JButton("Registrer Søknad");
        loggUt = new JButton("Logg ut");
        visVikariatListe = new JButton("Vis ledige vikariater");
        
        meny = new JPanel();
        meny.setLayout(new GridLayout(0,1,0,10));
        meny.setPreferredSize(new Dimension(212,200));
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
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(new JPanel());
        meny.add(loggUt);
        
        utskrift = new JTextArea(0,0);
        utskrift.setEditable(false);
        utskrift.setText("Vikarbruksanvisning");
        JScrollPane sp = new JScrollPane(utskrift);
        
        registrering = new JPanel();
        registrering.setLayout(null);
        registrering.setPreferredSize(new Dimension(500,500));
        
        bunn = new JPanel();
        bunn.setLayout(null);
        bunn.setPreferredSize(new Dimension(50,0));
        
        topp = new JPanel();
        topp.setLayout(null);
        topp.setPreferredSize(new Dimension(50,0));
        
        add(topp, BorderLayout.NORTH);
        add(meny, BorderLayout.WEST);
        add(sp, BorderLayout.CENTER);
        add(registrering, BorderLayout.EAST);
        add(bunn, BorderLayout.SOUTH);
        
        Knappelytter lytter = new Knappelytter();
        
        regSoking.addActionListener(lytter);
        loggUt.addActionListener(lytter);
        visVikariatListe.addActionListener(lytter);
    
    }//end Konstruktør
    
    //Viser vikariatliste i utskfriftsområdet
    public void visVikariatListe(){
        v.vikariatRegister.skrivVikariatListe(utskrift);
    }
    
    //Returnerer teksten som i utskriftsområdet
    private JTextArea getTextArea(){
        return utskrift;
    }
    
    //Viser registrerte og ledige vikariater for vikarer
    private void visLedigeVikariatReg(){
        v.vikariatRegister.skrivLedigVikariatListe(utskrift);
    }
    
    //Knytter de forskjellige knappene til lyttere
    private class Knappelytter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==regSoking){
                registrering.setVisible(false);
                RegistrerSoknad rs = new RegistrerSoknad(VikarVindu.this.getTextArea(), v);
                VikarVindu.this.rs = rs;
                add(rs, BorderLayout.EAST);
                rs.setVisible(true);
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
                //ramme.setVisible(false);
            }
        }
    }//end Knappelytter
}//end VikarVindu
