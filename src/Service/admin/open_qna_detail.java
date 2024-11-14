package Service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import VO.AnswerVo;
import VO.QuestionVo;
import admin.DAO.AdminDAO;

public class open_qna_detail implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int q_idx = Integer.parseInt(request.getParameter("q_idx"));
		
		QuestionVo qvo = AdminDAO.getInstance().getQ_detail(q_idx);
		
		request.setAttribute("qvo", qvo);
		
		if(qvo.getA_yn() == 1) {
			AnswerVo avo = AdminDAO.getInstance().getA_detail(qvo.getQ_idx());
			
			request.setAttribute("avo", avo);
		}

	}

}
