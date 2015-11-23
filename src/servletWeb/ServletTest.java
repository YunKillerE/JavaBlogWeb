package servletWeb;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		// PrintWriter pw = resp.getWriter();
		// pw.println("hello world");
		MysqlConection mq = new MysqlConection();
		String name = req.getParameter("nm");
//		try {
//			mq.ins(name);
//			ResultSet rs = mq.getResultSet();
//			while (rs.next()) {
//				String name1 = rs.getString("name");
//				System.out.println("name:" + name1);
//				req.setAttribute("name", name1);
//				req.getRequestDispatcher("ll.jsp").forward(req, resp);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
}
