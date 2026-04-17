package Services;

import java.awt.*;
import javax.swing.*;
public class Booking extends JFrame {
        
        public Booking(String name, String plate, String rate){
        setTitle("Booking...");
        setSize(600,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblmodel = new JLabel("MODEL: " + name);
        lblmodel.setBounds(50,90,300,40);
        lblmodel.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblplate = new JLabel("PLATE NUMBER: " +  plate );
        lblplate.setBounds(50,120,300,40);
        lblplate.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblrate = new JLabel("RATE: " + rate);
        lblrate.setBounds(50,150,300,40);
        lblrate.setFont(new Font("Arial", Font.BOLD,15));

        JLabel lblreserve = new JLabel("RESERVE DATE: ");
        lblreserve.setBounds(50,180,300,40);
        lblreserve.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lbldeadline = new JLabel("CAR DEADLINE: ");
        lbldeadline.setBounds(50,210,300,40);
        lbldeadline.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lbltotal = new JLabel("TOTAL: ");
        lbltotal.setBounds(50,240,300,40);
        lbltotal.setFont(new Font("Arial", Font.BOLD,15));

        JButton btnclose = new JButton("Cancel");
        btnclose.setBounds(450,450,100,50);
        btnclose.addActionListener(e -> dispose());
        
        JButton btnbook = new JButton("Book");
        btnbook.setBounds(300,450,100,50);
        btnbook.addActionListener (e -> {
            JOptionPane.showMessageDialog(this, "Booked!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });
        
        
        add(lblmodel);
        add(lblplate);
        add(lblrate);
        add(lblreserve);
        add(lbldeadline);
        add(lbltotal);
        add(btnclose);
        add(btnbook);
                
        setVisible(true);
}
}
