package Service.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import Service.Action;
import VO.AnswerVo;
import VO.QuestionVo;
import user.DAO.ManageDAO;

public class q_detail implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userid = (String)request.getSession().getAttribute("userid");
		
		ManageUserDTO dto =  ManageDAO.getInstance().loadPage(userid);
		
		request.setAttribute("dto", dto);
		
		int q_idx = Integer.parseInt(request.getParameter("q_idx"));

		QuestionVo q_vo = ManageDAO.getInstance().sel_q_detail(q_idx);
		
		if(q_vo.getQ_img() == null || q_vo.getQ_img().equals("")) {
			q_vo.setQ_img(null);
		}
		
		request.setAttribute("q_vo", q_vo);
		
		if(q_vo.getQ_ctgr() == 1) {
			request.setAttribute("q_ctgr", "ログイン");
		}else if(q_vo.getQ_ctgr() == 2) {
			request.setAttribute("q_ctgr", "機能/使い方");
		}else if(q_vo.getQ_ctgr() == 3) {
			request.setAttribute("q_ctgr", "権利侵害");
		}else if(q_vo.getQ_ctgr() == 4) {
			request.setAttribute("q_ctgr", "不具合/エラー/トラブル");
		}
		
		if(q_vo.getA_yn() == 1) {
			AnswerVo a_vo = ManageDAO.getInstance().sel_a_detailByQ(q_idx);
			
			request.setAttribute("a_vo", a_vo);
			
		}

	}

}
