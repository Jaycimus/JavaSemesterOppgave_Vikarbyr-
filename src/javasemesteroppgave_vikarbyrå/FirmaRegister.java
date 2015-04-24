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
    
    public Firma fforste, fsiste;
    
    public FirmaRegister(){
        fforste = null;
    }
   
    public void settInn(Firma ny){
        if(ny == null){
            return;
        }
        if(fforste == null){
            fforste = fsiste = ny;
        }
        else{
            fsiste.neste= ny;
            fsiste = ny;
        }
        
    }
    
    public Firma finnFirma(String firmanavn){
        return null;
    }
    
    public String[] getFirmaNavn(){
        String[] firmaNavn = new String[getAntallNoder()];
        Firma løper = fforste;
        for(int i = 0; i < getAntallNoder(); i++){
            firmaNavn[i] = løper.getNavn();
            løper = løper.neste;
        }
        return firmaNavn;
    }
    
    public int getAntallNoder(){
        int antall = 0;
        boolean ok = false;
        Firma løper = fforste;
        if(løper!=null){
            antall++;
            String forsteNavn = løper.getNavn();
            ok = true;
            løper = løper.neste;
            while(ok == true){
                if(løper!=null){
                    if(løper.getNavn()!=forsteNavn){
                        antall++;
                        løper = løper.neste;
                    }
                }
                else{
                    ok = false;
                }
            }
        }
        
        return antall;
    }
    public void skrivFirmaListe(JTextArea firmaListe){
        Firma loper = fforste;
        
        if(fforste == null){
            firmaListe.setText("Ingen firmaer i registeret!");
        }
        else{
            firmaListe.setText("");
            
            while(loper!=null){
                
                firmaListe.append(loper.toFirmaString()+"\n");
                
                loper = loper.neste;
            }                
        }        
    }   
}
