package carrentalsystemmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class carMenu extends JFrame implements ActionListener{
    
    JLabel lblTitle, lblcarModel, lblplateNumber;
    JComboBox<String> dbtncarModel, dbtnplateNumber;
    JButton enterbtn;
    
    
    carMenu(){
        
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Car Selection");
        setLocationRelativeTo(null);
        
        lblTitle = new JLabel(">> Select A Car <<");
        lblTitle.setBounds(250,20,200,50);
        add(lblTitle);
        
        lblcarModel = new JLabel("Car Model");
        lblcarModel.setBounds(135,150,200,50);
        add(lblcarModel);
        
        String[] dbcarModels = {"Toyota Vios","Nissan GT-R"};
        dbtncarModel = new JComboBox <> (dbcarModels);
        dbtncarModel.setBounds(100,210,200,40);
        add(dbtncarModel);
        
        lblplateNumber = new JLabel("Plate Number");
        lblplateNumber.setBounds(440,150,200,50);
        add(lblplateNumber);
        
        
        String [] dbplatenumbers = {"NCT 1270", "TRP 4567"};
        dbtnplateNumber = new JComboBox <>(dbplatenumbers);
        dbtnplateNumber.setBounds(340,210,200,50);
        add(dbtnplateNumber);
       
        
        enterbtn = new JButton("Enter");
        enterbtn.setBounds(190,400,200,40);
        add(enterbtn);
        
        enterbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent j) {
       if (j.getSource() == enterbtn)
        {
           String selectedCar = (String) dbtncarModel.getSelectedItem();
           String selectedPlate = (String) dbtnplateNumber.getSelectedItem();
          
           if (selectedCar.equals("Toyota Vios")&& selectedPlate.equals("NCT 1270"))
           {
               dispose();
               carStatusToyotaVios1270 csToyota1270 = new carStatusToyotaVios1270();
               csToyota1270.setVisible(true);
           }
           
           else if (selectedCar.equals("Nissan GT-R")&& selectedPlate.equals("TRP 4567"))
           {
               // classssss
           }
           
           else 
           {
              JOptionPane.showMessageDialog(this, "No car on the list"); 
           }
              
       }
       
       else {
           System.out.println("sfdfsdfs");
       }
    }
    
}
