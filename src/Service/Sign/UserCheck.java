package Service.Sign;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Action;
import user.DAO.SignDAO;
import util.SecurityPassword;

public class UserCheck implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String pw_chk = request.getParameter("pw_chk");
		
		int result = SignDAO.getInstance().checkUser(userid);
		System.out.println(result);
		HttpSession session = request.getSession();
		
		if(!pw.equals(pw_chk)) {
			result = -2;
		}
		
		if (pw.length() < 9 || pw.length() > 13) {
            result = -3;
        }

        // 정규 표현식: 영어 대소문자, 숫자, 특수문자의 조합
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$";
        Pattern pattern = Pattern.compile(regex);

        // 패스워드가 정규 표현식과 일치하는지 확인
        if(!pattern.matcher(pw).matches()) {
        	result = -3;
        }
		
		if(result == 1) {//admin
			return;
		}else if(result == 0) {//id or pw 틀림
			session.setAttribute("msg", "通信エーラが発生しました。");
			response.sendRedirect("/sign/join.do");
			return;
		}else if(result == -1) {//회원가입 안함
			session.setAttribute("msg", "使用されているIDです。");
			response.sendRedirect("/sign/join.do");
			return;
		}else if(result == -2) {//회원가입 안함
			session.setAttribute("msg_pw_chk", "パスワードが一致しません");
			response.sendRedirect("/sign/join.do");
			return;
		}else if(result == -3) {//회원가입 안함
			session.setAttribute("msg_pw", "安全性を高めるために、半角英字数字と記号を組み合わせてパスワードを入力してください。");
			response.sendRedirect("/sign/join.do");
			return;
		}
	}

}
