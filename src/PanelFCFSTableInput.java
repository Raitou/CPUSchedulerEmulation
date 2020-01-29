/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class PanelFCFSTableInput extends JPanel implements ComponentTableInput{
    
    PanelFCFSTableInput(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        super.setBorder(border);
        GridBagConstraints gbc = new GridBagConstraints();
        super.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        //bottom, left, right, top
        gbc.insets = new Insets(10 , 10, 10, 10);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        super.add(LABEL_PROCESS, gbc);
        
        gbc.gridx = 1;
        super.add(LABEL_BT, gbc);
        
        gbc.gridx = 2;
        super.add(LABEL_AT, gbc);
        
        int columns = 15;
        TEXTFIELD_PROCESS.setColumns(columns);
        gbc.gridx = 0;
        gbc.gridy = 1;
        super.add(TEXTFIELD_PROCESS, gbc);
        
        TEXTFIELD_BT.setColumns(columns);
        gbc.gridx = 1;
        super.add(TEXTFIELD_BT, gbc);
        
        TEXTFIELD_AT.setColumns(columns);
        gbc.gridx = 2;
        super.add(TEXTFIELD_AT, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        super.add(BUTTON_ADD, gbc);
        
        gbc.gridy = 3;
        super.add(BUTTON_CLEAR, gbc);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("PROCESS");
        tableModel.addColumn("BURST TIME");
        tableModel.addColumn("ARRIVAL TIME");
        TABLE_INPUT.setModel(tableModel);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        super.add(TABLE_INPUT_SCROLL, gbc);
        
        gbc.gridy = 5;
        super.add(BUTTON_EMULATE, gbc);
    }
    
}