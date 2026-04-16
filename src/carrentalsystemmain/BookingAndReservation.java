package carrentalsystemmain;

import javax.swing.*;
import java.awt.*;

class CarRentalSystemGUI extends JFrame {

    static String[] customerNames = new String[10];
    static String[] carModels = new String[10];
    static int count = 0;

    JTextField nameField, carField;
    JTextArea displayArea;

    public CarRentalSystemGUI() {

        setTitle("Car Rental System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Customer Name:");
        nameField = new JTextField(20);

        JLabel carLabel = new JLabel("Car Model:");
        carField = new JTextField(20);

        JButton rentButton = new JButton("Rent Car");
        JButton viewButton = new JButton("View Rentals");

        displayArea = new JTextArea(12, 40);
        displayArea.setEditable(false);

        add(nameLabel);
        add(nameField);
        add(carLabel);
        add(carField);
        add(rentButton);
        add(viewButton);
        add(new JScrollPane(displayArea));

        rentButton.addActionListener(e -> rentCar());
        viewButton.addActionListener(e -> viewRentals());

        setVisible(true);
    }

    void rentCar() {

        if (count >= 10) {
            JOptionPane.showMessageDialog(this, "Rental list is full!");
            return;
        }

        String name = nameField.getText();
        String car = carField.getText();

        if (name.isEmpty() || car.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        customerNames[count] = name;
        carModels[count] = car;
        count++;

        JOptionPane.showMessageDialog(this, "Car rental successful!");

        nameField.setText("");
        carField.setText("");
    }

    void viewRentals() {

        displayArea.setText("");

        if (count == 0) {
            displayArea.setText("No rentals found.");
            return;
        }

        displayArea.append("=== RENTAL LIST ===\n");

        for (int i = 0; i < count; i++) {
            displayArea.append("Customer: " + customerNames[i]
                    + " | Car: " + carModels[i] + "\n");
        }
    }
}

public class BookingAndReservation {

    public static void main(String[] args) {
        new CarRentalSystemGUI();
    }
}