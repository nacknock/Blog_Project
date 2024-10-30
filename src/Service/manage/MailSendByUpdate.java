package Service.manage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DTO.ManageUserDTO;
import Service.Action;
import VO.B_userVo;
import VO.ImgVo;
import util.SecurityPassword;

public class MailSendByUpdate implements Action {

	@Override
	public void command(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		
		String host = "smtp.naver.com";
		String user = "nawj0603@naver.com";
		String password = "nakiri3watame8#?";
		
		String to_email = email;
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		StringBuffer temp = new StringBuffer();
		
		Random rmd = new Random();
		
		for(int i=0; i<6; i++) {
			temp.append(rmd.nextInt(10));
		}

		String authenticationKey = temp.toString();
		System.out.println(authenticationKey);
		
		HttpSession authKey = request.getSession();
		authKey.setAttribute("authenticationKey",authenticationKey );
		
		Session mail_session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(user,password);
			}
		});

	    // HTML 템플릿 파일 읽기
	    String templatePath = request.getServletContext().getRealPath("/blog/pages/mail_send.html");
	    String htmlContent = new String(Files.readAllBytes(Paths.get(templatePath)), "UTF-8");
	    htmlContent = htmlContent.replace("${numbers}", authenticationKey);
		try {
			MimeMessage msg = new MimeMessage(mail_session);
			//메일보내기 주제, 수신자의 이메일주소, 발송지의 이메일주소, 보낸날짜와 같은 실제 이메일
			//메시지의 세부사항을 나타낸다
			msg.setFrom(new InternetAddress(user,"JSLHRD"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
			String subject = "Blogyの認証コード";
			msg.setSubject(subject,"UTF-8");
			msg.setContent(htmlContent, "text/html; charset=utf-8");
			Transport.send(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg","認証コードを発信しました。");
		
		Gson gson = new Gson();
		String msg = gson.toJson(map); //map->json
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(msg.toString());

	}

}
