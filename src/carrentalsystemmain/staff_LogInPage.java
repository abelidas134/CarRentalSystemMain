package carrentalsystemmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class staff_LogInPage extends JFrame implements ActionListener{
    
    JLabel lblTitle, lbllogin,lblstaffID, lblstaffName, lblstaffPassword, lblStatusLogin;
    JButton btnClear, btnSubmit;
    JTextField txtStaffID,txtStafName,txtstaffPassword;
    
    
    staff_LogInPage(){
        setSize(1000,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Staff Login Page");
        
        lblTitle = new JLabel("Maintenace Service & Tracking");
        lblTitle.setBounds(400,20,200,50);
        add(lblTitle);
        
        lbllogin = new JLabel(">> Login <<");
        lbllogin.setBounds(460,60,200,50);
        add(lbllogin);
        
        lblstaffID = new JLabel ("Staff ID: ");
        lblstaffID.setBounds(330,150,200,30);
        add(lblstaffID); 
        
        txtStaffID = new JTextField("  ");
        txtStaffID.setBounds(395,150,200,30);
        add(txtStaffID);
        
        lblstaffName = new JLabel ("Name: ");
        lblstaffName.setBounds(330,190,200,30);
        add(lblstaffName); 
        
        txtStafName = new JTextField("  ");
        txtStafName.setBounds(395,190,200,30);
        add(txtStafName);
        
        
        lblstaffPassword = new JLabel ("Password: ");
        lblstaffPassword.setBounds(330,230,200,30);
        add(lblstaffPassword);
        
        txtstaffPassword = new JTextField("  ");
        txtstaffPassword.setBounds(395,230,200,30);
        add(txtstaffPassword);
        
        lblStatusLogin = new JLabel (" ");
        lblStatusLogin.setBounds(390,350,300,30);
        add(lblStatusLogin);
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(150,400,100,40);
        add(btnClear);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(700,400,100,40);
        add(btnSubmit);
        
        
        btnClear.addActionListener(this);
        btnSubmit.addActionListener(this);
        
    }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent j) {
       
       if (j.getSource() == btnClear) 
       {
            txtStaffID.setText("");
            txtStafName.setText("");
            txtstaffPassword.setText("");
            lblStatusLogin.setText("");
        }
       
        else if (j.getSource() == btnSubmit) {
            String id = txtStaffID.getText().trim();
            String name = txtStafName.getText().trim();
            String password = txtstaffPassword.getText().trim();

            
            if (id.equals("1234") && name.equals("han") && password.equals("wing")) {
                dispose();
                carMenu cm = new carMenu();
                cm.setVisible(true);
            } else {
                lblStatusLogin.setText("Wrong credentials, please try again");
            }
        }
    
    }
}
