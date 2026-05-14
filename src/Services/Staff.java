package Services;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Staff extends JFrame {

    public Staff(DefaultTableModel model) {
        setTitle("Staff Tab");
        setSize(600, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
                
        //STATUS CHANGE
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.BOLD, 14));
        tabs.setBounds(0, 0, 594, 560);

        JPanel vehiclePanel = new JPanel(null);
        JLabel lbltitle = new JLabel("VEHICLE MANAGEMENT");
        lbltitle.setFont(new Font("Arial", Font.BOLD, 16));
        lbltitle.setBounds(50, 20, 300, 30);

        JTable vehicleTable = new JTable(model);
        vehicleTable.setRowHeight(30);
        vehicleTable.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(vehicleTable);
        scroll.setBounds(20, 60, 540, 173); 

        JButton btnStatus = new JButton("Change Status");
        btnStatus.setBounds(190, 260, 150, 30);
        
        JButton btnback = new JButton("Back");
        btnback.setBounds(20,260,150,30);
        
        btnback.addActionListener(e -> dispose());

        btnStatus.addActionListener(e -> {
            int row = vehicleTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select a vehicle.", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String[] options = {"AVAILABLE", "RESERVED", "RENTED", "UNDER MAINTENANCE"};
            String chosen = (String) JOptionPane.showInputDialog(
                null, "Select new status:", "Change Status",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]
            );
            if (chosen != null) {
                model.setValueAt(chosen, row, 3);
            }
        });

        vehiclePanel.add(lbltitle);
        vehiclePanel.add(scroll);
        vehiclePanel.add(btnStatus);
        vehiclePanel.add(btnback);
        
        //HISTORY   
        JPanel historyPanel = new JPanel(null);
        JLabel lbltitle2 = new JLabel("VEHICLE HISTORY");
        lbltitle2.setFont(new Font("Arial", Font.BOLD, 16));
        lbltitle2.setBounds(50, 20, 300, 30);
               
        historyPanel.add(lbltitle2);
        
        //MAINTENANCE       
        JPanel maintenancePanel = new JPanel(null);
        JLabel lbltitle3 = new JLabel("VEHICLE MAINTENANCE");
        lbltitle3.setFont(new Font("Arial", Font.BOLD, 16));
        lbltitle3.setBounds(50, 20, 300, 30);
       
        maintenancePanel.add(lbltitle3);
        
        //SERVICE DUE
        JPanel servicePanel = new JPanel(null);
        JLabel lbltitle4 = new JLabel("VEHICLE SERVICE DUE");
        lbltitle4.setFont(new Font("Arial", Font.BOLD, 16));
        lbltitle4.setBounds(50, 20, 300, 30);
        
        servicePanel.add(lbltitle4);
        
        tabs.addTab("Vehicles", vehiclePanel);
        tabs.addTab("History", historyPanel);
        tabs.addTab("Maintenance", maintenancePanel);
        tabs.addTab("Service Due", servicePanel);
        
        add(tabs);
        setVisible(true);
    }
}
