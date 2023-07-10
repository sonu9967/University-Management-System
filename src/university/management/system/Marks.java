
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Marks extends JFrame implements ActionListener{
    String rollno;
    JButton cancel;
    
    Marks(String rollno){
        this.rollno=rollno;
        
        setSize(750,600);
        setLocation(300,50);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
    
        JLabel heading = new JLabel("Sri Venkateswara College of Engineering and Technology");
        heading.setBounds(100,10,700,25);
        heading.setFont(new Font("tahoma",Font.BOLD,20));
        add(heading);
        // for result of examination
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(250,50,600,20);
        subheading.setFont(new Font("tahoma",Font.BOLD,18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll Number"+rollno);
        lblrollno.setBounds(60,100,700,20);
        lblrollno.setFont(new Font("tahoma",Font.PLAIN,18));
        add(lblrollno);
        // for result of examination
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,600,20);
        lblsemester.setFont(new Font("tahoma",Font.BOLD,18));
        add(lblsemester);
        
        //for subject
        JLabel sub1= new JLabel();
        sub1.setBounds(100,200,600,20);
        sub1.setFont(new Font("tahoma",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2= new JLabel();
        sub2.setBounds(100,230,600,20);
        sub2.setFont(new Font("tahoma",Font.PLAIN,18));
        add(sub2);
        //sub3
        JLabel sub3= new JLabel();
        sub3.setBounds(100,260,600,20);
        sub3.setFont(new Font("tahoma",Font.PLAIN,18));
        add(sub3);
        //sub4
        JLabel sub4= new JLabel();
        sub4.setBounds(100,290,600,20);
        sub4.setFont(new Font("tahoma",Font.PLAIN,18));
        add(sub4);
        //sub5
        JLabel sub5= new JLabel();
        sub5.setBounds(100,320,600,20);
        sub5.setFont(new Font("tahoma",Font.PLAIN,18));
        add(sub5);
        
        //fetch the all vlaues from database
        try{
            Conn c= new Conn();
            ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){// it is conneted with submit of examinationDetails
                
             sub1.setText(rs1.getString("subject1"));
             sub2.setText(rs1.getString("subject2"));
             sub3.setText(rs1.getString("subject3"));
             sub4.setText(rs1.getString("subject4"));
             sub5.setText(rs1.getString("subject5"));
            
            }
            ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+ "___________"+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+ "___________"+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+ "___________"+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+ "___________"+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+ "___________"+rs2.getString("marks5"));
                lblsemester.setText("Semester"+rs2.getString("semester"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //butoon of camcel
         cancel=new JButton("Back");
         cancel.setBackground(Color.black);
         cancel.setBounds(250,500,120,25);
         cancel.setForeground(Color.white);
         cancel.setFont(new Font("tahoma",Font.BOLD,15));
         cancel.addActionListener(this);
         add(cancel);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
     setVisible(false);
     }
    public static void main(String args[]){
    new Marks("");
    }
}
