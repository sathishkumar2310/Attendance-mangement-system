
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;

public class console{
    JLabel lab,hd;
    JComboBox t1,t2;
    JButton console;
    JRadioButton rb1,rb2;
    
    console()
    {
        
 String data[]={"I_CS","I_BCA","I_IT","II_CS","II_BCA","II_IT","III_CS","III_BCA","III_IT"};
 String data1[]={"I_MSc_CS","II_MSc_CS","I_MSc_IT","II_MSc_IT"};
         JFrame f=new JFrame("CONSOLIDATE");
       hd=new JLabel("CONSOLIDATION OF CLASS");
       hd.setBounds(100, 5, 200, 20);
        lab=new JLabel("SELECT CLASS  :");
        lab.setBounds(80,100,100,20);
        rb1=new JRadioButton("UG");
        rb1.setBounds(30, 30, 60, 20);
        rb2=new JRadioButton("PG");
        rb2.setBounds(100, 30, 60, 20);
       rb1.setSelected(true);
        rb1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){  
            if(rb1.isSelected())
            {
                t2.setVisible(false);
              t1.setVisible(true);
            }
               
            }  
        });
         rb2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){  
            if(rb2.isSelected())
            {
              t1.setVisible(false);
              t2.setVisible(true);
              
            }
               
            }  
        });
        t1=new JComboBox(data);
        t1.setBounds(190,100,100,20);
        t2=new JComboBox(data1);
        t2.setBounds(190,100,100,20);
        console=new JButton("REPORT");
        console.setBounds(150,150,95,30);
       console.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){
        if(rb1.isSelected())
        {
          String a=(String) t1.getItemAt(t1.getSelectedIndex());
               meth2(a);  
        }else if(rb2.isSelected())
        {
            String a=(String) t2.getItemAt(t2.getSelectedIndex());
               meth2(a);
        }
        
            }  
        });
         ButtonGroup bg=new ButtonGroup(); 
         
        bg.add(rb1);
        bg.add(rb2); 
       f.add(hd);
        f.add(lab);
        f.add(t1);
        f.add(t2);
        f.add(rb1);
        f.add(rb2);
        f.add(console);
        f.setSize(400,400);  
        f.setLayout(null); 
        
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true);
              
        
    }
    
    public void meth2(String tab)
    {
        final Vector columnNames = new Vector();
        final Vector data = new Vector(); 
    try
        {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS","root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from "+tab+";");
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) 
        {
columnNames.addElement( md.getColumnName(i) );
        }
while (rs.next()) 
{
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++)
{
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
JFrame frame=new JFrame("CLASS CONSOLIDATE REPORT");
JTable table = new JTable(data, columnNames);

JScrollPane pane=new JScrollPane(table);

frame.add(pane);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.pack();
frame.setSize(1366, 768);
}
catch(ClassNotFoundException | SQLException | HeadlessException ex){
System.out.println(ex);
}
    }


}

