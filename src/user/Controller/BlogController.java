package user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Sign.MailAuth;
import Service.Sign.MailSend;
import Service.Sign.login;
import Service.blog.getDetail;
import Service.blog.getReplyList;
import Service.blog.getlist;
import Service.blog.reply_update;
import Service.blog.reply_writeAciton;
import Service.manage.CertiCheck;
import Service.manage.LoadUser;
import Service.manage.MailSendByUpdate;
import Service.manage.Pchange_pri;
import Service.manage.Post_save;
import Service.manage.PwUpdate;
import Service.manage.PwUpdateAction;
import Service.manage.UserDelAction;
import Service.manage.UserUpdate;
import Service.manage.User_Del;
import Service.manage.ctgrAdd;
import Service.manage.ctgrDel;
import Service.manage.ctgrModify;
import Service.manage.ctgrPrivate;
import Service.manage.openP_manage;
import Service.manage.open_post_modify;
import Service.manage.open_post_write;
import Service.manage.open_pw_chk;
import Service.manage.open_reply_manage;
import Service.manage.postModifyAction;
import Service.manage.post_del;
import Service.manage.post_paging;
import Service.manage.pw_chk;
import Service.manage.q_detail;
import Service.manage.q_list;
import Service.manage.q_paging;
import Service.manage.q_writeAction;
import Service.manage.qna_write;
import Service.manage.reply_paging;

/**
 * Servlet implementation class ManageController
 */
@WebServlet("/b/*")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2, //2MB이상일 때 임시 디스크에 저장
		maxFileSize = 1024*1024*20, // 최대 파일 크기 20MB로 변경
		maxRequestSize = 1024*1024*100 //최대 요청 크기 100MB로 변경
		)
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		case "/reply_update.do":
			new reply_update().command(request, response);
			break;
		case "/reply_write.do":
			new reply_writeAciton().command(request, response);
			break;
		case "/list.do":
			new getlist().command(request, response);
			page = "/blog/template/list.jsp";
			break;
		case "/detail.do":
			new getDetail().command(request, response);
			page = "/blog/template/detail.jsp";
			break;
		case "/reply_list.do":
			new getReplyList().command(request, response);
			break;
			
		}
		
		if(page != null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
