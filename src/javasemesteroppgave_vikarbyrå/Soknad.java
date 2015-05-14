package javasemesteroppgave_vikarbyrå;

/**
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
public class Soknad {
    
    public Soknad neste;
    private String soknadTekst, navn, utdanning,jobberfaring, referanser;
    
    
    public Soknad(String soknadTekst)
    {
        this.soknadTekst=soknadTekst;
        neste = null;
    }
    
}
