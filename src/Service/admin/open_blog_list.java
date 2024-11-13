package Service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.BlogVo;
import admin.DAO.AdminDAO;

public class open_blog_list implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<BlogVo> list = AdminDAO.getInstance().getAllBlog();
		
		request.setAttribute("list", list);

	}

}
