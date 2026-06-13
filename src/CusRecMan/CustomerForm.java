package CusRecMan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerForm extends JFrame implements Searchable {

    private JTable table;
    private DefaultTableModel model;

    public CustomerForm() {

        setTitle("Car Rental System");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblTitle = new JLabel("CUSTOMER MANAGEMENT");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(160, 10, 300, 25);
        add(lblTitle);

        JTextField txtSearch = new JTextField();
        txtSearch.setBounds(20, 45, 380, 25);
        add(txtSearch);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(410, 45, 150, 25);
        add(btnSearch);

        btnSearch.addActionListener(e -> {
            search(txtSearch.getText().trim());
        });

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Phone", "Driver's License", "Address"}, 0);

        table = new JTable(model);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 80, 550, 280);
        add(scrollPane);

        JButton btnView = new JButton("View");
        btnView.setBounds(40, 420, 100, 40);
        add(btnView);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(170, 420, 100, 40);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(300, 420, 100, 40);
        add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(430, 420, 100, 40);
        add(btnBack);

        //validation for buttons
        btnView.addActionListener(e -> {
            int row = getSelectedRow();
            if (row == -1) return;

            JOptionPane.showMessageDialog(this,
                    "ID: " + model.getValueAt(row, 0) +
                    "\nName: " + model.getValueAt(row, 1) +
                    "\nPhone: " + model.getValueAt(row, 2) +
                    "\nLicense: " + model.getValueAt(row, 3) +
                    "\nAddress: " + model.getValueAt(row, 4));
        });

        btnUpdate.addActionListener(e -> {
            int row = getSelectedRow();
            if (row == -1) return;

            JOptionPane.showMessageDialog(this,
                    "Update customer ID: " + model.getValueAt(row, 0));
        });

        btnDelete.addActionListener(e -> {
            int row = getSelectedRow();
            if (row == -1) return;

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Delete this customer?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                model.removeRow(row);

                JOptionPane.showMessageDialog(this,
                        "Customer deleted.");
            }
        });

        btnBack.addActionListener(e -> {
            new HomePage().setVisible(true);
            dispose();
        }); 
    }
    
    @Override
    public void search(String keyword) {

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter ID or Name to search.");
            return;
        }

        //Databae placeholder
        JOptionPane.showMessageDialog(this,
                "Searching for: " + keyword);
    }

    //Validation
    private int getSelectedRow() {

        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select a customer first.");
        }

        return row;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}