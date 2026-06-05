package reservation;

import carrentalsystemmain.FoundationFrame;
import javax.swing.*;
import java.awt.*;
import carrentalsystemmain.*;

class ReservationDetailsFrame extends JPanel {

    JTextArea detailsArea;

    ReservationDetailsFrame(String details) {


   
        setBounds(400,25,600, 600);

        setLayout(null);

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

        closeButton.addActionListener(e -> {
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            Container background = mainFrame.getContentPane();
            background.remove(this);
            CustomerOption ap = new CustomerOption();
            ap.setBounds(875, 175, 1366, 768);
            background.add(ap);
            background.revalidate();
            background.repaint();
        });

        add(titleLabel);
        add(scrollPane);
        add(closeButton);

        setVisible(true);
    }
}

public class CarRentalSystemGUI extends JPanel {

    static int reservationCounter = 1001;

    JTextField nameField, contactField, emailField, licenseField, addressField;
    JLabel statusLabel;

    public CarRentalSystemGUI() {


   
        setBounds(450,50,1000, 600);

        setLayout(null);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(5, 475, 180, 40);
        add(backBtn);
        
    backBtn.addActionListener(e -> {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        currentFrame.dispose();

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(1366, 768);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel background = new JLabel(new ImageIcon(CarRentalSystemMain.class.getResource("/img/firstBG.png")));
        background.setLayout(null);
        CustomerOption ap = new CustomerOption();
        ap.setBounds(950, 150, 1366, 768);
        background.add(ap);
        mainFrame.setContentPane(background);
        mainFrame.setVisible(true);
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
        reserveButton.setBounds(475, 475, 180, 40);

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
