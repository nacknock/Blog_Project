package Service.manage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import Service.Action;
import VO.BlogVo;
import VO.PostVo;
import VO.categoryVo;
import user.DAO.ManageDAO;

public class Post_save implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
String savepath = "/blog/images";
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(savepath);
		System.out.println("서버상의 실제 디렉토리 : "+path);
		
		//파일 업로드 처리
		Part image = request.getPart("imgurl"); //파일 객체
		String realFile = null;
		if(image != null && image.getSize() > 0) {
			String fileName = image.getSubmittedFileName();// 파일명
			
			System.out.println("if");
			String realPath = path+"\\"+fileName;
			File file = new File(realPath);
			String uuidfileName = file.getName().substring(0,file.getName().lastIndexOf("."));
			String ext = file.getName().substring(file.getName().lastIndexOf("."),file.getName().lastIndexOf(".")+4);
			
			String uuid = UUID.randomUUID().toString();
			System.out.println(file.toString()+uuid);
			String realName = uuidfileName+"_"+uuid;
			System.out.println(realName);
			realFile = realName+ext;
			System.out.println("UploadFile = "+realFile);
			realPath = path+"\\"+realFile;
			image.write(realPath); //첨부파일 업로드
		}
		
		int ctgridx = Integer.parseInt(request.getParameter("ctgridx"));
		int b_idx = Integer.parseInt( request.getParameter("b_idx"));
		String p_title =  request.getParameter("p_title");
		String p_content =  request.getParameter("p_content");
		int p_private = Integer.parseInt( request.getParameter("p_private"));
		
		String[] tags = request.getParameterValues("tags");
		
		PostVo vo = new PostVo();
		categoryVo ct_vo = new categoryVo();
		BlogVo b_vo = new BlogVo();
		
		vo.setP_title(p_title);
		ct_vo.setCtgridx(ctgridx);
		vo.setP_ctgr(ct_vo);
		vo.setP_content(p_content);
		vo.setP_private(p_private);
		b_vo.setB_idx(b_idx);
		vo.setP_b_idx(b_vo);
		vo.setImg_path(realFile);
		
		int result = ManageDAO.getInstance().savePost(vo);
		
		System.out.println("post save result : "+result);
		if(tags != null) {
			ManageDAO.getInstance().saveTag(result,tags);
		}

		response.sendRedirect("/blog/post_detail.do?p_idx="+vo.getP_idx());

	}

}
