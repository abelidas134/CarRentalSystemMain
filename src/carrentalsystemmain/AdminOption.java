package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;

public class AdminOption extends JFrame implements ActionListener{
    private JButton btnCustomer, btnBack, btnMaintenance;
    public AdminOption() {
        setTitle("ADMIN OPTIONS");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        btnCustomer = new JButton("Customer Records");
        btnCustomer.setBounds(180, 210, 230, 50);
        add(btnCustomer);
        
        btnMaintenance = new JButton("Maintenance & Tracking");
        btnMaintenance.setBounds(180, 275, 230, 50);
        add(btnMaintenance);
        
        btnBack = new JButton ("Back");
        btnBack.setBounds(10,520,100,25);
        add(btnBack);
        
        btnCustomer.addActionListener(this);
        btnMaintenance.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnCustomer){
            CustomerForm cf = new CustomerForm();
            cf.setVisible(true);
        }else if (e.getSource()==btnMaintenance){
            staff_LogInPage lp = new staff_LogInPage();
            lp.setVisible(true);
        }else if (e.getSource()==btnBack){
            AdminPage ap = new AdminPage();
            ap.setVisible(true);
        }
    }
}