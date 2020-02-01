import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
public class PanelSJFTableInput extends JPanel implements ComponentTableInput, ComponentScheduler, ActionListener {
        private static final DefaultTableModel TABLE_MODEL = new DefaultTableModel();
    private static Integer mProcInc = 1;
    
    PanelSJFTableInput(){
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
        super.add(BUTTON_SIMULATE, gbc);
        
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
            BUTTON_SIMULATE.addActionListener(this);
        }
        else {
            BUTTON_ADD.removeActionListener(this);
            BUTTON_CLEAR.removeActionListener(this);
            BUTTON_SIMULATE.removeActionListener(this);
        }
    }

    private void SimulateSJF(){
        int n, output[][]; 
        int PrevSum = 0;
        boolean runned[];
        int minimum;
        float AWT=0;
        float ATAT=0;
        
        System.out.println("SHORTEST JOB FIRST CPU SCHEDULING");
        System.out.print("Enter no of process: "); 
        n = TABLE_MODEL.getRowCount();
        
        output = new int [n][6];
        runned = new boolean[n];
        for(int i = 0; i < n; i++){
            runned[i] = false;
        }
            
        System.out.println();

        for(int i=0;i<n;i++){ 
            System.out.print("Enter BT for process "+(i+1)+": "); 
            output[i][1]= Integer.parseInt(TABLE_MODEL.getValueAt(i, 1).toString());                                      //BT
            System.out.print("Enter AT for process "+(i+1)+": "); 
            output[i][2]= Integer.parseInt(TABLE_MODEL.getValueAt(i, 2).toString());                                      //AT
        } 
        System.out.println("*************************************************");
        int arrangement[] = new int[n];
        for(int i = 0; i < n; i++){
            arrangement[i] = output[i][1];                                      //arrangement = BT
        }
        Arrays.sort(arrangement);
        for(int i = 0; i < n; i++){
            System.out.println(arrangement[i]);                                      //arrangement = BT
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arrangement[i] == output[j][1] && !runned[j]){
                    output[j][3] = output[j][1] + PrevSum;                      //CT = BT + PrevSum
                    PrevSum = output[j][3];                                     //PrevSum = CT
                    output[j][4] = output[j][3] - output[j][2];                 //TAT = CT - AT
                    output[j][5] = output[j][4] - output[j][1];                 //WT = TAT - BT
                    ATAT += output[j][4];                                       //ATAT += TAT
                    AWT += output[j][5];                                        //AWT += WT
                    runned[j] = true;
                    break;
                }
            }
        } 
        AWT /= n;
        ATAT /= n;
        System.out.println("PROCESS\tBT\tAT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            output[i][0] = i+1;
            System.out.println(output[i][0]+"\t"+output[i][1]+"\t"+output[i][2]+"\t"+output[i][3]+"\t"+output[i][4]+"\t"+output[i][5]);
        }
        System.out.println("Average TAT: "+ATAT); 
        System.out.println("Average WT: "+AWT);
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
        } else if(e.getSource() == BUTTON_SIMULATE){
            SimulateSJF();
        }
    }
}
