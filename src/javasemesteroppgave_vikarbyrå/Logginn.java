/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Logginn extends JFrame{
    private final JTextField brukernavn; //innskrivningsfelt for brukernavn
    private final JPasswordField passord; //innskrivningsfelt for passord
    private final JButton loggInn; //knapp for aa logge inn
    private final JLabel bN, p, status; //gir beskjed om feil brukernavn/passord
    private final JRadioButton kundebehandler, vikar; //knapper for forskjellige ansatte
    private final ButtonGroup typeAnsatt;  //holder radio knapper sammen
    
    private Font knapper, tekstfelt;
    
    private Vikarbyraa v;
    
    public Logginn(){
        super("Logg Inn");
        setLayout(new FlowLayout());
        knapper = new Font("Arial", Font.BOLD, 20);
        tekstfelt = new Font("Bitstream Vera Sans Mono", Font.PLAIN, 20);
        v = new Vikarbyraa();
        
        //oppretter radio knapper
        kundebehandler = new JRadioButton("Høyere Ansatt", true);
        vikar = new JRadioButton("Vikar         ", false);
        add(kundebehandler); //legger til kundebehandler knappen til ramme
        add(vikar); //legger til vikar knappen til ramme
        
        //oppretter logisk relasjon mellom radio knapper
        typeAnsatt = new ButtonGroup(); //lager knappe gruppe
        typeAnsatt.add(kundebehandler); //legger til kundebehandler knapp til gruppen
        typeAnsatt.add(vikar); //legger til vikar knapp til gruppen
        
        //Endre font
        kundebehandler.setFont(knapper);
        vikar.setFont(knapper);
        
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
                boolean godkjent = false;
                if( kundebehandler.isSelected() ){
                    //Tillate brukernavn/passord kombinasjoner
                    String[] navneListe = {"Andreas","Arthur","Jørgen"};
                    String[] passordListe = {"andreas","arthur","jørgen"};
                    
                    //henter og lagrer det innskrivende brukernavnet og passord
                    String bruker = brukernavn.getText();
                    String pass = passord.getText();
                    
                    //tester om brukernavn og passord kombanasjonen funker
                    for(int i = 0; i < navneListe.length; i++) {
                        if(bruker.equalsIgnoreCase(navneListe[i]) && pass.equals(passordListe[i])) {
                            godkjent = true;
                            setVisible(false);
                            JFrame ansattVindu = new JFrame("Rekrutering AS - Ansatt");
                            AnsattVindu vindu = new AnsattVindu(v, ansattVindu);
                            ansattVindu.add(vindu);
                            ansattVindu.setSize(new Dimension(1200,700));
                            ansattVindu.setVisible(true);
                            ansattVindu.setLocationRelativeTo(null);
                            ansattVindu.setResizable(false);
                            ansattVindu.addWindowListener( new WindowAdapter(){
                                public void windowClosing(WindowEvent e){
                                    System.exit(0);
                                }
                            });
                            
                            
                        }
                    }
                } else if ( vikar.isSelected()){
                    //Tillate passord/brukernavn kombinasjoner
                    String[] navneListe={"Vikar"};
                    String[] passordListe={"vikar"};

                    String bruker = brukernavn.getText();
                    String pass = passord.getText();
                    
                    for(int i=0; i<navneListe.length; i++) {
                        if(bruker.equalsIgnoreCase(navneListe[i]) && pass.equals(passordListe[i])) {
                            godkjent = true;
                            JFrame vikarVindu = new JFrame("Rekrutering AS - Vikar");
                            VikarVindu vindu = new VikarVindu(v, vikarVindu);
                            vikarVindu.add(vindu);
                            vikarVindu.setSize(new Dimension(700,700));
                            vikarVindu.setVisible(true);
                            vikarVindu.setLocationRelativeTo(null);
                            vikarVindu.setResizable(false);
                        
                        }
                    }
                }
                
                if( godkjent == false ){
                    status.setText("Feil brukernavn/passord");
                }
                
                //fjerner all tekst i tekstfeltene
                brukernavn.setText("");
                passord.setText("");

            }
	});
    }

    public Logginn( Vikarbyraa v ){
        super("Logg Inn");
        setLayout(new FlowLayout());
        knapper = new Font("Arial", Font.BOLD, 20);
        tekstfelt = new Font("Bitstream Vera Sans Mono", Font.PLAIN, 20);
        this.v = v;
        
        //oppretter radio knapper
        kundebehandler = new JRadioButton("Høyere Ansatt", true);
        vikar = new JRadioButton("Vikar         ", false);
        add(kundebehandler); //legger til kundebehandler knappen til ramme
        add(vikar); //legger til vikar knappen til ramme
        
        //oppretter logisk relasjon mellom radio knapper
        typeAnsatt = new ButtonGroup(); //lager knappe gruppe
        typeAnsatt.add(kundebehandler); //legger til kundebehandler knapp til gruppen
        typeAnsatt.add(vikar); //legger til vikar knapp til gruppen
        
        //Endre font
        kundebehandler.setFont(knapper);
        vikar.setFont(knapper);
        
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
                boolean godkjent = false;
                if( kundebehandler.isSelected() ){
                    //Tillate brukernavn/passord kombinasjoner
                    String[] navneListe = {"Andreas","Arthur","Jørgen"};
                    String[] passordListe = {"andreas","arthur","jørgen"};
                    
                    //henter og lagrer det innskrivende brukernavnet og passord
                    String bruker = brukernavn.getText();
                    String pass = passord.getText();
                    
                    //tester om brukernavn og passord kombanasjonen funker
                    for(int i = 0; i < navneListe.length; i++) {
                        if(bruker.equalsIgnoreCase(navneListe[i]) && pass.equals(passordListe[i])) {
                            godkjent = true;
                            JFrame ansattVindu = new JFrame("Rekrutering AS - Ansatt");
                                                                                                                
                            AnsattVindu vindu = new AnsattVindu(v, ansattVindu);
                            ansattVindu.add(vindu);
                            ansattVindu.setSize(new Dimension(1200,700));
                            ansattVindu.setVisible(true);
                            ansattVindu.setLocationRelativeTo(null);
                            ansattVindu.setResizable(false);
                            ansattVindu.addWindowListener( new WindowAdapter(){
                                public void windowClosing(WindowEvent e){
                                    System.exit(0);
                                }
                            });
                        }
                    }
                } else if ( vikar.isSelected()){
                    //Tillate passord/brukernavn kombinasjoner
                    String[] navneListe={"Vikar"};
                    String[] passordListe={"vikar"};

                    String bruker = brukernavn.getText();
                    String pass = passord.getText();
                    
                    for(int i=0; i<navneListe.length; i++) {
                        if(bruker.equalsIgnoreCase(navneListe[i]) && pass.equals(passordListe[i])) {
                            godkjent = true;
                            JFrame vikarVindu = new JFrame("Rekrutering AS - Vikar");
                            VikarVindu vindu = new VikarVindu(v, vikarVindu);
                            vikarVindu.add(vindu);
                            vikarVindu.setSize(new Dimension(700,700));
                            vikarVindu.setVisible(true);
                            vikarVindu.setLocationRelativeTo(null);
                            vikarVindu.setResizable(false);
                        
                        }
                    }
                }
                
                if( godkjent == false ){
                    status.setText("Feil brukernavn/passord");
                }
                
                //fjerner all tekst i tekstfeltene
                brukernavn.setText("");
                passord.setText("");

            }
	});
    }
}


