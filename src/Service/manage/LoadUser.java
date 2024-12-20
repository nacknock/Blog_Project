package Service.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.ManageUserDTO;
import Service.Action;
import user.DAO.ManageDAO;

public class LoadUser implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean check = (boolean)request.getSession().getAttribute("checked");
		if(check) {
			String userid = (String)request.getSession().getAttribute("userid");
			
			ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);
			
			request.setAttribute("dto", dto);
		}else {
			response.sendRedirect("/manage/main");
		}
		
	}

}
