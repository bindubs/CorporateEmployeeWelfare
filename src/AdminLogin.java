import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AdminLogin {
	public static ResultSet AdminLogin(String adminUsername, String adminPassword) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM AdminLogin where Username = '"+adminUsername+"' and pass_word ='"+adminPassword+"'");
			return rs;		
	}

	public static ResultSet EmployeeDeatils(int adminEmployeeId) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EmployeeLogin where id = "+adminEmployeeId+"");
			return rs;
		// TODO Auto-generated method stub
		
	}

	public static ResultSet EmployeeDeatils1(int adminEmployeeId) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from EmployeeDeatils where id = "+adminEmployeeId+"");
			return rs;
	}

	public static void AdminDropMethod(int adminEmployeeDropId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM EmployeeDeatils where id = "+adminEmployeeDropId+"");
			stmt.executeUpdate("DELETE FROM EmployeeLogin where id = "+adminEmployeeDropId+"");
			System.out.print("Record is Deleted");
	}
}
