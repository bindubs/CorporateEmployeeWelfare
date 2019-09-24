import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeLogin {

	public static ResultSet EmployeeLogin(String employeeUsername, String employeePassword) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EmployeeLogin where Username = '"+employeeUsername+"' and pass_word ='"+employeePassword+"'");
			return rs;
		}

	public static int FirstTimeLogin(int iDfirstLogin, int workExperence, String dOB, String matrimonial,
			String native1, String address) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection conn = null;
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			int a = stmt.executeUpdate("INSERT INTO EmployeeDeatils  Values("+iDfirstLogin+","+workExperence+",'"+dOB+"','"+matrimonial+"','"+native1+"','"+address+"')");
			boolean b = stmt.execute("UPDATE EmployeeLogin SET count = 0 where id = "+iDfirstLogin+"");
			if(a==1 && b == false) {
				return 1;
			}else {
				return 0;
			}
		} 

	public static ResultSet EmployeeSelfDeatils(String employeeUsername, String employeePassword) throws SQLException, ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EmployeeLogin where Username = '"+employeeUsername+"' and pass_word ='"+employeePassword+"'");
			return rs;
}

	public static ResultSet EmployeeUpdateSelfDeatils(String employeeUsername, String employeePassword) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EmployeeLogin where Username = '"+employeeUsername+"' and pass_word ='"+employeePassword+"'");
			return rs;
	}

	public static boolean UpdateEmployeePassword(String newPassword, String iD1) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			boolean a = stmt.execute("UPDATE EmployeeLogin SET pass_word = '"+newPassword+"' where id = "+iD1+"");
			return a;
	}
	
	public static boolean UpdateEmail(String newEmail, String iD2) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			boolean a = stmt.execute("UPDATE EmployeeLogin SET email = '"+newEmail+"' where id = "+iD2+"");
			return a;
		}
}