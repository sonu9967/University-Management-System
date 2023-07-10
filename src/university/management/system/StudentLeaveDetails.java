
package university.management.system;
import javax.swing.*; //fro jframe
import java.awt.*; //for color
import java.sql.*; //for fetching the data and show the data

import net.proteanit.sql.DbUtils; //by dbutils class we an directly insert  data into table from db
import java.awt.event.*; //for actionlistener
public class StudentLeaveDetails extends JFrame implements ActionListener{
    Choice crollno;
    
    JTable table;//for table cration
    JButton search , print,update,add ,cancel;
    StudentLeaveDetails(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
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
        
        //for table
        table= new JTable();
         try{
            //create a conn class for establish the connection with db
            Conn c = new Conn();
            // it will hit query ans store into rs
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            //directlt print the data on table
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
           
        
        }catch(Exception e){
            //print that exception
            e.printStackTrace();
        }
        //for scrollbar 
        //but first create a table so
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print =new JButton("Print")  ;
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
//        add =new JButton("Add")  ;
//        add.setBounds(220,70,80,20);
//        add.addActionListener(this);
//        add(add);
//        
//        update =new JButton("Update")  ;
//        update.setBounds(320,70,80,20);
//        update.addActionListener(this);
//        add(update);
        
        cancel =new JButton("Cancel")  ;
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900,700);
        setLocation(220,20);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query= "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
           try{
           Conn c = new Conn();
           ResultSet rs=c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if(ae.getSource() == print){
        try{
        table.print();//for access the print function of system
        }catch(Exception e){
            e.printStackTrace();
        }
//        }else if(ae.getSource()==add){
//        setVisible(false);//if add then close that window and open
//        new AddStudent();//addstudent window for adding stu info
//        }else if(ae.getSource()==update){
//        setVisible(false);//if add then close that window and open
//       // new UpdateStudent();
//        }else{
        setVisible(false);
        }
            
    }
            
    public static void main(String args[]){
    new StudentLeaveDetails();
    }
}

// we dont have to change the file location aftr taking into project