
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
    
    Homepage(){
        setSize(1000,600);
        setTitle("Main Page");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblHome = new JLabel ("Welcome Back!");
        lblHome.setBounds(425,150,150,100);
        add(lblHome);
        
        lblHome = new JLabel ("Log in to manage your car rentals and get on the road!");
        lblHome.setBounds(325,175,500,100);
        add(lblHome);
        
        btnAdmin = new JButton ("ADMIN");
        btnAdmin.setBounds(275,275,175,50);
        add(btnAdmin);
        
        btnCustomer = new JButton ("CUSTOMER");
        btnCustomer.setBounds(500,275,175,50);
        add(btnCustomer);
        
        btnAdmin.addActionListener(this);
        btnCustomer.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnAdmin){
            AdminPage ap = new AdminPage();
            ap.setVisible(true);
        } else if (e.getSource()==btnCustomer){
            CustomerPage cp = new CustomerPage();
            cp.setVisible(true);
        }
    }
    
    
}