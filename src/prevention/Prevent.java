package prevention;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Prevent extends JFrame {

    static class Booking {
        final String id;
        final String car;
        final String customer;
        final LocalDate from;
        final LocalDate to;

        Booking(String id, String car, String customer, LocalDate from, LocalDate to) {
            this.id = id; this.car = car; this.customer = customer;
            this.from = from; this.to = to;
        }

        boolean conflictsWith(String otherCar, LocalDate otherFrom, LocalDate otherTo) {
            if (!this.car.equals(otherCar)) return false;
            return !otherTo.isBefore(this.from) && !otherFrom.isAfter(this.to);
        }

        String[] toRow() {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, yyyy");
            return new String[]{id, car, customer, from.format(fmt), to.format(fmt)};
        }
    }

    private final List<Booking> bookings = new ArrayList<>();
    private int nextId = 1;

    private final String[] CARS = {
        "Toyota Vios – KO3AN0",
        "Honda City – H3KAO9",
        "Ford Ranger – GW3H5D",
        "Nissan Altima – 1SN4US",
        "Hyundai Elantra – GSV4U8"
    };

    private JComboBox<String> carCombo;
    private JTextField customerField;
    private JSpinner fromSpinner, toSpinner;
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel statusLabel;

    public Prevent() {
        setTitle("Car Rental – Double Booking Prevention");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        buildHeader();
        buildForm();
        buildTable();

        addBookingDirect("Toyota Vios – KO3AN0",  "Maria Santos",   LocalDate.now().plusDays(1), LocalDate.now().plusDays(4));
        addBookingDirect("Honda City – H3KAO9",    "Juan dela Cruz", LocalDate.now().plusDays(3), LocalDate.now().plusDays(7));
    }

    private void buildHeader() {
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1000, 60);
        header.setBackground(new Color(30, 30, 40));

        JLabel title = new JLabel("Car Rental Booking");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(24, 8, 400, 26);

        JLabel sub = new JLabel("Double-booking prevention system");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        sub.setForeground(new Color(160, 160, 180));
        sub.setBounds(24, 34, 400, 18);

        header.add(title);
        header.add(sub);
        add(header);
    }

    private void buildForm() {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(20, 80, 300, 660);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 225), 1));

        JButton backBtn = new JButton("Back");
        styleButton(backBtn, new Color(100, 100, 120), Color.WHITE);
        backBtn.setBounds(16, 440, 268, 34);
        backBtn.addActionListener(e -> {dispose();});
        card.add(backBtn);
        
        JLabel secLabel = new JLabel("New Booking");
        secLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        secLabel.setForeground(new Color(30, 30, 50));
        secLabel.setBounds(16, 16, 268, 22);
        card.add(secLabel);

        // Vehicle
        JLabel vehicleLbl = new JLabel("Vehicle");
        vehicleLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        vehicleLbl.setForeground(new Color(100, 100, 120));
        vehicleLbl.setBounds(16, 54, 268, 16);
        card.add(vehicleLbl);

        carCombo = new JComboBox<>(CARS);
        carCombo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        carCombo.setBounds(16, 72, 268, 30);
        card.add(carCombo);

        // Customer Name
        JLabel custLbl = new JLabel("Customer Name");
        custLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        custLbl.setForeground(new Color(100, 100, 120));
        custLbl.setBounds(16, 118, 268, 16);
        card.add(custLbl);

        customerField = new JTextField();
        customerField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        customerField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(210, 210, 220), 1),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        customerField.setBounds(16, 136, 268, 30);
        card.add(customerField);

        // From Date
        JLabel fromLbl = new JLabel("From Date");
        fromLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        fromLbl.setForeground(new Color(100, 100, 120));
        fromLbl.setBounds(16, 182, 268, 16);
        card.add(fromLbl);

        fromSpinner = dateSpinner(LocalDate.now());
        fromSpinner.setBounds(16, 200, 268, 30);
        card.add(fromSpinner);

        // To Date
        JLabel toLbl = new JLabel("To Date");
        toLbl.setFont(new Font("SansSerif", Font.PLAIN, 12));
        toLbl.setForeground(new Color(100, 100, 120));
        toLbl.setBounds(16, 246, 268, 16);
        card.add(toLbl);

        toSpinner = dateSpinner(LocalDate.now().plusDays(1));
        toSpinner.setBounds(16, 264, 268, 30);
        card.add(toSpinner);

        // Status label
        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusLabel.setBounds(16, 308, 268, 32);
        card.add(statusLabel);

        // Check Availability button
        JButton checkBtn = new JButton("Check Availability");
        styleButton(checkBtn, new Color(60, 100, 200), Color.WHITE);
        checkBtn.setBounds(16, 348, 128, 34);
        checkBtn.addActionListener(e -> checkAvailability());
        card.add(checkBtn);

        // Book button
        JButton bookBtn = new JButton("Book");
        styleButton(bookBtn, new Color(34, 160, 100), Color.WHITE);
        bookBtn.setBounds(152, 348, 132, 34);
        bookBtn.addActionListener(e -> submitBooking());
        card.add(bookBtn);

        // Cancel Selected Booking button
        JButton cancelBtn = new JButton("Cancel Selected Booking");
        styleButton(cancelBtn, new Color(200, 60, 60), Color.WHITE);
        cancelBtn.setBounds(16, 394, 268, 34);
        cancelBtn.addActionListener(e -> cancelSelected());
        card.add(cancelBtn);

        add(card);
    }

    private void buildTable() {
        JLabel heading = new JLabel("Active Bookings");
        heading.setFont(new Font("SansSerif", Font.BOLD, 15));
        heading.setForeground(new Color(40, 40, 60));
        heading.setBounds(340, 80, 300, 24);
        add(heading);

        String[] cols = {"ID", "Vehicle", "Customer", "From", "To"};
        tableModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        table = new JTable(tableModel);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(210, 225, 255));
        table.setSelectionForeground(new Color(20, 20, 60));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(240, 240, 245));
        table.getTableHeader().setForeground(new Color(80, 80, 100));
        table.getTableHeader().setBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(210, 210, 220)));
        table.setDefaultRenderer(Object.class, new StripedRenderer());

        int[] widths = {36, 190, 130, 110, 110};
        for (int i = 0; i < widths.length; i++)
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(340, 110, 635, 630);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 225), 1));
        scroll.getViewport().setBackground(Color.WHITE);

        add(scroll);
    }

    private List<Booking> findConflicts(String car, LocalDate from, LocalDate to) {
        List<Booking> conflicts = new ArrayList<>();
        for (Booking b : bookings)
            if (b.conflictsWith(car, from, to))
                conflicts.add(b);
        return conflicts;
    }

    private void checkAvailability() {
        String car     = (String) carCombo.getSelectedItem();
        LocalDate from = spinnerDate(fromSpinner);
        LocalDate to   = spinnerDate(toSpinner);
        if (!validateDates(from, to)) return;

        List<Booking> conflicts = findConflicts(car, from, to);
        if (conflicts.isEmpty()) {
            setStatus("Vehicle is available for those dates.", new Color(34, 160, 100));
        } else {
            StringBuilder sb = new StringBuilder("<html>Conflict with booking(s): ");
            for (Booking b : conflicts) sb.append("#").append(b.id).append(" ");
            sb.append("</html>");
            setStatus(sb.toString(), new Color(200, 60, 60));
        }
    }

    private void submitBooking() {
        String car      = (String) carCombo.getSelectedItem();
        String customer = customerField.getText().trim();
        LocalDate from  = spinnerDate(fromSpinner);
        LocalDate to    = spinnerDate(toSpinner);

        if (customer.isEmpty()) {
            setStatus("Please enter a customer name.", new Color(200, 130, 0));
            return;
        }
        if (!validateDates(from, to)) return;

        List<Booking> conflicts = findConflicts(car, from, to);
        if (!conflicts.isEmpty()) {
            StringBuilder msg = new StringBuilder("Cannot book — conflicts with:\n");
            for (Booking b : conflicts)
                msg.append("  • Booking #").append(b.id)
                   .append(" (").append(b.customer).append(")\n");
            JOptionPane.showMessageDialog(this, msg.toString(),
                "Double Booking Detected", JOptionPane.ERROR_MESSAGE);
            setStatus("Booking rejected — double booking prevented.", new Color(200, 60, 60));
            return;
        }

        addBookingDirect(car, customer, from, to);
        customerField.setText("");
        setStatus("Booking confirmed successfully!", new Color(34, 160, 100));
    }

    private void addBookingDirect(String car, String customer, LocalDate from, LocalDate to) {
        Booking b = new Booking(String.valueOf(nextId++), car, customer, from, to);
        bookings.add(b);
        tableModel.addRow(b.toRow());
    }

    private void cancelSelected() {
        int row = table.getSelectedRow();
        if (row < 0) {
            setStatus("Select a booking in the table first.", new Color(200, 130, 0));
            return;
        }
        String id = (String) tableModel.getValueAt(row, 0);
        bookings.removeIf(b -> b.id.equals(id));
        tableModel.removeRow(row);
        setStatus("Booking #" + id + " cancelled.", new Color(100, 100, 120));
    }

    private boolean validateDates(LocalDate from, LocalDate to) {
        if (!to.isAfter(from)) {
            setStatus("Return date must be after pickup date.", new Color(200, 130, 0));
            return false;
        }
        if (from.isBefore(LocalDate.now())) {
            setStatus("Pickup date cannot be in the past.", new Color(200, 130, 0));
            return false;
        }
        return true;
    }

    private void setStatus(String msg, Color color) {
        statusLabel.setText("<html>" + msg + "</html>");
        statusLabel.setForeground(color);
    }

    private LocalDate spinnerDate(JSpinner spinner) {
        return ((SpinnerDateModel) spinner.getModel())
               .getDate().toInstant()
               .atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private JSpinner dateSpinner(LocalDate initial) {
        Date date = Date.from(initial.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SpinnerDateModel model = new SpinnerDateModel(date, null, null, Calendar.DAY_OF_MONTH);
        JSpinner spinner = new JSpinner(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "MMM dd, yyyy"));
        return spinner;
    }

    private void styleButton(JButton btn, Color bg, Color fg) {
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
    }

    static class StripedRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(
                JTable t, Object val, boolean sel, boolean focus, int row, int col) {
            super.getTableCellRendererComponent(t, val, sel, focus, row, col);
            setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            if (!sel) setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 248, 252));
            return this;
        }
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new Prevent().setVisible(true));
    }
}