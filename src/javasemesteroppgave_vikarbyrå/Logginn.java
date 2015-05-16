/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

//importerer nødvendige klasser fra Javas klassebiblotek
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Klassen bygger opp innloggings vinduet for ansatte og vikarer
public class Logginn extends JFrame{
    private final JTextField brukernavn;
    private final JPasswordField passord;
    private final JButton loggInn;
    private final JLabel bN, p, status;
        
    private Font knapper, tekstfelt;
    
    private Vikarbyraa v;
    private Fonts f;
    
    //Konstruktør
    public Logginn(){
        super("Logg Inn");
        setLayout(new FlowLayout());
        knapper = new Font("Arial", Font.BOLD, 20);
        tekstfelt = new Font("Bitstream Vera Sans Mono", Font.PLAIN, 20);
        f = new Fonts();
        v = new Vikarbyraa();
        
        //oppretter tekstfelt for brukernavn og regisrerer museklikk lytter
        brukernavn = new JTextField("Andreas",15);
        brukernavn.setFont(tekstfelt);
        brukernavn.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                brukernavn.setText("");
            }
	});
                        
        //oppretter tekstfelt for passord og regisrerer museklikk lytter
        passord = new JPasswordField("andreas",15);
        passord.setFont(tekstfelt);
	passord.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                passord.setText("");
            }
	});
        
        bN = new JLabel("Brukernavn: ");
        bN.setFont(tekstfelt);
        p = new JLabel("Passord:     ");
        p.setFont(tekstfelt);
        
        //oppretter logg inn knapp & status linje
        loggInn = new JButton("Logg inn");
        loggInn.setFont(knapper);
        status = new JLabel("Skriv inn brukernavn/passord");
        status.setFont(knapper);
        
        //legger til resterende elementer til ramme
        add(bN);
	add(brukernavn);
        add(p);
        add(passord);
        add(loggInn);
        add(status);
	
        //Metode som sjekker om riktig pass og brukernavn kombinasjon er skrevet
	loggInn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //henter og lagrer det innskrivende brukernavnet og passord
                String bruker = brukernavn.getText();
                String pass = passord.getText();
                    
                //tester om brukernavn og passord kombanasjonen funker
                for(int i = 0; i < v.navneListe1.size(); i++) {
                    if(bruker.equalsIgnoreCase(v.navneListe1.get(i)) && pass.equals(v.passordListe1.get(i))) {
                        setVisible(false);
                        JFrame ansattVindu = new JFrame("Vikarbyrå");
                        AnsattVindu vindu = new AnsattVindu(v, ansattVindu);
                        ansattVindu.add(vindu);
                        ansattVindu.setSize(new Dimension(1200,700));
                        ansattVindu.setVisible(true);
                        ansattVindu.setLocationRelativeTo(null);
                        ansattVindu.setResizable(false);
                        ansattVindu.addWindowListener( new WindowAdapter(){
                            public void windowClosing(WindowEvent e){
                                skrivTilFil();
                                System.exit(0);
                            }
                        });
                        return;
                    } 
                }
                for(int i = 0; i < v.navneListe2.size(); i++){
                    if (bruker.equalsIgnoreCase(v.navneListe2.get(i)) && pass.equals(v.passordListe2.get(i))){
                        setVisible(false);
                        JFrame vikarVindu = new JFrame("Vikarbyrå");
                        VikarVindu vindu = new VikarVindu(v, vikarVindu);
                        vikarVindu.add(vindu);
                        vikarVindu.setSize(new Dimension(1200,700));
                        vikarVindu.setVisible(true);
                        vikarVindu.setLocationRelativeTo(null);
                        vikarVindu.setResizable(false);
                        vikarVindu.addWindowListener( new WindowAdapter(){
                            public void windowsClosing(WindowEvent e){
                                skrivTilFil();
                                System.exit(0);
                                }
                            });
                        return;
                    }
                    else {
                        status.setText("       Feil brukernavn/passord       ");
                        
                        //fjerner all tekst i tekstfeltene
                        brukernavn.setText("");
                        passord.setText("");
                    }
                }
            }
        });
        
        lesFil();
    }
    
    
    public Logginn( Vikarbyraa v ){
        super("Logg Inn");
        setLayout(new FlowLayout());
        knapper = new Font("Arial", Font.BOLD, 20);
        tekstfelt = new Font("Bitstream Vera Sans Mono", Font.PLAIN, 20);
        this.v = v;
        
        ArrayList<String> navneListe1 = new ArrayList<String>();
            navneListe1.add("Andreas"); navneListe1.add("Arthur"); navneListe1.add("Jørgen");
        ArrayList<String> passordListe1 = new ArrayList<String>();
            passordListe1.add("andreas"); passordListe1.add("arthur"); passordListe1.add("jørgen");
        ArrayList<String> navneListe2 = new ArrayList<String>();
            navneListe2.add("Vikar");
        ArrayList<String> passordListe2 = new ArrayList<String>();
            passordListe2.add("vikar");
                
        //oppretter tekstfelt for brukernavn og regisrerer museklikk lytter
        brukernavn = new JTextField("Andreas",15);
        brukernavn.setFont(tekstfelt);
        brukernavn.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                brukernavn.setText("");
            }
	});
        
        //oppretter tekstfelt for passord og regisrerer museklikk lytter
        passord = new JPasswordField("andreas",15);
        passord.setFont(tekstfelt);
	passord.addMouseListener( new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                passord.setText("");
            }
	});
        
        bN = new JLabel("Brukernavn: ");
        bN.setFont(tekstfelt);
        p = new JLabel("Passord:     ");
        p.setFont(tekstfelt);
        
        //oppretter logg inn knapp & status linje
        loggInn = new JButton("Logg inn");
        loggInn.setFont(knapper);
        status = new JLabel("Skriv inn brukernavn/passord");
        status.setFont(knapper);
        
        //legger til resterende elemter til ramme
        add(bN);
	add(brukernavn);
        add(p);
        add(passord);
        add(loggInn);
        add(status);
	
        //Metode som sjekker om riktig pass og brukernavn kombinasjon er skrevet
	loggInn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //henter og lagrer det innskrivende brukernavnet og passord
                String bruker = brukernavn.getText();
                String pass = passord.getText();
                    
                //tester om brukernavn og passord kombanasjonen funker
                for(int i = 0; i < navneListe1.size(); i++) {
                    if(bruker.equalsIgnoreCase(navneListe1.get(i)) && pass.equals(passordListe1.get(i))) {
                        setVisible(false);
                        JFrame ansattVindu = new JFrame("Vikarbyrå");
                        AnsattVindu vindu = new AnsattVindu(v, ansattVindu);
                        ansattVindu.add(vindu);
                        ansattVindu.setSize(new Dimension(1200,700));
                        ansattVindu.setVisible(true);
                        ansattVindu.setLocationRelativeTo(null);
                        ansattVindu.setResizable(false);
                        ansattVindu.addWindowListener( new WindowAdapter(){
                            public void windowClosing(WindowEvent e){
                                skrivTilFil();
                                System.exit(0);
                            }
                        });
                        return;
                    } 
                }
                for(int i = 0; i < navneListe2.size(); i++){
                    if (bruker.equalsIgnoreCase(navneListe2.get(i)) && pass.equals(passordListe2.get(i))){
                        setVisible(false);
                        JFrame vikarVindu = new JFrame("Vikarbyrå");
                        VikarVindu vindu = new VikarVindu(v, vikarVindu);
                        vikarVindu.add(vindu);
                        vikarVindu.setSize(new Dimension(1200,700));
                        vikarVindu.setVisible(true);
                        vikarVindu.setLocationRelativeTo(null);
                        vikarVindu.setResizable(false);
                        vikarVindu.addWindowListener( new WindowAdapter(){
                            public void windowsClosing(WindowEvent e){
                                skrivTilFil();
                                System.exit(0);
                                }
                            });
                        return;
                    }
                    else {
                        status.setText("       Feil brukernavn/passord       ");
                        
                        //fjerner all tekst i tekstfeltene
                        brukernavn.setText("");
                        passord.setText("");
                    }
                }
            }
        });
    }
    
    //Metode for lesing ifra fil
    public void lesFil(){
        try (ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "register.dta" ))) {
            v = (Vikarbyraa) innfil.readObject();
	}
	catch(ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
            JOptionPane.showMessageDialog(null,"Oppretter et nytt Vikarbyraaobjekt");
            v = new Vikarbyraa();
	}
	catch(FileNotFoundException fne) {
            JOptionPane.showMessageDialog(null,"Finner ikke datafil. Oppretter et tomt objekt");
            v = new Vikarbyraa();
	}
	catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,"ERROR: Feil under lesing av fil, oppretter et tomt objekt");
            v = new Vikarbyraa();
	}
    }
    
    //Metode for skriving til fil
    public void skrivTilFil(){
        try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("register.dta"))) {
            utfil.writeObject(v);

	} catch(NotSerializableException nse) {
            System.out.println("Objekter er ikke serialisert!\n" + nse.toString());
	} catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,"ERROR: Feil under skriving av fil");
	}
    }
}//end Logginn


