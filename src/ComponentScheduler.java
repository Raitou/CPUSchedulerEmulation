/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.ArrayList;

public interface ComponentScheduler {
    public static final JLabel LABEL_INPUT = new JLabel("INPUT");
    public static final PanelFCFSTableInput PANEL_FCFS_TABLE_INPUT = new PanelFCFSTableInput();
    
    public static final JLabel LABEL_OUTPUT = new JLabel("OUTPUT");
    public static final JTable TABLE_OUTPUT = new JTable();
    public static final ArrayList<JLabel> GANTT = new ArrayList<JLabel>(); 
    
    public static final JButton BUTTON_GOBACK = new JButton("BACK");
}
