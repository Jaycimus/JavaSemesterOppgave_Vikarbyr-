/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
Gruppenummer: 15*/

//Sist endret 15. Mai 2015 AV: Arthur Nordnes
package javasemesteroppgave_vikarbyrå;

import javax.swing.JOptionPane;

//Klassen validerer infoen som vi ønsker å validere
public class Validering {
    
    //Validering av navn
    public static boolean validerNavn(String navn) {
        return true;//navn.matches( "[a-zæøåA-ZÆØÅ]+([ '-][a-zæøåA-ZÆØÅ]+)*" );
    }

    //Validering av adresse
    public static boolean validerAdresse(String adresse) {
	return true;//adresse.matches( "[a-zæøåA-ZÆØÅ]+([ '-]\\d+|[ '-][a-zæøåA-ZÆØÅ]+)*" );
    }

    //Validering av e-post
    public static boolean validerEpost(String epost) {
	return true;//epost.matches(".+@.+\\.[a-z]+");
    }
    
    //Validering av telfonnummer
    public static boolean validerTLF(String tlf) {
        return true;//tlf.matches( "[1-9]\\d{7}" );
    }

    //Validering av personnummer
    public static boolean validerPersonnummer(String personnummer) {
        return true;//personnummer.matches( "[1-9]\\d{10}" );
    }
    
    //Validering av vikariat input
    public static boolean validerVikariatInput(Kunde kunde, String arbeidsted, 
            int ar2, int ar, int maned2, int maned, int dag2, int dag, int timer2, 
            int timer, int minutter2, int minutter){
        
        if(kunde.getNavn().matches("---Kunder---")){
            JOptionPane.showMessageDialog(null, "Kunde ikke valgt");
            return false;
        } else if (!validerAdresse(arbeidsted)){
            JOptionPane.showMessageDialog(null, "Feil med arbeidsted");
            return false;
        } else if(ar2 < ar){
            JOptionPane.showMessageDialog(null,"Feil med varighet - år");
            return false;
        } else if(ar2 != 0 && ar2 == ar){
            if(maned2 < maned){
                JOptionPane.showMessageDialog(null,"Feil med varighet - måned");
                return false;
            } else if(maned2 != 0 && maned2 == maned) {
                if(dag2 < dag){
                    JOptionPane.showMessageDialog(null,"Feil med varighet - dag");
                    return false;
                } 
            }
        }
        
        return true;
    }//end validerVikariatInput()
}//end Validering
