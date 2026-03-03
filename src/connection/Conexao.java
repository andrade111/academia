package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String URL = "";
	private static final String username = "";
	private static final String password = "";
	
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL, username, password);
	}
}
