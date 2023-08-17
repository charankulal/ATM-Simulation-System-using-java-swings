package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pin;
    Deposit(String pin)
    {
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("    Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,14));
        amount.setBounds(180,350,320,25);
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,14));
        deposit.setBounds(400,505,100,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(400,545,100,30);
        back.addActionListener(this);
        image.add(back);
                
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String depos=amount.getText();
            Date date=new Date();
            if(depos.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter the amount you want to deposit");
            }else{
                Connectivity conn=new Connectivity();
                String query="insert into bank values('" + pin + "','" + date + "','Deposit','" + depos + "')";
                
                try{
                conn.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Deposited Successfully!");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }catch(Exception e)
                {
                    System.out.println(e);
                }
                
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        
    }
}
