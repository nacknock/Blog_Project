package Service.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import VO.AnswerVo;
import admin.DAO.AdminDAO;

public class answer_writeAction implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int q_idx = Integer.parseInt(request.getParameter("q_idx"));
		String a_content = request.getParameter("a_content");
		
		AnswerVo avo = new AnswerVo();
		
		avo.setA_q_idx(q_idx);
		avo.setA_content(a_content);
		
		int result = AdminDAO.getInstance().A_write(avo);
		
		if(result > 0) {
			result = AdminDAO.getInstance().UpA_yn(q_idx);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		if(result > 0) {
			map.put("result","ok");
		}else {
			map.put("result","nok");
		}
		
		
		Gson gson = new Gson();
		String msg = gson.toJson(map); //map->json
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(msg.toString());

	}

}
