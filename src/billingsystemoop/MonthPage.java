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
class MonthPage extends JFrame implements ActionListener {
    private JLabel lblPage, lblPick, lblDrop, lblMonthPick, lblMonthDrop, lblDayPick, lblDayDrop, lblYearPick, lblYearDrop;
    private JTextField txtYearPick, txtYearDrop;
    private JComboBox comboDayPick, comboDayDrop, comboMonthPick, comboMonthDrop;
    private JButton btnCalculate;
    private String [] month = {" ","January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December"};
    private Integer [] day28 = new Integer[28];
    private Integer [] day29 = new Integer [29];
    private Integer [] day30 = new Integer [30];
    private Integer [] day31 = new Integer [31];
    private Integer daysPickUp, daysDropOff, daysTotal, dayPick, dayDrop;
    
    {
        for (int i=0;i<day28.length;i++) day28[i]=i+1;
        for (int i=0;i<day29.length;i++) day29[i]=i+1;
        for (int i=0;i<day30.length;i++) day30[i]=i+1;
        for (int i=0;i<day31.length;i++) day31[i]=i+1;
    }
    
    MonthPage (){
        setSize(600,600);
        setTitle("Billing System");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblPage = new JLabel ("PAYMENT PORTAL");
        lblPage.setBounds(250,25,200,100);
        add(lblPage);
        
        lblPick = new JLabel ("Pick-Up Date");
        lblPick.setBounds(265,75,200,100);
        add(lblPick);
        
        lblYearPick = new JLabel ("Year: ");
        lblYearPick.setBounds(110,160,100,30);
        add(lblYearPick);
        txtYearPick = new JTextField();
        txtYearPick.setBounds(75,200,100,25);
        add(txtYearPick);
        
        lblMonthPick = new JLabel ("Month: ");
        lblMonthPick.setBounds(280,160,100,30);
        add(lblMonthPick);
        comboMonthPick = new JComboBox (new DefaultComboBoxModel<>(month));
        comboMonthPick.setBounds(250, 200, 100, 25);
        add(comboMonthPick);
        
        lblDayPick = new JLabel ("Day: ");
        lblDayPick.setBounds(460,160,100,30);
        add(lblDayPick);
        comboDayPick = new JComboBox();
        comboDayPick.setBounds(425, 200, 100, 25);
        add(comboDayPick);
        
        
        
        
        
        lblDrop = new JLabel ("Drop-Off Date");
        lblDrop.setBounds(265,250,200,100);
        add(lblDrop);
        
        lblYearDrop = new JLabel ("Year: ");
        lblYearDrop.setBounds(110,335,100,30);
        add(lblYearDrop);
        txtYearDrop = new JTextField();
        txtYearDrop.setBounds(75,375,100,25);
        add(txtYearDrop);
        
        lblMonthDrop = new JLabel ("Month: ");
        lblMonthDrop.setBounds(280,335,100,30);
        add(lblMonthDrop);
        comboMonthDrop = new JComboBox (new DefaultComboBoxModel<>(month));
        comboMonthDrop.setBounds(250, 375, 100, 25);
        add(comboMonthDrop);
        
        lblDayDrop = new JLabel ("Day: ");
        lblDayDrop.setBounds(460,335,100,30);
        add(lblDayDrop);
        comboDayDrop = new JComboBox();
        comboDayDrop.setBounds(425, 375, 100, 25);
        add(comboDayDrop);
        
        
        
        
        
        btnCalculate = new JButton ("CALCULATE");
        btnCalculate.setBounds(215,450,175,50);
        add(btnCalculate);
        
        btnCalculate.addActionListener(this);
        comboMonthPick.addActionListener(this);
        comboMonthDrop.addActionListener(this);
        txtYearPick.addActionListener(this);
        comboMonthDrop.addActionListener(this);
        
    }
    
    public void monthPick(){
        String monthSelected = ((String) comboMonthPick.getSelectedItem()).toLowerCase();
        
        if (monthSelected.equals("january") || monthSelected.equals("march") || monthSelected.equals("may")
                || monthSelected.equals("july") || monthSelected.equals("august") || monthSelected.equals("october") || monthSelected.equals("december")) {
            comboDayPick.setModel(new DefaultComboBoxModel(day31));
        } else if (monthSelected.equals("february")) {
            String yearString = txtYearPick.getText().trim();
            if (yearString.matches("\\d+")){
                int year = Integer.parseInt(yearString);
                
                if ((year % 4 ==0 && year % 100 != 0) || (year % 400 == 0)){
                    comboDayPick.setModel(new DefaultComboBoxModel(day29));
                } else {
                    comboDayPick.setModel(new DefaultComboBoxModel(day28));
                }
            } else {
                JOptionPane.showMessageDialog(this,"Invalid year. Please try again!", "Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (monthSelected.equals("april") || monthSelected.equals("june") || monthSelected.equals("september")
                || monthSelected.equals("november")) {
            comboDayPick.setModel(new DefaultComboBoxModel(day30));
        } else {
            comboDayPick.setModel(new DefaultComboBoxModel<>(new String[]{" "}));
        }
    }
    
    public void monthDrop(){
        String monthSelected = ((String) comboMonthDrop.getSelectedItem()).toLowerCase();
        if (monthSelected.equals("january") || monthSelected.equals("march") || monthSelected.equals("may")
                || monthSelected.equals("july") || monthSelected.equals("august") || monthSelected.equals("october") || monthSelected.equals("december")) {
            comboDayDrop.setModel(new DefaultComboBoxModel(day31));
        } else if (monthSelected.equals("february")) {
            String yearString = txtYearDrop.getText().trim();
            if (yearString.matches("\\d+")) {
                int year = Integer.parseInt(yearString);

                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    comboDayDrop.setModel(new DefaultComboBoxModel(day29));
                } else {
                    comboDayDrop.setModel(new DefaultComboBoxModel(day28));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid year. Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (monthSelected.equals("april") || monthSelected.equals("june") || monthSelected.equals("september")
                || monthSelected.equals("november")) {
            comboDayDrop.setModel(new DefaultComboBoxModel(day30));
        } else {
            comboDayDrop.setModel(new DefaultComboBoxModel<>(new String[]{" "}));
        }
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==comboMonthPick || e.getSource()==txtYearPick){
            monthPick();
        } else if (e.getSource()==comboMonthDrop || e.getSource()==txtYearDrop){
            monthDrop();
        } else if (e.getSource() == btnCalculate) {
            dayPick = (Integer) comboDayPick.getSelectedItem();
            dayDrop = (Integer) comboDayDrop.getSelectedItem();

            if (dayPick != null && dayDrop != null) {
                int pickMonthDays = 0;
                String monthSelected = ((String) comboMonthPick.getSelectedItem()).toLowerCase();
                switch (monthSelected) {
                    case "january":
                    case "march":
                    case "may":
                    case "july":
                    case "august":
                    case "october":
                    case "december":
                        pickMonthDays = 31;
                        break;
                    case "april":
                    case "june":
                    case "september":
                    case "november":
                        pickMonthDays = 30;
                        break;
                    case "february":
                        int year = Integer.parseInt(txtYearPick.getText().trim());
                        pickMonthDays = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? 29 : 28;
                        break;
                }

                daysTotal = (pickMonthDays - dayPick + 1) + (dayDrop - 1);

                if (daysTotal < 1) {
                    JOptionPane.showMessageDialog(this, "Drop-off day must be after pick-up day!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    OutputPage op = new OutputPage(daysTotal); // pass total days
                    op.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select both pick-up and drop-off days!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
