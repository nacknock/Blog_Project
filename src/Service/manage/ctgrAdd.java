package Service.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.categoryVo;
import user.DAO.ManageDAO;
import util.PageVo;

public class ctgrAdd implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		String ctgr_name = request.getParameter("ctgr_name");
		
		categoryVo vo = new categoryVo();
		
		vo.setCtgr_name(ctgr_name);
		vo.setCtgr_b_idx(b_idx);
		
		vo = ManageDAO.getInstance().saveCtgr(vo);
		
		request.setAttribute("vo", vo);

		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter를 속성으로 설정
	    
	    request.getRequestDispatcher("/blog/template/fragments/ctgr_box.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());


	}

}
