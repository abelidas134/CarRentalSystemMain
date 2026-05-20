
package serviceTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class nissan4567_HistoryReports extends JFrame implements ActionListener {
    JTextArea txtHistory;
    JButton btnback;
    
    nissan4567_HistoryReports(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("History Reports of Toyota Vios 1270");
        setLocationRelativeTo(null);
        
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
        
        
        btnback = new JButton("Back");
        btnback.setBounds(250, 480, 100, 25);
        add(btnback);
        
        btnback.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent j) {
        if (j.getSource() == btnback) 
        {
            dispose();
            updatingPageStatusNissanGTR4567 updStatNissan4567 = new updatingPageStatusNissanGTR4567();
            updStatNissan4567.setVisible(true);
        }
    }
    
}
