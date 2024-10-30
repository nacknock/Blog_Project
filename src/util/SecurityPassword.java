package util;

import java.security.MessageDigest;

public class SecurityPassword {

	public static String encoding(String pw) {
		
		String newPassword = "";
		try {
			//�ڹٽ�ť��Ƽ MessageDigest import
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			//��ȣȭ �ϰ��� �ϴ� �н����� update()�޼��带 �̿��Ͽ� ����
			md.update(pw.getBytes());
			//digest()�޼��带 �̿��Ͽ� ��ȣȭ�� ���� �����ͼ� byte[]��ȯ�Ͽ� ����
			byte[] encodeData = md.digest();
			//16������ ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϰ� �ѹ��� ��ȣȭ
			for(int i=0; i<encodeData.length;i++) {
				newPassword += Integer.toHexString(encodeData[i]&0xFF);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return newPassword;
	}
}
