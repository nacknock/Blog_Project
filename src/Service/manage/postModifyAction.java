package Service.manage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
import user.DAO.SignDAO;

public class postModifyAction implements Action {

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
			String uuidfileName = file.getName().substring(0,file.getName().lastIndexOf("."));//Ȯ���� ������ ���ϸ��� ���ϱ�
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
			realFile = request.getParameter("imgurl").substring(8);//���� ���� ��ο��� /upload�� �����Ѱ�(db�� ����ִ� �״��)
		}
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));//update �� where���� ���� idx//modify.jsp���� input type hidden���� ������ ��
		String p_title = request.getParameter("p_title");
		String p_content = request.getParameter("p_content");
		int p_private = Integer.parseInt(request.getParameter("p_private"));
		int p_ctgr = Integer.parseInt(request.getParameter("p_ctgr"));
		
		PostVo vo = new PostVo();
		
		vo.setP_idx(p_idx);
		vo.setP_title(p_title);
		vo.setP_content(p_content);
		vo.setP_private(p_private);
		vo.setP_ctgr(p_ctgr);
		vo.setImg_path(realFile);
		
		//path+"\\"+request.getParameter("imgurl").substring(8) = ���� �̹��� url
		//�뵵�� ���� �������� �� ���� ���� ������
		//imgChange ������ �����ߴ��� ���� üũ true�� �� ���� ���, false�� ���� ��ü ����
		int result = ManageDAO.getInstance().PostModifyAction(vo,imgChange);
		
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		
		if(result > 0) {
			map.put("check", "ok");
		}else {
			map.put("check", "nok");
		}
		
		response.setCharacterEncoding("utf-8");
		
		String json = gson.toJson(map);
		response.getWriter().write(json.toString());
		
	}

}