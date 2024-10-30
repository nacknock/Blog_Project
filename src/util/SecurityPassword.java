package util;

import java.security.MessageDigest;

public class SecurityPassword {

	public static String encoding(String pw) {
		
		String newPassword = "";
		try {
			//자바시큐리티 MessageDigest import
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			//암호화 하고자 하는 패스워드 update()메서드를 이용하여 전달
			md.update(pw.getBytes());
			//digest()메서드를 이용하여 암호화된 값을 가져와서 byte[]변환하여 저장
			byte[] encodeData = md.digest();
			//16진수를 문자열로 변환하여 반환하고 한번더 암호화
			for(int i=0; i<encodeData.length;i++) {
				newPassword += Integer.toHexString(encodeData[i]&0xFF);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return newPassword;
	}
}
