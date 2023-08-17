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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10,100 ,100 );
        add(label);
        
        JLabel text=new JLabel("WELCOME TO ATM");
        add(text);
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        
        JLabel cardno=new JLabel("Card No. : ");
        add(cardno);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Consolas",Font.BOLD,20));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN: ");
        add(pin);
        pin.setFont(new Font("Ralevay",Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        cardTextField.setFont(new Font("Consolas",Font.BOLD,20));
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
        
    } 
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==login){
            Connectivity conn=new Connectivity();
            String cardnumber=cardTextField.getText();
            String pin=pinTextField.getText();
            String query="select * from login where cardnumber='"+cardnumber+"'and pin='"+pin+"'";
            try{ 
            ResultSet rs=conn.st.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"Incorrect Card number or PIN");
            }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            SignupOne signupone=new SignupOne();
            signupone.setVisible(true);
        }
    }
    
    
    public static void main(String args[]){
        Login login = new Login();
    }
}
