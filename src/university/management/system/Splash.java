
package university.management.system;
import javax.swing.*;
import java.awt.*; //for classloader
public class Splash extends JFrame implements Runnable {
    //declare the thread 
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);//we cant pass imageclass directly so we create obj
        JLabel image= new JLabel(i3);
        add(image);
        //object creation for thread
        t = new Thread(this);
        t.start();//for run method we have to cal start methid
        //forrun method we have to call the start methd
         setVisible(true);
         int x=1;
         //for present in smaller to bigger size conversion of frame
         for(int i=2;i<=600;i+=4, x+=1){
        setLocation(500-((i+1)/2) ,325-(i/2));//left,top se
        setSize(i+3*x,i+x/2);
        
        try{
            Thread.sleep(10);
        }
        catch(Exception e){}
         }
       }
    //for override the runnable 
    public void run(){
        try{
            Thread.sleep(7000);//7sec
            setVisible(false);//for nex frame to be opened
            //next frmae
            new Login();
        }catch(Exception e){
        }
    }
    public static void main(String args[]){
         new Splash();
    }
}
