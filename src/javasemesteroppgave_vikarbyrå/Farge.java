/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import java.awt.Color;

//Klassen er for når vi vil kalle på en spesifik farge et sted
public class Farge {
    private Color bakgrunn;
    

//Setter opp en farge i konstruktøren
    public Farge(){
        bakgrunn = Color.decode("#d5ebf2");
    }
    
    //Returnerer fargen når vi kaller på den
    public Color getBakrunn(){
        return bakgrunn;
    }
}//end Farge
