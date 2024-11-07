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
import VO.PostVo;
import VO.QuestionVo;
import user.DAO.ManageDAO;
import util.Criteria;
import util.PageVo;

public class post_paging implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		
		int pageNum = 1;
		int amount = 10;
		
		String term = "";//�Ⱓ
		String type = "";//��ȸ�� updown
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
			if(type.equals("up")) {
				query_type = "order by hit asc ";
			}else if(type.equals("down")) {
				query_type = "order by hit desc ";
			}else {
				query_type = "";
			} 
		}
		
		if(request.getParameter("term") != null &&!request.getParameter("term").equals("")) {
			term = request.getParameter("term");
			if(!term.equals("desc") && !term.equals("asc")) {
				query_term = "";
			}else {
				if(!query_type.equals("")) {
					query_term = " ,created_at "+term+" ";
				}else {
					query_term = "order by created_at "+term+" ";
				}
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

		List<PostVo> list = ManageDAO.getInstance().getListWithPagingP_Manage(cri,query_keyword,query_type,query_term,b_idx);

		if(request.getParameter("keyword") != null &&!request.getParameter("keyword").equals("")) {
			keyword = request.getParameter("keyword");
			query_keyword = "p_title like '%"+keyword+"%' ";
		}
		
		int count = ManageDAO.getInstance().getCountP_Manage(query_keyword,b_idx);
		
		PageVo pvo = new PageVo(cri, count);
		
		request.setAttribute("pageMaker", pvo);
		
		request.setAttribute("list", list);
		
		request.setAttribute("count", count);

		response.setContentType("text/html;charset=UTF-8");
		StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    request.setAttribute("writer", printWriter); // PrintWriter�� �Ӽ����� ����
	    
	    request.getRequestDispatcher("/blog/template/fragments/p_manage_paging.jsp").include(request, response);
	    
	    response.getWriter().write(stringWriter.toString());


	}

}
