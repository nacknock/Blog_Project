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
import Service.manage.CertiCheck;
import Service.manage.LoadUser;
import Service.manage.MailSendByUpdate;
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
import Service.manage.open_post_write;
import Service.manage.open_pw_chk;
import Service.manage.pw_chk;
import Service.manage.q_detail;
import Service.manage.q_list;
import Service.manage.q_paging;
import Service.manage.q_writeAction;
import Service.manage.qna_write;

/**
 * Servlet implementation class ManageController
 */
@WebServlet("/manage/*")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2, //2MB이상일 때 임시 디스크에 저장
		maxFileSize = 1024*1024*20, // 최대 파일 크기 20MB로 변경
		maxRequestSize = 1024*1024*100 //최대 요청 크기 100MB로 변경
		)
public class ManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageController() {
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
		case "/main.do":
			//new LoadMain().command(request, response);
			page="/blog/template/manage/main.jsp";
			break;
		case "/user.do":
			new LoadUser().command(request, response);
			page="/blog/template/manage/user.jsp";
			break;
		case "/pw_chk.do":
			new open_pw_chk().command(request, response);
			page="/blog/template/manage/pw_chk.jsp";
			break;
		case "/pw_chkAction.do":
			new pw_chk().command(request, response);
			break;
		case "/emailsend.do":
			new MailSendByUpdate().command(request, response);
			break;
		case "/certiCheck.do":
			new CertiCheck().command(request, response);
			break;
		case "/user_update.do":
			new UserUpdate().command(request, response);
			page="/blog/template/manage/main.jsp";
			break;
		case "/pw_update.do":
			new PwUpdate().command(request, response);
			page="/blog/template/manage/pw_update.jsp";
			break;
		case "/pw_updateAction.do":
			new PwUpdateAction().command(request, response);
			break;
		case "/user_del.do":
			new User_Del().command(request, response);
			page="/blog/template/manage/user_del.jsp";
			break;
		case "/user_delAction.do":
			new UserDelAction().command(request, response);
			break;
		case "/qna_write.do":
			new qna_write().command(request, response);
			page="/blog/template/manage/qna_write.jsp";
			break;
		case "/q_writeAction.do":
			new q_writeAction().command(request, response);
			break;
		case "/qna_list.do":
			new q_list().command(request, response);
			page="/blog/template/manage/q_list.jsp";
			break;
		case "/q_paging.do":
			new q_paging().command(request, response);
			break;
		case "/qna_detail.do":
			new q_detail().command(request, response);
			page="/blog/template/manage/q_detail.jsp";
			break;
		case "/ctgrAdd.do":
			new ctgrAdd().command(request, response);
			break;
		case "/ctgrModify.do":
			new ctgrModify().command(request, response);
			break;
		case "/ctgrDel.do":
			new ctgrDel().command(request, response);
			break;
		case "/ctgrPrivate.do":
			new ctgrPrivate().command(request, response);
			break;
		case "/open_post_write.do":
			new open_post_write().command(request, response);
			page="/blog/template/manage/wirte_post.jsp";
			break;
		case "/post_writeAction.do":
			new Post_save().command(request, response);
			break;
		}
		
		if(page != null) {
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
