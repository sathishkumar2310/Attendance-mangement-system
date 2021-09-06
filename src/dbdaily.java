
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class dbdaily {
    public void meth2(String tab,String col)
    {
        final Vector columnNames = new Vector();
        final Vector data = new Vector(); 
    try
        {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS","root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select ROLL_NO,NAME,CLASS,"+col+" from "+tab+" where "+col+"='0';");
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
JFrame frame=new JFrame("TODAY'S ATTENDANCE");
JTable table = new JTable(data, columnNames);

JScrollPane pane=new JScrollPane(table);

frame.add(pane);

frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
frame.setVisible(true);
frame.pack();
}
catch(ClassNotFoundException | SQLException | HeadlessException ex){
System.out.println(ex);
}
    }
}
