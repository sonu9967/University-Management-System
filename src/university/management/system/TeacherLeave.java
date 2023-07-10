package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;//for calender
import java.awt.event.*;
public class TeacherLeave extends JFrame implements ActionListener{
    Choice cEmpId, ctime;
    JButton submit,cancel;
    JDateChooser dcdate;
    TeacherLeave(){
    
    setSize(500,550);
    setLocation(420,100);
    setLayout(null);
    
    getContentPane().setBackground(Color.white);
    
    JLabel heading = new JLabel("Apply Leave(Teacher)");
    heading.setBounds(40,50,300,30);
    heading.setFont(new Font("Tahoma",Font.BOLD,20));
    add(heading);
    
    //
        JLabel lblrollno = new JLabel("Search By Employee Id");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);
        
        cEmpId = new Choice();
        cEmpId .setBounds(60,130,200,20);
        add(cEmpId);
        
        //for showing data, fetch from DB so that
        
        try{
            //create a conn class for establish the connection with db
            Conn c = new Conn();
            // it will hit query ans store into rs
            ResultSet rs = c.s.executeQuery("select * from teacher");
            //it check the roll no and add 
            while(rs.next()){
               cEmpId.add(rs.getString("empId"));
            }
        
        }catch(Exception e){
            //print that exception
            e.printStackTrace();
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
        //for caledar
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        
        //for duraton
         JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        //button submit or cancel
         submit= new JButton("Submit");
         submit.setBounds(60,350,100,25);
         submit.setBackground(Color.black);
         submit.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        submit.addActionListener(this);
         submit.setFont(new Font("tahoma",Font.BOLD,16));
         add(submit);
   //cancel button
         cancel= new JButton("Cancel");
         cancel.setBounds(200,350,100,25);
         cancel.setBackground(Color.black);
         cancel.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
         cancel.addActionListener(this);
         cancel.setFont(new Font("tahoma",Font.BOLD,16));
         add(cancel);
        
    
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
        String rollno = cEmpId .getSelectedItem();
        String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
        String duration =ctime.getSelectedItem();
        
        String query = "insert into teacherleave values('"+rollno+"','"+date+"','"+duration+"')";
        // for execute
        try{
            Conn c=new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Leave Confirem");
            setVisible(false);
        }catch(Exception e){
        e.printStackTrace();
        }
    }else{
    setVisible(false);
    }
    }
    public static void main(String args[]){
    new TeacherLeave(); 
    }
}
