package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
//for taking from libraries a calender for dob
import com.toedter.calendar.JDateChooser;
 import java.awt.event.*; // for actionlistener

public class AddStudent extends JFrame implements ActionListener{
    JTextField tfname , tffname , tfaddress, tfphone ,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelrollno;//cant change value
    JDateChooser dcdob;
    JComboBox cbcourse , cbbranch;
    
    JButton submit ,cancel;
    //for rollno should be autogenerated
    Random ran = new Random();
    long first4=Math.abs((ran.nextLong() %9000L)+1000L);
    AddStudent(){
        
    setSize(900,700);
    setLocation(230,16);
    
    setLayout(null);//bcse we want to set layout myself
    
    JLabel heading = new JLabel("New Student Details");
    heading.setBounds(310,30,500,50);
    heading.setFont(new Font("serif" , Font.BOLD,30));
    add(heading);
    
    //name of label
    JLabel lblname = new JLabel("Name");
    lblname.setBounds(50,150,100,30);
    lblname.setFont(new Font("serif" , Font.BOLD,20));
    add(lblname);
    
    //for enter the detail we take textview 
    tfname=new JTextField();
    tfname.setBounds(200,150,150,30);
    add(tfname);
    
     //name of label
    JLabel lblfname = new JLabel(" Father's Name");
    lblfname.setBounds(400,150,200,30);
    lblfname.setFont(new Font("serif" , Font.BOLD,20));
    add(lblfname);
    
    //for enter the detail we take textview 
    tffname=new JTextField();
    tffname.setBounds(600,150,150,30);
    add(tffname);
    
    //roll number
    //name of label
    JLabel lblrollno = new JLabel(" Roll Number");
    lblrollno.setBounds(50,200,200,30);
    lblrollno.setFont(new Font("serif" , Font.BOLD,20));
    add(lblrollno);
    
    //for enter the detail we take textview 
    labelrollno =new JLabel("1533"+first4);
    labelrollno.setBounds(200,200,200,30);
    labelrollno.setFont(new Font("serif" , Font.BOLD,20));
    add(labelrollno);
    
    //dob
    JLabel lbldob = new JLabel(" Date Of Birth");
    lbldob.setBounds(400,200,200,30);
    lbldob.setFont(new Font("serif" , Font.BOLD,20));
    add(lbldob);
    
    //obe create for getting aceecin calender
    dcdob = new JDateChooser();
    dcdob.setBounds(600,200,150,30);
    add(dcdob);
    
    //address
    JLabel lbladdress = new JLabel(" Address");
    lbladdress.setBounds(50,250,200,30);
    lbladdress.setFont(new Font("serif" , Font.BOLD,20));
    add(lbladdress);
    
    //for enter the detail we take textview 
    tfaddress=new JTextField();
    tfaddress.setBounds(200,250,150,30);
    add(tfaddress);
    
    //
    JLabel lblphone = new JLabel(" Phone");
    lblphone.setBounds(400,250,200,30);
    lblphone.setFont(new Font("serif" , Font.BOLD,20));
    add(lblphone);
    
    //for enter the detail we take textview 
    tfphone=new JTextField();
    tfphone.setBounds(600,250,150,30);
    add(tfphone);
    
    //email
     //
    JLabel lblemail = new JLabel(" Email Id");
    lblemail.setBounds(50,300,200,30);
    lblemail.setFont(new Font("serif" , Font.BOLD,20));
    add(lblemail);
    
    //for enter the detail we take textview 
    tfemail=new JTextField();
    tfemail.setBounds(200,300,150,30);
    add(tfemail);
    
    //10th marks
    JLabel lblx = new JLabel(" Class X (%)");
    lblx.setBounds(400,300,200,30);
    lblx.setFont(new Font("serif" , Font.BOLD,20));
    add(lblx);
    
    //for enter the detail we take textview 
    tfx=new JTextField();
    tfx.setBounds(600,300,150,30);
    add(tfx);
    
   //
    JLabel lblxii = new JLabel(" Class XII (%)");
    lblxii.setBounds(50,350,200,30);
    lblxii.setFont(new Font("serif" , Font.BOLD,20));
    add(lblxii);
    
    //for enter the detail we take textview 
    tfxii=new JTextField();
    tfxii.setBounds(200,350,150,30);
    add(tfxii);
   
    //adharcard
    JLabel lblaadhar = new JLabel(" Aadhar Number");
    lblaadhar.setBounds(400,350,200,30);
    lblaadhar.setFont(new Font("serif" , Font.BOLD,20));
    add(lblaadhar);
    
    //for enter the detail we take textview 
    tfaadhar=new JTextField();
    tfaadhar.setBounds(600,350,150,30);
    add(tfaadhar);
    
    //which course you want to join
    JLabel lblcourse = new JLabel("Course");
    lblcourse.setBounds(50,400,200,30);
    lblcourse.setFont(new Font("serif" , Font.BOLD,20));
    add(lblcourse);
    
    //for making dropdown , 2 method
    //for putting value in dropdown create an array
    String course[] ={"B.Tech" ,"BBA","BCA","Bsc","Msc","MBA","MCA","MCom","MA","BA"};
    //1 class is "choice in awt package
    // 2 is jcombobox in swing
    cbcourse=new JComboBox(course);
    cbcourse.setBounds(200,400,150,30);
    cbcourse.setBackground(Color.WHITE);
    add(cbcourse);
    
    //branch
    JLabel lblbranch = new JLabel("Branch");
    lblbranch.setBounds(400,400,200,30);
    lblbranch.setFont(new Font("serif" , Font.BOLD,20));
    add(lblbranch);
    
    //for making dropdown , 2 method
    //for putting value in dropdown create an array
    String branch[] ={"CSE" ,"ECE","EEE","CIVIL","MECHANICAL","IOT","CSE(AI/ML)","CSE(D)","CHEMICAL ENGG","BIOTECH"};
    //1 class is "choice in awt package
    // 2 is jcombobox in swing
    cbbranch=new JComboBox(branch);
    cbbranch.setBounds(600,400,150,30);
    cbbranch.setBackground(Color.WHITE);
    add(cbbranch);
    
    //BUTTONS
    //for using the button we access the button class by create the object
    submit= new JButton("Submit");
    submit.setBounds(250,550,120,30);
    submit.setBackground(Color.black);
    submit.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
    submit.addActionListener(this);
    submit.setFont(new Font("tahoma",Font.BOLD,16));
    add(submit);
   //cancel button
    cancel= new JButton("Cancel");
    cancel.setBounds(450,550,120,30);
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
         String name=tfname.getText();
         String fname=tffname.getText();
         String rollno=labelrollno.getText();
         String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
         String address=tfaddress.getText();
         String phone=tfphone.getText();
         String email=tfemail.getText();
         String x=tfx.getText();
         String xii=tfxii.getText();
         String aadhar=tfaadhar.getText();
         String course=(String) cbcourse.getSelectedItem();
         String branch = (String) cbbranch.getSelectedItem();
         
         try{
             String query = "insert into student values( '"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
             Conn con=new Conn();
             // we update the info
             con.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
             setVisible(false);
         }catch(Exception e){
         e.printStackTrace();}
     }else{
         setVisible(false);
     }
 }
public static void main(String args[]){
new AddStudent();
        }
}
