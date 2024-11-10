package Service.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.B_replyVo;
import VO.PostVo;
import user.DAO.ManageDAO;

public class LoadMain implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = (String)request.getSession().getAttribute("userid");
		
		ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);
		
		request.setAttribute("dto", dto);
		
		List<PostVo> p_list3 = ManageDAO.getInstance().getP_list_3(dto.getBlog().getB_idx());
		
		request.setAttribute("p_list3", p_list3);
		
		List<B_replyVo> rep_list3 = ManageDAO.getInstance().getR_list_3(dto.getUser().getIdx());
		
		request.setAttribute("rep_list3", rep_list3);

	}

}
