package importList.DbUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DbConnect {
	public void Execute(String sql) throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException {
		Connection dbConn = createConnection();
		System.out.println("Connection Successful!"); // 如果连接成功 控制台输出Connection
		Statement st = dbConn.createStatement();
		st.execute(sql);
		st.close();
		dbConn.close();
	}

	public ResultSet ExecuteSql(String sql) throws ClassNotFoundException,
			SQLException, ParserConfigurationException, SAXException, IOException {
		Connection dbConn = createConnection();
		System.out.println("Connection Successful!"); // 如果连接成功 控制台输出Connection
														// Successful!
		// DatabaseMetaData rs = dbConn.getMetaData();
		Statement st = dbConn.createStatement();
		st.execute(sql);
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public Connection createConnection() throws ClassNotFoundException,
			SQLException, ParserConfigurationException, SAXException, IOException {
		String driverName = null;; // JDBC驱动 名称
		String dbURL = null;;// 连接服务器和数据库test
		String userName = null; // 默认用户名
		String userPwd = null;// 密码
		DocumentBuilderFactory dbf = DocumentBuilderFactory .newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File("DBConfig.xml");
		Document doc = db.parse(file); doc.getDocumentElement().getElementsByTagName("driverName");doc.getDocumentElement().getElementsByTagName("root");
		doc.getDocumentElement().getChildNodes().item(0);
		NodeList root = doc.getElementsByTagName("myRoot"); doc.getElementsByTagName("driverName");
		NodeList list = doc.getElementsByTagName("myRoot");
		for (int i = 0; i < list.getLength(); i++) {
			Element e = (Element) list.item(i);
			driverName = e.getElementsByTagName("driverName").item(0).getFirstChild().getNodeValue();  
			dbURL = e.getElementsByTagName("dbURL").item(0).getFirstChild().getNodeValue();
			userName = e.getElementsByTagName("userName").item(0).getFirstChild().getNodeValue();
			userPwd = e.getElementsByTagName("userPwd").item(0).getFirstChild().getNodeValue();
		}
		Connection dbConn;
		Class.forName(driverName);
		dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		return dbConn;
	}

}
