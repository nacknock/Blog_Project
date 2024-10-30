package Service.Sign;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Action;
import user.DAO.SignDAO;
import util.SecurityPassword;

public class login implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String pw = SecurityPassword.encoding(request.getParameter("pw"));
		System.out.println(pw);
		
		int result = SignDAO.getInstance().getSelectIdPw(userid,pw);
		HttpSession session = request.getSession();
		
		if(result == 1) {//로그인
			session.setAttribute("userid", userid);
			response.sendRedirect("/");
		}else if(result == 0) {//id or pw 틀림
			session.setAttribute("msg", "아이디 또는 패스워드 확인 바랍니다");
			response.sendRedirect("/sign/login.do");
		}else if(result == -1) {//회원가입 안함
			session.setAttribute("msg", "아이디 또는 패스워드 확인 바랍니다");
			response.sendRedirect("/sign/login.do");
		}

	}

}
