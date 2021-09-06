import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;  
    import javax.swing.*;    
    public class Ams {  
        Ams()
        {
             JFrame f=new JFrame("DEPARTMENT LOGIN"); 
           f.getContentPane().setBackground(Color.GRAY);
        JLabel l=new JLabel("USER NAME :"); 
        JLabel l1=new JLabel("PASSWORD :"); 
        l.setBounds(70, 50, 100, 20);
        l1.setBounds(70,100,100,20);
       JTextField tf=new JTextField();  
        tf.setBounds(150,50,150,20);
        JPasswordField tf1=new JPasswordField();  
        tf1.setBounds(150,100,150,20);
        JButton b=new JButton("LOGIN"); 
        JButton b1=new JButton("CANCEL"); 
        b.setBounds(50,150,95,30);
        b1.setBounds(200,150,95,30);
        database db;
    db=new database();
        b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                char[] temp_pwd=tf1.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
               
                
                if(db.checkLogin(tf.getText(), pwd))
                {
                    System.out.println("dept logged in successfully");
                    c_log obj1=new c_log();
                    f.setVisible(false);
                }
                else
                {
                   
                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",JOptionPane.ERROR_MESSAGE);
                }
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
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        }
    public static void main(String[] args) {  
          Ams obj=new Ams();
    }  
    }  