/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.ArrayList;

public interface ComponentScheduler {
    public static final JLabel LABEL_INPUT = new JLabel("INPUT");
    public static final PanelFCFSTableInput PANEL_FCFS_TABLE_INPUT = new PanelFCFSTableInput();
    public static final PanelSJFTableInput PANEL_SJF_TABLE_INPUT = new PanelSJFTableInput();
    
    public static final JLabel LABEL_OUTPUT = new JLabel("OUTPUT");
    public static final PanelFCFSTableOutput PANEL_FCFS_TABLE_OUTPUT = new PanelFCFSTableOutput();
    
    public static final PanelGantt PANEL_GANTT_CHART = new PanelGantt();
    
    public static final JButton BUTTON_GOBACK = new JButton("BACK");
    public static final JButton BUTTON_ADD = new JButton("ADD PROCESS");
    public static final JButton BUTTON_CLEAR = new JButton("CLEAR PROCESS");
    public static final JButton BUTTON_SIMULATE = new JButton("SIMULATE");
    
}
