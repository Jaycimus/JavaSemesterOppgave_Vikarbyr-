/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Font;

//Klassen er for å sette et spesifikt font når vi trenger det
public class Fonts {
    private Font sansserif_bold;
    
    //Setter et font i konstruktøren
    public Fonts(){
        sansserif_bold = new Font("Serif", Font.BOLD, 13);
    }
    
    //Retunerer fonten når vi kaller på den
    public Font getSerif_bold(){
       return sansserif_bold;
   }
}//end Fonts