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
		System.out.println("�������� ���� ���丮 : "+path);
		
		//���� ���ε� ó��
		Part image = request.getPart("imgurl"); //���� ��ü
		String realFile = null;
		if(image != null && image.getSize() > 0) {
			String fileName = image.getSubmittedFileName();// ���ϸ�
			
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
			image.write(realPath); //÷������ ���ε�
		}
		
		int ctgridx = Integer.parseInt((String) request.getAttribute("ctgridx"));
		int b_idx = Integer.parseInt((String) request.getAttribute("b_idx"));
		String p_title = (String) request.getAttribute("p_title");
		String p_content = (String) request.getAttribute("p_content");
		int p_private = Integer.parseInt((String) request.getAttribute("p_private"));
		
		PostVo vo = new PostVo();
		
		vo.setP_title(p_title);
		vo.setP_ctgr(ctgridx);
		vo.setP_content(p_content);
		vo.setP_private(p_private);
		vo.setP_b_idx(b_idx);
		vo.setImg_path(realFile);
		
		ManageDAO.getInstance().savePost(vo);

		response.sendRedirect("/blog/post_detail.do?p_idx="+vo.getP_idx());

	}

}