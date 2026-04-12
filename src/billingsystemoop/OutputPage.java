/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billingsystemoop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
class OutputPage extends JFrame implements ActionListener{
    private JLabel lblPage;
    
    OutputPage(Integer daysTotal) {
        setSize(600,600);
        setTitle("Billing System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblPage = new JLabel ("PAYMENT PORTAL");
        lblPage.setBounds(250,25,200,100);
        add(lblPage);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
