package serviceTracking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import carrentalsystemmain.*;
import java.awt.Font;


public class carMenu extends JPanel implements ActionListener{
    
    JLabel lblTitle, lblcarModel, lblplateNumber;
    JComboBox<String> dbtncarModel, dbtnplateNumber;
    JButton enterbtn, btnback;
    
    
    public carMenu(){
        
        setBounds(450,150,1000,600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
        
        lblTitle = new JLabel(">> Select A Car <<");
        lblTitle.setBounds(430,20,200,50);
        lblTitle.setFont(new Font("Poppins",Font.BOLD,25));
        add(lblTitle);
        
        lblcarModel = new JLabel("Car Model");
        lblcarModel.setBounds(235,150,200,50);
        lblcarModel.setFont(new Font("Poppins",Font.BOLD,25));
        add(lblcarModel);
        
        String[] dbcarModels = {"Toyota Vios","Nissan GT-R"};
        dbtncarModel = new JComboBox <> (dbcarModels);
        dbtncarModel.setBounds(170,210,200,40);
        add(dbtncarModel);
        
        lblplateNumber = new JLabel("Plate Number");
        lblplateNumber.setBounds(640,150,200,50);
        lblplateNumber.setFont(new Font("Poppins",Font.BOLD,25));
        add(lblplateNumber);
        
        
        String [] dbplatenumbers = {"NCT 1270", "TRP 4567"};
        dbtnplateNumber = new JComboBox <>(dbplatenumbers);
        dbtnplateNumber.setBounds(590,210,200,50);
        add(dbtnplateNumber);
       
        
        enterbtn = new JButton("Enter");
        enterbtn.setFont(new Font("Poppins", Font.BOLD, 15));
        enterbtn.setForeground(Color.WHITE);
        enterbtn.setBackground(darkAzure);
        enterbtn.setOpaque(true);
        enterbtn.setFocusPainted(false);        
        enterbtn.setBounds(390,400,200,25);
        add(enterbtn);
        
        btnback = new JButton("Back");
        btnback.setFont(new Font("Poppins", Font.BOLD, 15));
        btnback.setForeground(Color.WHITE);
        btnback.setBackground(darkAzure);
        btnback.setOpaque(true);
        btnback.setFocusPainted(false);
        btnback.setBounds(30,480,100,25);
        add(btnback);
        
        enterbtn.addActionListener(this);
        btnback.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent j) {
       if (j.getSource() == enterbtn)
        {
           String selectedCar = (String) dbtncarModel.getSelectedItem();
           String selectedPlate = (String) dbtnplateNumber.getSelectedItem();
          //for the status, palaging carStatus + MODEL + plate number (wala na ung letters)
           if (selectedCar.equals("Toyota Vios")&& selectedPlate.equals("NCT 1270"))
           {
               carStatusToyotaVios1270 csToyota1270 = new carStatusToyotaVios1270();
               csToyota1270.setVisible(true);
           }
           
           else if (selectedCar.equals("Nissan GT-R")&& selectedPlate.equals("TRP 4567"))
           {
               // classssss carStatusNissanGTR4567
               carStatusNissanGTR4567 csNissan4567 = new carStatusNissanGTR4567();
               csNissan4567.setVisible(true);
           }
           
           else 
           {
              JOptionPane.showMessageDialog(this, "No car on the list"); 
           }
              
       }
       
       else if (j.getSource() == btnback){
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            currentFrame.dispose();
            
            JFrame mainFrame = new JFrame();
            mainFrame.setSize(1366, 768);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            
            JLabel background = new JLabel(new ImageIcon(CarRentalSystemMain.class.getResource("/img/firstBG.png")));
            background.setLayout(null);
            AdminOption ap = new AdminOption();
            ap.setBounds(875, 175, 1366, 768);
            background.add(ap);
            mainFrame.setContentPane(background);
            mainFrame.setVisible(true);
       }
    }
    
}
