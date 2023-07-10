package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    Choice crollno;
    JLabel labeltotal;
    JButton pay,update,back; 
    
    JComboBox cbcourse,cbbranch,cbsemester;
    StudentFeeForm(){
     
         setSize(900,500);
         setLocation(300,100);
         
         setLayout(null);
         getContentPane().setBackground(Color.white);
         
         //for image 
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);//we cant pass imageclass directly so we create obj
         JLabel image= new JLabel(i3);
         image.setBounds(400, 50,500, 300);
         add(image);
         
        
    //for updsate the selected rollno
         JLabel lblrollnumber  = new JLabel("Select Roll No");
         lblrollnumber.setBounds(40,60,150,20);
         lblrollnumber.setFont(new Font("tahoma" , Font.BOLD,16));
         add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
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
    
    //name of label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("tahoma" , Font.BOLD,16));
        add(lblname);
    
   
     //for not to change the name so we take jlabel
       JLabel labelname = new JLabel();
       labelname.setBounds(200,100,150,20);
       labelname.setFont(new Font("tahoma" , Font.PLAIN,16));
       add(labelname);
    
     //name of label
      JLabel lblfname = new JLabel("Father's Name");
      lblfname.setBounds(40,140,150,20);
      lblfname.setFont(new Font("tahoma" , Font.BOLD,16));
      add(lblfname);
    
    //for not to change the father's name so we take jlabel
      JLabel labelfname=new JLabel();
      labelfname.setBounds(200,140,150,20);
      labelfname.setFont(new Font("tahoma" , Font.PLAIN,16));
      add(labelfname);
       
      try{
       Conn c = new Conn();
       String query = "select * from student where rollno ='"+crollno.getSelectedItem()+"'";
       ResultSet rs=c.s.executeQuery(query);
       while(rs.next());
       {
           labelname.setText(rs.getString("name"));
           labelfname.setText(rs.getString("fname"));
       }
      }catch(Exception e){
      e.printStackTrace();
      } 
      
//       crollno.addItemListener(new ItemListener(){
//           public void itemStateChanged(ItemEvent ie){
//               try{
//       Conn c = new Conn();
//       String query = "select * from student where rollno ='"+crollno.getSelectedItem()+"'";
//       ResultSet rs=c.s.executeQuery(query);
//       while(rs.next());
//       {
//           labelname.setText(rs.getString("name"));
//           labelfname.setText(rs.getString("fname"));
//       }
//      }catch(Exception e){
//      e.printStackTrace();
//      }   
//       
//           }
//       });
//       
       JLabel lblcourse = new JLabel(" Course");
       lblcourse.setBounds(40,180,150,20);
       lblcourse.setFont(new Font("TAHOMA" , Font.BOLD,16));
       add(lblcourse);
    
    //for making dropdown , 2 method
    //for putting value in dropdown create an array
    String course[] ={"B Tech","BCA","Bsc","MSc","MCA","Mcom"};
    //1 class is "choice in awt package
    // 2 is jcombobox in swing
    cbcourse=new JComboBox(course);
    cbcourse.setBounds(200,180,150,20);
    cbcourse.setBackground(Color.WHITE);
    add(cbcourse);
    
    //branch
    JLabel lblbranch = new JLabel(" Branch");
    lblbranch.setBounds(40,220,150,20);
    lblbranch.setFont(new Font("tahoma" , Font.BOLD,16));
    add(lblbranch);
    
    //for making dropdown , 2 method
    //for putting value in dropdown create an array
    String branch[] ={"CSE" ,"ECE","EEE","CIVIL","MECHANICAL","IOT","CSE(AI/ML)","CSE(D)","CHEMICAL ENGG","BIOTECH"};
    //1 class is "choice in awt package
    // 2 is jcombobox in swing
    cbbranch=new JComboBox(branch);
    cbbranch.setBounds(200,220,150,20);
    cbbranch.setBackground(Color.WHITE);
    add(cbbranch);
    
     JLabel lblsemester = new JLabel("semester");
     lblsemester.setBounds(40,260,150,20);
     lblsemester.setFont(new Font("tahoma",Font.BOLD,16));
     add(lblsemester);
    
     String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
     cbsemester = new JComboBox(semester);
     cbsemester.setBounds(200,260,150,20);
     cbsemester.setBackground(Color.white);
     add(cbsemester);
     
     JLabel lbltotal= new JLabel("Total Payable");
     lbltotal.setBounds(40,300,150,20);
     lbltotal.setFont(new Font("tahoma",Font.PLAIN,16));
     add(lbltotal);
     
    labeltotal = new JLabel();
     labeltotal.setBounds(200,300,150,20);
     labeltotal.setFont(new Font("tahoma",Font.PLAIN,16));
     add(labeltotal);
     
        update= new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        update.addActionListener(this);
        update.setFont(new Font("tahoma",Font.BOLD,16));
        add(update);
   //cancel button
        pay= new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.black);
        pay.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        pay.addActionListener(this);
       // pay.setFont(new Font("tahoma",Font.BOLD,16));
        add(pay);
        
        back= new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);//for text color
    //aftr click the button it call the actionlistener func and actionlistener call the actionperformed func
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD,16));
        add(back);
     
     setVisible(true);
    }
   public void actionPerformed(ActionEvent ae){
   if(ae.getSource()==update){
   String course=(String)cbcourse.getSelectedItem();
   String semester =(String)cbsemester.getSelectedItem();
   try{
     Conn c=new Conn();
     ResultSet rs= c.s.executeQuery("select * from fee where course='"+course+"'");
     
     while(rs.next() ){
     labeltotal.setText(rs.getString(semester));
     }
   }catch(Exception e){
      e.printStackTrace();
   }
   }else if(ae.getSource()==pay){
     String rollno=crollno.getSelectedItem();
     String course=(String)cbcourse.getSelectedItem();
     String semester=(String) cbsemester.getSelectedItem();
     String branch=(String)cbbranch.getSelectedItem();
     String total=labeltotal.getText();
      
     try{
     Conn c=new Conn();
    String query="insert into collegefees values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
    c.s.executeUpdate(query);
    
    JOptionPane.showMessageDialog(null,"College fee submitted");
    setVisible(false);
     }catch(Exception e){
      e.printStackTrace();
   }
   }else{
    setVisible(false);
   }
   }
    public static void main(String args[]){
    new StudentFeeForm();
    }
}
