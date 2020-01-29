import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public interface ComponentTableInput {
    public static final JTable TABLE_INPUT = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column){
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            return false;
        }
    };
    public final static JScrollPane TABLE_INPUT_SCROLL = new JScrollPane(TABLE_INPUT);
    
    public static final JLabel LABEL_PROCESS = new JLabel("PROCESS", JLabel.CENTER);
    public static final JLabel LABEL_BT = new JLabel("BURST TIME", JLabel.CENTER);
    public static final JLabel LABEL_AT = new JLabel("ARRIVAL TIME", JLabel.CENTER);
    public static final JLabel LABEL_QT = new JLabel("QUANTUM TIME", JLabel.CENTER);
    
    public static final JTextField TEXTFIELD_PROCESS = new JTextField();
    public static final JTextField TEXTFIELD_BT = new JTextField();
    public static final JTextField TEXTFIELD_AT = new JTextField();
    public static final JTextField TEXTFIELD_QT = new JTextField();
    
    public static final JButton BUTTON_ADD = new JButton("ADD");
    public static final JButton BUTTON_CLEAR = new JButton("CLEAR");
    public static final JButton BUTTON_EMULATE = new JButton("EMULATE");
}
