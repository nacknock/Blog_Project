package Service.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.QuestionVo;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class q_list implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pageNum = 1;
		int amount = 10;
		
		String type = "";
		String keyword = "";
		String query = "";
		
		if(request.getParameter("type") != null && !request.getParameter("keyword").equals("")) {
			type = request.getParameter("type");
			keyword = request.getParameter("keyword");
			query = " like '%"+keyword+"%'";
		}
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		Criteria cri = new Criteria();
		cri.setAmount(amount);
		cri.setPageNum(pageNum);
		cri.setType(type);
		cri.setKeyword(keyword);

		//List<NoticeVo> list = NoticeDAO.getInstance().getNotice();
		//List<Map<String,Object>> list = NoticeDAO.getInstance().getMapNotice();
		List<QuestionVo> list = ManageDAO.getInstance().getListWithPaging(cri,query,type);

		int count = ManageDAO.getInstance().getCount(query);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("list", list);
		
		
		request.setAttribute("count", count);

	}

}
