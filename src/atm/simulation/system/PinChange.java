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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{
    String pin;
    JPasswordField pinfield,repinfield;
    JButton change,back;
    PinChange(String pin){
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel(" Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,320,400,20);
        image.add(text);
        
        JLabel pintext=new JLabel(" New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(170,380,200,20);
        image.add(pintext);
        
        pinfield=new JPasswordField();
        pinfield.setFont(new Font("Raleway",Font.BOLD,16));
        pinfield.setBounds(330,380,180,25);
        image.add(pinfield);
        
        JLabel repintext=new JLabel(" Re-Enter new PIN: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(170,420,200,20);
        image.add(repintext);
        
        repinfield=new JPasswordField();
        repinfield.setFont(new Font("Raleway",Font.BOLD,16));
        repinfield.setBounds(330,420,180,25);
        image.add(repinfield);
        
        change = new JButton("Change");
        change.setBounds(400,505,100,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(400,545,100,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String pin1=pinfield.getText();
            String repin1=repinfield.getText();
            
            if(!pin1.equals(repin1))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if(pin1.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter new PIN");
                return;
            }
            if(repin1.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }
            Connectivity conn=new Connectivity();
            String query1="update bank  set pin='"+pin1+"'where pin='"+pin+"'";
            String query2="update login  set pin='"+pin1+"'where pin='"+pin+"'";
            String query3="update signup3  set pin='"+pin1+"'where pin='"+pin+"'";
            
            conn.st.executeUpdate(query1);
            conn.st.executeUpdate(query2);
            conn.st.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
            
            setVisible(false);
            new Transactions(pin1).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String args[]){
        
    }
}
