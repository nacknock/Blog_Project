package Service.manage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;

public class CertiCheck implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String certinumber = request.getParameter("certinumber");
		String authenKey = (String)request.getSession().getAttribute("authenticationKey");
		
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		
		if(certinumber.equals(authenKey)) {
			map.put("msg","認証コードの確認が完了しました。");
			map.put("check","ok");
		}else {
			map.put("msg", "認証コードが違います。");
			map.put("check", "nok");
		}
		
		response.setCharacterEncoding("utf-8");
		
		String json = gson.toJson(map);
		response.getWriter().write(json.toString());

	}

}
