/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystemmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
class HomePageBilling extends JFrame implements ActionListener {
    private JLabel lblPage,lblResNo;
    private JTextField txtResNo;
    private JButton btnEnter;
    
    HomePageBilling (){
        setSize(600,600);
        setTitle("Billing System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblPage = new JLabel ("PAYMENT PORTAL");
        lblPage.setBounds(230,75,200,100);
        add(lblPage);
        
        lblResNo = new JLabel ("RESERVATION NUMBER: ");
        lblResNo.setBounds(75,150,200,100);
        add(lblResNo);
        
        txtResNo = new JTextField ();
        txtResNo.setBounds(250,175,225,50);
        add(txtResNo);
        
        btnEnter = new JButton ("ENTER");
        btnEnter.setBounds(200,270,175,50);
        add(btnEnter);
        
        btnEnter.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnEnter){
            String resNoText = txtResNo.getText().trim();
            if (resNoText.matches("0000")){
                MonthPage mp = new MonthPage();
                mp.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Reservation number is not recorded. Try again!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
