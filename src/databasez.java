import java.sql.*;

public class databasez {
   // JDBC driver name and database URL
   

   //  Database credentials
  
   
  public void meth(String uname,String pwd) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","");
      System.out.println("Connected database successfully...");
      
      
      stmt = conn.createStatement();
      
      String sql = "INSERT INTO cls_login " +
                   "VALUES ('"+uname+"','"+pwd+"')";
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
//end databasez