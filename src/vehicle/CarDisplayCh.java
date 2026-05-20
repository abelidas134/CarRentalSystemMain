package vehicle;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import Services.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
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
                       
        String[] column = {"ID","Plate Number","Name", "Status", "Rate"};
        String[][] data = { 
            {"V001","KO3AN0","Toyota Vios", "AVAILABLE", "P200"},
            {"V002","H3KAO9", "Honda Civic", "AVAILABLE", "P230"},
            {"V003","GW3H5D","Ford Ranger", "AVAILABLE", "P330"},
            {"V004","1SN4US", "Nissan Altima", "AVAILABLE", "P280"},
            {"V005","GSV4U8", "Hyundai Elantra", "AVAILABLE", "P350"},
        };
        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);
        table.setRowHeight(35);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
          table.getColumnModel().getColumn(i).setCellRenderer(center);
       }

        JScrollPane spane = new JScrollPane(table);
        spane.setBounds(200, 150, 600, 200);
       
        JButton btndetails = new JButton("View Details");
        btndetails.setBounds(425, 400, 150, 40);
        JButton btnbook = new JButton("Book Vehicle");
        btnbook.setBounds(650, 400, 150, 40);
        JButton btncancel = new JButton("Cancel");
        btncancel.setBounds(200,400,150,40);
        JButton btnstaff = new JButton("Staff?");
        btnstaff.setBounds(800, 500, 150, 30);
        
        btncancel.addActionListener(e -> dispose());

        btndetails.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a vehicle first.", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String id = (String)model.getValueAt(row, 0);
            String plate = (String)model.getValueAt(row, 1);
            String name = (String)model.getValueAt(row, 2);
            String status = (String)model.getValueAt(row, 3);
            String rate = (String)model.getValueAt(row, 4);

                new CarDetails(id,name,status, rate, plate);
           });
       btnbook.addActionListener(e -> {
           int row = table.getSelectedRow();
           if (row == -1) {
               JOptionPane.showMessageDialog(this,"Please select a vehicle first.", "No Selection", JOptionPane.WARNING_MESSAGE);
               return;
           }
            String id = (String)model.getValueAt(row, 0);
            String plate = (String)model.getValueAt(row, 1);
            String name = (String)model.getValueAt(row, 2);
            String rate = (String)model.getValueAt(row, 4);
            
                new Booking(id,name, plate, rate, row, model);
           });
       
      btnstaff.addActionListener(e -> new Staff(model));
               
        add(lblce);
        add(spane);
        add(btndetails);
        add(btnbook);
        add(btncancel);
        add(btnstaff);
        
        setVisible(true);
        
}
    
}
