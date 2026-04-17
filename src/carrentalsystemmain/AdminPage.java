
package carrentalsystemmain;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mickey
 */
class AdminPage extends JFrame implements ActionListener {
    private JLabel lblMessage, lblUserName, lblPassword;
    private JTextField txtUserName, txtPassword;
    private JButton btnLogin, btnBack;
    
    AdminPage(){
        setSize(600,600);
        setTitle("Admin Account");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblMessage = new JLabel ("ADMIN ACCOUNT");
        lblMessage.setBounds(250, 125, 500,100);
        add(lblMessage);
        
        lblUserName = new JLabel ("Username:");
        lblUserName.setBounds(190,175, 100,100);
        add(lblUserName);
        
        txtUserName = new JTextField ();
        txtUserName.setBounds(290,210,150,30);
        add(txtUserName);
        
        lblPassword = new JLabel ("Password:");
        lblPassword.setBounds(190,215,100,100);
        add(lblPassword);
        
        txtPassword = new JTextField ();
        txtPassword.setBounds(290,250,150,30);
        add(txtPassword);
        
        btnLogin = new JButton ("Log In");
        btnLogin.setBounds(240,300,100,25);
        add(btnLogin);
        
        btnBack = new JButton ("Back");
        btnBack.setBounds(10,520,100,25);
        add(btnBack);
        
        btnLogin.addActionListener(this);
        btnBack.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnLogin){
            String userName = txtUserName.getText().trim();
            String pass = txtPassword.getText().trim();
            if (userName.matches("admin123")&&pass.matches("0000")){
                AdminOption ao = new AdminOption();
                ao.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid account!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource()==btnBack){
            Homepage hp = new Homepage();
            hp.setVisible(true);
        }
    }
    
}
