
package serviceTracking;

import java.awt.Color;
import javax.swing.*;

//History
    public class History extends JPanel {
    JTextArea txtHistory;
    
    public History(){
        setSize(600,600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
        
        txtHistory = new JTextArea();
        txtHistory.setEditable(false);
        txtHistory.setLineWrap(true); 
        txtHistory.setWrapStyleWord(true); 
        
        txtHistory.setText("=== Toyota Vios 1270 History Reports ===\n"
                + "2024-05-10: Brake maintenace\n"
                + "2025-07-22: Tire replacement\n"
                + "2026-01-15: Rented in Manila\n"
                + "2025-09-30: Battery replaced\n"
                + "...\n"
                + "Sampleee Recordsssss (not yet added to the database)");
        
        
        JScrollPane scrollPane = new JScrollPane(txtHistory);
        scrollPane.setBounds(50, 50, 500, 400); 
        add(scrollPane);
    
    }
    
   
}
