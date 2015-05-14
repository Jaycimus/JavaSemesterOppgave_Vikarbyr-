/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import javax.swing.JOptionPane;

public class Validering {
    public static boolean validerNavn(String navn) {
        return navn.matches( "[a-zæøåA-ZÆØÅ]+([ '-][a-zæøåA-ZÆØÅ]+)*" );
    }

    public static boolean validerAdresse(String adresse) {
	return adresse.matches( "[a-zæøåA-ZÆØÅ]+([ '-]\\d+|[ '-][a-zæøåA-ZÆØÅ]+)*" );
    }

    public static boolean validerEpost(String epost) {
	return epost.matches(".+@.+\\.[a-z]+");
    }
    
    public static boolean validerTLF(String tlf) {
        return tlf.matches( "[1-9]\\d{7}" );
    }

    public static boolean validerPersonnummer(String personnummer) {
        return personnummer.matches( "[1-9]\\d{10}" );
    }
    
    public static boolean validerVikariatInput(String kunde, String arbeidsted, 
            int ar2, int ar, int maned2, int maned, int dag2, int dag, int timer2, 
            int timer, int minutter2, int minutter){
        
        if(kunde.matches("---Kunder---")){
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
    }
}
