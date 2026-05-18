package carrentalsystemmain;

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

class CarRentalSystemGUI extends JFrame {

    static int reservationCounter = 1001;

    JTextField nameField;
    JTextField contactField;
    JTextField carField;
    JTextField daysField;

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


        JLabel titleLabel = new JLabel("BOOKING AND RESERVATION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setBounds(320, 30, 500, 40);

        JLabel nameLabel = new JLabel("Customer Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(220, 120, 180, 30);

        nameField = new JTextField();
        nameField.setBounds(420, 120, 300, 35);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contactLabel.setBounds(220, 190, 180, 30);

        contactField = new JTextField();
        contactField.setBounds(420, 190, 300, 35);

        JLabel carLabel = new JLabel("Car Model:");
        carLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        carLabel.setBounds(220, 260, 180, 30);

        carField = new JTextField();
        carField.setBounds(420, 260, 300, 35);

        JLabel daysLabel = new JLabel("Rental Days:");
        daysLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        daysLabel.setBounds(220, 330, 180, 30);

        daysField = new JTextField();
        daysField.setBounds(420, 330, 300, 35);

        JButton reserveButton = new JButton("Reserve");
        reserveButton.setFont(new Font("Arial", Font.BOLD, 16));
        reserveButton.setBounds(420, 420, 160, 45);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 15));
        statusLabel.setBounds(390, 490, 300, 30);

        reserveButton.addActionListener(e -> reserveCar());

        add(titleLabel);

        add(nameLabel);
        add(nameField);

        add(contactLabel);
        add(contactField);

        add(carLabel);
        add(carField);

        add(daysLabel);
        add(daysField);

        add(reserveButton);

        add(statusLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

   public void reserveCar() {

        String name = nameField.getText();
        String contact = contactField.getText();
        String car = carField.getText();
        String days = daysField.getText();

        if (name.isEmpty() || contact.isEmpty()
                || car.isEmpty() || days.isEmpty()) {

            statusLabel.setText("Please fill in all fields!");
            return;
        }

        String reservationNumber = "CR-" + reservationCounter++;

        String details =
                "RESERVATION DETAILS\n\n"
                + "Reservation Number : " + reservationNumber + "\n\n"
                + "Customer Name      : " + name + "\n\n"
                + "Contact Number     : " + contact + "\n\n"
                + "Car Model          : " + car + "\n\n"
                + "Rental Days        : " + days + "\n\n"
                + "Reservation Status : RESERVED";

        new ReservationDetailsFrame(details);

        statusLabel.setText("Reservation Successful!");

        nameField.setText("");
        contactField.setText("");
        carField.setText("");
        daysField.setText("");
    }
}

public class BookingAndReservation {

    public static void main(String[] args) {

        new CarRentalSystemGUI();
    }
}