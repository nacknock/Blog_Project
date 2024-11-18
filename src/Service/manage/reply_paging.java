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
import VO.B_replyVo;
import VO.PostVo;
import VO.QuestionVo;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class reply_paging implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		
		
		int pageNum = 1;
		int amount = 10;
		
		String term = "order by r.created_at desc";//기간
		String type = "";//댓글/답글 구분
		String keyword = "";
		String query_keyword = "";
		String query_type = "";
		String query_term = "order by r.created_at desc";
		
		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			query_keyword = "and r.r_content like '%"+keyword+"%' ";
		}
		
//		if(request.getParameter("type") != null &&!request.getParameter("type").equals("")) {
//			type = request.getParameter("type");
//			query_type = "and r_grade = "+type+" ";
//		}
		
		if(request.getParameter("term") != null &&!request.getParameter("term").equals("")) {
			term = request.getParameter("term");
			if(!term.equals("desc") && !term.equals("asc")) {
				query_term = "";
			}else {
				query_term = "order by r.created_at "+term+" ";
				
			}
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

		List<B_replyVo> list = ManageDAO.getInstance().getListWithPagingR_Manage(cri,query_keyword,query_term,idx);

		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			query_keyword = "and r_content like '%"+keyword+"%' ";
		}
		
		int count = ManageDAO.getInstance().getCountR_Manage(query_keyword,idx);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("list", list);
		
		request.setAttribute("count", count);
		
		request.setAttribute("b_idx", b_idx);

		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter를 속성으로 설정
	    
	    request.getRequestDispatcher("/blog/template/fragments/reply_manage_paging.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());


	}

}
