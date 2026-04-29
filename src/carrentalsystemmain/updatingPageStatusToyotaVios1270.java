package carrentalsystemmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class updatingPageStatusToyotaVios1270 extends JFrame implements ActionListener{
    JLabel lblupdateTitle, lblupdatedText;
    JRadioButton rbtnAvailable,rbtnReserved, rbtnRented, rbtnUnderMaintenance;
    JButton btnback, btnSubmit, btnReports;
    
    updatingPageStatusToyotaVios1270(){
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Updating Status of Toyota Vios 1270");
        
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
        btnReports.setBounds(30,430,180,40);
        add(btnReports);
        
        btnback = new JButton("Back");
        btnback.setBounds(30,480,100,40);
        add(btnback);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(450,480,100,40);
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
            carStatusToyotaVios1270 csToyota1270 = new carStatusToyotaVios1270();
            csToyota1270.setVisible(true);
        }
        
        else if (j.getSource() == btnReports) 
        {
           dispose();
           toyota1270_HistoryReports tyt1270History = new toyota1270_HistoryReports();
           tyt1270History.setVisible(true);
        }
        
        else if (j.getSource()== btnSubmit){
            if (rbtnAvailable.isSelected()) 
            {
            lblupdatedText.setText("Updated Status to AVAILABLE");
            } 
            else if (rbtnReserved.isSelected())
                {
                    dispose();
                    toyota1270_ReservedUpdate tyt1270_reserved = new toyota1270_ReservedUpdate();
                    tyt1270_reserved.setVisible(true);
                }
            
            else if (rbtnUnderMaintenance.isSelected())
                {
                    dispose();
                //WINDOW FOR Undermaintenance
                }
            
            else if (rbtnRented.isSelected())
                {
                    dispose();
                //WINDOW FOR RENTED
                }
        }
    }
    
}
