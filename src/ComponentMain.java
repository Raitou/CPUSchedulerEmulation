


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raito
 */

import javax.swing.JButton;
import javax.swing.JLabel;

public interface ComponentMain {
    public static final JLabel LABEL_ALGO = new JLabel("Select CPU Scheduling Algorithm", JLabel.CENTER);
    public static final JButton BUTTON_FCFS = new JButton("First Come First Serve");
    public static final JButton BUTTON_SJF = new JButton("Short Job First");
    public static final JButton BUTTON_SRTF = new JButton("Shortest Remaining Time");
    public static final JButton BUTTON_RROBIN = new JButton("Round Robin");
    public static final JButton BUTTON_PRIORITY = new JButton("Priority");
    
    public static final PanelFCFS PANEL_FCFS = new PanelFCFS();
}
