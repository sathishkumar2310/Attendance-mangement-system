import java.awt.Color;
import java.awt.event.*;  
    import javax.swing.*;    
    public class c_log { 
        c_log()
        {
            JFrame f=new JFrame("STAFF LOGIN");
            f.getContentPane().setBackground(Color.pink);
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
        JButton b2=new JButton("REGISTER");
        JButton b3=new JButton("CHANGE PASSWORD");
        b.setBounds(50,150,95,30);
        b1.setBounds(200,150,95,30);
        b2.setBounds(50,200,95,30);
        b3.setBounds(180,200,200,30);
        
        database1 db;
    db=new database1();
        b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                char[] temp_pwd=tf1.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
               
                
                if(db.checkLogin(tf.getText(), pwd))
                {
                    System.out.println("class logged in successfully");
                    options obj1=new options();
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
        b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
              register ob=new register();
            }  
        });
        b3.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
              chgpwd ob1=new chgpwd();
            }  
        });
        f.add(b2);
        f.add(b3);
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
    
    }  