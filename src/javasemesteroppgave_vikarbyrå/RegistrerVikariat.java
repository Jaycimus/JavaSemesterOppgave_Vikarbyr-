package javasemesteroppgave_vikarbyrå;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

    
/*
Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA
 */





public class RegistrerVikariat extends JPanel {
    private JButton regVikariat;
   // JTextField rvt_firm
  //  private JLabel lbl_
  //  private JRadioButton
    
    private JTextArea utskrift;
    
    private JComboBox<String> cb_firmaer;
    private String[] firmaer = {"Firma 1","Firma 2"};
    
    public RegistrerVikariat (JTextArea utskrift){
        setLayout(new GridLayout(0,2,20,25));
        setPreferredSize(new Dimension(500,500));
        
        this.utskrift = utskrift;
        
        //Knappelytter lytter = new Knappelytter();
        
    }

}
