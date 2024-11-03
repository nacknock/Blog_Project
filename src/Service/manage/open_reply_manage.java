package Service.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.B_replyVo;
import user.DAO.ManageDAO;

public class open_reply_manage implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = (String)request.getSession().getAttribute("userid");
		
		ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);

		request.setAttribute("dto", dto);

	}

}
