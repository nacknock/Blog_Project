package Service.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.ManageUserDTO;
import Service.Action;
import user.DAO.ManageDAO;
import user.DAO.SignDAO;
import util.SecurityPassword;

public class pw_chk implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
			
		String userid = (String)request.getSession().getAttribute("userid");
		if (userid == null) {
	        response.sendRedirect("/");
	    } else {
	        String pw = SecurityPassword.encoding(request.getParameter("pw"));
	        int page = Integer.parseInt(request.getParameter("page"));
	        
	        if (page == 0) {
	            session.setAttribute("msg", "문제 발생.");
	            response.sendRedirect("/manage/pw_chk.do?page=" + page);
	            return; // 리디렉션 후 메서드 종료
	        } else {
	            int result = SignDAO.getInstance().getSelectIdPw(userid, pw);
	            if (result == 1) { // 로그인 성공
	                session.setAttribute("checked", true);
	                if (page == 1) {
	                    response.sendRedirect("/manage/user.do");
	                    return;
	                } else {
	                	if (page == 2) {
		                    response.sendRedirect("/manage/pw_update.do");
		                } else {
		                	if (page == 3) {
			                    response.sendRedirect("/manage/user_del.do");
			                } else {
			                    session.setAttribute("msg", "문제 발생.");
			                    response.sendRedirect("/manage/pw_chk.do?page=" + page);
			                }
		                }
	                }
	            } else { // 로그인 실패
	                session.setAttribute("msg", "비밀번호가 다릅니다.");
	                response.sendRedirect("/manage/pw_chk.do?page=" + page);
	            }
	        }
	    }

	}

}
