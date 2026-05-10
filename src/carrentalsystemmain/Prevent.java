package prevention;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.event.*;
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

        // double prevention
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
    private JLabel statusLabel;

    public Prevent() {
        setTitle("Car Rental – Double Booking Prevention");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setMinimumSize(new Dimension(720, 480));
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 247));
        setLayout(new BorderLayout(0, 0));

        add(buildHeader(), BorderLayout.NORTH);
        add(buildMain(),   BorderLayout.CENTER);

        // My Demo reservation
        addBookingDirect("Toyota Vios – KO3AN0",  "Maria Santos",  LocalDate.now().plusDays(1),  LocalDate.now().plusDays(4));
        addBookingDirect("Honda City – H3KAO9",   "Juan dela Cruz", LocalDate.now().plusDays(3), LocalDate.now().plusDays(7));
    }

    // Header 
    private JPanel buildHeader() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(new Color(30, 30, 40));
        p.setBorder(BorderFactory.createEmptyBorder(18, 24, 18, 24));

        JLabel title = new JLabel("Car Rental Booking");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(Color.WHITE);

        JLabel sub = new JLabel("Double-booking prevention system");
        sub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        sub.setForeground(new Color(160, 160, 180));

        JPanel text = new JPanel(new GridLayout(2, 1, 0, 2));
        text.setOpaque(false);
        text.add(title);
        text.add(sub);
        p.add(text, BorderLayout.WEST);
        return p;
    }

    // Main 
    private JSplitPane buildMain() {
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buildForm(), buildTable());
        split.setDividerLocation(320);
        split.setDividerSize(6);
        split.setBorder(null);
        split.setBackground(new Color(245, 245, 247));
        return split;
    }

    // Booking form 
    private JPanel buildForm() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(new Color(245, 245, 247));
        wrapper.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 225), 1, true),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        card.add(sectionLabel("New Booking"));
        card.add(Box.createVerticalStrut(16));

        // Car selection and car information
        card.add(fieldLabel("Vehicle"));
        card.add(Box.createVerticalStrut(4));
        carCombo = new JComboBox<>(CARS);
        styleCombo(carCombo);
        card.add(carCombo);
        card.add(Box.createVerticalStrut(14));

        // Customer info
        card.add(fieldLabel("Customer Name"));
        card.add(Box.createVerticalStrut(4));
        customerField = new JTextField();
        styleField(customerField);
        card.add(customerField);
        card.add(Box.createVerticalStrut(14));

        // From date or date of pick up
        card.add(fieldLabel("From Date"));
        card.add(Box.createVerticalStrut(4));
        fromSpinner = dateSpinner(LocalDate.now());
        card.add(fromSpinner);
        card.add(Box.createVerticalStrut(14));

        // To date ot till when 
        card.add(fieldLabel("To Date"));
        card.add(Box.createVerticalStrut(4));
        toSpinner = dateSpinner(LocalDate.now().plusDays(1));
        card.add(toSpinner);
        card.add(Box.createVerticalStrut(20));

        // Status label
        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusLabel.setAlignmentX(LEFT_ALIGNMENT);
        card.add(statusLabel);
        card.add(Box.createVerticalStrut(10));

        // Buttons
        JPanel btnRow = new JPanel(new GridLayout(1, 2, 8, 0));
        btnRow.setOpaque(false);
        btnRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        btnRow.setAlignmentX(LEFT_ALIGNMENT);

        JButton checkBtn = new JButton("Check Availability");
        styleButton(checkBtn, new Color(60, 100, 200), Color.BLACK);
        checkBtn.addActionListener(e -> checkAvailability());

        JButton bookBtn = new JButton("Book");
        styleButton(bookBtn, new Color(34, 160, 100), Color.BLACK);
        bookBtn.addActionListener(e -> submitBooking());

        btnRow.add(checkBtn);
        btnRow.add(bookBtn);
        card.add(btnRow);

        // Cancel button (
        card.add(Box.createVerticalStrut(10));
        JButton cancelBtn = new JButton("Cancel Selected Booking");
        styleButton(cancelBtn, new Color(200, 60, 60), Color.BLACK);
        cancelBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));
        cancelBtn.setAlignmentX(LEFT_ALIGNMENT);
        cancelBtn.addActionListener(e -> cancelSelected());
        card.add(cancelBtn);

        wrapper.add(card, BorderLayout.CENTER);
        return wrapper;
    }

    
    private JPanel buildTable() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(new Color(245, 245, 247));
        wrapper.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        String[] cols = {"ID", "Vehicle", "Customer", "From", "To"};
        tableModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        JTable table = new JTable(tableModel);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setSelectionBackground(new Color(210, 225, 255));
        table.setSelectionForeground(new Color(20, 20, 60));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(240, 240, 245));
        table.getTableHeader().setForeground(new Color(80, 80, 100));
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(210, 210, 220)));
        table.setDefaultRenderer(Object.class, new StripedRenderer());

        int[] widths = {40, 200, 130, 110, 110};
        for (int i = 0; i < widths.length; i++)
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 225), 1));
        scroll.getViewport().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Active Bookings");
        heading.setFont(new Font("SansSerif", Font.BOLD, 15));
        heading.setForeground(new Color(40, 40, 60));
        heading.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        wrapper.add(heading, BorderLayout.NORTH);
        wrapper.add(scroll,  BorderLayout.CENTER);
        return wrapper;
    }

    private List<Booking> findConflicts(String car, LocalDate from, LocalDate to) {
        List<Booking> conflicts = new ArrayList<>();
        for (Booking b : bookings)
            if (b.conflictsWith(car, from, to))
                conflicts.add(b);
        return conflicts;
    }

    private void checkAvailability() {
        String car = (String) carCombo.getSelectedItem();
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
        // find selected row in table — we need to match to the backing list by ID
        Component c = ((JSplitPane) getContentPane().getComponent(1)).getRightComponent();
        JScrollPane scroll = (JScrollPane) ((JPanel) c).getComponent(1);
        JTable table = (JTable) scroll.getViewport().getView();

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
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "MMM dd, yyyy");
        spinner.setEditor(editor);
        spinner.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        spinner.setAlignmentX(LEFT_ALIGNMENT);
        return spinner;
    }

    private JLabel sectionLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.BOLD, 15));
        l.setForeground(new Color(30, 30, 50));
        l.setAlignmentX(LEFT_ALIGNMENT);
        return l;
    }

    private JLabel fieldLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("SansSerif", Font.PLAIN, 12));
        l.setForeground(new Color(100, 100, 120));
        l.setAlignmentX(LEFT_ALIGNMENT);
        return l;
    }

    private void styleField(JTextField field) {
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        field.setAlignmentX(LEFT_ALIGNMENT);
        field.setFont(new Font("SansSerif", Font.PLAIN, 13));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(210, 210, 220), 1, true),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
    }

    private void styleCombo(JComboBox combo) {
        combo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        combo.setAlignmentX(LEFT_ALIGNMENT);
        combo.setFont(new Font("SansSerif", Font.PLAIN, 13));
    }

    private void styleButton(JButton btn, Color bg, Color fg) {
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
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
}

   
