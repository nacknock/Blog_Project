package Service.manage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import user.DAO.ManageDAO;

public class ctgrPrivate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int pri_bool = Integer.parseInt(request.getParameter("pri_bool")); // 0은 공개로 돌리기,1은 비공개로 돌리기
		int ctgridx = Integer.parseInt(request.getParameter("ctgridx"));
		
		int result = ManageDAO.getInstance().ctgrChangePri(pri_bool,ctgridx);
		
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
