/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystemmain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
public class FoundationFrame extends JFrame{
    private JButton btnBack, btnRecords, btnMaintenance;
    
    FoundationFrame(){
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Color darkAzure = new Color(0, 95, 115);
        
        ImageIcon bgIcon = new ImageIcon(CarRentalSystemMain.class.getResource("/img/secondBG.png"));
        JLabel background = new JLabel(bgIcon);
        background.setBounds(0, 0, 1366, 768);
        background.setLayout(null);
        add(background);
        
        AdminOption op = new AdminOption();
        op.setBounds(775, 150, 550, 600);
        op.setOpaque(false);
        background.add(op);
        
        
        setContentPane(background);
        
          setVisible(true);
    }
    
}
