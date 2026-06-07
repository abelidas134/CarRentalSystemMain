package serviceTracking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Maintenance
public class Maintenance extends JPanel implements ActionListener{
    JLabel lblcarModelPlatenum, lbl2ndHeadStatus, lblCurrentReports ;
    JButton btnback, btnUpdateStats;
    
    public Maintenance(){
        setBounds(0,0,600,600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
        
        lblcarModelPlatenum = new JLabel("Nissan GT-R TRP 4567");
        lblcarModelPlatenum.setBounds(30,40,200,50);
        add(lblcarModelPlatenum);
        
        lbl2ndHeadStatus = new JLabel("<< Status >>");
        lbl2ndHeadStatus.setBounds(30,60,200,50);
        add(lbl2ndHeadStatus);
        
        lblCurrentReports = new JLabel("--- Undermaintenace This will update in the database as well as here");
        lblCurrentReports.setBounds(30, 100, 500, 30);
        add(lblCurrentReports);
        
        
//        lbl2ndHeadStatus = new JLabel("--- Undermaintenace "
//                + "\n  : Fixing Aircon"
//                + "\n  Can back on rent in May 14, 2026");
//        lbl2ndHeadStatus.setBounds(30,80,300,90);
//        add(lbl2ndHeadStatus);
        
        //
//        btnback = new JButton("Back");
//        btnback.setBounds(30,480,100,25);
//        add(btnback);
//        
        btnUpdateStats = new JButton("UPDATE STATUS");
        btnUpdateStats.setBounds(175,400,140,25);
        add(btnUpdateStats);
        
        
//        btnback.addActionListener(this);
        btnUpdateStats.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent j) {
//         if (j.getSource() == btnback) 
//            {
//                dispose();
//                carMenu cm = new carMenu();
//                cm.setVisible(true);
//            }
         
          if(j.getSource() == btnUpdateStats)
            {
                MaintenanceUpdate updStatNissan4567 = new MaintenanceUpdate();
                updStatNissan4567.setVisible(true);
            }
    }
    
}
