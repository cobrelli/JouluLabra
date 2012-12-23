/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ToiminnanKuuntelijat;

import GUI.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author vito
 */
public class luoKauppa  implements ActionListener {

    JFrame frame;
    GUI gui;
    
    public luoKauppa(JFrame frame, GUI gui){
        this.frame = frame;
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        frame.invalidate();
        gui.luoKauppa(frame.getContentPane());
        frame.validate();
    }
}
