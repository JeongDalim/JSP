package mvc.board.util;

import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}

	private void loadJDBCDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool() {
		try {
			String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; //�닔�젙
			String username = "jsldb"; //�닔�젙
			String pw = "6007"; //�닔�젙

			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);//�쑀�슚 而ㅻ꽖�뀡 寃��궗 二쇨린(諛�由ъ큹)
			poolConfig.setTestWhileIdle(true);//而ㅻ꽖�뀡�씠 �쑀�슚�븳吏� 寃��궗
			poolConfig.setMinIdle(4);//���씠 �쑀吏��븷 理쒖냼 而ㅻ꽖�뀡�닔
			poolConfig.setMaxTotal(50);//���씠 愿�由ы븷 而ㅻ꽖�뀡 理쒕� 媛��닔

			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("oracledb", connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
