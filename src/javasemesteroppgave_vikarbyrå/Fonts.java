/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Font;
import java.io.Serializable;

//Klassen er for å sette et spesifikt font når vi trenger det
public class Fonts implements Serializable {
    private Font bitstreamVeraSansMono;
    private Font arial;
    
    //Setter et font i konstruktøren
    public Fonts(){
        bitstreamVeraSansMono = new Font("Bitstream Vera Sans Mono", Font.PLAIN, 20);
        arial = new Font("Arial", Font.BOLD, 20);
    }
    
    //Retunerer fonten når vi kaller på den
    public Font getArial(){
       return arial;
    }
    
    public Font getBitstreamVeraSansMono(){
       return bitstreamVeraSansMono;
    }
}//end Fonts