package prevention;


import javax.swing.SwingUtilities;

public class Preventrun {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookingManager manager = new BookingManager();
            BookingUI ui = new BookingUI(manager);
            ui.setVisible(true);
        });
    }
}
