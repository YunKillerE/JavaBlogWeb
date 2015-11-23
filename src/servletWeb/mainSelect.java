package servletWeb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainSelect extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MysqlConection mc = new MysqlConection();
			String type = req.getParameter("type");
			System.out.println(type);
			if (null == type) {
				type = "0";
			}
			if (type.equals("0")) {
				
				
				String selectTypeSql = "SELECT * FROM blogdb.articleType ORDER BY id LIMIT 8";
				selectDetailType(selectTypeSql, mc, req, resp);
				
				selectMainArticle(mc,req,resp);
			} else if (type.equals("1")) {

				int id = Integer.valueOf(req.getParameter("id"));
				System.out.println(id);
				String selectMainSql = "SELECT * FROM blogdb.article where ID='" + id + "'";
				selectDetailArticle(selectMainSql, mc, req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectMainArticle(MysqlConection mc, HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {

		String selectMainSql = "SELECT * FROM article ORDER BY createTime DESC limit 10";
		ResultSet rs = mc.selectMysqlSql(selectMainSql);
		System.out.println("print rs==" + rs);
		ArrayList<String[]> al = new ArrayList<String[]>();
		while (rs.next()) {
			String id =  rs.getString("id");
			String articleName = rs.getString("articleName");
			String articleContent = rs.getString("articleContent");
			int acsize = articleContent.length();
			String ac = null;
			if(acsize<=150){
				ac = articleContent.substring(1, acsize);
			}else{
				ac = articleContent.substring(1, 150);
			}
			String[] arr = {id, articleName,ac};
			al.add(arr);
			System.out.println(al);
			System.out.println(arr[0] + "   " + arr[1] + "  content=====   " + arr[2]);
		}
		// String an = rs.getString("articleName");
		// String ac = rs.getString("articleContent");
		req.setAttribute("array", al);
		// req.setAttribute("articleContent", articleContent);
		req.getRequestDispatcher("jsp/main.jsp").forward(req, resp);
	}

	public void selectDetailArticle(String selectMainSql, MysqlConection mc, HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		
		ResultSet rs = mc.selectMysqlSql(selectMainSql);
		ArrayList<String[]> al = new ArrayList<String[]>();
		while (rs.next()) {
			String[] arr = { rs.getString("id"), rs.getString("articleName"), rs.getString("articleContent") };
			al.add(arr);
			System.out.println(al);
			System.out.println(arr[0] + "   " + arr[1]);
			// req.setAttribute("array", arr);
		}
		req.setAttribute("array", al);
		System.out.println(al);
		req.getRequestDispatcher("jsp/articleContent.jsp").forward(req, resp);
	}
	
	/**
	 * 查询分类，并显示在主页
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	public void selectDetailType(String selectTypeSql, MysqlConection mc, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException{
	
		
		ResultSet rs = mc.selectMysqlSql(selectTypeSql);
		ArrayList<String[]> altype = new ArrayList<String[]>();
		while (rs.next()) {
			String[] arr = { rs.getString("id"), rs.getString("typeName")};
			altype.add(arr);
			System.out.println("altype==="+altype);
			System.out.println(arr[0] + "   " + arr[1]);
			// req.setAttribute("array", arr);
		}
		req.setAttribute("arraytype", altype);
		System.out.println("altype====111==="+altype);
//		req.getRequestDispatcher("jsp/articleContent.jsp").forward(req, resp);
	}

}
