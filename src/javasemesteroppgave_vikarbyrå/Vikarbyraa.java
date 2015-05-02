/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 2. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.io.Serializable;


public class Vikarbyraa implements Serializable {
    public FirmaRegister firmaRegister = new FirmaRegister();
    public VikariatRegister vikariatRegister = new VikariatRegister();
    public ArbeidsforholdRegister arbeidsforholdRegister = new ArbeidsforholdRegister();
    public VikarRegister vikarRegister = new VikarRegister();
    
    public Vikarbyraa(){
        
    }
}
