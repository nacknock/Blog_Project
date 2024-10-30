package Service.manage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DTO.ManageUserDTO;
import Service.Action;
import user.DAO.ManageDAO;

public class UserUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String savepath = "/blog/images";//저장될 파일 바로 위 디렉토리
		boolean imgChange = false;//파일을 수정했는지 여부 체크 true는 새 파일 등록, false는 파일 교체 없음
		
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
		}else { //첨부파일 안 했을때
			realFile = request.getParameter("imgurl").substring(13);//원래 파일 경로에서 /upload를 제외한것(db에 담겨있던 그대로)
		}
		
		ManageUserDTO dto = new ManageUserDTO();

		int idx = Integer.parseInt(request.getParameter("idx"));
		String user_id = request.getParameter("user_id");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String one_liner = request.getParameter("one_liner");
		String b_title = request.getParameter("b_title");
		
		dto.setIdx(idx);
		dto.setUser_id(user_id);
		dto.setNickname(nickname);
		dto.setEmail(email);
		dto.setOne_liner(one_liner);
		dto.setPath(realFile);
		dto.setB_title(b_title);
		
		//path+"\\"+request.getParameter("imgurl").substring(8) = 원래 이미지 url
		//용도는 파일 수정했을 시 원래 파일 삭제용
		//imgChange 파일을 수정했는지 여부 체크 true는 새 파일 등록, false는 파일 교체 없음
		ManageDAO.getInstance().setUserModify(dto,path+"\\"+request.getParameter("imgurl").substring(13),imgChange);
		

	}

}
