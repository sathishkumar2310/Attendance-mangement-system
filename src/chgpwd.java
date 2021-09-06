import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class chgpwd {
    chgpwd()
    {
        
    JFrame f=new JFrame("CHANGE PASSWORD"); 
             f.setBackground(Color.orange);
        JLabel l=new JLabel("USER NAME"); 
        JLabel l1=new JLabel("OLD PASSWORD"); 
         JLabel l2=new JLabel("NEW PASSWORD"); 
          JLabel l3=new JLabel("* old password is an optional field."); 
        l.setBounds(70, 50, 100, 20);
        l1.setBounds(40,100,100,20);
        l2.setBounds(40, 150,100, 20);
         l3.setBounds(50,250,250,30);
       JTextField tf=new JTextField();  
        tf.setBounds(180,50,150,20);
        JPasswordField tf1=new JPasswordField();  
        tf1.setBounds(180,100,150,20);
         JPasswordField tf2=new JPasswordField();
         tf2.setBounds(180,150,150,20);
        JButton b=new JButton("OK"); 
        JButton b1=new JButton("CANCEL"); 
        b.setBounds(50,200,95,30);
        b1.setBounds(200,200,95,30);
        
        b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                char[] temp_pwd=tf1.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
                 char[] temp_pwd1=tf2.getPassword();
                String pwd1=null;
                pwd1=String.copyValueOf(temp_pwd1);
               meth(tf.getText(),pwd,pwd1);
                
                
            }  
        });
        b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
              f.dispose();
            }  
        });
        f.add(l);
        f.add(tf2);
        f.add(l3);
        f.add(l2);
        f.add(l1);
        f.add(b);
        f.add(b1);
        f.add(tf);
        f.add(tf1);
        f.setSize(400,400);  
        f.setLayout(null); 
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        }
    
    
    
    
    
    
     
  public void meth(String uname,String old_pwd,String new_pwd) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
      System.out.println("Connected database successfully...");
      
      
      stmt = conn.createStatement();
      
      String sql = "update cls_login set pwd='"+new_pwd+"' where uname='"+uname+"' or pwd='"+old_pwd+"';";
      stmt.executeUpdate(sql);
      

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}
 
}
//end JDBCExample