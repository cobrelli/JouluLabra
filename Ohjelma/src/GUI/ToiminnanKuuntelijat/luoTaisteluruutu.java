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
public class luoTaisteluruutu implements ActionListener {

    JFrame frame;
    GUI gui;
    
    public luoTaisteluruutu(JFrame frame, GUI gui){
        this.frame = frame;
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        if(frame.getContentPane().getKeyListeners().length>0){
            frame.getContentPane().removeKeyListener(frame.getContentPane().getKeyListeners()[0]);
        }
        
        frame.invalidate();
        gui.luoTaisteluruutu(frame.getContentPane());
        frame.validate();
    }
}
