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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class PanelFCFSTableInput extends JPanel implements ComponentTableInput, ActionListener{
    private static final DefaultTableModel TABLE_MODEL = new DefaultTableModel(){
        
    };
    private static Integer mProcInc = 1;
    PanelFCFSTableInput(){
        TABLE_MODEL.addColumn("PROCESS ID");
        TABLE_MODEL.addColumn("BURST TIME");
        TABLE_MODEL.addColumn("ARRIVAL TIME");
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
        super.add(LABEL_PROCESS, gbc);
        
        gbc.gridx = 1;
        super.add(LABEL_BT, gbc);
        
        gbc.gridx = 2;
        super.add(LABEL_AT, gbc);
        
        int columns = 15;
        TEXTFIELD_PROCESS.setColumns(columns);
        gbc.gridx = 0;
        gbc.gridy = 1;
        TEXTFIELD_PROCESS.setText(Integer.toString(mProcInc));
        TEXTFIELD_PROCESS.setEditable(false);
        TEXTFIELD_PROCESS.setHorizontalAlignment(JTextField.CENTER);
        super.add(TEXTFIELD_PROCESS, gbc);
        
        TEXTFIELD_BT.setColumns(columns);
        gbc.gridx = 1;
        TEXTFIELD_BT.setHorizontalAlignment(JTextField.CENTER);
        super.add(TEXTFIELD_BT, gbc);
        
        TEXTFIELD_AT.setColumns(columns);
        gbc.gridx = 2;
        TEXTFIELD_AT.setHorizontalAlignment(JTextField.CENTER);
        super.add(TEXTFIELD_AT, gbc);
        
        TABLE_INPUT.setModel(TABLE_MODEL);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        TABLE_INPUT_SCROLL.setPreferredSize(new Dimension(0, 200));
        super.add(TABLE_INPUT_SCROLL, gbc);
        
        gbc.gridy = 3;
        super.add(BUTTON_ADD, gbc);
        
        gbc.gridy = 4;
        super.add(BUTTON_CLEAR, gbc);
        
        gbc.gridy = 5;
        super.add(BUTTON_EMULATE, gbc);
        
        LoadListener(true);
    }
    
    public void DeinitializeComponents(){
        super.remove(LABEL_PROCESS);
        super.remove(LABEL_BT);
        super.remove(LABEL_AT);
        super.remove(TEXTFIELD_PROCESS);
        super.remove(TEXTFIELD_BT);
        super.remove(TEXTFIELD_AT);
        LoadListener(false);
    }
    
    private void LoadListener(Boolean b){
        if(b){
            BUTTON_ADD.addActionListener(this);
            BUTTON_CLEAR.addActionListener(this);
        }
        else {
            BUTTON_ADD.removeActionListener(this);
            BUTTON_CLEAR.removeActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BUTTON_ADD){
            if(
                TEXTFIELD_AT.getText().isEmpty() ||
                TEXTFIELD_BT.getText().isEmpty()
            )
            {
                JOptionPane.showMessageDialog(this, "Fill up the necessary Text Fields!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String textFieldArr[] = new String[3];
            textFieldArr[0] = TEXTFIELD_PROCESS.getText();
            textFieldArr[1] = TEXTFIELD_BT.getText();
            textFieldArr[2] = TEXTFIELD_AT.getText();
            TABLE_MODEL.addRow(textFieldArr);
            mProcInc++;
            TEXTFIELD_PROCESS.setText(Integer.toString(mProcInc));
            TEXTFIELD_BT.setText("");
            TEXTFIELD_AT.setText("");
        } else if(e.getSource() == BUTTON_CLEAR){
            mProcInc = 1;
            TEXTFIELD_PROCESS.setText(Integer.toString(mProcInc));
            while(TABLE_MODEL.getRowCount() != 0){
                TABLE_MODEL.removeRow(TABLE_MODEL.getRowCount()-1);
            }
        }
    }
    
}