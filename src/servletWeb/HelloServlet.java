package servletWeb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//第一步：继承httpservlet抽象类
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 第二步：覆盖doGet()方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		// 第三步：创建数据库连接对象
		MysqlConection mc = new MysqlConection();

		try {
			//方便调试，控制台输出
			System.out.println(req.getParameter("firstname"));
			System.out.println(req.getParameter("lastname"));
			// 第四部：调用jsp来获取数据，并插入数据库
			mc.ins(req.getParameter("firstname"), req.getParameter("lastname"));
			// 第五步：查询输出
			ResultSet rs = mc.getResultSet();
			ArrayList<String[]> al = new ArrayList<String[]>();
			while (rs.next()) {
				// String firstname = rs.getString("firstname");
				// String lastname = rs.getString("lastname");
				// System.out.println("firstname is :"+firstname+" lastname
				// is:"+lastname);
				String[] aly = { rs.getString("firstname"), rs.getString("lastname") };
				al.add(aly);
				al.toArray();
				System.out.println(al);
				System.out.println(aly[0] + "   " + aly[1]);
			}
			for (String[] strings : al) {
				System.out.println("@@@@@@@@@@@@@@@" + strings[0]);
			}

			req.setAttribute("allist", al);
			req.getRequestDispatcher("helloout.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
