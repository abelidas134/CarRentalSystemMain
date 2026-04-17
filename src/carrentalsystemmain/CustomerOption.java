/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;

class CustomerOption extends JFrame implements ActionListener {
    private JButton btnBook, btnBack, btnVehicle,btnBill;
    CustomerOption (){
        setTitle("CUSTOMER OPTIONS");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        btnBook = new JButton("Book Now!");
        btnBook.setBounds(180, 210, 230, 50);
        add(btnBook);
        
        btnVehicle = new JButton("Available Vehicle");
        btnVehicle.setBounds(180, 275, 230, 50);
        add(btnVehicle);
        
        btnBill = new JButton("Payment");
        btnBill.setBounds(180, 340, 230, 50);
        add(btnBill);
        
        btnBack = new JButton ("Back");
        btnBack.setBounds(10,520,100,25);
        add(btnBack);
        
        btnBook.addActionListener(this);
        btnVehicle.addActionListener(this);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnBook){
            CarRentalSystemGUI book = new CarRentalSystemGUI();
            book.setVisible(true);
        } else if (e.getSource()==btnVehicle){
            //
        } else if (e.getSource()==btnBack){
            Homepage hp = new Homepage();
            hp.setVisible(true);
        }
    }
}
