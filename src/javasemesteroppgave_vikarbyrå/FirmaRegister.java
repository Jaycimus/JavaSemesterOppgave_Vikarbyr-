/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */
package javasemesteroppgave_vikarbyrå;

import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import javax.swing.*;
import java.io.*;

public class FirmaRegister implements Serializable {
    
    public Firma fforste;
   
    public void settInn(Firma ny)
    {
        if(ny == null)
        {
            return;
        }
        ny.neste= fforste;
        fforste = ny;
    }
    
    public Firma finnFirma(String firmanavn)
    {
        return null;
    }
    
    public void skrivFirmaListe(JTextArea firmaListe)
    {
        Firma loper = fforste;
        
        if(fforste == null)
        {
            firmaListe.setText("Ingen firmaer i registeret!");
        }else{
            firmaListe.setText("");
            
            while(loper!=null){
                
                firmaListe.append(loper.toFirmaString()+"\n");
            }
                
        }
            
        
    }
   
}
