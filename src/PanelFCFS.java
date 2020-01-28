/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raito
 */

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
public class PanelFCFS extends JPanel implements ComponentMain {
    PanelFCFS(){
        GridBagConstraints gbc = new GridBagConstraints();
        super.setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(5,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        super.add(BUTTON_FCFS, gbc);
        
    }
}
