package postgresql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCPostgresqlconnect {
		
		
			   static final String DB_URL = "jdbc:postgresql://localhost:5432/java_learning";
			   static final String USER = "anusha";
			   static final String PASS = "amazing";
			   static final String QUERY = "SELECT * FROM employees";

			   public static void main(String[] args) {
			      // Open a connection
				   try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			         Statement stmt = conn.createStatement();
			      ) {	
//			    	   // Execute a query
			          System.out.println("Inserting records into the table...");          
			          String sql = "INSERT INTO employees VALUES ('a0eebc999c0b4ef8bb6d6bb9bd380a11','anu', 'prawin@gmail.com', 9876543456)";
			          stmt.executeUpdate(sql);
//			          sql = "INSERT INTO employees VALUES ('anusha', 'anusha@gmail.com', 9999887766)";
//			          stmt.executeUpdate(sql);
//			          sql = "INSERT INTO employees VALUES ('manju', 'manju@gmail.com', 8976543456)";
//			          stmt.executeUpdate(sql);
//			          sql = "INSERT INTO employees VALUES('dilli', 'dilli@gmail.com', 9876543234)";
			          System.out.println("Inserted records into the table..."); 
		    		  ResultSet rs = stmt.executeQuery(QUERY);

			          while(rs.next()){
			              //Display values
			        	  System.out.println(" id: " + rs.getString("emp_id"));
			              System.out.println(" username: " + rs.getString("emp_name"));
			              System.out.println(" mobile_number: " + rs.getString("mobile_number"));
			              System.out.println(" email: " + rs.getString("email"));
			          
			       }
			      }catch (SQLException e) {
			          e.printStackTrace();
			       } 
			    }
		}