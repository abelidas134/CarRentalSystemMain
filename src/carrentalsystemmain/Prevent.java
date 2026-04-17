package prevention;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Prevent {
    String customerName;
    String carModel;
    String date;   
    String time;   

    Prevent(String customerName, String carModel, String date, String time) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.date = date;
        this.time = time;
    }
}

class BookingManager {
    private List<Prevent> bookings = new ArrayList<>();

    public BookingManager() {
       // Mga Bookings na ilalabas Imnida
        bookings.add(new Prevent("Alice", "Toyota Corolla", "2026-03-18", "09:00"));
        bookings.add(new Prevent("Bob", "Honda Civic", "2026-03-18", "10:00"));
        bookings.add(new Prevent("Charlie", "Ford Focus", "2026-03-18", "11:00"));
        bookings.add(new Prevent("Diana", "Mazda 3", "2026-03-18", "13:00"));
        bookings.add(new Prevent("Ethan", "Nissan Altima", "2026-03-18", "14:00"));
    }

    public boolean addBooking(String name, String car, String date, String time) {
        for (Prevent b : bookings) {
            if (b.carModel.equals(car) && b.date.equals(date) && b.time.equals(time)) {
                return false; 
            }
        }
        bookings.add(new Prevent(name, car, date, time));
        return true;
    }

    public List<Prevent> getBookings() {
        return bookings;
    }
}

class BookingUI extends JFrame {
    private BookingManager manager;
    private JTextField nameField = new JTextField(10);
    private JTextField dateField = new JTextField("2026-03-18", 10); 
    private JTextField timeField = new JTextField("09:00", 5);       
    private JComboBox<String> carBox = new JComboBox<>(new String[]{
        "Toyota Corolla", "Honda Civic", "Ford Focus", "Mazda 3", "Nissan Altima"
    });
    private JTextArea output = new JTextArea();

    BookingUI(BookingManager manager) {
        this.manager = manager;
        setTitle("Car Renting");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Car:"));
        panel.add(carBox);
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(new JLabel("Time (HH:mm):"));
        panel.add(timeField);

        JButton bookBtn = new JButton("Book");
        panel.add(bookBtn);
        add(panel, "North");

        output.setEditable(false);
        add(new JScrollPane(output), "Center");

// Initial Booking daw to sabi ko
        for (Prevent b : manager.getBookings()) {
            output.append(" booked " + b.customerName + " - " + b.carModel +
                          " on " + b.date + " at " + b.time + "\n");
        }

        bookBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String car = (String) carBox.getSelectedItem();
            String date = dateField.getText().trim();
            String time = timeField.getText().trim();

            if (name.isEmpty() || date.isEmpty() || time.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill in all fields!");
                return;
            }

            // eto para makapag add ng bookings
            if (manager.addBooking(name, car, date, time)) {
                output.append(" booked: " + name + " - " + car + " Date - " + date + " at " + time + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Someones Booking Still Existing Please Choose Another Booking");
            }
        });
    }
}
