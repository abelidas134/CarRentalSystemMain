package carrentalsystemmain;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import Services.*;
public class CarDisplayCh extends JFrame{
    public CarDisplayCh(){
    
        setTitle("Vehicles");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel lblce = new JLabel("What do you want to book today?");
        lblce.setFont(new Font("Arial", Font.BOLD, 25));
        lblce.setBounds(300, 80, 450, 30);
                       
        String[] column = {"Plate Number","Name", "Status", "Rate"};
        String[][] data = { 
            {"KO3AN0","Toyota Vios", "AVAILABLE", "P 200"},
            {"H3KAO9", "Honda Civic", "AVAILABLE", "P 230"},
            {"GW3H5D","Ford Ranger", "AVAILABLE", "P 330"},
            {"1SN4US", "Nissan Altima", "AVAILABLE", "P 280"},
            {"GSV4U8", "Hyundai Elantra", "AVAILABLE", "P 350"},
        };
        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);
        table.setRowHeight(35);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.setFont(new Font("Arial", Font.PLAIN, 14));
       
        JScrollPane spane = new JScrollPane(table);
        spane.setBounds(200, 150, 600, 200);
       
        JButton btndetails = new JButton("View Details");
        btndetails.setBounds(425, 400, 150, 40);
        JButton btnbook = new JButton("Book Vehicle");
        btnbook.setBounds(650, 400, 150, 40);
        JButton btncancel = new JButton("Cancel");
        btncancel.setBounds(200,400,150,40);
        
        btncancel.addActionListener(e -> dispose());

        btndetails.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a vehicle first.", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String plate = (String)model.getValueAt(row, 0);
            String name = (String)model.getValueAt(row, 1);
            String status = (String)model.getValueAt(row, 2);
            String rate = (String)model.getValueAt(row, 3);

                new CarDetails(name,status, rate, plate);
           });
       btnbook.addActionListener(e -> {
           int row = table.getSelectedRow();
           if (row == -1) {
               JOptionPane.showMessageDialog(this,"Please select a vehicle first.", "No Selection", JOptionPane.WARNING_MESSAGE);
               return;
           }
            String plate = (String)model.getValueAt(row, 0);
            String name = (String)model.getValueAt(row, 1);
            String rate = (String)model.getValueAt(row, 3);
            
                new Booking(name, plate, rate, row, model);
           });
        
        add(lblce);
        add(spane);
        add(btndetails);
        add(btnbook);
        add(btncancel);
        
        setVisible(true);
        
}
    
}
