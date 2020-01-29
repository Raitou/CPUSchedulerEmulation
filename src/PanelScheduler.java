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
public class PanelScheduler extends JPanel implements ComponentScheduler {
    
    public void InitializeComponents(){    
        GridBagConstraints gbc = new GridBagConstraints();
        super.setLayout(new GridBagLayout());
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        super.add(LABEL_INPUT);
        
        gbc.gridy = 1;
        switch(EmulationWin.mOperation){
            case 0:{
                super.add(PANEL_FCFS_TABLE_INPUT, gbc);
                break;
            }
            case 1:{
                break;
            }
        }
        
        gbc.gridx = 1;
        super.add(BUTTON_GOBACK);
    }
    
    public void DeinitializeComponents(){
        super.remove(LABEL_INPUT);
        
        switch(EmulationWin.mOperation){
            case 0:{
                super.remove(PANEL_FCFS_TABLE_INPUT);
                break;
            }
            case 1:{
                break;
            }
        }
    }
}
