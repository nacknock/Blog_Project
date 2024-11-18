package test;

import java.sql.Clob;

import VO.BlogVo;
import VO.PostVo;
import VO.categoryVo;
import user.DAO.ManageDAO;

public class post_test {
	
	public int p_save() {
		PostVo vo = new PostVo(); 
		categoryVo cvo = new categoryVo();
		BlogVo bvo = new BlogVo();
		int result = 0;
		cvo.setCtgridx(1);
		vo.setP_ctgr(cvo);
		vo.setP_title("test123");
		vo.setP_content("123");
		vo.setP_private(0);
		bvo.setB_idx(21);
		vo.setP_b_idx(bvo);
		vo.setCreated_at("2024-11-15 15:36:22");
		for(int i = 0; i<20; i ++) {
			result = ManageDAO.getInstance().savePost(vo);
		}
		return result;
	}

	public static void main(String[] args) {
		post_test p = new post_test();
		System.out.println(p.p_save());
	}

}
