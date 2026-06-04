/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystemmain;

import customers.CustomerForm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
public class FoundationFrame extends JFrame{
    private JButton btnBack, btnRecords, btnMaintenance;
    
    public FoundationFrame(JPanel panel, int x, int y, int w, int h) {
        setSize(1366, 768);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel background = new JLabel(
                new ImageIcon(
                        CarRentalSystemMain.class.getResource("/img/3rdBG.jpg")
                )
        );

        background.setLayout(null);

        panel.setBounds(600, 100, 550, 600);
        panel.setOpaque(false);

        background.add(panel);

        setContentPane(background);

        setVisible(true);
    }
    
}
