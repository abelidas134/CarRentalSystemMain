package reservation;

import javax.swing.*;
import java.awt.*;

class ReservationDetailsFrame extends JFrame {

    JTextArea detailsArea;

    ReservationDetailsFrame(String details) {

        setTitle("Reservation Details");

   
        setSize(600, 600);

        setLayout(null);
        setResizable(false);

        JLabel titleLabel = new JLabel("RESERVATION DETAILS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(160, 30, 300, 30);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        detailsArea.setText(details);

        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBounds(70, 100, 450, 320);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(220, 460, 120, 40);

        closeButton.addActionListener(e -> dispose());

        add(titleLabel);
        add(scrollPane);
        add(closeButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

public class CarRentalSystemGUI extends JFrame {

    static int reservationCounter = 1001;

    JTextField nameField, contactField, emailField, licenseField, addressField;
    JLabel statusLabel;

    public CarRentalSystemGUI() {

        setTitle("Booking and Reservation");

   
        setSize(1000, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(20, 510, 100, 40);
        add(backBtn);
        
    backBtn.addActionListener(e -> {
    dispose(); 
    });

        JLabel titleLabel = new JLabel("BOOKING AND RESERVATION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(320, 30, 500, 40);

        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(150, 120, 250, 30);

         nameField = new JTextField();
        nameField.setBounds(420, 120, 300, 35);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contactLabel.setBounds(150, 190, 250, 30);

         contactField = new JTextField();
        contactField.setBounds(420, 190, 300, 35);

        JLabel emailLabel = new JLabel("Email Address (Optional)");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        emailLabel.setBounds(150, 260, 250, 30);

          emailField = new JTextField();
        emailField.setBounds(420, 260, 300, 35);

        JLabel licenseLabel = new JLabel("Driver's License Number");
        licenseLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        licenseLabel.setBounds(150, 330, 250, 30);

          licenseField = new JTextField();
        licenseField.setBounds(420, 330, 300, 35);

        JLabel addressLabel = new JLabel("Driver's Address(Optional)");
        addressLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        addressLabel.setBounds(150, 400, 250, 30);

         addressField = new JTextField();
        addressField.setBounds(420, 400, 300, 35);
        
        
        JButton reserveButton = new JButton("Reserve");
        reserveButton.setFont(new Font("Arial", Font.BOLD, 16));
        reserveButton.setBounds(420, 510, 160, 45);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 15));
        statusLabel.setBounds(420, 470, 300, 30);

        reserveButton.addActionListener(e -> reserveCar());

        add(titleLabel);

        add(nameLabel);
        add(nameField);

        add(contactLabel);
        add(contactField);

        add(licenseLabel);
        add(licenseField);

        add(emailLabel);
        add(emailField);

        add(addressLabel);
        add(addressField);
        
        
            
        add(reserveButton);

        add(statusLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

   public void reserveCar() {

        String name = nameField.getText();
        String contact = contactField.getText();
        String email = emailField.getText();
        String licensenum = licenseField.getText();
        String address = addressField.getName();

        if (name.isEmpty() || contact.isEmpty()
                || licensenum.isEmpty()) {

            statusLabel.setText("Please fill in the fields!");
            return;
        }
if (email == null || email.trim().isEmpty()) {
    email = "N/A";
}

if (address == null || address.trim().isEmpty()) {
    address = "N/A";
}
        String reservationNumber = "CR-" + reservationCounter++;

        String details =
                "RESERVATION DETAILS\n\n"
                + "Reservation Number : " + reservationNumber + "\n\n"
                + "Customer Name      : " + name + "\n\n"
                + "Contact Number     : " + contact + "\n\n"
                + "Email Address      : " + email + "\n\n"
                + "Driver's Address   : " + address + "\n\n"
                + "Driver's License Number  : " + licensenum + "\n\n"
                + "Reservation Status : RESERVED";

        new ReservationDetailsFrame(details);

        statusLabel.setText("Reservation Successful!");

        nameField.setText("");
        contactField.setText("");
        licenseField.setText("");
    }
}
