package university.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    //step3 creating the statement
    Statement s;
    Conn()
    {
        //step2 cretaing the connection string
        try{
        //step1 driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
       //mention all info of darabase method jdbc:db://locationonrun:pot no/nameofdatabase,"userbame","paass"
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","SONUMONU");
        s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
