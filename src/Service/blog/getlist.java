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
import VO.PostVo;
import VO.QuestionVo;
import VO.TagVo;
import VO.categoryVo;
import user.DAO.BlogDAO;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class getlist implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String login_userid = (String)request.getSession().getAttribute("userid");
		
		int idx = Integer.parseInt(request.getParameter("blog"));
		
		ManageUserDTO dto =  BlogDAO.getInstance().loadPageByBlog(idx);
		
		request.setAttribute("dto", dto);
		
		String my = "and category.ctgr_private = 0 and p_private = 0";
		if(login_userid != null) {
			if(dto.getUser().getUser_id().equals(login_userid)) {
				my = "";
			}
		}
		int pageNum = 1;
		int amount = 5;
		
		String term = "";//태그
		String type = "";//카테고리
		String keyword = "";
		String query_keyword = "";
		String query_type = "";
		String query_term = "";
		
		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			query_keyword = "and p_title like '%"+keyword+"%' ";
		}
		
		if(request.getParameter("type") != null &&!request.getParameter("type").equals("")) {
			type = request.getParameter("type");
			query_type = "and p_ctgr = "+type+" ";
		}
		
		if(request.getParameter("term") != null &&!request.getParameter("term").equals("")) {
			term = request.getParameter("term");
			query_term = "and tag.tag_name = '"+term+"' ";
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

		List<PostVo> list = BlogDAO.getInstance().getListByBlog(cri,dto,my,query_keyword,query_type,query_term);
		
		int count = BlogDAO.getInstance().getCountByBlogMain(my,dto,query_keyword,query_type,query_term);
		
		System.out.println(count + " : cnt");
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("list", list);
		
		request.setAttribute("count", count);
		
		List<categoryVo> ctgr_list = BlogDAO.getInstance().getCtgrListByBlog(my,dto);
		
		request.setAttribute("ctgr_list", ctgr_list);
		
		List<PostVo> top3list = BlogDAO.getInstance().getLoadTop3(my,dto);
		
		request.setAttribute("top3list", top3list);
		
		List<TagVo> taglist = BlogDAO.getInstance().getTagList(my,dto);
		
		request.setAttribute("taglist", taglist);

	}

}
