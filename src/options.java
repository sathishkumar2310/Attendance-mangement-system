
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class options extends JFrame {
    
 
    options()
    {
            
        JFrame f=new JFrame("OPTIONS"); 
        
        
      
        JButton b=new JButton("ATTENDANCE"); 
        JButton b1=new JButton("CONSOLIDATE"); 
        b.setBounds(125,100,150,40);
        b1.setBounds(125,150,150,40);
       
        b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e)
    {  
             attend obj2=new attend();  
    }  
        });
        b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
             console obj5=new console();
            }  
        });
        
        f.add(b);
        f.add(b1);
        
        f.setSize(400,400);  
        f.setLayout(null); 
        
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true);   
    }  
    }  
        
 
    



