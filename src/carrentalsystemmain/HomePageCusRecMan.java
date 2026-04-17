package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;

public class HomePageCusRecMan extends JFrame implements ActionListener{
    private JButton btnCustomer, btnBack;
    public HomePageCusRecMan() {
        setTitle("Customer Record Management");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        btnCustomer = new JButton("WELCOME ADMIN, CLICK ME!");
        btnCustomer.setBounds(180, 220, 230, 50);
        add(btnCustomer);
        
        btnBack = new JButton ("Back");
        btnBack.setBounds(10,520,100,25);
        add(btnBack);
        
        btnCustomer.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnCustomer){
            CustomerForm cf = new CustomerForm();
            cf.setVisible(true);
        }else if (e.getSource()==btnBack){
            AdminPage ap = new AdminPage();
            ap.setVisible(true);
        }
    }
}