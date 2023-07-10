package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project(){
        setSize(1540,850);
        
        // for keep the image just right side
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);//we cant pass imageclass directly so we create obj
        JLabel image= new JLabel(i3);
       // image.setBounds(350, 0, 200, 200);
      
       //
        add(image);
        //menubar is created by jmenubar class
        JMenuBar mb =new JMenuBar();
        
        //menu is putting on menubar
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.blue);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
       //details
       //menu is putting on menubar
        JMenu details = new JMenu("view details");
        details.setForeground(Color.red);
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.white);
        studentdetails.addActionListener(this);
        details.add(studentdetails);// for add in details option when we click on details then
       
        //for leave menu
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.red);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        //menu is putting on menubar
        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.red);
        mb.add(leavedetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.white);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.white);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);
        
        //exam
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.red);
        mb.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.white);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        //for upload the marks
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        //update information
        JMenu updateInfo = new JMenu("Update Information");
        updateInfo.setForeground(Color.red);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updateInfo.add(updatefacultyinfo);
        //for upload the marks
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.white);
        updateInfo.add(updatestudentinfo);
        
        //fee 
         JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.red);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        //for upload the marks
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        //Utility
         JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.red);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);
        //for upload the marks
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);
        //about
        JMenu about = new JMenu("About");
        about.setForeground(Color.red);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);
        //exit
         JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);
       
        setJMenuBar(mb);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        //we have to work on string not the button so we used the getactioncommand
        String msg=ae.getActionCommand();
        
        if(msg.equals("Exit")){
        setVisible(false);
        }else if(msg.equals("Calculator")){
        try{
        Runtime.getRuntime().exec("calc.exe");
        }catch(Exception e){
        }
        }else if(msg.equals("Notepad")){
        try{
        Runtime.getRuntime().exec("notepad.exe");
        }catch(Exception e){
        }
        }else if(msg.equals("New Faculty Information")){
        new AddTeacher();
        }else if(msg.equals("New Student Information")){
        new AddStudent();
        }else if(msg.equals("View Faculty Details")){
        new TeacherDetails();
        }else if(msg.equals("View Student Details")){
        new StudentDetails();//for update the data create an object
        }else if(msg.equals("Faculty Leave")){
        new TeacherLeave();//for update the data create an object
        }else if(msg.equals("Student Leave")){
        new StudentLeave();//for update the data create an object
        }else if(msg.equals("Faculty Leave Details")){
        new TeacherLeaveDetails();//for update the data create an object
        }else if(msg.equals("Student Leave Details")){
        new StudentLeaveDetails();//for update the data create an object
        }//for update student details is still pendin so i will writetheir
        else if(msg.equals("Enter Marks")){
        new EnterMarks();//for update the data create an object
        }else if(msg.equals("Examination Results")){
        new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
        new FeeStructure();
        }else if(msg.equals("About")){
        new About();
        }else if(msg.equals("Student Fee Form")){
        new StudentFeeForm();
        }
    }
    
    
    public static void main(String args[]){
    new Project();
    }
}
