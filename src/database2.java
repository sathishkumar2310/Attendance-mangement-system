
import java.sql.*;


public class database2 {
     public void Altar(String table,String col)
                {
                    
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS","root","");
			try {
				Statement st = con.createStatement();
				String sql = "ALTER TABLE "+table+" add("+col+" varchar(30))";
				st.executeUpdate(sql);
                                PreparedStatement preparedStmt = con.prepareStatement("update "+table+" set "+col+"='1';");

                                preparedStmt.executeUpdate();
				
			} catch (SQLException s) {
				System.out.println(s);
			}
			con.close();
		} catch (Exception e)
                {
			e.printStackTrace();
		}
                }
                
                }


