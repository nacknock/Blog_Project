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

public class search_result_p implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pageNum = 1;
		int amount = 5;
		
		String term = "";//기간
		String type = "";//답변된것만
		String bp_keyword = "";
		String keyword_post = " where p_private = 0 ";
		
		if(request.getParameter("bp_keyword") != null &&!request.getParameter("bp_keyword").equals("")) {
			bp_keyword = request.getParameter("bp_keyword");
			keyword_post = " where p_title like '%"+bp_keyword+"%' and p_private = 0 ";
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
		
//		System.out.println(amount+" : amount");
//		System.out.println(pageNum+" : pageNum");
//		System.out.println(term+" : term");
//		System.out.println(type+" : type");
//		System.out.println(bp_keyword+" : bp_keyword");
		
		List<PostVo> post_list = BlogDAO.getInstance().SearchResultP(cri,keyword_post);
		
		//System.out.println(post_list.size()+" : post_list");

		if(request.getParameter("bp_keyword") != null &&!request.getParameter("bp_keyword").equals("")) {
			bp_keyword = request.getParameter("bp_keyword");
			keyword_post = " where p_title like '%"+bp_keyword+"%' and p_private = 0 ";
		}
		
		int p_count = ManageDAO.getInstance().SearchResultCountP(keyword_post);

		PageVo p_pvo = new PageVo(cri, p_count);
		
		request.setAttribute("p_pageMaker", p_pvo);
		
		request.setAttribute("p_list", post_list);
		
		request.setAttribute("p_count", p_count);
		
		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter를 속성으로 설정
	    
	    request.getRequestDispatcher("/blog/template/fragments/search_result_paging_p.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());

	}

}
