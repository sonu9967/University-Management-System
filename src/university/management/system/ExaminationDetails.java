package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener{
    JTextField search;
    JButton cancel, submit;
    JTable table;
    ExaminationDetails(){
    
    setSize(1000,475);
    setLocation(180,100);
    setLayout(null);
    
    getContentPane().setBackground(Color.white);
    
    JLabel heading = new JLabel("Enter Result");
    heading.setBounds(80,15,400,50);
    heading.setFont(new Font("tahoma",Font.BOLD,24));
    add(heading);
    
    //textfield
    search =new JTextField();
    search.setBounds(80,90,200,30);
    search.setFont(new Font("tahoma",Font.PLAIN,18));
    add(search);
    
    //button
    submit=new JButton("Submit");
    submit.setBackground(Color.black);
    submit.setBounds(300,90,120,30);
    submit.setForeground(Color.white);
    submit.setFont(new Font("tahoma",Font.BOLD,15));
    submit.addActionListener(this);
    add(submit);
    
    cancel=new JButton("Cancel");
    cancel.setBackground(Color.black);
    cancel.setBounds(440,90,120,30);
    cancel.setForeground(Color.white);
    cancel.setFont(new Font("tahoma",Font.BOLD,15));
    cancel.addActionListener(this);
    add(cancel);
    
    //table
    table=new JTable();
    table.setFont(new Font("tahoma",Font.PLAIN,16));
    //scrollbar 
    JScrollPane jsp= new JScrollPane(table);
    jsp.setBounds(0,130,1000,310);
    add(jsp);
    
    //add the data inside the table
    try{
        Conn c= new Conn();
        //for fetching the dsta ,we use this class fron sql
        ResultSet rs=c.s.executeQuery("select * from student");
        table.setModel(DbUtils.resultSetToTableModel(rs));//helpd to display
        
    }catch(Exception e){
    e.printStackTrace();
    }
    // when we click then rollno will inserted into the jtextfield
    //use 
    table.addMouseListener(new MouseAdapter(){
        //for override 
    public void mouseClicked(MouseEvent me){
    int row=table.getSelectedRow();
    //for getting the rollnumber in textfield
    search.setText(table.getModel().getValueAt(row,2).toString());//2 is for in which row value will be dispaly
    
    }
    });
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==submit){
        setVisible(false);
     new Marks(search.getText());
    }else{
    setVisible(false);
    }
    }
    public static void main(String args[]){
    new ExaminationDetails();
    }
}
 