package importList.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	public void Execute(String sql) throws ClassNotFoundException, SQLException {
		Connection dbConn = createConnection();
		System.out.println("Connection Successful!"); // ������ӳɹ� ����̨���Connection
														// Successful!
		// DatabaseMetaData rs = dbConn.getMetaData();
		Statement st = dbConn.createStatement();
		st.execute(sql);
		// ResultSet rs = st.executeQuery(sql);
		// while(rs.next()){
		// String idcard = rs.getString("idcard");
		// System.out.println(idcard);
		// }
		st.close();
		dbConn.close();
	}

	public ResultSet ExecuteSql(String sql) throws ClassNotFoundException,
			SQLException {
		Connection dbConn = createConnection();
		System.out.println("Connection Successful!"); // ������ӳɹ� ����̨���Connection
														// Successful!
		// DatabaseMetaData rs = dbConn.getMetaData();
		Statement st = dbConn.createStatement();
		st.execute(sql);
		ResultSet rs = st.executeQuery(sql);
		st.close();
		dbConn.close();
		return rs;
	}

	public Connection createConnection() throws ClassNotFoundException,
			SQLException {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����
		String dbURL = "jdbc:sqlserver://114.80.116.56; DatabaseName=hrchannel_data"; // ���ӷ����������ݿ�test
		String userName = "brqy"; // Ĭ���û���
		String userPwd = "5thnji9876"; // ����
		Connection dbConn;
		Class.forName(driverName);
		dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		return dbConn;
	}

}
