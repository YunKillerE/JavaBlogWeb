package servletWeb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectArticleById extends HttpServlet{

	public void selectArticleById(int articleId,HttpServletRequest req,HttpServletResponse resp) throws SQLException, ServletException, IOException{
	
	MysqlConection mc = new MysqlConection();

	String selectMainSql = "SELECT * FROM article where ID='" + articleId + "' ORDER BY createTime DESC";

	ResultSet rs = mc.selectMysqlSql(selectMainSql);

	ArrayList<String[]> al = new ArrayList<String[]>();

	String[] arr = { rs.getString("id"), rs.getString("articleName"), rs.getString("articleContent") };
	al.add(arr);
	System.out.println(al);
	System.out.println(arr[0] + "   " + arr[1]);

	req.setAttribute("array", al);

	req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
	
	}
	
}

