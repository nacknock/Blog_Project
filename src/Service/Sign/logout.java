package Service.Sign;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Action;

public class logout implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println(1);
		HttpSession session = request.getSession();
		System.out.println(2);
		session.removeAttribute("userid");//userid 技记加己父 昏力
		System.out.println(3);
		session.invalidate();//葛电 技记加己 昏力
		System.out.println(4);
		response.sendRedirect("/");

	}

}
