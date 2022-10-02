package com.oodj_assignment.helper.UI;

import java.awt.Color;
import javax.swing.JButton;

/**
 * UI Helper class for changing the appearance of clicked Jbutton.
 */
public class JButtonActivator {
    
    JButton [] btns; 
    
    public JButtonActivator(JButton [] btns) {
        this.btns = btns;
    }
    
    public void activateBtn(JButton activeBtn) {
        for (JButton btn : btns) {
            btn.setBackground(Color.white);
            btn.setForeground(Color.black);
        }
        activeBtn.setBackground(new Color(0, 102, 255));
        activeBtn.setForeground(Color.white);
    }
    
}
