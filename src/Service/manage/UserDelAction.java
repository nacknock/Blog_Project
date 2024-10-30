package Service.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Action;
import user.DAO.ManageDAO;

public class UserDelAction implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String userid = (String)request.getSession().getAttribute("userid");
		ManageDAO.getInstance().user_del(userid);
		HttpSession session = request.getSession();
		session.invalidate();//葛电 技记加己 昏力
		response.sendRedirect("/");
	}

}
