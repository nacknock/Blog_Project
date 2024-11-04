package test;

import VO.B_replyVo;
import VO.B_userVo;
import VO.PostVo;
import user.DAO.BlogDAO;

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
		vo.setR_parent(string);
		BlogDAO.getInstance().reply_write(vo);
		
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, vo.getR_content());
//		pstmt.setInt(2, vo.getR_u_idx().getIdx());
//		pstmt.setInt(3, vo.getR_p_idx().getP_idx());
//		pstmt.setInt(4, vo.getR_grade());
//		if(vo.getR_parent() != null || !vo.getR_parent().equals("")) {
//			pstmt.setString(5, vo.getR_parent());
//		}
	}
	
	public static void main(String[] args) {
		reply_test test = new reply_test();
		for(int i = 0; i<30; i++) {
			test.insert(i);
		}
	}
}
