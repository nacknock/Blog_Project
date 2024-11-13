package Service.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import admin.DAO.AdminDAO;

public class admin_check implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String login_userid = (String)request.getSession().getAttribute("userid");
		
		if(login_userid == null) {
			response.sendRedirect("/sign/login.do");
			return;
		}
		
		int role = AdminDAO.getInstance().roleCheck(login_userid);
		
		if(role != 1) {
			response.sendRedirect("/");
			return;
		}
		
	}

}
