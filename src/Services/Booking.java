package Services;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Booking extends JFrame {
        
        public Booking(String id, String name, String plate, String rate, int row, DefaultTableModel model){
        setTitle("Booking...");
        setSize(600,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        int x = 50, y = 20, w = 300, l = 40, gap = 40;
        
        JLabel lblid = new JLabel("VEHICLE ID: " + id);
        lblid.setBounds(x,y,w,l);
        lblid.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblmodel = new JLabel("MODEL: " + name);
        lblmodel.setBounds(x,y+=gap,w,l);
        lblmodel.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblplate = new JLabel("PLATE NUMBER: " +  plate );
        lblplate.setBounds(x,y+=gap,w,l);
        lblplate.setFont(new Font("Arial", Font.BOLD,15));
        
        JLabel lblrate = new JLabel("RATE: " + rate);
        lblrate.setBounds(x,y+=gap,w,l);
        lblrate.setFont(new Font("Arial", Font.BOLD,15));

        //RESERVE DATE
        JLabel lblreserve = new JLabel("RESERVE DATE: ");
        lblreserve.setBounds(x,y+=gap,w,l);
        lblreserve.setFont(new Font("Arial", Font.BOLD,15));
        
        JTextField txtreserve = new JTextField("Month/Day/Year");
        txtreserve.setBounds(x, y+=gap, 200, 25);
        txtreserve.setFont(new Font("Arial", Font.PLAIN, 14));
        
        //DEADLINE
        JLabel lbldeadline = new JLabel("CAR DEADLINE: ");
        lbldeadline.setBounds(x,y+=gap,w,l);
        lbldeadline.setFont(new Font("Arial", Font.BOLD,15));
        
        JTextField txtdeadline = new JTextField("Month/Day/Year");
        txtdeadline.setBounds(x, y+=gap, 200, 25);
        txtdeadline.setFont(new Font("Arial", Font.PLAIN, 14));
        
        //DAYS
        JLabel lbldays = new JLabel("ENTER NUMBER OF DAYS: ");
        lbldays.setBounds(x,y+=gap,w,l);
        lbldays.setFont(new Font("Arial", Font.BOLD,15));
        
        JTextField txtdays = new JTextField();
        txtdays.setBounds(x, y+=gap, 200, 25);
        txtdays.setFont(new Font("Arial", Font.PLAIN, 14));
                    
                
        JButton btnclose = new JButton("Cancel");
        btnclose.setBounds(450,450,100,40);
        btnclose.addActionListener(e -> dispose());
        
        JButton btnbook = new JButton("Book");
        btnbook.setBounds(300,450,100,40);
        
        btnbook.addActionListener (e -> {
            String reserve = txtreserve.getText().trim();
            String deadline = txtdeadline.getText().trim();
            String days = txtdays.getText().trim();
                                                
            if (reserve.isEmpty() || reserve.equals("Month/Day/Year")){
                JOptionPane.showMessageDialog(this, "Please Enter a Date.", "Error", JOptionPane.ERROR_MESSAGE); 
                return;
            } if(deadline.isEmpty() || deadline.equals("Month/Day/Year")){
                JOptionPane.showMessageDialog(this, "Please Enter a Date.", "Error", JOptionPane.ERROR_MESSAGE); 
                return;
            }
              if (days.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Number of Days.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        try {
            double rateNum = Double.parseDouble(rate.replace("P", "").trim());
            int daysNum    = Integer.parseInt(days);
            double total   = rateNum * daysNum;
                       
            model.setValueAt("RENTED", row, 3);
            JOptionPane.showMessageDialog(this, "Booking Confirmed!\n" 
                    + "Thank You for Booking with Us!\n" 
                    + "-------------------------------------------\n"
                    + "Vehicle: " + name + "\n"
                    + "Plate Number: " + plate + "\n"
                    + "From: " + reserve + "\n"
                    + "Until: " + deadline + "\n"
                    + "Total: " + total + "\n", "Successful", JOptionPane.INFORMATION_MESSAGE);
            dispose();
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number of days.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        });
        
        
        add(lblmodel);
        add(lblplate);
        add(lblrate);
        add(lblreserve);
        add(lbldeadline);
        add(btnclose);
        add(btnbook);
        add(lblid);
        add(txtreserve);
        add(txtdeadline);
        add(lbldays);
        add(txtdays);
                              
        setVisible(true);
}
}
