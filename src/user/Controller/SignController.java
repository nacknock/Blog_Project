package user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Sign.MailAuth;
import Service.Sign.MailSend;
import Service.Sign.UserCheck;
import Service.Sign.login;
import Service.Sign.logout;

/**
 * Servlet implementation class SignController
 */
@WebServlet("/sign/*")
public class SignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignController() {
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
		switch (action) {
		case "/login.do":
			page="/blog/template/Sign/login.jsp";
			break;
		case "/join.do":
			page="/blog/template/Sign/join.jsp";
			break;
		case "/mailAction.do":
			new UserCheck().command(request, response);
			if (response.isCommitted()) { // 응답이 이미 전송된 경우
		        return; // 더 이상 처리하지 않음
		    }
			new MailSend().command(request, response);
			page=null;
			response.sendRedirect("/sign/mail_auth.do");
			break;
		case "/mail_auth.do":
			page="/blog/template/Sign/mail_auth.jsp";
			break;
		case "/mail_authAction.do":
			page=null;
			new MailAuth().command(request, response);
			break;
		case "/loginAction.do":
			page=null;
			new login().command(request, response);
			break;
		case "/logout.do":
			new logout().command(request, response);
			break;
		}
		if(page != null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
