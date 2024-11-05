package test;


import java.util.List;

import VO.B_replyVo;
import VO.B_userVo;
import VO.PostVo;
import user.DAO.BlogDAO;
import util.Criteria;

public class reply_test {

	public void insert(int i) {
		B_replyVo vo = new B_replyVo();
		B_userVo u_vo = new B_userVo();
		PostVo p_vo = new PostVo();
		u_vo.setIdx(20);
		p_vo.setP_idx(2);
		vo.setR_content("test num"+i);
		vo.setR_u_idx(u_vo);
		vo.setR_p_idx(p_vo);
		vo.setR_grade(1);
		BlogDAO.getInstance().reply_write(vo);
	}
	
	public void getlist() {
		
		Criteria cri = new Criteria();
		cri.setAmount(5);
		cri.setPageNum(1);
		cri.setTerm("");
		cri.setType("");
		cri.setKeyword("");
		
		
		List<B_replyVo> list = BlogDAO.getInstance().getReplyListByBlog(cri, 2);
		System.out.println("±Ê¿Ã : "+list.size());
		
		for(B_replyVo vo : list) {
			System.out.print("r_idx : "+vo.getR_idx()+"\t");
			System.out.print("r_content : "+vo.getR_content()+"\t");
			System.out.println("parn_nick : "+vo.getR_parent().getR_u_idx().getNickname());
		}
	}
	
	public void insertChild(int i) {
		B_replyVo vo = new B_replyVo();
		B_userVo u_vo = new B_userVo();
		PostVo p_vo = new PostVo();
		B_replyVo parnvo = new B_replyVo();
		
		u_vo.setIdx(20);
		p_vo.setP_idx(2);
		parnvo.setR_idx(2);
		
		vo.setR_content("child test num"+i);
		vo.setR_u_idx(u_vo);
		vo.setR_p_idx(p_vo);
		vo.setR_grade(1);
		vo.setR_parent(parnvo);
		BlogDAO.getInstance().reply_write(vo);
	}
	
	public static void main(String[] args) {
		reply_test test = new reply_test();
			test.getlist();
	}
}
