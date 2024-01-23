package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class DBController {
	
	public Connection getConnection() {
		Connection conn = null;
		try{
			   String userName = "root";
			   String password = "W@2915djkq#";
			   String url = "jdbc:mysql://localhost/football";
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   conn = DriverManager.getConnection(url, userName, password);
			   conn.setAutoCommit(true);
		} catch(Exception e){
			   System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = null;
		try{
			   
			   Class.forName ("com.mysql.cj.jdbc.Driver");
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","W@2915djkq#");
			   System.out.println("Connection thanh cong");
			   
			   String sql = "SELECT * FROM footballteam";
			   PreparedStatement stm = con.prepareStatement(sql);
			   stm = con.prepareStatement(sql);
			   ResultSet rs = stm.executeQuery();
			  //while(rs.next()) {
			//	 System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDate(4));
			 //}
			   
		} catch(Exception e){
			 // System.out.println(e.getMessage());
		}
		
	}

}
