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
class Homepage extends JFrame implements ActionListener {
    private JLabel lblHome;
    private JButton btnAdmin;
    private JButton btnCustomer;
    private JButton btnSubmit;
    
    Homepage(){
        setSize(1000,600);
        setTitle("Main Page");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblHome = new JLabel ("Welcome Back!");
        lblHome.setBounds(250,150,150,100);
        add(lblHome);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
}
