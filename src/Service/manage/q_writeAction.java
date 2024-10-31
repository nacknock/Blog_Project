package Service.manage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Service.Action;
import VO.QuestionVo;
import user.DAO.ManageDAO;

public class q_writeAction implements Action {

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
		String q_title = request.getParameter("q_title");
		String q_content = request.getParameter("q_content");
		int q_u_idx = Integer.parseInt(request.getParameter("idx"));
		int q_ctgr = Integer.parseInt(request.getParameter("q_ctgr"));
		
		QuestionVo vo = new QuestionVo();
		
		vo.setQ_title(q_title);
		vo.setQ_content(q_content);
		vo.setQ_u_idx(q_u_idx);
		vo.setQ_ctgr(q_ctgr);
		vo.setQ_img(realFile);
		
		
		
		ManageDAO.getInstance().setQuestionSave(vo);
		
		response.sendRedirect("/manage/qna_list.do");

	}

}
