package Service.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import VO.categoryVo;
import user.DAO.ManageDAO;
import user.DAO.SignDAO;

public class ctgrModify implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int ctgridx = Integer.parseInt((String) request.getAttribute("ctgridx"));
		String ctgr_name = (String) request.getAttribute("ctgr_name");
		
		categoryVo vo = new categoryVo();
		
		vo.setCtgr_name(ctgr_name);
		vo.setCtgridx(ctgridx);
		
		int result = ManageDAO.getInstance().ModifyCtgr(vo);

		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		
		if(result > 0) {
			map.put("ctgr_name", vo.getCtgr_name());
			map.put("check", "ok");
		}else {
			vo = ManageDAO.getInstance().sel_one_ctgr(vo);
			map.put("ctgr_name", vo.getCtgr_name());
			map.put("check", "nok");
		}
		
		response.setCharacterEncoding("utf-8");
		
		String json = gson.toJson(map);
		response.getWriter().write(json.toString());
		
	}

}
