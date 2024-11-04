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
		
		String r_content = request.getParameter("r_content");

		int r_grade = 0;
		
		B_userVo r_parent = new B_userVo();
		
		if(request.getParameter("r_parent") != null && !request.getParameter("r_parent").equals("")) {
			r_parent.setIdx(Integer.parseInt(request.getParameter("r_parent")));
			r_grade = 1;
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
		
		
		int result = BlogDAO.getInstance().reply_write(vo);

		Map<String, String> map = new HashMap<String, String>();

		Gson gson = new Gson();
		
		String msg = null;
		
		if(result > 0) {
			map.put("result","ok");
		}else{
			map.put("result","nok");
		}

		msg = gson.toJson(map); //map->json
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(msg.toString());
	}

}
