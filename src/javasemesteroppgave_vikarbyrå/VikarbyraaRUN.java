/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes


import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//klassen inneholder mainmetoden og starter programmet
public class VikarbyraaRUN {

    //Kjører i gang programmet
    public static void main(String[] args) {
        final Logginn logginn = new Logginn();
        
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
    }
}//end VikarbyraaRUN