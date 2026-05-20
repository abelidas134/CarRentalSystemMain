package prevention;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author sanch
 */
public class Preventrun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new Prevent().setVisible(true));
    }
}