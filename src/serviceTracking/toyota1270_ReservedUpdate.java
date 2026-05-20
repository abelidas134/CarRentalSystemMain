package serviceTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class toyota1270_ReservedUpdate extends JFrame implements ActionListener{

    JLabel lblReservedTitle,lblcarModelPlatenum, lblreservedDate, lblUntil, lblCustomerUser;//suggestion na may client ID tayo per account
    JTextField txtCustomerUser, txtUntil, txtReservedDate;
    JButton btnback, btnUpdate;
    
    toyota1270_ReservedUpdate()
    {
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Updating Reserved Status of Toyota Vios 1270");
        setLocationRelativeTo(null);
        
        lblcarModelPlatenum = new JLabel("Toyota Vios 1270");
        lblcarModelPlatenum.setBounds(30,40,200,50);
        add(lblcarModelPlatenum);
        
        lblreservedDate = new JLabel("Date Reserved:");
        lblreservedDate.setBounds(30,150,100, 30);
        add(lblreservedDate);
        
        lblUntil = new JLabel("Date Until:");
        lblUntil.setBounds(30,210,100, 30);
        add(lblUntil);
        
        lblCustomerUser = new JLabel("Customer Username:"); //dapat unique tohhh
        lblCustomerUser.setBounds(30,270,200, 30);
        add(lblCustomerUser);
        
        txtReservedDate = new JTextField("");
        txtReservedDate.setBounds(210,150,200, 30);
        add(txtReservedDate);
        
        txtUntil = new JTextField("");
        txtUntil.setBounds(210,210,200, 30);
        add(txtUntil);
        
        txtCustomerUser = new JTextField (""); //dapat unique tohhh
        txtCustomerUser.setBounds(210,270,200, 30);
        add(txtCustomerUser);
        
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
            String reservedDate = txtReservedDate.getText().trim();
            String untilDate = txtUntil.getText().trim();
            String customerUser = txtCustomerUser.getText().trim();

            if (reservedDate.isEmpty() || untilDate.isEmpty() || customerUser.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Please fill in all fields before updating!");
            } else 
            {
                JOptionPane.showMessageDialog(this, "Reserved Updated!");
                this.dispose();
                carStatusToyotaVios1270 csToyota1270 = new carStatusToyotaVios1270();
                csToyota1270.setVisible(true);
            }   
        }
           
    }
    
}
