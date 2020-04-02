package Jdbc_0530_Board_Bean;

import java.sql.*;

public class DBManager {
	String myDriver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "JSLDB";
	String password = "6007";
	Connection conn = null;

	public Connection getConnection() throws Exception{
		try {
			Class.forName(myDriver);
			System.out.println("드라이버 연결 성공");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("드라이버 연결 실패");
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("커넥션 성공");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("커넥션 실패");
		} finally {

		}
		return conn;
	}
}
