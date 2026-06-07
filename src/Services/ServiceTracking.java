package Services;

import carrentalsystemmain.AdminOption;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import carrentalsystemmain.*;
import serviceTracking.*;

public class ServiceTracking extends JPanel {

    public ServiceTracking(DefaultTableModel model) {
        setBounds(600,150,600, 600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
                
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
        
        
        
        btnback.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            currentFrame.dispose();
            
            JFrame mainFrame = new JFrame();
            mainFrame.setSize(1366, 768);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            JLabel background = new JLabel(new ImageIcon(Main.class.getResource("/img/firstBG.png")));
            background.setLayout(null);
            AdminOption ap = new AdminOption();
            ap.setBounds(875, 175, 1366, 768);
            background.add(ap);
            mainFrame.setContentPane(background);
            mainFrame.setVisible(true);
        });

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
        History h = new History();
        h.setBounds(0, 0, 600, 600);
        historyPanel.add(h);       
        historyPanel.add(lbltitle2);
        
        //MAINTENANCE       
        JPanel maintenancePanel = new JPanel(null);
        JLabel lbltitle3 = new JLabel("VEHICLE MAINTENANCE");
        lbltitle3.setFont(new Font("Arial", Font.BOLD, 16));
        lbltitle3.setBounds(50, 20, 300, 30);
       
        maintenancePanel.add(lbltitle3);
        Maintenance m = new Maintenance();
        m.setBounds(50,25,600,600);
        maintenancePanel.add(m);
        JButton btnUpdate = new JButton("Update");
        btnback.setBounds(20,260,150,30);
        maintenancePanel.add(btnUpdate);
        btnUpdate.addActionListener(e -> {
            MaintenanceUpdate mu = new MaintenanceUpdate();
            mu.setVisible(true);
        });
        
        
       
        tabs.addTab("Vehicles", vehiclePanel);
        tabs.addTab("History", historyPanel);
        tabs.addTab("Maintenance", maintenancePanel);
        
        add(tabs);
        setVisible(true);
    }
}
