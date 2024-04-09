package GenericUtilitiesPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	Connection con;
	
	public void connectDB() throws SQLException {
		
	//Step 1) Register Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	//Step 2) Get Connection
		con = DriverManager.getConnection(IPathConstant.DBurl, IPathConstant.DBusername, IPathConstant.DBpassword);
	}
	
	public void executeAndGetData(String statement, int columnNum, String expected) throws SQLException {
		
	//Step 3) Create Statement
		Statement state = con.createStatement();
	//Step 4) Execute query / update query
		ResultSet result = state.executeQuery(statement);
		
		boolean flag = false;
		
		while(result.next()) {
			
			String actual = result.getString(columnNum);
			if (actual.equals(expected)) {
				flag =true;
				break;
			}
		}
		
		if (flag) {
			System.out.println("-------Data is verified-------");
		}
		else {
			System.out.println("-------Data is not present--------");
		}
		
	}
	
	public void closeDB() throws SQLException {
		
	//Step 5) Close connection
		con.close();
	
	}
}
