package Service.Sign;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Service.Action;
import VO.B_userVo;
import user.DAO.SignDAO;

public class MailAuth implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String number = request.getParameter("auth_num");
		
		String authenKey = (String)request.getSession().getAttribute("authenticationKey");
		
		B_userVo vo = (B_userVo)request.getSession().getAttribute("user");
		System.out.println(vo.getUser_id() + " : vo");
		
		
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		
		if(number != null && number.equals(authenKey)) {
			int result = SignDAO.getInstance().setMemberInsert(vo);
			if(result > 0) {
				map.put("msg","회원가입되었습니다");
				map.put("check","ok");
			}else {
				map.put("msg", "회원가입에 실패했습니다.");
				map.put("check", "nok");
			}
		}else {
			map.put("msg", "인증번호가 다릅니다.");
			map.put("check", "nok");
		}
		
		response.setCharacterEncoding("utf-8");
		
		String json = gson.toJson(map);
		response.getWriter().write(json.toString());
	}

}
