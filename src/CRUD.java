
import java.sql.*;


public class CRUD {
private	 static String dbURL = "jdbc:postgresql://localhost:5433/Test";
private static	String username = "postgres";
private static 	String password = "root";



	public static void INSERT (String usern,String pass, String fullname, String email) throws SQLException{
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		String sql = "INSERT INTO user (username, password, fullname, email) VALUES (?, ?, ?, ?)";
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		PreparedStatement statement = conn.prepareStatement(sql);
		 statement.setString(1, usern);
		 statement.setString(2, pass);
		 statement.setString(3, fullname);
		 statement.setString(4, email);
		 int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
		conn.close();
		
	}
	
	
	public static void SELECT () throws SQLException{
		String sql = "SELECT * FROM user";
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		Statement statement = conn.createStatement();
		ResultSet result =  statement.executeQuery(sql);
		int count = 0;
		 
		while (result.next()){
		    String name = result.getString(2);
		    String pass = result.getString(3);
		    String fullname = result.getString("fullname");
		    String email = result.getString("email");
		 
		    String output = "User #%d: %s - %s - %s - %s";
		    System.out.println(String.format(output, ++count, name, pass, fullname, email));
		}
		conn.close();
		
	}
	
	public static void DELETE (String name) throws SQLException{
		String sql = "DELETE FROM Users WHERE username=?";
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}else System.out.println("user indefiened");
		conn.close();
	}
	public static void UPDATE (String usern) throws SQLException{
		String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
		Connection conn = DriverManager.getConnection(dbURL, username, password);
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, "123456789");
		statement.setString(2, "Oleg Koval");
		statement.setString(3, "oleg111koval@gmail.com");
		statement.setString(4, usern);
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("User was updated successfully!");
		}	else System.out.println("user indefiened"); 
		
		conn.close();
	}
	
	
}
