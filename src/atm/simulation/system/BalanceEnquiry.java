package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JButton back;
    int balance = 0;
    BalanceEnquiry(String pin) {
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 545, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Connectivity conn = new Connectivity();
        try {
            ResultSet rs = conn.st.executeQuery("Select * from bank where pin='" + pin + "'");
            
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Account Balance is "+balance+" Rs");
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);

    }

    public static void main(String args[]) {
      
    }
}
