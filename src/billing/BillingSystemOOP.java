package billing;

import javax.swing.*;
import java.awt.*;

public class BillingSystemOOP extends JPanel  {

    private JTextField txtReservation, txtPickDay, txtDropDay;
    private JComboBox<String> cbPickMonth, cbDropMonth;
    private JTextArea txtInvoice;
    private JButton btnCalculate;

    public BillingSystemOOP() {
        setBounds(400,100,700,600);
        setLayout(null);

        JLabel lblRes = new JLabel("Reservation No:");
        lblRes.setBounds(50,50,120,25);
        add(lblRes);

        txtReservation = new JTextField();
        txtReservation.setBounds(180,50,150,25);
        add(txtReservation);

        String[] months = {
            "January","February","March","April",
            "May","June","July","August",
            "September","October","November","December"
        };

        JLabel lblPickMonth = new JLabel("Pick-up Month:");
        lblPickMonth.setBounds(50,100,120,25);
        add(lblPickMonth);

        cbPickMonth = new JComboBox<>(months);
        cbPickMonth.setBounds(180,100,150,25);
        add(cbPickMonth);

        JLabel lblPickDay = new JLabel("Pick-up Day:");
        lblPickDay.setBounds(50,140,120,25);
        add(lblPickDay);

        txtPickDay = new JTextField();
        txtPickDay.setBounds(180,140,150,25);
        add(txtPickDay);

        JLabel lblDropMonth = new JLabel("Drop-off Month:");
        lblDropMonth.setBounds(50,190,120,25);
        add(lblDropMonth);

        cbDropMonth = new JComboBox<>(months);
        cbDropMonth.setBounds(180,190,150,25);
        add(cbDropMonth);

        JLabel lblDropDay = new JLabel("Drop-off Day:");
        lblDropDay.setBounds(50,230,120,25);
        add(lblDropDay);

        txtDropDay = new JTextField();
        txtDropDay.setBounds(180,230,150,25);
        add(txtDropDay);

        btnCalculate = new JButton("Generate Invoice");
        btnCalculate.setBounds(180,280,180,35);
        add(btnCalculate);

        txtInvoice = new JTextArea();
        txtInvoice.setEditable(false);

        JScrollPane sp = new JScrollPane(txtInvoice);
        sp.setBounds(50,340,580,180);
        add(sp);

        btnCalculate.addActionListener(e -> generateBill());

        setVisible(true);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("OptionPane.messageFont",new Font("Poppins", Font.BOLD, 14));
    }

    private void generateBill() {

        try {

            String reservationNo = txtReservation.getText();

            int pickDay = Integer.parseInt(txtPickDay.getText());
            int dropDay = Integer.parseInt(txtDropDay.getText());

            int daysRented = dropDay - pickDay + 1;

            int ratePerDay = 2000;
            int cleaningFee = 400;
            double damageFee = ratePerDay * 0.50;

            double subtotal =
                    (daysRented * ratePerDay)
                    + cleaningFee
                    + damageFee;

            double tax = subtotal * 0.12;
            double total = subtotal + tax;

            txtInvoice.setText(
                    "CAR RENTAL INVOICE\n\n" +
                    "Reservation #: " + reservationNo + "\n\n" +
                    "Days Rented: " + daysRented + "\n\n" +
                    "Rental Cost: ₱" + (daysRented * ratePerDay) + "\n" +
                    "Cleaning Fee: ₱" + cleaningFee + "\n" +
                    "Damage Fee: ₱" + damageFee + "\n" +
                    "Tax: ₱" + String.format("%.2f", tax) + "\n\n" +
                    "TOTAL: ₱" + String.format("%.2f", total)
            );

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid values."
            );
        }
    }
}