package test;

import java.util.regex.Pattern;

public class pwtest {

	public static void main(String[] args) {
		String pw = "qwerqwer@";
		String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$";
        Pattern pattern = Pattern.compile(regex);

        // 패스워드가 정규 표현식과 일치하는지 확인
        if(!pattern.matcher(pw).matches()) {
        	System.out.println("nok");
        }else {
        	System.out.println("ok");
        }


	}

}
