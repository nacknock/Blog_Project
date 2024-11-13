package Service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.QuestionVo;
import admin.DAO.AdminDAO;

public class open_admin_main implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int usercnt = AdminDAO.getInstance().CntAllUser();
		
		request.setAttribute("usercnt", usercnt);
		
		int blogcnt = AdminDAO.getInstance().CntAllBlog();
		
		request.setAttribute("blogcnt", blogcnt);
		
		int postcnt = AdminDAO.getInstance().CntAllPost();
		
		request.setAttribute("postcnt", postcnt);
		
		int hitcnt = AdminDAO.getInstance().CntAllHit();
		
		request.setAttribute("hitcnt", hitcnt);
		
//		List<Integer> raiting = AdminDAO.getInstance().getRaitingGrape();
//		int j = 1;
//		for(Integer i : raiting) {
//			request.setAttribute("rat"+j, i);
//			System.out.println(i);
//			j++;
//		}
		
		List<QuestionVo> q_list = AdminDAO.getInstance().getQ5();
		
		request.setAttribute("q_list", q_list);
		
		

	}

}
