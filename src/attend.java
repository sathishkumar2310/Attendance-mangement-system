    import java.awt.event.*;  
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
    import javax.swing.*;    
    public class attend {
        
        JLabel cls,date,absent;
    JTextField dt,abs; 
    JButton next,ok,ok1,cancel;
        JRadioButton rb1,rb2;
        JComboBox ct,ct1; 
        database2 db2;
        database3 db3;
        attend()
        {
             String classes[]={"I_CS","I_BCA","I_IT","II_CS","II_BCA","II_IT","III_CS","III_BCA","III_IT"}; 
                  String classes1[]={"I_MSc_CS","II_MSc_CS","I_MSc_IT","II_MSc_IT"}; 
               
            
        JFrame f=new JFrame("ATTENDANCE"); 
        
                db2=new database2();
                db3=new database3();
                rb1=new JRadioButton("UG");
        rb1.setBounds(30, 30, 60, 20);
        rb2=new JRadioButton("PG");
        rb2.setBounds(100, 30, 60, 20);
        rb1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){  
            if(rb1.isSelected())
            {
                ct1.setVisible(false);
              ct.setVisible(true);
            }
               
            }  
        });
         rb2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){  
            if(rb2.isSelected())
            {
              ct.setVisible(false);
              ct1.setVisible(true);
              
            }
               
            }  
        });
         
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
                LocalDate localDate = LocalDate.now();
                String dtt=dtf.format(localDate);
        ct=new JComboBox(classes);
        rb1.setSelected(true);
        ct1=new JComboBox(classes1);
        ct.setBounds(80,50,80,20);
        ct1.setBounds(80,50,80,20);
        cls=new JLabel("CLASS :");
        cls.setBounds(30, 50, 100, 20);
       
        ct.setBounds(80,50,80,20);
        date=new JLabel("DATE :");
        date.setBounds(200,50,100,20);
        dt=new JTextField(dtt);
        dt.setBounds(250,50,80,20);
        ok1=new JButton("OK");
        ok1.setBounds(150,100,95,30);
        absent=new JLabel("ABSENTEES ROLL_NO:");
        absent.setBounds(30,175,150,20);
        
        abs=new JTextField(10);
        abs.setBounds(170,175,70,20);
        next=new JButton("NEXT");
        next.setBounds(250,175,80,20);
        ok=new JButton("OK");
        ok.setBounds(80,250,80,30);
        cancel=new JButton("CANCEL");
        cancel.setBounds(200,250,100,30);
        f.add(cls);
        ButtonGroup bg=new ButtonGroup(); 
         
        bg.add(rb1);
        bg.add(rb2); 
        f.add(ct);
        f.add(ct1);
        f.add(rb1);
        f.add(rb2);
        f.add(date);
        f.add(dt);
        f.add(ok1);
        f.add(absent);
        f.add(abs);
        f.add(next);
        f.add(ok);
        f.add(cancel);
         
           
            database2 obj3=new database2();
            database3 obj5=new database3();
       ok1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){ 
           if(rb1.isSelected())
           {
              String cl=(String) ct.getItemAt(ct.getSelectedIndex());
            String dat=dt.getText();
            obj3.Altar(cl,dat);     
           }
           else if(rb2.isSelected())
           {
             String cl=(String) ct1.getItemAt(ct1.getSelectedIndex());
            String dat=dt.getText();
            obj3.Altar(cl,dat);   
           }
            
                
                
            }  
        });
       ok.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
        if(rb1.isSelected())
        {
           String cl=(String) ct.getItemAt(ct.getSelectedIndex());
            String dat=dt.getText();
            dbdaily obj6=new dbdaily();   
               obj6.meth2(cl, dat);  
        }else if(rb2.isSelected())
        {
          String cl=(String) ct1.getItemAt(ct1.getSelectedIndex());
            String dat=dt.getText();
            dbdaily obj6=new dbdaily();   
               obj6.meth2(cl, dat);   
        }
               
            }  
        });
       next.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
        if(rb1.isSelected())
        {
            String cl=(String) ct.getItemAt(ct.getSelectedIndex());
            String dat=dt.getText();
                
            int lst=Integer.parseInt(abs.getText());
   obj5.Altar1(cl,dat,lst);
   meth();   
        }else if(rb2.isSelected())
        {
             String cl=(String) ct1.getItemAt(ct1.getSelectedIndex());
            String dat=dt.getText();
                
            int lst=Integer.parseInt(abs.getText());
   obj5.Altar1(cl,dat,lst);
   meth();  
        }
          
                
            }  
        });
       cancel.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            f.dispose();
                
                
            }  
        });
       
        f.setSize(400,400);  
        f.setLayout(null); 
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true); 
        
        }
        public void meth()
    {
        abs.setText("");
    }
      
    }  
     
    