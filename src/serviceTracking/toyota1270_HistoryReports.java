//dito na yung magshoshow ung na saved sa database huhu T.T

package serviceTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class toyota1270_HistoryReports extends JFrame implements ActionListener{
    JTextArea txtHistory;
    JButton btnback;
    
    toyota1270_HistoryReports(){
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
                + "2025-05-10: Oil changed\n"
                + "2025-07-22: Rented in Quezon City\n"
                + "2025-07-22: Tire replacement\n"
                + "2025-01-15: Brake maintenance\n"
                + "2025-09-30: Battery replaced\n"
                + "2026-03-12: Engine check-up\n"
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
            updatingPageStatusToyotaVios1270 updStatToyota1270 = new updatingPageStatusToyotaVios1270();
            updStatToyota1270.setVisible(true);
            }
    }
}
