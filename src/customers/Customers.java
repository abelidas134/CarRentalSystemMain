package customers;

import billing.ResNumLog;
import carrentalsystemmain.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Customers extends JPanel implements Searchable {

    private JTable table;
    private DefaultTableModel model;

    public Customers() {

        setBounds(800,200,600,600);
        setLayout(null);
        
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

        sharedModel = model;
        for (CustomerMethods c : customerList) {
            model.addRow(new Object[]{c.getId(), c.getName(), c.getPhone(), c.getLicense(), c.getAddress()});
        }
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

            String currentId   = model.getValueAt(row, 0).toString();
            String currentName = model.getValueAt(row, 1).toString();
            String currentPhone = model.getValueAt(row, 2).toString();
            String currentLicense = model.getValueAt(row, 3).toString();
            String currentAddress = model.getValueAt(row, 4).toString();

            JTextField txtName    = new JTextField(currentName);
            JTextField txtPhone   = new JTextField(currentPhone);
            JTextField txtLicense = new JTextField(currentLicense);
            JTextField txtAddress = new JTextField(currentAddress);

            JPanel panel = new JPanel(new GridLayout(5, 2, 5, 8));
            panel.add(new JLabel("ID (non-editable):"));
            JTextField txtId = new JTextField(currentId);
            txtId.setEditable(false);
            txtId.setBackground(new Color(220, 220, 220));
            panel.add(txtId);
            panel.add(new JLabel("Name:"));
            panel.add(txtName);
            panel.add(new JLabel("Phone:"));
            panel.add(txtPhone);
            panel.add(new JLabel("Driver's License:"));
            panel.add(txtLicense);
            panel.add(new JLabel("Address:"));
            panel.add(txtAddress);

            int result = JOptionPane.showConfirmDialog(this, panel,
                    "Update Customer ID: " + currentId,
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String newName    = txtName.getText().trim();
                String newPhone   = txtPhone.getText().trim();
                String newLicense = txtLicense.getText().trim();
                String newAddress = txtAddress.getText().trim();

                if (newName.isEmpty() || newPhone.isEmpty() || newLicense.isEmpty() || newAddress.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Fields cannot be empty.", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                model.setValueAt(newName,    row, 1);
                model.setValueAt(newPhone,   row, 2);
                model.setValueAt(newLicense, row, 3);
                model.setValueAt(newAddress, row, 4);

                int id = Integer.parseInt(currentId);
                for (CustomerMethods c : customerList) {
                    if (c.getId() == id) {
                        c.setName(newName);
                        c.setPhone(newPhone);
                        c.setLicense(newLicense);
                        c.setAddress(newAddress);
                        break;
                    }
                }

                JOptionPane.showMessageDialog(this, "Customer updated successfully.");
            }
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
                int id = Integer.parseInt(model.getValueAt(row, 0).toString());
                customerList.removeIf(c -> c.getId() == id);
                model.removeRow(row);
                JOptionPane.showMessageDialog(this, "Customer deleted.");
            }
        });

        btnBack.addActionListener(e -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            currentFrame.dispose();
            
            JFrame mainFrame = new JFrame();
            mainFrame.setSize(1366, 768);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            JLabel background = new JLabel(new ImageIcon(Main.class.getResource("/img/firstBG.png")));
            background.setLayout(null);
            AdminOption ap = new AdminOption();
            ap.setBounds(1100, 250, 1366, 768);
            background.add(ap);
            mainFrame.setContentPane(background);
            mainFrame.setVisible(true);
        });
    }
    
    @Override
    public void search(String keyword) {
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter ID or Name to search.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            String id   = model.getValueAt(i, 0).toString();
            String name = model.getValueAt(i, 1).toString().toLowerCase();
            if (id.equals(keyword) || name.contains(keyword.toLowerCase())) {
                table.setRowSelectionInterval(i, i);
                table.scrollRectToVisible(table.getCellRect(i, 0, true));
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No customer found for: " + keyword);
        }
    }

    private int getSelectedRow() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer first.");
        }
        return row;
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return model; }

    public static java.util.ArrayList<CustomerMethods> customerList = new java.util.ArrayList<>();
    private static DefaultTableModel sharedModel;

    public static void addCustomer(int id, String name, String phone, String license, String address) {
        customerList.add(new CustomerMethods(id, name, phone, license, address));
        if (sharedModel != null) {
            sharedModel.addRow(new Object[]{id, name, phone, license, address});
        }
    }
}