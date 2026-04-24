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
public class bill extends JFrame implements ActionListener {
    private JPanel panelBill,panelPick, panelDrop;
    private JLabel lblSec, lblPick, lblDrop,lblYear, lblMonth, lblDay;
    private JTextField txtYearPick, txtYearDrop;
    private JComboBox comboDayPick, comboDayDrop, comboMonthPick, comboMonthDrop;
    private String [] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December"};
    private JButton btnBack, btnContinue;
    private Integer[] feb28 = new Integer[28];
    private Integer[] feb29 = new Integer[29];
    private Integer[] month30 = new Integer[30];
    private Integer[] month31 = new Integer[31];
    
    {
        for (int i=0;i<feb28.length;i++) feb28[i]=i+1;
        for (int i=0;i<feb29.length;i++) feb29[i]=i+1;
        for (int i=0;i<month30.length;i++) month30[i]=i+1;
        for (int i=0;i<month31.length;i++) month31[i]=i+1;
    }
    
    
    bill(){
        setSize (600,600);
        setTitle("Date Details");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        panelBill = new JPanel ();
        panelBill.setLayout(null);
        panelBill.setBounds(220,10,125,40);
        add(panelBill);
        panelBill.setBorder(BorderFactory.createEtchedBorder());
        
        lblSec = new JLabel ("BILLING SYSTEM");
        lblSec.setBounds(10,0,125,40);
        panelBill.add(lblSec);
        panelBill.setBackground(Color.WHITE);
        
        lblSec = new JLabel ("Fill in the pick-up and drop-off details below.");
        lblSec.setBounds(165,30,500,75);
        add(lblSec);
        
        panelPick = new JPanel ();
        panelPick.setLayout(null);
        panelPick.setBounds(75,100,435,175);
        add(panelPick);
        panelPick.setBorder(BorderFactory.createEtchedBorder());
        panelPick.setBackground(Color.WHITE);

        lblPick = new JLabel ("PICK UP");
        lblPick.setBounds(50,25,100,100);
        panelPick.add(lblPick);
        
        lblYear = new JLabel ("Year:");
        lblYear.setBounds(200,0,100,75);
        panelPick.add(lblYear);
        
        txtYearPick = new JTextField ("   ");
        txtYearPick.setBounds(260,23,100,25);
        panelPick.add(txtYearPick);
        
        lblMonth = new JLabel ("Month:");
        lblMonth.setBounds(200,25,100,100);
        panelPick.add(lblMonth);
        
        comboMonthPick = new JComboBox (months);
        comboMonthPick.setBounds(260,65,100,25);
        panelPick.add(comboMonthPick);
        
        lblDay = new JLabel ("Day:");
        lblDay.setBounds(200,70,100,100);
        panelPick.add(lblDay);
        
        comboDayPick = new JComboBox (month31);
        comboDayPick.setBounds(260,110,100,25);
        panelPick.add(comboDayPick);
        
        panelDrop = new JPanel ();
        panelDrop.setLayout(null);
        panelDrop.setBounds(75,300,435,175);
        add(panelDrop);
        panelDrop.setBorder(BorderFactory.createEtchedBorder());
        panelDrop.setBackground(Color.WHITE);

        lblDrop = new JLabel ("DROP OFF");
        lblDrop.setBounds(50,25,100,100);
        panelDrop.add(lblDrop);
        
        lblYear = new JLabel ("Year:");
        lblYear.setBounds(200,0,100,75);
        panelDrop.add(lblYear);
        
        txtYearDrop = new JTextField ("   ");
        txtYearDrop.setBounds(260,23,100,25);
        panelDrop.add(txtYearDrop);
        
        lblMonth = new JLabel ("Month:");
        lblMonth.setBounds(200,25,100,100);
        panelDrop.add(lblMonth);
        
        comboMonthDrop = new JComboBox (months);
        comboMonthDrop.setBounds(260,65,100,25);
        panelDrop.add(comboMonthDrop);
        
        lblDay = new JLabel ("Day:");
        lblDay.setBounds(200,70,100,100);
        panelDrop.add(lblDay);
        
        comboDayDrop = new JComboBox (month31);
        comboDayDrop.setBounds(260,110,100,25);
        panelDrop.add(comboDayDrop);
        
        btnBack = new JButton ("Back");
        btnBack.setBounds(10,510,75,30);
        add(btnBack);
        
        btnContinue = new JButton ("Continue");
        btnContinue.setBounds(475,510,100,30);
        add(btnContinue);
        
        btnBack.addActionListener(this);
        btnContinue.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dayPickSelected = (int) comboDayPick.getSelectedItem();
        int dayDropSelected = (int) comboDayDrop.getSelectedItem();
        
        if(e.getSource()==btnBack){
            HomePageBilling hp = new HomePageBilling();
            hp.setVisible(true);
        }
    }
}
