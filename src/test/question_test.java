package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import VO.QuestionVo;
import util.DBManager;

public class question_test {
	
public void setQuestionSave(QuestionVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "insert into question (q_idx,q_ctgr,q_title,q_content,a_yn,q_u_idx) values (q_seq.nextval,?,?,?,0,?)";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQ_ctgr());
			pstmt.setString(2, vo.getQ_title());
			pstmt.setString(3, vo.getQ_content());
			pstmt.setInt(4, vo.getQ_u_idx());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void test_data(){
		
		for(int i=0;i<1;i++) {
			QuestionVo vo = new QuestionVo();
			
			vo.setQ_u_idx(20);
			vo.setA_yn(0);
			vo.setQ_content("qqqq");
			vo.setQ_ctgr(2);
			vo.setQ_title("q_title+"+i);
			setQuestionSave(vo);
		}
		
	}

	public static void main(String[] args) {
		question_test test = new question_test();
		test.test_data();
	}

}
