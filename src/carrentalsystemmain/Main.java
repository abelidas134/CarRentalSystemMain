

package carrentalsystemmain;
import java.awt.*;
import javax.swing.*;
import reservation.*;


public class Main {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame ();
        mainFrame.setSize(1366, 768);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
        JLabel background = new JLabel(new ImageIcon(Main.class.getResource("/img/firstBG.png")));
        background.setLayout(null);
        Homepage hp = new Homepage();
        hp.setBounds(775, 150, 1366, 768);
        hp.setOpaque(false);
        background.add(hp);
        
        mainFrame.setContentPane(background);

        mainFrame.setVisible(true);
        
    }
    
}