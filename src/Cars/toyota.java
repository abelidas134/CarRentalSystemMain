package Cars;

import java.awt.*;
import javax.swing.*;
public class toyota extends JFrame {
    
    public toyota(String name, String status, String rate, String plate){
        setTitle("Display");
        setSize(600,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblmodel = new JLabel("MODEL: " + name);
        lblmodel.setBounds(330,90,300,40);
        lblmodel.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblplate = new JLabel("PLATE NUMBER: " + plate);
        lblplate.setBounds(330,120,300,40);
        lblplate.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblrate = new JLabel("RATE: " + rate);
        lblrate.setBounds(330,150,300,40);
        lblrate.setFont(new Font("Arial", Font.BOLD,15));

        JLabel lblavail = new JLabel("STATUS: " + status);
        lblavail.setBounds(330,180,300,40);
        lblavail.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblcondi = new JLabel("CONDITION: GOOD");
        lblcondi.setBounds(330,210,300,40);
        lblcondi.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblmaintenance = new JLabel("LAST MAINTENANCE: ");
        lblmaintenance.setBounds(330,240,300,40);
        lblmaintenance.setFont(new Font("Arial", Font.BOLD,15));

        JButton btnclose = new JButton("Close");
        btnclose.setBounds(450,450,100,50);
        
        btnclose.addActionListener(e -> dispose());
        
        add(lblmodel);
        add(lblplate);
        add(lblrate);
        add(lblavail);
        add(lblcondi);
        add(lblmaintenance);
        add(btnclose);
                
        setVisible(true);
}
}