package atm.simulation.system;

import java.sql.*;
public class Connectivity {
    Connection cn;
    Statement st;
    public Connectivity() {
        try{
            cn=DriverManager.getConnection("jdbc:mysql:///atmsimulationsystem","root","Charan");
            st=cn.createStatement();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        
    }
}
