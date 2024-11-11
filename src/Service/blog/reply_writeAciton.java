package Service.blog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DTO.ManageUserDTO;
import Service.Action;
import VO.AnswerVo;
import VO.B_replyVo;
import VO.B_userVo;
import VO.PostVo;
import VO.QuestionVo;
import user.DAO.BlogDAO;
import user.DAO.ManageDAO;

public class reply_writeAciton implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = (String)request.getSession().getAttribute("userid");
		
		int r_p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		
		String r_content = request.getParameter("r_content");

		int r_grade = 0;
		
		int r_group = 0;
		
		B_replyVo r_parent = new B_replyVo();
		System.out.println(request.getParameter("r_parent")+" : r_parent");
		
		if(request.getParameter("r_parent") != null && !request.getParameter("r_parent").equals("")) {
			r_parent.setR_idx(Integer.parseInt(request.getParameter("r_parent")));
			r_grade = 1;
			
			if(request.getParameter("r_group") != null && !request.getParameter("r_group").equals("")) {
				r_group = Integer.parseInt(request.getParameter("r_group"));
			}
		}else {
			r_parent = null;
		}
		
		B_replyVo vo = new B_replyVo();
		
		PostVo p_vo = new PostVo();
		p_vo.setP_idx(r_p_idx);
		
		B_userVo u_vo = BlogDAO.getInstance().getUser(userid);
		
		vo.setR_content(r_content);
		vo.setR_p_idx(p_vo);
		vo.setR_u_idx(u_vo);
		vo.setR_parent(r_parent);
		vo.setR_grade(r_grade);
		vo.setR_group(r_group);
		
		
		BlogDAO.getInstance().reply_write(vo);
		
		response.sendRedirect("/b/detail.do?blog="+b_idx+"&&p="+r_p_idx);
	}

}
