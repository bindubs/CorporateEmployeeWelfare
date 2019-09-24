import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Registration {

	
	public static int Registration(int empid, String employeeRegisterUsername, long phone, String newpassword,
			String email) throws NullPointerException {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BINDU", "56789");
			Statement stmt = conn.createStatement();
			int a = stmt.executeUpdate("INSERT INTO EmployeeLogin Values("+empid+",'"+employeeRegisterUsername+"','"+email+"',"+phone+",'"+newpassword+"',1)");
			return a;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}
			catch (SQLException sqlE) {
				System.out.println("Error Occured while Closing Conection!!");
			}
		}
		return 0;
		// TODO Auto-generated method stub
		
	}

}
