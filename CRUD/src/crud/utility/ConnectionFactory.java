package crud.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//Singleton class
	String driverClassName = "com.mysql.cj.jdbc.Driver";
	public  String url = "jdbc:mysql://localhost:3306/Ajp8706";
	public  String username = "root";
	public  String pw = "1stdba@shreya";
	
	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	private static ConnectionFactory connectionFactory = null;
	
	public static ConnectionFactory getConnectionFactory() {
		if(connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	//method to get connection from this singleton class
	public Connection getConnection() throws SQLException {
		 Connection con = DriverManager.getConnection( url, username, pw);
		 return con;
	}
}
