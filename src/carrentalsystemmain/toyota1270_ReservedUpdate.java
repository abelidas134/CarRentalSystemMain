package carrentalsystemmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class toyota1270_ReservedUpdate extends JFrame implements ActionListener{

    JLabel lblRentedTitle, lblModelPlate, lblrentedDate, lblUntil, lblClientNo;//suggestion na may client ID tayo per account
    JTextField txtrentedDate, txtUntil, txtClient;
    JButton btnback, btnUpdate;
    
    toyota1270_ReservedUpdate()
    {
        setSize(600,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Updating Reserved Status of Toyota Vios 1270");
        
        
    }
    @Override
    public void actionPerformed(ActionEvent j) {
       
    }
    
}
