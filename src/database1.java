
import java.sql.*;
public class database1 
{
    Connection con1;
    PreparedStatement pst1;
    ResultSet rs1;
    database1()
    {
        try{
 Class.forName("com.mysql.jdbc.Driver");
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
                        pst1=con1.prepareStatement("select * from cls_login where uname=? and pwd=?");
             
           }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
        
public Boolean checkLogin(String uname,String pwd)
    {
        try {
                        
            pst1.setString(1, uname);        
    pst1.setString(2, pwd);    
rs1=pst1.executeQuery();
            if(rs1.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("error while validating"+e);
            return false;
        }
}
}



