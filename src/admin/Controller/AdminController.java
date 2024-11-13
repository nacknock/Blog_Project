package admin.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Sign.login_check;
import Service.admin.admin_check;
import Service.admin.open_admin_main;
import Service.admin.open_blog_detail;
import Service.admin.open_blog_list;
import Service.admin.open_user_detail;
import Service.admin.open_user_list;
import Service.blog.getDetail;
import Service.blog.getReplyList;
import Service.blog.getlist;
import Service.blog.open_search_result;
import Service.blog.post_delete;
import Service.blog.reply_delAciton;
import Service.blog.reply_update;
import Service.blog.reply_writeAciton;
import Service.blog.search_result_b;
import Service.blog.search_result_p;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doAction(request,response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println(action);
		String page = null;
		new admin_check().command(request, response);
		if (response.isCommitted()) { // 응답이 이미 전송된 경우
	        return; // 더 이상 처리하지 않음
	    }
		switch (action) {
		case "/main.do":
			new open_admin_main().command(request, response);
			page="/blog/template/admin/admin_main.jsp";
			break;
		case "/user_list.do":
			new open_user_list().command(request, response);
			page="/blog/template/admin/user_list.jsp";
			break;
		case "/user_detail.do":
			new open_user_detail().command(request, response);
			page="/blog/template/admin/user_detail.jsp";
			break;
		case "/blog_list.do":
			new open_blog_list().command(request, response);
			page="/blog/template/admin/blog_list.jsp";
			break;
		case "/blog_detail.do":
			new open_blog_detail().command(request, response);
			page="/blog/template/admin/blog_detail.jsp";
			break;
		}
		
		if(page != null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}
}
