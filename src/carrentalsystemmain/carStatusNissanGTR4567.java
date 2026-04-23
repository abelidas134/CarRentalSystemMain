package carrentalsystemmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class carStatusNissanGTR4567 extends JFrame implements ActionListener{
    JLabel lblcarModelPlatenum, lbl2ndHeadStatus, lblReports;
    JButton btnback, btnUpdateStats;
    
    carStatusNissanGTR4567(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Nissan GT-R TRP 4567 Status");
        
        lblcarModelPlatenum = new JLabel("Nissan GT-R TRP 4567");
        lblcarModelPlatenum.setBounds(30,40,200,50);
        add(lblcarModelPlatenum);
        
        lbl2ndHeadStatus = new JLabel("<< Status >>");
        lbl2ndHeadStatus.setBounds(30,60,200,50);
        add(lbl2ndHeadStatus);
        
        lbl2ndHeadStatus = new JLabel("--- Undermaintenace chuchcuhcuhc");
        lbl2ndHeadStatus.setBounds(30,80,300,90);
        add(lbl2ndHeadStatus);
        
        
//        lbl2ndHeadStatus = new JLabel("--- Undermaintenace "
//                + "\n  : Fixing Aircon"
//                + "\n  Can back on rent in May 14, 2026");
//        lbl2ndHeadStatus.setBounds(30,80,300,90);
//        add(lbl2ndHeadStatus);
        
        //
        btnback = new JButton("Back");
        btnback.setBounds(30,400,100,40);
        add(btnback);
        
        btnUpdateStats = new JButton("UPDATE STATUS");
        btnUpdateStats.setBounds(415,400,140,40);
        add(btnUpdateStats);
        
        
        btnback.addActionListener(this);
        btnUpdateStats.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent j) {
         if (j.getSource() == btnback) 
        {
            dispose();
            carMenu cm = new carMenu();
            cm.setVisible(true);
        }
    }
    
}
