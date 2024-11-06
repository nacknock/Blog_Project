package Service.Sign;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;

public class login_check implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String login_userid = (String)request.getSession().getAttribute("userid");
		
		if(login_userid == null) {
			response.sendRedirect("/sign/login.do");
		}
		

	}

}
