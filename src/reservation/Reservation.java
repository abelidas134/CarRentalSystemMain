package reservation;

import carrentalsystemmain.FoundationFrame;
import javax.swing.*;
import java.awt.*;
import carrentalsystemmain.*;
import billing.*;
import vehicle.*;
import customers.*;

class ReservationDetailsFrame extends JPanel {

    JTextArea detailsArea;
    String rate, name, plate, customerName;
        
    public ReservationDetailsFrame(
            String details,
            String reservationNumber,
            String rate,
            String name,
            String plate,
            String customerName) {
            this.rate = rate;
            this.name = name;
            this.plate = plate;
            this.customerName = customerName;
            
            
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

        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 460, 120, 40);

        JButton closeButton = new JButton("Check Out");
        closeButton.setBounds(300, 460, 120, 40);

        closeButton.addActionListener(e -> {
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            Container background = mainFrame.getContentPane();
            background.remove(this);
            HomePageBilling ap
                    = new HomePageBilling(
                            reservationNumber,
                            rate,
                            name,
                            plate,
                            customerName
                    );
            ap.setBounds(550, 200, 1366, 768);
            background.add(ap);
            background.revalidate();
            background.repaint();
        });
        
        backButton.addActionListener(e -> {
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                Container background = mainFrame.getContentPane();

                background.remove(this);

                Reservation reservationPanel = new Reservation(rate,name, plate);
                reservationPanel.setBounds(450, 50, 1000, 600);

                background.add(reservationPanel);

                background.revalidate();
                background.repaint();
        
        });

        add(titleLabel);
        add(scrollPane);
        add(closeButton);
        add(backButton);

        setVisible(true);
    }
}

public class Reservation extends JPanel {

    static int reservationCounter = 1001;

    JTextField nameField, contactField, emailField, licenseField, addressField;
    JLabel statusLabel;
    private String rate, name, plate, customerName;
    public Reservation(String rate,String name, String plate) {
        this.rate = rate;
        this.name = name;
        this.plate = plate;
        setBounds(450,50,1000, 600);

        setLayout(null);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(5, 475, 180, 40);
        add(backBtn);
        
    backBtn.addActionListener(e -> {
        JFrame current = (JFrame) SwingUtilities.getWindowAncestor(this);
        current.dispose();

        FoundationFrame ff = new FoundationFrame(new Vehicle());
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

        JLabel addressLabel = new JLabel("House Address(Optional)");
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
        this.customerName = name;
        String contact = contactField.getText();
        String email = emailField.getText();
        String licensenum = licenseField.getText();
        String address = addressField.getText();
        
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
        
        CustomerForm.addCustomer(
               reservationCounter - 1,
               name,
               contact,
               licensenum,
               address
       );

        String details =
                "RESERVATION DETAILS\n\n"
                + "Reservation ID     : " + reservationNumber + "\n\n"
                + "Customer Name      : " + name + "\n\n"
                + "Contact Number     : " + contact + "\n\n"
                + "Email Address      : " + email + "\n\n"
                + "Driver's Address   : " + address + "\n\n"
                + "Driver's License Number  : " + licensenum + "\n\n";

        JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
       Container background = mainFrame.getContentPane();

       background.remove(this);

       ReservationDetailsFrame rdf
               = new ReservationDetailsFrame(
                       details,
                       reservationNumber,
                       this.rate,
                       this.name,
                       this.plate,
                       this.customerName
               );
       rdf.setBounds(600, 25, 600, 600);

       background.add(rdf);

       background.revalidate();
       background.repaint();

        statusLabel.setText("Reservation Successful!");

        nameField.setText("");
        contactField.setText("");
        licenseField.setText("");
        System.out.println("Vehicle Name = " + this.name);
System.out.println("Customer Name = " + this.customerName);
    }
}
