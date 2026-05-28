package dbCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlCon {
	public static void main(String[] args) {
		System.out.println("welcome");
		
		//step 1
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//step 2
		Connection con = DriverManager.getConnection("jdbc:mysql:localhost:3306/ajp", null, null)
	}
}
