package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;
import customers.*;
import java.awt.*;
import serviceTracking.*;

public class AdminOption extends JPanel implements ActionListener{
    private JButton btnCustomer, btnBack, btnMaintenance;
    
    public AdminOption() {
        setBounds(0,0,600, 600);
        setLayout(null);
        setOpaque(false);

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
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            currentFrame.dispose();
            
            JFrame mainFrame = new JFrame();
            mainFrame.setSize(1366, 768);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            JLabel background = new JLabel(new ImageIcon(CarRentalSystemMain.class.getResource("/img/firstBG.png")));
            background.setLayout(null);
            AdminPage ap = new AdminPage();
            ap.setBounds(875, 175, 1366, 768);
            background.add(ap);
            mainFrame.setContentPane(background);
            mainFrame.setVisible(true);
        }
    }
}