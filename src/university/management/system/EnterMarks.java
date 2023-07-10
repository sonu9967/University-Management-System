package university.management.system;

import java.awt.*;
import javax.swing.*;// for frame
import java.sql.*;//or resultset also can insert
import java.awt.event.*;
public class EnterMarks extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,cancel;
    EnterMarks(){
        setSize(1000,500);
        setLocation(205,105);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 =i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("TAHOMA" , Font.BOLD,20));
        add(heading);
    //for updsate the selected rollno
        JLabel lblrollnumber  = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,70,150,20);
        lblrollnumber.setFont(new Font("serif" , Font.PLAIN,14));
        add(lblrollnumber); 
        
        crollno = new Choice();
        crollno.setBounds(200,70,150,20);
        add(crollno);
        //for showing data, fetch from DB so that
        
        try{
            //create a conn class for establish the connection with db
            Conn c = new Conn();
            // it will hit query ans store into rs
            ResultSet rs = c.s.executeQuery("select * from student");
            //it check the roll no and add 
            while(rs.next()){
               crollno.add(rs.getString("rollno"));
            }
        
        }catch(Exception e){
            //print that exception
            e.printStackTrace();
        }
        
         //for select the semester
        JLabel lblsemester  = new JLabel("Select Semester");
        lblsemester.setBounds(50,110,150,20);
       //lblrollnumber.setFont(new Font("serif" , Font.PLAIN,20));
        add(lblsemester);
        
        //add value for select
        String semester[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        
        
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,110,150,20);
        add(cbsemester);
        
        //for subject
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100,150,200,20);
       //lblrollnumber.setFont(new Font("serif" , Font.PLAIN,20));
        add(lblentersubject);
        
        JLabel lblentermarks  = new JLabel("Enter Marks");
        lblentermarks.setBounds(320,150,200,20);
       //lblrollnumber.setFont(new Font("serif" , Font.PLAIN,20));
        add(lblentermarks);
        
        tfsub1=new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        
        tfsub2=new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        
        tfsub3=new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3
        );
        tfsub4=new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        
        tfsub5=new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5); 
        
        // for marks textfield
        tfmarks1=new JTextField();
        tfmarks1.setBounds(250,200,200,20);
        add(tfmarks1); 
        
        tfmarks2=new JTextField();
        tfmarks2.setBounds(250,230,200,20);
        add(tfmarks2); 
        
        tfmarks3=new JTextField();
        tfmarks3.setBounds(250,260,200,20);
        add(tfmarks3); 
        
        tfmarks4=new JTextField();
        tfmarks4.setBounds(250,290,200,20);
        add(tfmarks4); 
        
        tfmarks5=new JTextField();
        tfmarks5.setBounds(250,320,200,20);
        add(tfmarks5); 
        
        //button
        submit= new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
   //cancel button
        cancel= new JButton("Back");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
        
        
        
        
      setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
        try{
         Conn c = new Conn();
         String query1= "insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
        String query2= "insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
        
        //execute the query
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        
        //pop up
        JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
        }catch(Exception e){
         e.printStackTrace();
        }
    }else{
        
       setVisible(false);
    }
    }
    public static void main(String args[]){
       //if i didnt call then it will not show the output
       new EnterMarks();
    }
}
