package Service.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

import DTO.ManageUserDTO;
import Service.Action;
import VO.B_replyVo;
import VO.PostVo;
import VO.QuestionVo;
import VO.TagVo;
import VO.categoryVo;
import user.DAO.BlogDAO;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class getDetail implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String login_userid = (String)request.getSession().getAttribute("userid");
		
		int idx = Integer.parseInt(request.getParameter("blog"));
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		BlogDAO.getInstance().upHit(p_idx);
		
		ManageUserDTO dto =  BlogDAO.getInstance().loadPageByBlog(idx);
		
		request.setAttribute("dto", dto);
		
		String my = "and category.ctgr_private = 0 and p_private = 0";
		
		if(dto.getUser().getUser_id().equals(login_userid)) {
			my = "";
		}
		
		PostVo vo = BlogDAO.getInstance().loadDetail(p_idx);
		
		request.setAttribute("vo", vo);

		List<categoryVo> ctgr_list = BlogDAO.getInstance().getCtgrListByBlog(my,dto);
		
		request.setAttribute("ctgr_list", ctgr_list);
		
		List<TagVo> taglist = ManageDAO.getInstance().sel_tags(vo.getP_idx());
		
		request.setAttribute("taglist", taglist);
		
		List<PostVo> top3list = BlogDAO.getInstance().getLoadTop3(dto);
		
		request.setAttribute("top3list", top3list);

	}

}
