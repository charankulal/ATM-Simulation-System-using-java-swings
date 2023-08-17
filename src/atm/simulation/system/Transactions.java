package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pin;
    
    Transactions(String pin){
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,310,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,425,130,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setBounds(375,425,130,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,465,130,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(375,465,130,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton(" Pin Change");
        pinchange.setBounds(170,505,130,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(375,505,130,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("EXIT");
        exit.setBounds(375,545,130,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
//            setVisible(false);
//            new Login().setVisible(true);
              System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==ministatement){
            
            new MiniStatement(pin).setVisible(true);
        }
    }
    
    public static void main(String args[])  {
        
    }
}
