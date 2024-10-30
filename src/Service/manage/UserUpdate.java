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
		String savepath = "/blog/images";//����� ���� �ٷ� �� ���丮
		boolean imgChange = false;//������ �����ߴ��� ���� üũ true�� �� ���� ���, false�� ���� ��ü ����
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(savepath);
		System.out.println("�������� ���� ���丮 : "+path);
		
		//���� ���ε� ó��
		Part image = request.getPart("img"); //���� ��ü
		String fileName = image.getSubmittedFileName();// ���ϸ�
		String realFile = "";//vo�� �� file��
		
		if(fileName != null && !fileName.isEmpty()) {// �� ÷�������� �����Ҷ�
			String realPath = path+"\\"+fileName;// ���+\\+���ϸ�
			File file = new File(realPath);// realpath�� ������ file��ü ����
			String uuidfileName = file.getName().substring(0,file.getName().lastIndexOf("."));//Ȯ���� ������ ���ϸ� ���ϱ�
			System.out.println("���ϸ� : "+uuidfileName);
			String ext = file.getName().substring(file.getName().lastIndexOf("."),file.getName().lastIndexOf(".")+4);//���ϸ� ������ Ȯ���ڸ� ���ϱ�
			System.out.println("Ȯ���ڸ� : "+ext);
			
			String uuid = UUID.randomUUID().toString();// uuid ����
			System.out.println("���ϸ� + uuid : "+file.toString()+uuid);
			String realName = uuidfileName+"_"+uuid; //uuid�� ���� ���ϸ�(Ȯ���� x)
			System.out.println("uuid�� ���� ���ϸ�(Ȯ���� x) : "+realName);
			realFile = realName+ext; //uuid�� ���� ���ϸ� + Ȯ����
			System.out.println("UploadFile = "+realFile);
			realPath = path+"\\"+realFile;//���� ��� + ���ϸ�
			image.write(realPath); //÷������ ���ε�
			imgChange = true;//������ �����ߴ��� ���� üũ true�� �� ���� ���, false�� ���� ��ü ����
		}else { //÷������ �� ������
			realFile = request.getParameter("imgurl").substring(13);//���� ���� ��ο��� /upload�� �����Ѱ�(db�� ����ִ� �״��)
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
		
		//path+"\\"+request.getParameter("imgurl").substring(8) = ���� �̹��� url
		//�뵵�� ���� �������� �� ���� ���� ������
		//imgChange ������ �����ߴ��� ���� üũ true�� �� ���� ���, false�� ���� ��ü ����
		ManageDAO.getInstance().setUserModify(dto,path+"\\"+request.getParameter("imgurl").substring(13),imgChange);
		

	}

}
