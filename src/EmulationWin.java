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
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EmulationWin extends JFrame implements ComponentMain, ComponentScheduler, ActionListener {
    public static Integer mOperation = -1;

    private static Boolean bHasOperation = false;
    
    EmulationWin(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("CPU Scheduler Emulation");
        super.setLayout(new GridBagLayout());
        
        InitializeComponents();
        BUTTON_GOBACK.addActionListener(this);
        
        super.setResizable(false);
        super.pack();
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    private void InitializeComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        //bottom, left, right, top
        gbc.insets = new Insets(10 , 10, 10, 10);
        
        if(!bHasOperation){
            NoOperation();
        } else {
            HasOperation();
        }
        LoadListeners(true);
    }
    
    private void RemoveComponents(){
        if(bHasOperation){
            super.remove(LABEL_ALGO);
            super.remove(BUTTON_FCFS);
            super.remove(BUTTON_SJF);
            super.remove(BUTTON_SRTF);
            super.remove(BUTTON_RROBIN);
            super.remove(BUTTON_PRIORITY);
        }
        LoadListeners(false);
    }
    
    public void RefreshComponents(){
        RemoveComponents();
        InitializeComponents();
    }
    
    private void HasOperation(){
        
    }
    
    private void NoOperation(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        //bottom, left, right, top
        gbc.insets = new Insets(10 , 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        super.add(LABEL_ALGO, gbc);
        
        gbc.gridy = 1;
        super.add(BUTTON_FCFS, gbc);

        gbc.gridy = 2;
        super.add(BUTTON_SJF, gbc);
        
        gbc.gridy = 3;
        super.add(BUTTON_SRTF, gbc);
        
        gbc.gridy = 4;
        super.add(BUTTON_RROBIN, gbc);
        
        gbc.gridy = 5;
        super.add(BUTTON_PRIORITY, gbc);
    }
    
    private void LoadListeners(boolean b){
        if(b){
            BUTTON_FCFS.addActionListener(this);
        } else {
            BUTTON_FCFS.removeActionListener(this);
        }
    }
    
    private void InitializeScheduler(){
        bHasOperation = !bHasOperation;
        RefreshComponents();
        PANEL_SCHEDULER.InitializeComponents();
        super.add(PANEL_SCHEDULER);
    }
    
    private void DeinitializeScheduler(){
        bHasOperation = !bHasOperation;
        PANEL_SCHEDULER.DeinitializeComponents();
        mOperation = -1;
        super.remove(PANEL_SCHEDULER);
        RefreshComponents();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BUTTON_FCFS){
            mOperation = 0;
            InitializeScheduler();
        }
        else if(e.getSource() == BUTTON_GOBACK){
            DeinitializeScheduler();
        }
        super.pack();
    }
        
    public static void main(String[] args) {
        new EmulationWin();
    }
}
