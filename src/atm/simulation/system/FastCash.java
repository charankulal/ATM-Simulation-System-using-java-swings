
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
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.*;

public class FastCash extends JFrame implements ActionListener{
    JButton oneh,fiveh,onet,twot,fivet,tent,back;
    String pin;
    
    
    FastCash(String pin){
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(210,310,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        oneh=new JButton("Rs 100");
        oneh.setBounds(170,425,130,30);
        oneh.addActionListener(this);
        image.add(oneh);
        
        fiveh=new JButton("Rs 500");
        fiveh.setBounds(375,425,130,30);
        fiveh.addActionListener(this);
        image.add(fiveh);
        
        onet=new JButton("Rs 1000");
        onet.setBounds(170,465,130,30);
        onet.addActionListener(this);
        image.add(onet);
        
        twot=new JButton("Rs 2000");
        twot.setBounds(375,465,130,30);
        twot.addActionListener(this);
        image.add(twot);
        
        fivet=new JButton("Rs 5000");
        fivet.setBounds(170,505,130,30);
        fivet.addActionListener(this);
        image.add(fivet);
        
        tent=new JButton("Rs 10000");
        tent.setBounds(375,505,130,30);
        tent.addActionListener(this);
        image.add(tent);
        
        back=new JButton("Back");
        back.setBounds(375,545,130,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
              
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Connectivity conn=new Connectivity();
            try{
                ResultSet rs=conn.st.executeQuery("Select * from bank where pin='"+pin+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, " Insufficient Balance");
                    return;
                }
                
                Date date=new Date();
                String query="insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')";
                conn.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Successfully!");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[])  {
        
    }
}
