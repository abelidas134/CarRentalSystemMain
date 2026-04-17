/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
class CustomerPage extends JFrame implements ActionListener {
    private JLabel lblMessage, lblUserName, lblPassword;
    private JTextField txtUserName, txtPassword;
    private JButton btnLogin, btnBack;
    
    CustomerPage(){
        setSize(600,600);
        setTitle("Customer Account");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblMessage = new JLabel ("CUSTOMER ACCOUNT");
        lblMessage.setBounds(230, 125, 500,100);
        add(lblMessage);
        
        lblMessage = new JLabel ("Check your receipt and login your account!");
        lblMessage.setBounds(180, 150, 500,100);
        add(lblMessage);
        
        lblUserName = new JLabel ("Username:");
        lblUserName.setBounds(175,185, 100,100);
        add(lblUserName);
        
        txtUserName = new JTextField (" ");
        txtUserName.setBounds(275,220,150,30);
        add(txtUserName);
        
        lblPassword = new JLabel ("Password:");
        lblPassword.setBounds(175,225,100,100);
        add(lblPassword);
        
        txtPassword = new JTextField (" ");
        txtPassword.setBounds(275,260,150,30);
        add(txtPassword);
        
        btnLogin = new JButton ("Log In");
        btnLogin.setBounds(250,310,100,25);
        add(btnLogin);
        
        btnBack = new JButton ("Back");
        btnBack.setBounds(10,520,100,25);
        add(btnBack);
        
        btnLogin.addActionListener(this);
        btnBack.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnLogin){
            String userName = txtUserName.getText().trim();
            String pass = txtPassword.getText().trim();
            if(userName.matches("user123")&&pass.matches("0000")){
                CustomerOption co = new CustomerOption();
                co.setVisible(true);
            }
        } else if (e.getSource()==btnBack){
            Homepage hp = new Homepage();
            hp.setVisible(true);
        }
    }
    
}
