package Service.manage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import user.DAO.SignDAO;

public class postModifyAction implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String savepath = "/blog/images";//저장될 파일 바로 위 디렉토리
		boolean imgChange = false;//파일을 수정했는지 여부 체크 true는 새 파일 등록, false는 파일 교체 없음
		boolean InsertImg = false;
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(savepath);
		System.out.println("서버상의 실제 디렉토리 : "+path);
		
		//파일 업로드 처리
		Part image = request.getPart("img"); //파일 객체
		String fileName = image.getSubmittedFileName();// 파일명
		String realFile = "";//vo에 들어갈 file명
		
		if(fileName != null && !fileName.isEmpty()) {// 새 첨부파일이 존재할때
			String realPath = path+"\\"+fileName;// 경로+\\+파일명
			File file = new File(realPath);// realpath를 가지고 file객체 생성
			String uuidfileName = file.getName().substring(0,file.getName().lastIndexOf("."));//확장자 제외한 파일명만 구하기
			System.out.println("파일명 : "+uuidfileName);
			String ext = file.getName().substring(file.getName().lastIndexOf("."),file.getName().lastIndexOf(".")+4);//파일명 제외한 확장자만 구하기
			System.out.println("확장자명 : "+ext);
			
			String uuid = UUID.randomUUID().toString();// uuid 생성
			System.out.println("파일명 + uuid : "+file.toString()+uuid);
			String realName = uuidfileName+"_"+uuid; //uuid를 합한 파일명(확장자 x)
			System.out.println("uuid를 합한 파일명(확장자 x) : "+realName);
			realFile = realName+ext; //uuid를 합한 파일명 + 확장자
			System.out.println("UploadFile = "+realFile);
			realPath = path+"\\"+realFile;//파일 경로 + 파일명
			image.write(realPath); //첨부파일 업로드
			imgChange = true;//파일을 수정했는지 여부 체크 true는 새 파일 등록, false는 파일 교체 없음
			if(request.getParameter("imgurl") == null) {
				InsertImg = true;
			}
		}else { //첨부파일 안 했을때
			if(request.getParameter("imgurl") != null) {
			realFile = request.getParameter("imgurl").substring(13);//원래 파일 경로에서 /upload를 제외한것(db에 담겨있던 그대로)
			}
		}
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));//update 시 where절에 넣을 idx//modify.jsp에서 input type hidden으로 보내온 것
		String p_title = request.getParameter("p_title");
		String p_content = request.getParameter("p_content");
		int p_private = Integer.parseInt(request.getParameter("p_private"));
		int p_ctgr = Integer.parseInt(request.getParameter("p_ctgr"));
		
		PostVo vo = new PostVo();
		categoryVo cvo = new categoryVo();
		
		vo.setP_idx(p_idx);
		vo.setP_title(p_title);
		vo.setP_content(p_content);
		vo.setP_private(p_private);
		cvo.setCtgridx(p_ctgr);
		vo.setP_ctgr(cvo);
		vo.setImg_path(realFile);
		
		//path+"\\"+request.getParameter("imgurl").substring(8) = 원래 이미지 url
		//용도는 파일 수정했을 시 원래 파일 삭제용
		//imgChange 파일을 수정했는지 여부 체크 true는 새 파일 등록, false는 파일 교체 없음
		int result = ManageDAO.getInstance().PostModifyAction(vo,imgChange,InsertImg);
		
		String[] tags = request.getParameterValues("tags");
		
		List<String> tag_list = new ArrayList<String>();
		if(tags != null) {
			for(String tag : tags) {
				if(!tag.equals("")) {
					tag_list.add(tag);
				}
			}
		}
		
		
		if(result > 0) {
			result = ManageDAO.getInstance().tagModifyAction(tag_list,p_idx);
		}
		
		
	}

}
