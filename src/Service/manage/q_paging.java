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
		int amount = 5;
		
		String term = "";//기간
		String type = "";//답변된것만
		String keyword = "";
		String query_keyword = "";
		String query_type = "";
		String query_term = "order by question.created_at desc";
		String query_where = "";
		
		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			query_keyword = " q_title like '%"+keyword+"%' ";
			query_where = " where ";
		}
		
		if(request.getParameter("type") != null &&!request.getParameter("type").equals("")) {
			type = request.getParameter("type");
			if(type.equals("yes_a")) {
				query_type = " a_yn = 1 ";
			}else if(type.equals("none_a")) {
				query_type = " a_yn = 0 ";
			}else {
				query_type = "";
			} 
			if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
				if(type.equals("yes_a")) {
					query_type = " and a_yn = 1 ";
				}else if(type.equals("none_a")) {
					query_type = " and a_yn = 0 ";
				}else {
					query_type = "";
				} 
			}
			query_where = " where ";
		}
		
		if(request.getParameter("term") != null &&!request.getParameter("term").equals("")) {
			term = request.getParameter("term");
			if(!term.equals("desc") && !term.equals("asc")) {
				query_term = "order by question.created_at desc ";
			}
			query_term = "order by question.created_at "+term+" ";
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

		List<QuestionVo> list = ManageDAO.getInstance().getListWithPagingQnA(cri,query_keyword,query_type,query_term,query_where);

		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			query_keyword = "q_title like '%"+keyword+"%' ";
		}else {
			if(request.getParameter("type") != null &&!request.getParameter("type").equals("")) {
				type = request.getParameter("type");
				if(type.equals("yes_a")) {
					query_type = "a_yn = 1 ";
				}else if(type.equals("none_a")) {
					query_type = "a_yn = 0 ";
				}else {
					query_type = "";
				} 
			}
		}
		
		int count = ManageDAO.getInstance().getCountQnA(query_keyword,query_type);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("list", list);
		
		request.setAttribute("count", count);

		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter를 속성으로 설정
	    
	    request.getRequestDispatcher("/blog/template/fragments/q_list_paging.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());


	}

}
