
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 201812358
 */
public class PanelFCFSTableOutput extends JPanel implements ComponentTableOutput{
    private static final DefaultTableModel TABLE_MODEL = new DefaultTableModel();
    
    public void SetAverage(String avgTat, String avgWt){
        
    }
    
    public void AddRow(Integer row[]){
        TABLE_MODEL.addRow(row);
    }
    
    PanelFCFSTableOutput(){
        TABLE_MODEL.addColumn("PROCESS ID");
        TABLE_MODEL.addColumn("BURST TIME");
        TABLE_MODEL.addColumn("ARRIVAL TIME");
        TABLE_MODEL.addColumn("COMPLETION TIME");
        TABLE_MODEL.addColumn("TURN AROUND TIME");
        TABLE_MODEL.addColumn("WAITING TIME");
    }
    
    public void InitializeComponents(){
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        super.setBorder(border);
        GridBagConstraints gbc = new GridBagConstraints();
        super.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;
        //bottom, left, right, top
        gbc.insets = new Insets(3 , 3, 3, 3);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        super.add(LABEL_AVG_TAT, gbc);
        
        gbc.gridx = 1;
        super.add(LABEL_AVG_WT, gbc);
        
        int columns = 32;
        TEXTFIELD_AVG_TAT.setColumns(columns);
        gbc.gridx = 0;
        gbc.gridy = 1;
        TEXTFIELD_AVG_TAT.setEditable(false);
        TEXTFIELD_AVG_TAT.setHorizontalAlignment(JTextField.CENTER);
        super.add(TEXTFIELD_AVG_TAT, gbc);
        
        TEXTFIELD_AVG_WT.setColumns(columns);
        gbc.gridx = 1;
        TEXTFIELD_AVG_WT.setEditable(false);
        TEXTFIELD_AVG_WT.setHorizontalAlignment(JTextField.CENTER);
        super.add(TEXTFIELD_AVG_WT, gbc);
        
        TABLE_OUTPUT.setModel(TABLE_MODEL);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        TABLE_OUTPUT_SCROLL.setPreferredSize(new Dimension(0, 295));
        super.add(TABLE_OUTPUT_SCROLL, gbc);
        
    }
    
    public void DeinitializeComponents(){
        super.remove(LABEL_AVG_TAT);
        super.remove(LABEL_AVG_WT);
        super.remove(TEXTFIELD_AVG_TAT);
        super.remove(TEXTFIELD_AVG_WT);
        super.remove(TABLE_OUTPUT_SCROLL);
    }
    
    
}
