package Service.manage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import user.DAO.ManageDAO;
import util.SecurityPassword;

public class PwUpdateAction implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userid = (String)request.getSession().getAttribute("userid");
		String pw = SecurityPassword.encoding(request.getParameter("pw"));
		String new_pw = SecurityPassword.encoding(request.getParameter("new_pw"));
		
		System.out.println(pw);
		
		String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$";
		Pattern pattern = Pattern.compile(regex);
		if (request.getParameter("new_pw").length() < 9 || request.getParameter("new_pw").length() > 13) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("result","nok0");
			
			Gson gson = new Gson();
			String msg = gson.toJson(map); //map->json
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(msg.toString());
			return;
		}
		// 패스워드가 정규 표현식과 일치하는지 확인
		if(!pattern.matcher(request.getParameter("new_pw")).matches()) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("result","nok0");
			
			Gson gson = new Gson();
			String msg = gson.toJson(map); //map->json
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(msg.toString());
			return;
		}
		
		int result = ManageDAO.getInstance().checkedPw(userid,pw);
		
		if(result == 0) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("result","nok1");
			
			Gson gson = new Gson();
			String msg = gson.toJson(map); //map->json
			
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(msg.toString());
			return;
		}else if(result == 1) {
			result = ManageDAO.getInstance().updateNewPw(userid, new_pw);
			if(result == 0) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("result","nok2");
				
				Gson gson = new Gson();
				String msg = gson.toJson(map); //map->json
				
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(msg.toString());
				return;
			}else if(result == 1) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("result","ok");
				
				Gson gson = new Gson();
				String msg = gson.toJson(map); //map->json
				
				response.setCharacterEncoding("utf-8");
				response.getWriter().write(msg.toString());
			}
		}

	}

}
