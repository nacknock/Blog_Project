package Service.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.BlogVo;
import VO.PostVo;
import user.DAO.BlogDAO;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class search_result_blog implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		
		int pageNum = 1;
		int amount = 10;
		
		String term = "";//기간
		String type = "";//답변된것만
		String keyword = "";
		String keyword_post = "";
		
		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			keyword_post = "and p_title like '%"+keyword+"%' ";
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

		List<PostVo> post_list = BlogDAO.getInstance().SearchResultP(cri,keyword_post);

		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			keyword_post = "p_title like '%"+keyword+"%' ";
		}
		
		int p_count = ManageDAO.getInstance().SearchResultBlogCountP(keyword_post,b_idx);

		PageVo p_pvo = new PageVo(cri, p_count);
		
		request.setAttribute("pageMaker", p_pvo);
		
		request.setAttribute("list", post_list);
		
		request.setAttribute("count", p_count);

	}

}
