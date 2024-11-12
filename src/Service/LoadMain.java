package Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.ManageUserDTO;
import VO.PostVo;
import VO.TagVo;
import VO.categoryVo;
import user.DAO.BlogDAO;
import util.Criteria;
import util.PageVo;

public class LoadMain implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<TagVo> tag_list = BlogDAO.getInstance().getCtgrListUpHit();
		
		List<PostVo> hitTop6list = BlogDAO.getInstance().gethitTop6();
		
		request.setAttribute("hitTop6list", hitTop6list);
		
		String tag1 = "";

		String tag2 = "";
		int i = 0;
		for(TagVo vo : tag_list) {
			if(i == 0) {
				tag1 = vo.getTag_name();
			}else {
				tag2 = vo.getTag_name();
			}
			i++;
		}

		List<PostVo> cate1list5 = BlogDAO.getInstance().gettaglist5(tag1);
		List<PostVo> cate2list5 = BlogDAO.getInstance().gettaglist5(tag2);
		

		request.setAttribute("cate1list5", cate1list5);
		request.setAttribute("cate2list5", cate2list5);
		request.setAttribute("tag1", tag1);
		request.setAttribute("tag2", tag2);
		
	}

}
