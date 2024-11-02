package Service.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.QuestionVo;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class q_paging implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pageNum = 1;
		int amount = 10;
		
		String term = "";//�Ⱓ
		String type = "";//�亯�Ȱ͸�
		String keyword = "";
		String query_keyword = "";
		String query_type = "";
		String query_term = "";
		
		if(request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
			query_keyword = "and q_title like '%"+keyword+"%' ";
		}
		
		if(request.getParameter("type") != null) {
			type = request.getParameter("type");
			query_type = "and a_yn = 1 ";
		}
		
		if(request.getParameter("term") != null) {
			term = request.getParameter("term");
			query_term = "order by "+term+" ";
		}
		
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		Criteria cri = new Criteria();
		cri.setAmount(amount);
		cri.setPageNum(pageNum);
		cri.setTerm(term);
		cri.setType(type);
		cri.setKeyword(keyword);

		List<QuestionVo> list = ManageDAO.getInstance().getListWithPaging(cri,query_keyword,query_type,query_term);

		int count = ManageDAO.getInstance().getCount(query_keyword,query_type,query_term);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("list", list);
		
		request.setAttribute("count", count);

		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter�� �Ӽ����� ����
	    
	    request.getRequestDispatcher("/blog/template/fragments/q_list_paging.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());


	}

}
