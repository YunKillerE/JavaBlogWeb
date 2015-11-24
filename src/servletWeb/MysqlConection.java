package servletWeb;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConection {

	// private String url;
	// private String username;
	// private String passwd;
	//
	// String url = "jdbc:mysql://192.168.1.240:3306/studenttest" ;
	// String userName = "goujia" ;
	// String passWord = "goujia0512" ;
	String url = "jdbc:mysql://211.211.211.131:3306/blogdb?characterEncoding=utf-8";
	String userName = "blogdb";
	String passWord = "blogdb";

	Connection con = null;

	public Connection getConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		return con;
	}

	public int ins(String firstname, String lastname) throws SQLException {
		con = getConnect();
		Statement stmt = con.createStatement();
		int rows = stmt.executeUpdate(
				"INSERT INTO baseinfo(firstname,lastname) values('" + firstname + "','" + lastname + "')");
		return rows;
	}

	public ResultSet getResultSet() throws SQLException {

		con = getConnect();
		Statement stmt = con.createStatement();
		// int rows = stmt.executeUpdate("INSERT INTO ...") ;
		ResultSet rs = stmt.executeQuery("SELECT * FROM baseinfo order by id desc");
		return rs;

	}

	public int insertMysqlSql(String insertsql) throws SQLException {
		con = getConnect();
		Statement stmt = con.createStatement();
		// int rows = stmt.executeUpdate("INSERT INTO
		// baseinfo(firstname,lastname) values('"+firstname+"','"+lastname+"')")
		// ;
		int rows = stmt.executeUpdate(insertsql);
		return rows;
	}

	public ResultSet selectMysqlSql(String selectsql) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;

		con = getConnect();
		stmt = con.createStatement();
		// int rows = stmt.executeUpdate("INSERT INTO ...") ;
		// ResultSet rs = stmt.executeQuery("SELECT * FROM baseinfo order by
		// id
		// desc") ;
		rs = stmt.executeQuery(selectsql);
		return rs;
	}

}
