package Service.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.PostVo;
import VO.TagVo;
import user.DAO.ManageDAO;

public class open_post_modify implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = (String)request.getSession().getAttribute("userid");
		
		ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);

		request.setAttribute("dto", dto);
		
		int pidx = Integer.parseInt((String)request.getParameter("p_idx"));
		
		PostVo vo = ManageDAO.getInstance().sel_post_one(pidx);
		
		request.setAttribute("vo", vo);
		
		List<TagVo> taglist = ManageDAO.getInstance().sel_tags(pidx);
		
		request.setAttribute("taglist", taglist);

	}

}
