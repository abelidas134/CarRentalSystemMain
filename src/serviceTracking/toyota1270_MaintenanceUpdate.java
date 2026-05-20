
package serviceTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class toyota1270_MaintenanceUpdate extends JFrame implements ActionListener {
    JLabel lblmaintenanceTitle,lblcarModelPlatenum, lblLastMaintenanceDate, lblRepairing, lblnextService;//suggestion na may client ID tayo per account
    JTextField txtLastMaintenanceDate, txtRepairing, txtnextService;
    JButton btnback, btnUpdate;
    
    toyota1270_MaintenanceUpdate(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Updating Maintenance Status of Toyota Vios 1270");
        setLocationRelativeTo(null);
        
        lblcarModelPlatenum = new JLabel("Toyota Vios 1270");
        lblcarModelPlatenum.setBounds(30,40,200,50);
        add(lblcarModelPlatenum);
        
        lblLastMaintenanceDate = new JLabel("Last Repair Date:");
        lblLastMaintenanceDate.setBounds(30,150,100, 30);
        add(lblLastMaintenanceDate);
        
        lblRepairing = new JLabel("Repairing:");
        lblRepairing.setBounds(30,210,100, 30);
        add(lblRepairing);
        
        lblnextService = new JLabel("Next service:"); //dapat unique tohhh
        lblnextService.setBounds(30,270,200, 30);
        add(lblnextService);
        
        txtLastMaintenanceDate = new JTextField("");
        txtLastMaintenanceDate.setBounds(210,150,200, 30);
        add(txtLastMaintenanceDate);
        
        txtRepairing = new JTextField("");
        txtRepairing.setBounds(210,210,200, 30);
        add(txtRepairing);
        
        txtnextService = new JTextField (""); 
        txtnextService.setBounds(210,270,200, 30);
        add(txtnextService);
        
        btnback = new JButton("Back");
        btnback.setBounds(30,480,100,25);
        add(btnback);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(450,480,100,25);
        add(btnUpdate);
        
        btnback.addActionListener(this);
        btnUpdate.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent j) {
        if (j.getSource() == btnback) 
        {
            dispose();
            updatingPageStatusToyotaVios1270 updStatToyota1270 = new updatingPageStatusToyotaVios1270();
            updStatToyota1270.setVisible(true);
        }
       
       else if (j.getSource() == btnUpdate) 
       {
            String LastMaintenanceDate = txtLastMaintenanceDate.getText().trim();
            String Repairing = txtRepairing.getText().trim();
            String nextService = txtnextService.getText().trim();

            if (LastMaintenanceDate.isEmpty() || Repairing.isEmpty() || nextService.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Please fill in all fields before updating!");
            } else 
            {
                JOptionPane.showMessageDialog(this, "Maintenance Updated!");
                this.dispose();
                carStatusToyotaVios1270 csToyota1270 = new carStatusToyotaVios1270();
                csToyota1270.setVisible(true);
            }   
        }
    }
    
}
