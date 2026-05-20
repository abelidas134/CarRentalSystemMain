package serviceTracking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class updatingPageStatusNissanGTR4567 extends JFrame implements ActionListener {
    JLabel lblupdateTitle, lblupdatedText;
    JRadioButton rbtnAvailable,rbtnReserved, rbtnRented, rbtnUnderMaintenance;
    JButton btnback, btnSubmit, btnReports;
    
    updatingPageStatusNissanGTR4567(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Updating Status of Nissan GTR 4567");
        setLocationRelativeTo(null);
        
        lblupdateTitle = new JLabel("Choose an Update:");
        lblupdateTitle.setBounds(240, 30, 200, 30);
        add(lblupdateTitle);
        
        //radiobuttons
        rbtnAvailable = new JRadioButton("Available");
        rbtnAvailable.setBounds(100, 150, 200, 30);
        add(rbtnAvailable);
        
        rbtnRented = new JRadioButton("Rented");
        rbtnRented.setBounds(340, 150, 200, 30);
        add(rbtnRented);
        
        rbtnReserved = new JRadioButton("Reserved");
        rbtnReserved.setBounds(100, 200, 200, 30);
        add(rbtnReserved);
        
        rbtnUnderMaintenance = new JRadioButton("Under Maintenance"); //dapat nakakainput ung Admin here
        rbtnUnderMaintenance.setBounds(340, 200, 400, 30);
        add(rbtnUnderMaintenance);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnAvailable);
        group.add(rbtnReserved);
        group.add(rbtnRented);
        group.add(rbtnUnderMaintenance);
        
        //
        lblupdatedText = new JLabel(" ");
        lblupdatedText.setBounds(200,300, 400, 30);
        add(lblupdatedText);
        
        
        
        //BUTTONNSS
        btnReports = new JButton("History Reports");
        btnReports.setBounds(30,430,180,25);
        add(btnReports);
        
        btnback = new JButton("Back");
        btnback.setBounds(30,480,100,25);
        add(btnback);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(450,480,100,25);
        add(btnSubmit);
        
        btnback.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnReports.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent j) {
       if (j.getSource() == btnback) 
        {
            dispose();
            carStatusNissanGTR4567 csNissan4567 = new carStatusNissanGTR4567();
            csNissan4567.setVisible(true);
        }
       
       else if (j.getSource() == btnReports) 
        {
            dispose();
           nissan4567_HistoryReports nsn4567 = new nissan4567_HistoryReports();
           nsn4567.setVisible(true);
        }
       
       else if (j.getSource()== btnSubmit){
            if (rbtnAvailable.isSelected()) 
            {
            lblupdatedText.setText("Updated Status to AVAILABLE");
            } 
            else if (rbtnReserved.isSelected())
                {
                    dispose();
                    nissan4567_ReservedUpdate nssn1270_reserved = new nissan4567_ReservedUpdate();
                    nssn1270_reserved.setVisible(true);
                }
            
            else if (rbtnUnderMaintenance.isSelected())
                {
                    dispose();
                    nissan4567_MaintenanceUpdate nssn4567_maintenance = new nissan4567_MaintenanceUpdate();
                    nssn4567_maintenance.setVisible(true);
                }
            
            else if (rbtnRented.isSelected())
                {
                    dispose();
                 nissan4567_RentedUpdate nssn4567_rented = new nissan4567_RentedUpdate();
                 nssn4567_rented.setVisible(true);
                }
            }
       }
    
}
