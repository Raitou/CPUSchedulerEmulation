
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public interface ComponentTableOutput {
    public static final JTable TABLE_OUTPUT = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column){
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            return false;
        }
    };
    public static final JScrollPane TABLE_OUTPUT_SCROLL = new JScrollPane(TABLE_OUTPUT);
    
    public static final JLabel LABEL_AVG_TAT = new JLabel("AVERAGE TURN AROUND TIME", JLabel.CENTER);
    public static final JTextField TEXTFIELD_AVG_TAT = new JTextField();
    public static final JLabel LABEL_AVG_WT = new JLabel("AVERAGE WAITING TIME", JLabel.CENTER);
    public static final JTextField TEXTFIELD_AVG_WT = new JTextField();   
}
