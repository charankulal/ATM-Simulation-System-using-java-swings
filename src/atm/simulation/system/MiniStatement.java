package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

    String pin;
    int balance=0;

    MiniStatement(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
         mini.setFont(new Font("Consolas",Font.BOLD,12));
        add(mini);

        JLabel bank = new JLabel("PEOPLE'S BANK");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balancel = new JLabel();
        balancel.setBounds(20, 400, 300, 20);
        add(balancel);

        try {
            Connectivity conn = new Connectivity();
            ResultSet rs = conn.st.executeQuery("select * from login where pin ='" + pin + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + " - XXXX - XXXX - " + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Connectivity conn = new Connectivity();
            ResultSet rs = conn.st.executeQuery("select * from bank where pin ='" + pin + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
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

            balancel.setText("Closing Balance: "+balance);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(420, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        
    }

}
