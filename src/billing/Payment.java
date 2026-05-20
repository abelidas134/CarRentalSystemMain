/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
class Payment extends JFrame implements ActionListener{
    private JPanel panelBill,panelMenu;
    private JLabel lblMode;
    
    Payment(){
        setSize(600,600);
        setTitle("Billing System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panelBill = new JPanel ();
        panelBill.setLayout(null);
        panelBill.setBounds(200,20,200,40);
        add(panelBill);
        panelBill.setBorder(BorderFactory.createEtchedBorder());
        
        panelMenu = new JPanel ();
        panelMenu.setLayout(null);
        panelMenu.setBounds(75,100,450,400);
        add(panelMenu);
        panelMenu.setBorder(BorderFactory.createEtchedBorder());
        panelMenu.setBackground(Color.WHITE);
        
        lblMode = new JLabel ("MODE OF TRANSACTION");
        lblMode.setBounds(30,0,200,40);
        panelBill.add(lblMode);
        panelBill.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
