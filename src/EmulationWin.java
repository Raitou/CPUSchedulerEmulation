/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raito
 */

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class EmulationWin extends JFrame implements ComponentMain {
    private static Component panelFCFS;
    private static Component panelSJF;
    private static Component panelSRTF;
    private static Component panelRROBIN;
    private static Component panelPriority;
    
    EmulationWin(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("CPU Scheduler Emulation");
        super.setLayout(new GridBagLayout());
        
        initiateComponents();
        
        super.setResizable(false);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    private void initiateComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        //bottom, left, right, top
        gbc.insets = new Insets(10 , 10, 10, 10);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        super.add(LABEL_ALGO, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        super.add(BUTTON_FCFS, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        super.add(BUTTON_SJF, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        super.add(BUTTON_SRTF, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        super.add(BUTTON_RROBIN, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        super.add(BUTTON_PRIORITY, gbc);
    }
    
    
    public static void main(String[] args) {
        new EmulationWin();
    }
}
