package jdbc_0531_util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnection() throws Exception {
		String myDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JSLDB";
		String password = "6007";
		Connection conn = null;
		try {
			Class.forName(myDriver);
			//System.out.println("����̹� ���� ����");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("����̹� ���� ����");
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("Ŀ�ؼ� ����");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Ŀ�ؼ� ����");
		} finally {

		}
		return conn;
	}
}
