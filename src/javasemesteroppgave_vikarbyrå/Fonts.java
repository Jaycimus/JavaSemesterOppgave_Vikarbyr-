/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasemesteroppgave_vikarbyrå;

import java.awt.Font;

public class Fonts {
    private Font sansserif_bold;
    
    public Fonts(){
        sansserif_bold = new Font("Serif", Font.BOLD, 13);
    }
     
   public Font getSerif_bold(){
       return sansserif_bold;
   }
}