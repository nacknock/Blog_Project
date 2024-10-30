package user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.B_userVo;
import util.DBManager;

public class SignDAO {
	
	private static SignDAO instance = new SignDAO();
	private SignDAO() {}
	public static SignDAO getInstance() {
		return instance;
	}
	
//	public int getMemberId(String id) {
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = "select * from member where id = ?";
//		int result = 0;
//		
//		try {
//			conn = DB_Conn.getInst().conn();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				result = 1;
//			}else {
//				result = -1;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//				if(rs != null) rs.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return result;
//	}

	public int setMemberInsert(B_userVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into b_user (idx,user_id,pw,email,nickname,role) values(b_user_seq.nextval,?,?,?,?,?)";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getNickname());
			pstmt.setInt(5, vo.getRole());
			
			result = pstmt.executeUpdate();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

//	public int getSelectIdPw(String id, String pw) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String query = "select id from member where id like ?";
//		
//		int result = 0;
//		
//		try {
//			conn = DB_Conn.getInst().conn();
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, id);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				query = "select pw from member where id like ? and pw like ?";
//
//				if(pstmt != null) pstmt.close();
//				
//				try {
//					pstmt = conn.prepareStatement(query);
//					
//					pstmt.setString(1, id);
//					pstmt.setString(2, pw);
//					
//					rs = pstmt.executeQuery();
//					
//					if(rs.next()) {
//						result = 1;
//					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}else {
//				result = -1;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return result;
//	}
}
