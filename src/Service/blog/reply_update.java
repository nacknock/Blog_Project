package Service.blog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import VO.B_replyVo;
import user.DAO.BlogDAO;

public class reply_update implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		

		B_replyVo vo = new B_replyVo();
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		String r_content = request.getParameter("r_content");
		System.out.println(r_content+" : 1234");
		int r_p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		int result = 0;
		
		vo.setR_idx(r_idx);
		vo.setR_content(r_content);

		String userid = (String)request.getSession().getAttribute("userid");
		
		if(userid == null || !BlogDAO.getInstance().checkReply(userid,r_idx)) {
			result = -1;
		}
		
		result = BlogDAO.getInstance().reply_updateAction(vo);
		
		response.sendRedirect("/b/detail.do?blog="+b_idx+"&&p="+r_p_idx);
		
		
	}

}
