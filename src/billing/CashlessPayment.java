package billing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CashlessPayment extends JPanel implements ActionListener {

    private JPanel panelBill, panelMenu;
    private JLabel lblMode;
    private JButton btnCard, btnQR;

    public CashlessPayment() {

        setBounds(600,100,600,600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
        
        panelBill = new JPanel();
        panelBill.setLayout(null);
        panelBill.setBounds(200,20,200,40);
        panelBill.setBorder(BorderFactory.createEtchedBorder());
        panelBill.setBackground(Color.WHITE);
        add(panelBill);

        lblMode = new JLabel("CASHLESS PAYMENT");
        lblMode.setBounds(20,0,200,40);
        panelBill.add(lblMode);

        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(75,100,450,400);
        panelMenu.setBorder(BorderFactory.createEtchedBorder());
        panelMenu.setBackground(Color.WHITE);
        add(panelMenu);

        btnCard = new JButton("CARD");
        btnCard.setBounds(125,120,200,50);
        panelMenu.add(btnCard);

        btnQR = new JButton("QR CODE");
        btnQR.setBounds(125,220,200,50);
        panelMenu.add(btnQR);

        btnCard.addActionListener(this);
        btnQR.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnCard){
            JOptionPane.showMessageDialog(this,
                    "Card Payment Successful!");
        }

        else if(e.getSource() == btnQR){
            JOptionPane.showMessageDialog(this,
                    "Scan QR Code to complete payment.");
        }
    }
}