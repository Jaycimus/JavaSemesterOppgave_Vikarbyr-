/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VikarbyraaRUN {

    public static void main(String[] args) {
        Logginn logginn = new Logginn();
        logginn.setSize(new Dimension(400,220));
	logginn.setVisible(true);
	logginn.setLocationRelativeTo(null);
	logginn.setResizable(false);
        logginn.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
	});
        
    }
}
