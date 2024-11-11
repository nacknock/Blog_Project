package Service.blog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import user.DAO.BlogDAO;
import user.DAO.ManageDAO;

public class reply_delAciton implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		

		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		int result = 0;

		String userid = (String)request.getSession().getAttribute("userid");
		
		if(userid == null || !BlogDAO.getInstance().checkReply(userid,r_idx)) {
			result = -1;
		}
		
		result = ManageDAO.getInstance().reply_del_Action(r_idx);
		
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		
		if(result > 0) {
			map.put("check", "ok");
		}else {
			map.put("check", "nok");
		}
		
		response.setCharacterEncoding("utf-8");
		
		String json = gson.toJson(map);
		response.getWriter().write(json.toString());

	}

}
