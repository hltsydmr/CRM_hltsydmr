import java.sql.*;

public class DbCreate {

	public void createDb(){
		try{
			Class.forName(DbSettings.driver);
			String url = DbSettings.protocol + DbSettings.dbName + ";create=true";
			Connection conn = DriverManager.getConnection(url, DbSettings.username, DbSettings.password);
			Statement statement = conn.createStatement();
			String tableSql = "CREATE TABLE tableCustomer (id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1,INCREMENT BY 1), name VARCHAR(20), surname VARCHAR(20), company VARCHAR(50), department VARCHAR(50), position VARCHAR(50), phone VARCHAR(20), email VARCHAR(100))";
			statement.execute(tableSql);
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
