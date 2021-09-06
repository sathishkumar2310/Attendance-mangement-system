
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class database3 {
    public void Altar1(String ta,String co,int roll)
                {
                    
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS","root","")) {
                            try {
                                Statement st1 = conn.createStatement();
                                
                                PreparedStatement preparedStmt = conn.prepareStatement("update "+ta+" set "+co+"='0' where ROLL_NO="+roll+";");

                                preparedStmt.executeUpdate();
                                
                            } catch (SQLException s) {
                                System.out.println(s);
                            }
				
			}		} catch (ClassNotFoundException | SQLException e)
                {
		}
}
}

