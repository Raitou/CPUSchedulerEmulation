
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */

public class PanelGantt extends JPanel {
    private static final ArrayList<JLabel> LABEL_GANTT = new ArrayList<>();
    private static final ArrayList<Integer> EVENT_LENGTH = new ArrayList<>();
        
    public void AddEvent(String eventName, int length){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        JLabel labelEvent = new JLabel(eventName, JLabel.CENTER);
        labelEvent.setBorder(border);
        LABEL_GANTT.add(labelEvent);
        EVENT_LENGTH.add(length);
    }
    
    public void ShowEvent(){
        GridBagConstraints gbc = new GridBagConstraints();
        int gridx = 0, iter = 0;
        gbc.gridy = 0;
        for(JLabel i : LABEL_GANTT){
            //gbc.gridx = gridx;
            //gbc.gridwidth = gridx = EVENT_LENGTH.get(iter);
            super.add(i, gbc);
            gridx--;
            iter++;
        }
    }
    
    public void ClearEvents(){
        for(JLabel i : LABEL_GANTT){
            super.remove(i);
        }
        EVENT_LENGTH.clear();
        LABEL_GANTT.clear();
    }
    
    public void InitializeComponents(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        super.setBorder(border);
        super.setLayout(new GridBagLayout());
    }
    
    public void DeinitializeComponents(){
        ClearEvents();
    }
}
