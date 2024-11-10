package Service.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

import DTO.ManageUserDTO;
import Service.Action;
import VO.B_replyVo;
import VO.PostVo;
import VO.QuestionVo;
import VO.categoryVo;
import user.DAO.BlogDAO;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class getReplyList implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		int pageNum = 1;
		int amount = 5;
		
		String term = "";//기간
		String type = "";//답변된것만
		String keyword = "";
		String query_keyword = "";
		String query_type = "";
		String query_term = "";
		
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

		List<B_replyVo> list = BlogDAO.getInstance().getReplyListByBlog(cri,p_idx);
		
		int count = BlogDAO.getInstance().getCountByReplyPost(p_idx);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("re_list", list);
		
		request.setAttribute("count", count);
		
		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter를 속성으로 설정
	    
	    request.getRequestDispatcher("/blog/template/fragments/reply_list_paging.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());

	}

}
