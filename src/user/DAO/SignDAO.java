package user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
			if(result > 0) {
				vo.setIdx(selectJoinedIdx(vo.getUser_id()));
				result = insertBlogByJoin(vo);
			}
			if(result > 0) {
				//result = insertPostByJoin(result);
			}
			if(result > 0) {
				result = insertImgByJoin(vo);
			}
			
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

	private int insertImgByJoin(B_userVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "insert into img (img_id,img_path,user_img) values(img_seq.nextval,?,?)";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,"default_profile.png");
			pstmt.setInt(2, vo.getIdx());
			
			result = pstmt.executeUpdate();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
			
			if(result > 0) {
				result = selectJoinedBlog(vo);
			}
			
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
	private int selectJoinedIdx(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select idx from b_user where user_id = ?";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
			if(rs.next()) {
				result = rs.getInt("idx");
			}
			
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
	public int getSelectIdPw(String userid, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select user_id from b_user where user_id like ?";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				query = "select pw from b_user where user_id like ? and pw like ?";

				if(pstmt != null) pstmt.close();
				
				try {
					pstmt = conn.prepareStatement(query);
					
					pstmt.setString(1, userid);
					pstmt.setString(2, pw);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						result = 1;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else {
				result = -1;
			}
			
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
	
	public int insertBlogByJoin(B_userVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "insert into blog (B_IDX,B_TITLE,B_U_IDX) values(blog_seq.nextval,?,?)";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, vo.getNickname()+"의 blog");
			pstmt.setInt(2, vo.getIdx());
			
			result = pstmt.executeUpdate();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
			
			if(result > 0) {
				result = selectJoinedBlog(vo);
			}
			
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
	private int selectJoinedBlog(B_userVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select b_idx from blog where B_U_IDX = ?";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, vo.getIdx());
			
			rs = pstmt.executeQuery();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
			if(rs.next()) {
				result = rs.getInt("b_idx");
			}
			
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
//	private int insertPostByJoin(int b_idx) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		String query = "insert into post (P_IDX,P_TITLE,P_CONTENT,P_PRIVATE,HIT,P_B_IDX) values(post_seq.nextval,?,?,?,?,?)";
//		
//		int result = 0;
//		
//		try {
//			conn = DBManager.getInstance().getConnection();
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, "환영합니다!");
//			pstmt.setString(2, "환영합니다. 앞으로 많은 글을 작성해보세요.");
//			pstmt.setInt(3, 1);
//			pstmt.setInt(4, 0);
//			pstmt.setInt(5, b_idx);
//			
//			result = pstmt.executeUpdate();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
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
	public int getCheckRole(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select role from b_user where user_id = ?";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();//insert,update,delete 쿼리는 정상적으로 실행했을때 0보다 큰값을 리턴한다
			
			if(rs.next()) {
				result = rs.getInt("role");
			}
			
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
	public int checkUser(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select user_id from b_user where user_id = ?";
		
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(userid.equals(rs.getString("user_id"))) {
					result = -1;
				}else {
					result = 1;
				}
			}else {
				result = 1;
			}
			
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
}
