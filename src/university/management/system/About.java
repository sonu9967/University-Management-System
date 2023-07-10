package university.management.system;
import javax.swing.*;
import java.awt.*;


public class About extends JFrame{
    
    About(){
         setSize(700,500);
         setLocation(300,130);
         getContentPane().setBackground(Color.white);
         
         //for image 
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
         Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);//we cant pass imageclass directly so we create obj
         JLabel image= new JLabel(i3);
         image.setBounds(350, 0, 300, 200);
         add(image);
         
         //
         JLabel heading = new JLabel("<html>University<br/>Management System</html>");
         heading.setBounds(70,20,300,130);
         heading.setFont(new Font("tahoma",Font.BOLD,30));
         add(heading);
         
         JLabel name = new JLabel("Developed By:Sonu Kumar");
         name.setBounds(70,200,450,30);
         name.setFont(new Font("tahoma",Font.BOLD,25));
         add(name);
         
         JLabel rollno = new JLabel("Roll Number: 20781A05H2");
         rollno.setBounds(70,280,550,20);
         rollno.setFont(new Font("tahoma",Font.PLAIN,25));
         add(rollno);
         
         JLabel contact = new JLabel("<html>E-mail: sonu@gmail.com <br>Contact :124466788</html>");
         contact.setBounds(70,340,550,70);
         contact.setFont(new Font("tahoma",Font.PLAIN,20));
         add(contact);
         
         setLayout(null);//it is very important to insert otherwise it affect our layout
         setVisible(true);
    }
    public static void main(String args[]){
         new About();
    }
    
}
