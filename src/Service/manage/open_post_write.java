package Service.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.categoryVo;
import user.DAO.ManageDAO;

public class open_post_write implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = (String)request.getSession().getAttribute("userid");
		
		ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);
		
		request.setAttribute("dto", dto);
		
		int p_pri_yn = ManageDAO.getInstance().sel_one_p_pri_yn(dto.getBlog().getB_idx());
		
		request.setAttribute("p_pri_yn", p_pri_yn);
		
		List<categoryVo> list = ManageDAO.getInstance().sel_ctgr(dto.getBlog().getB_idx());
		
		request.setAttribute("ctgr_list", list);

	}

}
