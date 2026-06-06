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
    private JButton btnCash, btnCashless;
    
    
    Payment(){
        setBounds(400,100,600,600);
        setLayout(null);
        
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
        
        btnCash = new JButton("CASH");
        btnCash.setBounds(125, 120, 200, 50);
        panelMenu.add(btnCash);

        btnCashless = new JButton("CASHLESS");
        btnCashless.setBounds(125, 220, 200, 50);
        panelMenu.add(btnCashless);

        btnCash.addActionListener(this);
        btnCashless.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCash) {
            JOptionPane.showMessageDialog(this,
                    "Please proceed to the cashier.");
        } else if (e.getSource() == btnCashless) {
            CashlessPayment cp = new CashlessPayment();
            cp.setVisible(true);
        }
    }
    
}
