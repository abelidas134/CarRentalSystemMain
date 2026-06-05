/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;
import reservation.*;
import billing.*;
import java.awt.*;
import vehicle.*;
import reservation.*;
public class CustomerOption extends JPanel implements ActionListener {
    private JButton btnBook, btnBack, btnVehicle,btnBill;
    
    public CustomerOption (){
        setBounds(0,0,600, 600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);

        btnBook = new JButton("Book Now!");
        btnBook.setFont(new Font("Poppins",Font.BOLD,15));
        btnBook.setForeground(Color.WHITE);
        btnBook.setBackground(darkAzure);
        btnBook.setOpaque(true);
        btnBook.setFocusPainted(false);
        btnBook.setBounds(180, 210, 230, 50);
        add(btnBook);
        
        btnVehicle = new JButton("Available Vehicle");
        btnVehicle.setFont(new Font("Poppins",Font.BOLD,15));
        btnVehicle.setForeground(Color.WHITE);
        btnVehicle.setBackground(darkAzure);
        btnVehicle.setOpaque(true);
        btnVehicle.setFocusPainted(false);
        btnVehicle.setBounds(180, 275, 230, 50);
        add(btnVehicle);
        
        btnBill = new JButton("Payment");
        btnBill.setFont(new Font("Poppins",Font.BOLD,15));
        btnBill.setForeground(Color.WHITE);
        btnBill.setBackground(darkAzure);
        btnBill.setOpaque(true);
        btnBill.setFocusPainted(false);
        btnBill.setBounds(180, 340, 230, 50);
        add(btnBill);
        
        btnBack = new JButton ("Back");
        btnBack.setFont(new Font("Poppins",Font.BOLD,15));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(darkAzure);
        btnBack.setOpaque(true);
        btnBack.setFocusPainted(false);
        btnBack.setBounds(10,520,100,25);
        add(btnBack);
        
        btnBook.addActionListener(this);
        btnVehicle.addActionListener(this);
        btnBill.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnBook){
            JFrame current = (JFrame) SwingUtilities.getWindowAncestor(this);
            current.dispose();

            FoundationFrame ff = new FoundationFrame(new CarRentalSystemGUI());
        } else if (e.getSource()==btnVehicle){
            CarDisplayCh ch = new CarDisplayCh();
            ch.setVisible(true);
        } else if (e.getSource()==btnBill){
            HomePageBilling hpBill = new HomePageBilling();
            hpBill.setVisible(true);
        }else if (e.getSource()==btnBack){
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            Container background = mainFrame.getContentPane();
            background.remove(this);
            CustomerPage ap = new CustomerPage();
            ap.setBounds(950, 150, 1366, 768);
            background.add(ap);
            background.revalidate();
            background.repaint();
        }
    }
}
