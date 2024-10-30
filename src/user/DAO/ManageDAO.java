package user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.ManageUserDTO;
import VO.B_userVo;
import util.DBManager;

public class ManageDAO {
	
	private static ManageDAO instance = new ManageDAO();
	private ManageDAO() {}
	public static ManageDAO getInstance() {
		return instance;
	}
//	public  getMemberId(String id) {
//	
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
//	String sql = "select * from member where id = ?";
//	int result = 0;
//	
//	try {
//		conn = DB_Conn.getInst().conn();
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, id);
//		rs = pstmt.executeQuery();
//		
//		if(rs.next()) {
//			result = 1;
//		}else {
//			result = -1;
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		try {
//
//			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close();
//			if(rs != null) rs.close();
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//	}
//	return result;
//}
	public ManageUserDTO loadPage(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageUserDTO dto = new ManageUserDTO();
		
		String sql = "select user_id,idx,email,nickname,b.one_liner,img.img_path\r\n" + 
				"from b_user\r\n" + 
				"left join img\r\n" + 
				"on img.user_img = b_user.idx\r\n" + 
				"left join blog b\r\n" + 
				"on b.b_u_idx = b_user.idx\r\n" + 
				"where b_user.user_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setIdx(rs.getInt("idx"));
				dto.setEmail(rs.getString("email"));
				dto.setNickname(rs.getString("nickname"));
				dto.setOne_liner(rs.getString("one_liner"));
				dto.setPath(rs.getString("img_path"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}


}
