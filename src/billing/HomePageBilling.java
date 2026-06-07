/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package billing;

import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import reservation.*;
/**
 *
 * @author Mickey
 */
public class HomePageBilling extends JPanel implements ActionListener {
    private JLabel lblPage,lblResNo;
    private JTextField txtResNo;
    private JButton btnEnter;
    private String reservationNumber,rate, name, plate;
    
    public HomePageBilling (String reservationNumber, String rate, String name, String plate){
        this.reservationNumber = reservationNumber;
        this.rate = rate;
        this.name = name;
        this.plate = plate;
        
        setBounds(600,100,600,600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
        
        lblPage = new JLabel ("PAYMENT PORTAL");
        lblPage.setBounds(220,75,200,100);
        lblPage.setFont(new Font("Poppins",Font.BOLD,20));
        add(lblPage);
        
        lblResNo = new JLabel ("RESERVATION NUMBER: ");
        lblResNo.setBounds(100,150,200,100);
        lblResNo.setFont(new Font("Poppins",Font.BOLD,15));
        add(lblResNo);
        
        txtResNo = new JTextField ();
        txtResNo.setBounds(300,175,200,40);
        add(txtResNo);
        
        btnEnter = new JButton ("ENTER");
        btnEnter.setBounds(225,270,175,50);
        btnEnter.setFont(new Font("Poppins",Font.BOLD,15));
        btnEnter.setForeground(Color.WHITE);
        btnEnter.setBackground(darkAzure);
        btnEnter.setOpaque(true);
        btnEnter.setFocusPainted(false);
        add(btnEnter);
        
        btnEnter.addActionListener(this);
        
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("OptionPane.messageFont",new Font("Poppins", Font.BOLD, 14));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnter) {

            String resNoText = txtResNo.getText().trim();

            if (resNoText == null || resNoText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a reservation number!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (resNoText.equals(reservationNumber)) {
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                Container background = mainFrame.getContentPane();
                background.remove(this);
                bill ap = new bill(reservationNumber, rate, name, plate);
                ap.setBounds(550, 200, 1366, 768);
                background.add(ap);
                background.revalidate();
                background.repaint();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Reservation number is not recorded. Try again!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
