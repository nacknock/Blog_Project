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

public class search_result_b implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pageNum = 1;
		int amount = 5;
		
		String term = "";//기간
		String type = "";//답변된것만
		String bp_keyword = "";
		String keyword_blog = "";
		
		if(request.getParameter("bp_keyword") != null &&!request.getParameter("bp_keyword").equals("")) {
			bp_keyword = request.getParameter("bp_keyword");
			keyword_blog = "where b_title like '%"+bp_keyword+"%' ";
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
		cri.setKeyword(bp_keyword);

		List<BlogVo> blog_list = BlogDAO.getInstance().SearchResultB(cri,keyword_blog);

		if(request.getParameter("bp_keyword") != null &&!request.getParameter("bp_keyword").equals("")) {
			bp_keyword = request.getParameter("bp_keyword");
			keyword_blog = "b_title like '%"+bp_keyword+"%' ";
		}
		
		int b_count = ManageDAO.getInstance().SearchResultCountB(keyword_blog);
		
		PageVo b_pvo = new PageVo(cri, b_count);
		
		request.setAttribute("b_pageMaker", b_pvo);
		
		request.setAttribute("b_list", blog_list);
		
		request.setAttribute("b_count", b_count);
		
		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter를 속성으로 설정
	    
	    request.getRequestDispatcher("/blog/template/fragments/search_result_paging_b.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());

	}

}
