package servletWeb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1
 */
public class ArticleAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String addArticleSql;
	private String selectArticleSql;
	private ResultSet rs;
	private int articleSelectTypeId;
	private int articleAddTypeId;
	private int articleId;
	private String articleName;
	private MysqlConection mc;
	
	
	/**
	 * dopost
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			String type = null;
			type = req.getParameter("type");
			if(null==type){
				type="1";
			}
			
			// 创建mysql连接对象
			mc = new MysqlConection();
			mainSelect ms = new mainSelect();
			String selectTypeSql = "SELECT * FROM blogdb.articleType ORDER BY id LIMIT 8";
			try {
				ms.selectDetailType(selectTypeSql, mc, req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(type.equals("1")){
				req.getRequestDispatcher("/myadmin/add-article.jsp").forward(req, resp);
			}else if(type.equals("2")){
				req.getRequestDispatcher("/myadmin/article-type.jsp").forward(req, resp);
			}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try{
		// 从页面获取标题和文章内容然后插入数据库
					// 分类增加
					articleAdd(mc, req, resp);
					// 在没有后台时自动查询输出刚添加到文章，看看是否插入成功
					// selectArticleSql = "SELECT * FROM blogdb.article ORDER BY id DESC
					// limit 1";
					System.out.println("articleName===main==="+articleName);
					selectArticleSql = "SELECT * FROM blogdb.article WHERE articleName='" + articleName
							+ "'  ORDER BY id DESC limit 1";
					rs = mc.selectMysqlSql(selectArticleSql);
					while (rs.next()) {
						articleId = Integer.valueOf(rs.getString(1));
					}
					System.out.println("articleId======" + articleId);
					// 分类与文章关系表建立

					//articleTypeAdd(mc, req, resp);
					
					// 调用另外mainSelect的函数显示文章内容
					mainselectOutResult(selectArticleSql, mc, req, resp);
					// 下面是本类的函数，简单的显示
					// selectOutResult(mc, req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * 从前台获取文章标题和文章内容并插入数据库的函数
	 */
	public void articleAdd(MysqlConection mc, HttpServletRequest req, HttpServletResponse resp) {

		articleName = req.getParameter("articleName");
		String articleContent = req.getParameter("articleContent");
		String[] articleType=req.getParameterValues("articleType");
		// String type1 = req.getParameter("type1");
		// System.out.println("type1==="+type1);
		System.out.println("articleName:" + articleName);
		System.out.println("articleContent" + articleContent);
		addArticleSql = "INSERT INTO article(articleName,articleContent) values ('" + articleName + "','"
				+ articleContent + "')";
		// 插入数据库
		System.out.println(
				"addArticleSql===================================================================" + addArticleSql);
		try {
			mc.insertMysqlSql(addArticleSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("add blog success.");
	}

	/**
	 * 在没有后台的情况下，查询输出刚刚添加的文章，并调用前台页面显示
	 * 
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 **/

	public void mainselectOutResult(String selectArticleSql, MysqlConection mc, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		mainSelect ms = new mainSelect();
		try {
			ms.selectDetailArticle(selectArticleSql, mc, req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 测试函数，简单输出
	 */
	public void selectOutResult(MysqlConection mc, HttpServletRequest req, HttpServletResponse resp) {

		selectArticleSql = "SELECT * FROM article ORDER BY id DESC limit 1";
		try {
			// 查询输出
			// System.out.println("selectArticleSql==" + selectArticleSql);
			rs = mc.selectMysqlSql(selectArticleSql);
			// System.out.println("success or failure");
			// System.out.println("print rs==" + rs);
			// 读取数据，并返回到另外一个页面
			ArrayList<String[]> al = new ArrayList<String[]>();
			while (rs.next()) {
				String[] arr = { rs.getString("id"), rs.getString("articleName"), rs.getString("articleContent") };
				al.add(arr);
				// System.out.println(al);
				// System.out.println(arr[0] + " " + arr[1]);
			}
			// String an = rs.getString("articleName");
			// String ac = rs.getString("articleContent");
			req.setAttribute("array", al);
			// req.setAttribute("articleContent", articleContent);
			req.getRequestDispatcher("home/articleshow.jsp").forward(req, resp);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增加分类的函数，并处理分类id和文章id的对应关系
	 * 
	 * *1，将分类插入分类表中 2，查询出分类id和文章id 3，将结果写入文章和分类的关系表中
	 * 
	 * @throws SQLException
	 */

	private void articleTypeAdd(MysqlConection mc, HttpServletRequest req, HttpServletResponse resp)
			throws SQLException {

		String articleSelectType = req.getParameter("articleSelectType");
		String articleAddType = req.getParameter("articleAddType");

		System.out.println("选择的分类：" + articleSelectType);
		System.out.println("新增加的分类：" + articleAddType);

		//插入分类名称sql
		String insertTypesql = "INSERT INTO articleType(typeName) VALUES ('" + articleAddType + "')";

		//插入分类id和文章id的sql
		String inertRelationsql1 = "INSERT INTO relationShip(articleId,typeId) VALUES ('" + articleId + "','"
				+ articleAddTypeId + "')";
		String inertRelationsql2 = "INSERT INTO relationShip(articleId,typeId) VALUES ('" + articleId + "','"
				+ articleSelectTypeId + "')";
		String inertRelationsql3 = "INSERT INTO relationShip(articleId,typeId) VALUES ('" + articleId + "','"
				+ articleAddTypeId + "'),('" + articleId + "','" + articleSelectTypeId + "')";

		if (null == articleAddType && null == articleSelectType
				|| "".equals(articleAddType) && "".equals(articleSelectType)) {
			System.out.println("1");
			// ResultSet rs = mc.selectMysqlSql("SELECT id FROM blogdb.article
			// OEDER BY id DESC limit 1");
			// while (rs.next()) {
			// articleAddTypeId = Integer.valueOf(rs.getString(0));
			// System.out.println(articleAddTypeId);
			articleSelectTypeId = 1;
			mc.insertMysqlSql(inertRelationsql2);
			// }
		} else if (null == articleAddType && null != articleSelectType || "".equals(articleAddType)) {
			System.out.println("2");
			String se = "SELECT * FROM blogdb.articleType WHERE typeName='" + articleSelectType
					+ "' ORDER BY id desc LIMIT 1";
			System.out.println(se);
			ResultSet rs = mc.selectMysqlSql(se);
			System.out.println(rs);
			// System.out.println(rs.getNString(1));
			while (rs.next()) {
				articleSelectTypeId = Integer.valueOf(rs.getString(1));
				System.out.println("articleSelectTypeId===" + articleSelectTypeId);
			}
			mc.insertMysqlSql(inertRelationsql1);
		} else if (null != articleAddType && null == articleSelectType || "".equals(articleSelectType)) {
			System.out.println("3");
			mc.insertMysqlSql(insertTypesql);
			rs = mc.selectMysqlSql("SELECT * FROM blogdb.articleType WHERE typeName='" + articleAddType
					+ "' ORDER BY id DESC limit 1");
			while (rs.next()) {
				articleAddTypeId = Integer.valueOf(rs.getString(0));
				System.out.println("articleAddTypeId==" + articleAddTypeId);
			}

			mc.insertMysqlSql(inertRelationsql2);
		} else {
			System.out.println("4");
			mc.insertMysqlSql(insertTypesql);
			ResultSet rs = mc.selectMysqlSql("SELECT * FROM blogdb.articleType WHERE typeName='" + articleAddType
					+ "' or typeName='" + articleSelectType + "'");
			ArrayList<String> al = new ArrayList<String>();
			while (rs.next()) {
				String arr1 = rs.getString("id");
				System.out.println(arr1);
				al.add(arr1);
				System.out.println(al);
			}
			articleAddTypeId = Integer.valueOf(al.get(0));
			articleSelectTypeId = Integer.valueOf(al.get(1));
			System.out.println("articleAddTypeId==" + articleAddTypeId);
			System.out.println("articleSelectTypeId==" + articleSelectTypeId);

			mc.insertMysqlSql(inertRelationsql3);
		}
	}

}
