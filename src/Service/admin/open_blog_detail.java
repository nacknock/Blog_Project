package Service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.BlogVo;
import VO.PostVo;
import admin.DAO.AdminDAO;

public class open_blog_detail implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		
		//blog vo,post list
		//b_title,b_idx,created_at,one_liner(user_id),최신 포스트 등록 일자,sum(hit),count(post),count(reply)
		//p_idx,p_title,p_private,created_at,hit,count(reply),p_ctgr(name)
		//tag
		
		BlogVo vo = AdminDAO.getInstance().getB_detail(b_idx);
		String p_created = AdminDAO.getInstance().getBlogLastPostCre(b_idx);
		
		List<PostVo> list = AdminDAO.getInstance().getAdminPList(b_idx);
		
		request.setAttribute("vo", vo);
		request.setAttribute("p_created", p_created);
		request.setAttribute("list", list);

	}

}
