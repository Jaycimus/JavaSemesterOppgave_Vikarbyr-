/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

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
    
    public static boolean validerArbeidstid(String arbeidstid){
        return arbeidstid.matches("[0-9]{2}:[0-9]{2}-[0-9]{2}:[0-9]{2}");
    }

    public static boolean validerPersonnummer(String personnummer) {
        return personnummer.matches( "[1-9]\\d{10}" );
    }
}
