package Service.manage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import user.DAO.ManageDAO;

public class post_del implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int p_idx = Integer.parseInt((String) request.getAttribute("p_idx"));
		
		String savepath = "/blog/images";
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(savepath);
		
		int result = ManageDAO.getInstance().DelPost(p_idx,path);

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
