package test;

import java.util.regex.Pattern;

public class pwtest {

	public static void main(String[] args) {
		String pw = "qwerqwer@";
		String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$";
        Pattern pattern = Pattern.compile(regex);

        // �н����尡 ���� ǥ���İ� ��ġ�ϴ��� Ȯ��
        if(!pattern.matcher(pw).matches()) {
        	System.out.println("nok");
        }else {
        	System.out.println("ok");
        }


	}

}
