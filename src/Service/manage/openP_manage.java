package Service.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.PostVo;
import VO.categoryVo;
import user.DAO.ManageDAO;

public class openP_manage implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = (String)request.getSession().getAttribute("userid");
		
		ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);
		
		request.setAttribute("dto", dto);
		request.setAttribute("b_idxBypaging", dto.getBlog().getB_idx());

	}

}
