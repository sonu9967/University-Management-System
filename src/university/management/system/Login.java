package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//for performing or keep any action to button used actionllistener
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login , cancel; 
    JTextField tfusername,tfpassword;
    Login(){
        //color taken from color class in awt
        getContentPane().setBackground(Color.white);
         setLayout(null);
//for writing anything we use jlabel class
        JLabel lblusername = new JLabel("Username");
       //setbound is used for putting the label on the frame
        lblusername.setBounds(40,20,100,20);//dist from left,top, label width,height
        add(lblusername);
        
        //for asking something to type by user
         tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        //for password
        JLabel lblpassword = new JLabel("Password");
       //setbound is used for putting the label on the frame
        lblpassword.setBounds(40,70,100,20);//dist from left,top, label width,height
        add(lblpassword);
        
        //for asking something to type by user and passwordfield used for not show password the used hide
         tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        //for using the button we access the button class by create the object
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        login.addActionListener(this);
        login.setFont(new Font("tahoma",Font.BOLD,16));
        add(login);
        
        //for cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);//for text color
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
        
        // for keep the image just right side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);//we cant pass imageclass directly so we create obj
        JLabel image= new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
    setSize(600,300);
    setLocation(500,250);
    setVisible(true);
    }
    //for override the actionlistener and Actionevent class make the difference that which button is called
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            //maked the mysql query
            String query = "select * from login where username = '"+username+"' and password='"+password+"'";
        //step4 execute the mysql query
          try{
              //make the obj of the class of conn for making the connection
              Conn c=new Conn();
              ResultSet rs = c.s.executeQuery(query);
              //if username is not in db then
              if(rs.next()){
              setVisible(false);
              new Project(); //open the project
              }else{
              //if username not match then we show on epop msge by use of JoptionPane
              JOptionPane.showMessageDialog(null, "Invalid username or password");
              setVisible(false);
              }
              //close also step5 --> c.s.close();
          }catch(Exception e){
              e.printStackTrace();
          }  
        }else if(ae.getSource()==cancel){
        setVisible(false);}
    }
   public static void main(String args[]){
   new Login();
   } 
}

