package serviceTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class nissan4567_ReservedUpdate extends JFrame implements ActionListener {
    JLabel lblReservedTitle,lblcarModelPlatenum, lblReservedDate, lblUntil, lblCustomerUser;//suggestion na may client ID tayo per account
    JTextField txtCustomerUser, txtUntil, txtReservedDate;
    JButton btnback, btnUpdate;
    
    nissan4567_ReservedUpdate(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Updating Reserved Status of Nissan GTR 4567");
        setLocationRelativeTo(null);
        
        lblcarModelPlatenum = new JLabel("Nissan GTR 4567");
        lblcarModelPlatenum.setBounds(30,40,200,50);
        add(lblcarModelPlatenum);
        
        lblReservedDate = new JLabel("Date Reserved:");
        lblReservedDate.setBounds(30,150,100, 30);
        add(lblReservedDate);
        
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
            updatingPageStatusNissanGTR4567 updStatNissan4567 = new updatingPageStatusNissanGTR4567();
            updStatNissan4567.setVisible(true);
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
                carStatusNissanGTR4567 csNissan4567 = new carStatusNissanGTR4567();
                csNissan4567.setVisible(true);
            }   
        }
    }
}
