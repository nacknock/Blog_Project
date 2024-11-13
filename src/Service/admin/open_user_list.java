package Service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.B_userVo;
import admin.DAO.AdminDAO;

public class open_user_list implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<B_userVo> list = AdminDAO.getInstance().getAllUser();
		
		request.setAttribute("list", list);

	}

}
