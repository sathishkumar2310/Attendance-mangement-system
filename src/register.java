
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class register {
     
        register()
        {
             JFrame f=new JFrame("REGISTRATION"); 
            
        JLabel l=new JLabel("NEW USERNAME :"); 
        JLabel l1=new JLabel("PASSWORD :"); 
        l.setBounds(40, 50, 100, 20);
        l1.setBounds(70,100,100,20);
       JTextField tf=new JTextField();  
        tf.setBounds(150,50,150,20);
        JPasswordField tf1=new JPasswordField();  
        tf1.setBounds(150,100,150,20);
        JButton b=new JButton("OK"); 
        JButton b1=new JButton("CANCEL"); 
        b.setBounds(50,150,95,30);
        b1.setBounds(200,150,95,30);
        databasez db;
    db=new databasez();
        b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                char[] temp_pwd=tf1.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
               
db.meth(tf.getText(),pwd);
JOptionPane.showMessageDialog(null, "Registered succesfully!","success!!",JOptionPane.INFORMATION_MESSAGE);
f.dispose();
                
                
            }  
        });
        b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
              f.dispose();
            }  
        });
        f.add(l);
        f.add(l1);
        f.add(b);
        f.add(b1);
        f.add(tf);
        f.add(tf1);
        f.setSize(400,400);  
        f.setLayout(null); 
        
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true);
        }
}
