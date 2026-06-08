package billing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CashlessPayment extends JPanel implements ActionListener {

    private JPanel panelBill, panelMenu;
    private JLabel lblMode;
    private JButton btnCard, btnQR;
    private JLabel lblQR;
    private String resNum, pickDeets, dropDeets, name, plate, rate, reservationNumber, customerName;
    private int daysTotal;
    
    public CashlessPayment(String resNum,String pickDeets, String dropDeets,Integer daysTotal, String name, 
            String plate, String rate, String reservationNumber, String customerName) {
        this.resNum = resNum;
        this.pickDeets = pickDeets;
        this.dropDeets = dropDeets;
        this.daysTotal = daysTotal;
        this.name = name;
        this.plate = plate;
        this.rate = rate;
        this.reservationNumber = reservationNumber;
        this.customerName = customerName;
        double rentalRate = Double.parseDouble(rate.replace("P", ""));

        setBounds(600,100,600,600);
        setLayout(null);
        setOpaque(false);
        Color darkAzure = new Color(0, 95, 115);
        
        panelBill = new JPanel();
        panelBill.setLayout(null);
        panelBill.setBounds(200,20,200,40);
        panelBill.setBorder(BorderFactory.createEtchedBorder());
        panelBill.setBackground(Color.WHITE);
        add(panelBill);

        lblMode = new JLabel("CASHLESS PAYMENT");
        lblMode.setBounds(20,0,200,40);
        panelBill.add(lblMode);

        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(75,100,450,400);
        panelMenu.setBorder(BorderFactory.createEtchedBorder());
        panelMenu.setBackground(Color.WHITE);
        add(panelMenu);

        btnCard = new JButton("CARD");
        btnCard.setBounds(125,120,200,50);
        panelMenu.add(btnCard);

        btnQR = new JButton("QR CODE");
        btnQR.setBounds(125,220,200,50);
        panelMenu.add(btnQR);
        
        ImageIcon qrIcon = new ImageIcon(
                getClass().getResource("/img/qr.jpg"));

        Image img = qrIcon.getImage().getScaledInstance(
                200, 200, Image.SCALE_SMOOTH);

        lblQR = new JLabel(new ImageIcon(img));
        lblQR.setBounds(125, 100, 200, 200);
        lblQR.setVisible(false);

        panelMenu.add(lblQR);

        btnCard.addActionListener(this);
        btnQR.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCard) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please proceed to the cashier for card payment processing."
            );

            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            Container background = mainFrame.getContentPane();

            background.remove(this);

            SummaryReceipt sr = new SummaryReceipt(
                    resNum,
                    pickDeets,
                    dropDeets,
                    daysTotal,
                    name,
                    plate,
                    rate,
                    reservationNumber,
                    "CARD",
                    customerName
            );

            sr.setBounds(550, 200, 1366, 768);

            background.add(sr);
            background.revalidate();
            background.repaint();
        } 
        if (e.getSource() == btnQR) {

            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            Container background = mainFrame.getContentPane();

            background.remove(this);

            SummaryReceipt sr = new SummaryReceipt(
                    resNum,
                    pickDeets,
                    dropDeets,
                    daysTotal,
                    name,
                    plate,
                    rate,
                    reservationNumber,
                    "QR CODE",
                    customerName
            );

            sr.setBounds(550, 200, 1366, 768);

            background.add(sr);
            background.revalidate();
            background.repaint();
        }
    }
}